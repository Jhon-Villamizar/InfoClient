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
@Table(name = "tbl_country")
@SequenceGenerator(name="seq", initialValue=50, allocationSize=999999999)
public class Country {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private int id;
	@Column(name = "name")
	private String name;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "countries")
	private Set<Client> countries;
	
	
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
	public Set<Client> getCountries() {
		return countries;
	}
	public void setCountries(Set<Client> countries) {
		this.countries = countries;
	}	
}
