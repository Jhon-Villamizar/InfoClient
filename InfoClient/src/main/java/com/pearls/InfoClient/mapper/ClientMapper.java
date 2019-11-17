package com.pearls.InfoClient.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearls.InfoClient.model.Client;
import com.pearls.InfoClient.model.Visit;

@Service("clientMapper")
public class ClientMapper {
	
	@Autowired
	VisitMapper visitMapper;
	
	public Set<Client> mapper(Set<Client> client){
		Set<Client> clients = new HashSet<Client>();
		for(Client c:client) {
			Client c2=mapper(c);
			clients.add(c2);
		}
		return clients;
	}
	
	public Client mapper(Client c) {
		Client c2 = new Client();
		c2.setId(c.getId());
		c2.setNit(c.getNit());
		c2.setName(c.getName());
		c2.setAddress(c.getAddress());
		c2.setPhone(c.getPhone());
		c2.setCreditLimit(c.getCreditLimit());
		c2.setAvailableCredit(c.getAvailableCredit());
		c2.setVisitPercentage(c.getVisitPercentage());
		c2.setDescription(c.getDescription());
		c2.setCountries(c.getCountries());
		c2.setStates(c.getStates());
		c2.setCities(c.getCities());
		c2.setClients(c.getClients());
		
		Set<Visit> v = visitMapper.mapper(c.getClients());
		c2.setClients(v);
		return c2;
	}

}
