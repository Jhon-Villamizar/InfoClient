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
@Table(name="tbl_city")
@SequenceGenerator(name="seq", initialValue=50, allocationSize=999999999)
public class City {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int id;
	@Column(name="name", length=50)
	private String name;
	@Column(name="stateId")
	private int stateId;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="cities")
	private Set<Client> cities;
	
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
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public Set<Client> getCities() {
		return cities;
	}
	public void setCities(Set<Client> cities) {
		this.cities = cities;
	}
}
