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

import com.pearls.InfoClient.mapper.CityMapper;
import com.pearls.InfoClient.mapper.ClientMapper;
import com.pearls.InfoClient.model.City;
import com.pearls.InfoClient.model.Client;
import com.pearls.InfoClient.repositories.CityRepository;

@RestController
@RequestMapping("/api")
public class CityController {
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CityMapper cityMapper;
	
	@Autowired
	ClientMapper clientMapper;
	
	@GetMapping(path = "/cities")
	public Set<City> getAllCities(){
		Set<City> cities = new HashSet<City>();
		cityRepository.findAll().forEach(city->cities.add(city));
		return cityMapper.mapper(cities);
	}

	@GetMapping(path = "/cities/{id}")
	public City getCityById(@PathVariable("id") int id) {
		City city = cityRepository.findById(id).get();
		Set<Client> cities= clientMapper.mapper(city.getCities());
		city.setCities(cities);
		return cityMapper.mapper(city);
	}
	
	@PostMapping(path = "/cities")
	public String createCity(@RequestBody City city) {
		cityRepository.save(city);
		return "City Created!";
	}
	

	@PutMapping(path = "/cities/{id}")
	public String updateCity(@PathVariable("id") int id, @RequestBody City city) {
		cityRepository.save(city);
		return "City Updated!";
	}
	
	@DeleteMapping(path = "/cities/{id}")
	public String delete(@PathVariable("id") int id) {
		cityRepository.deleteById(id);
		return "City Deleted";
	}
}