package com.pearls.InfoClient.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_state")
@SequenceGenerator(name="seq", initialValue=50, allocationSize=999999999)
public class State {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="countryId")
	private String countryId;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="states")
	private Set<Client> states;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public Set<Client> getStates() {
		return states;
	}
	public void setStates(Set<Client> states) {
		this.states = states;
	}
}
