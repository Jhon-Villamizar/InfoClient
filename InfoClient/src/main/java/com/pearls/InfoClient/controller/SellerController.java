package com.pearls.InfoClient.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearls.InfoClient.mapper.SellerMapper;
import com.pearls.InfoClient.mapper.VisitMapper;
import com.pearls.InfoClient.model.Seller;
import com.pearls.InfoClient.model.Visit;
import com.pearls.InfoClient.repositories.SellerRepository;

@RestController
@RequestMapping(path = "/api")
public class SellerController {

	@Autowired
	SellerRepository sellerRepository;
	
	@Autowired
	SellerMapper sellerMapper;
	
	@Autowired
	VisitMapper visitMapper;
	
	@GetMapping(path = "/sellers")
	public Set<Seller> getAllSellers(){
		Set<Seller> sellers = new HashSet<Seller>();
		sellerRepository.findAll().forEach(seller->sellers.add(seller));
		return sellerMapper.mapper(sellers);
	}


	@GetMapping(path = "/sellers/{id}")
	public Seller getSellerById(@PathVariable("id") int id) {
		Seller seller = sellerRepository.findById(id).get();
		Set<Visit> sellers= visitMapper.mapper(seller.getSellers());
		seller.setSellers(sellers);
		return sellerMapper.mapper(seller);
	}
	
	@PostMapping(path = "/sellers")
	public String createSeller(@RequestBody Seller seller) {
		sellerRepository.save(seller);
		return "Seller Created!";
	}
	

	@PutMapping(path = "/sellers/{id}")
	public String updateSeller(@PathVariable("id") int id, @RequestBody Seller seller) {
		sellerRepository.save(seller);
		return "Seller Updated!";
	}
	
	@DeleteMapping(path = "/sellers/{id}")
	public String delete(@PathVariable("id") int id) {
		sellerRepository.deleteById(id);
		return "Seller Deleted";
	}
}
