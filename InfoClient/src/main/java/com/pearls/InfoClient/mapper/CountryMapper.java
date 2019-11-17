package com.pearls.InfoClient.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearls.InfoClient.model.Client;
import com.pearls.InfoClient.model.Country;

@Service("countryMapper")
public class CountryMapper {
	
	@Autowired
	ClientMapper clientMapper;
	
	public Set<Country> mapper(Set<Country> country){
		Set<Country> countries = new HashSet<Country>();
		for(Country co : country) {
			Country co2= mapper(co);
			countries.add(co2);
		}
		return countries;
	}
	
	public Country mapper(Country co) {
		Country co2= new Country();
		co2.setId(co.getId());
		co2.setName(co.getName());
		co2.setCountries(co.getCountries());
		
		Set<Client> c = clientMapper.mapper(co.getCountries());
		co2.setCountries(c);
		
		return co2;
	}

}
