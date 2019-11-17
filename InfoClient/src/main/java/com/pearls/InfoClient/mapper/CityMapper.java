package com.pearls.InfoClient.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearls.InfoClient.model.City;
import com.pearls.InfoClient.model.Client;

@Service("cityMapper")
public class CityMapper {
	
	@Autowired
	ClientMapper clientMapper;
	
	public Set<City> mapper(Set<City> city){
		Set<City> cities= new HashSet<City>();
		for(City ci : city) {
			City ci2 = mapper(ci);
			cities.add(ci2);
		}
		return cities;
	}
	
	public City mapper(City ci) {
		City ci2= new City();
		ci2.setId(ci.getId());
		ci2.setName(ci.getName());
		ci2.setStateId(ci.getStateId());
		ci2.setCities(ci.getCities());
		
		Set<Client> c = clientMapper.mapper(ci.getCities());
		ci2.setCities(c);
		return ci2;
	}

}
