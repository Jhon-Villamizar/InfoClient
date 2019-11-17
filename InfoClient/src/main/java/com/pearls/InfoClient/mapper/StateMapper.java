package com.pearls.InfoClient.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pearls.InfoClient.model.Client;
import com.pearls.InfoClient.model.State;

@Service("stateMapper")
public class StateMapper {
	
	@Autowired
	ClientMapper clientMapper;
	
	public Set<State> mapper(Set<State> state){
		Set<State> states = new HashSet<State>();
		for(State s : state) {
			State s2 = mapper(s);
			states.add(s2);
		}
		return states;
	}
	
	
	public State mapper(State s) { 
		State s2 = new State();
		s2.setId(s.getId());
		s2.setName(s.getName());
		s2.setCountryId(s.getCountryId());
		s2.setStates(s.getStates());
		
		Set<Client> c = clientMapper.mapper(s.getStates());
		s2.setStates(c);
		return s2;
	}

}
