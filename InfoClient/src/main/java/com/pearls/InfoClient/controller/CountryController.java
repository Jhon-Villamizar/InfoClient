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

import com.pearls.InfoClient.mapper.ClientMapper;
import com.pearls.InfoClient.mapper.CountryMapper;
import com.pearls.InfoClient.model.Client;
import com.pearls.InfoClient.model.Country;
import com.pearls.InfoClient.repositories.CountryRepository;


@RestController
@RequestMapping(path = "/api")
public class CountryController {
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	CountryMapper countryMapper;
	
	@Autowired
	ClientMapper clientMapper;
	
	@GetMapping(path = "/countries")
	public Set<Country> getAllCountries(){
		Set<Country> countries = new HashSet<Country>();
		countryRepository.findAll().forEach(country->countries.add(country));
		return countryMapper.mapper(countries);
	}
	
	@GetMapping(path = "/countries/{id}")
	public Country gerContryById(@PathVariable("id") int id) {
		Country country = countryRepository.findById(id).get();
		Set<Client> countries = clientMapper.mapper(country.getCountries());
		country.setCountries(countries);
		return countryMapper.mapper(country);
	}
	
	@PostMapping(path = "/countries")
	public String createCountry(@RequestBody Country country) {
		countryRepository.save(country);
		return "Client Created!";
	}
	
	@PutMapping(path = "/countries/{id}")
	public String updateCountry(@PathVariable("id") int id, @RequestBody Country country) {
		countryRepository.save(country);
		return "Client Updated!";
	}
	
	@DeleteMapping(path = "/countries/{id}")
	public String delete(@PathVariable("id") int id) {
		countryRepository.deleteById(id);
		return "Client Deleted!";
	}
}
