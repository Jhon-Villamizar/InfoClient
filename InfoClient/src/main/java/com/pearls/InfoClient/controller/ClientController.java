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
import com.pearls.InfoClient.mapper.VisitMapper;
import com.pearls.InfoClient.model.Client;
import com.pearls.InfoClient.model.Visit;
import com.pearls.InfoClient.repositories.ClientRepository;

@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ClientMapper clientMapper;
	
	@Autowired
	VisitMapper visitMapper;
	
	@GetMapping(path = "/clients")
	public Set<Client> getAllClients(){
		Set<Client> clients = new HashSet<Client>();
		clientRepository.findAll().forEach(client ->clients.add(client));
		return clientMapper.mapper(clients);
	}
	
	@GetMapping(path = "/clients/{id}")
	public Client  getClientById(@PathVariable("id") int id) {
		Client client = clientRepository.findById(id).get();
		Set<Visit>clients = visitMapper.mapper(client.getClients());
		client.setClients(clients);
		return clientMapper.mapper(client);
	}
	
	@PostMapping(path = "/clients")
	public String createClient(@RequestBody Client client) {
		clientRepository.save(client);
		return "Client Created!";
	}
	
	@PutMapping(path = "/clients/{id}")
	public String updateClient(@PathVariable("id") int id, @RequestBody Client client) {
		clientRepository.save(client);
		return "Client Updated!";
	}
	
	@DeleteMapping(path = "/clients/{id}")
	public String delete(@PathVariable("id") int id) {
		clientRepository.deleteById(id);
		return "Client deleted";
	}
	
}
