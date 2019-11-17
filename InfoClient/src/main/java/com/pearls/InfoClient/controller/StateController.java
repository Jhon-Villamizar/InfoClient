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
import com.pearls.InfoClient.mapper.StateMapper;
import com.pearls.InfoClient.model.Client;
import com.pearls.InfoClient.model.State;
import com.pearls.InfoClient.repositories.StateRepository;

@RestController
@RequestMapping("/api")
public class StateController {

	@Autowired
	 StateRepository stateRepository;
	 
	 @Autowired
	 StateMapper stateMapper;
	 
	 @Autowired
	 ClientMapper clientMapper;
	 
	 @GetMapping(path = "/states")
	 public Set<State> getAllStates(){
		 Set<State> states= new HashSet<State>();
		 stateRepository.findAll().forEach(state->states.add(state));
		 return stateMapper.mapper(states);
	 }
	 
	 @GetMapping(path = "/states/{id}")
	 public State getStateById(@PathVariable("id") int id) {
		 State state = stateRepository.findById(id).get();
		 Set<Client> states = clientMapper.mapper(state.getStates());
		 state.setStates(states);
		 return stateMapper.mapper(state);
	 }
	 
	 @PostMapping(path = "/states")
	 public String createState(@RequestBody State state) {
		 stateRepository.save(state);
		 return "State Created!";
	 }
	 
	 @PutMapping(path = "/states/{id}")
	 public String updateState(@PathVariable("id") int id, @RequestBody State state) {
		 stateRepository.save(state);
		 return "State Updated!";
	 }
	 
	 @DeleteMapping(path = "/states/{id}")
	 public String delete(@PathVariable("id") int id) {
		 stateRepository.deleteById(id);
		 return "State Deleted!";
	 }

}
