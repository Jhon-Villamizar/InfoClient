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

import com.pearls.InfoClient.mapper.VisitMapper;
import com.pearls.InfoClient.model.Visit;
import com.pearls.InfoClient.repositories.VisitRepository;

@RestController
@RequestMapping(path = "/api")
public class VistController {
	
	@Autowired
	VisitRepository visitRepository;
	
	@Autowired
	VisitMapper visitMapper;
	
	@GetMapping(path = "/visits")
	public Set<Visit> getAllVisit(){
		Set<Visit> visits = new HashSet<Visit>();
		visitRepository.findAll().forEach(visit->visits.add(visit));
		return visitMapper.mapper(visits);
	}
	
	@GetMapping(path = "/visits/{id}")
	public Visit getVisitById(@PathVariable("id") int id) {
		Visit visit = visitRepository.findById(id).get();
		return visitMapper.mapper(visit);
	}

	@PostMapping(path = "/visits")
	public String createVisit(@RequestBody Visit visit) {
		visitRepository.save(visit);
		return "Visit Created!";
	}
	
	@PutMapping(path = "/visits/{id}")
	public String updateVisit(@PathVariable("id") int id, @RequestBody Visit visit) {
		visitRepository.save(visit);
		return "Visit Update!";
	}
	
	@DeleteMapping(path = "/visits/{id}")
	public String delete(@PathVariable("id") int id) {
		visitRepository.deleteById(id);
		return "Visit Deleted";
	}
	
}
