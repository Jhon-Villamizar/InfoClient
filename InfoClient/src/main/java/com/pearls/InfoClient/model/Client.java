package com.pearls.InfoClient.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_client")
public class Client {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "nit")
	private String nit;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private String phone;
	@Column(name = "city")
	private int city;
	@Column(name = "state")
	private int state;
	@Column(name = "country")
	private int country;
	@Column(name = "creditLimit")
	private int creditLimit;
	@Column(name = "availableCredit")
	private int availableCredit;
	@Column(name = "visitPercentage")
	private int visitPercentage;
	@Column(name = "description")
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "cities")
	private City cities;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "states")
	private State states;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "countries")
	private Country countries;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name ="clients")
	private Set<Visit> clients;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public int getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}
	public int getAvailableCredit() {
		return availableCredit;
	}
	public void setAvailableCredit(int availableCredit) {
		this.availableCredit = availableCredit;
	}
	public int getVisitPercentage() {
		return visitPercentage;
	}
	public void setVisitPercentage(int visitPercentage) {
		this.visitPercentage = visitPercentage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public City getCities() {
		return cities;
	}
	public void setCities(City cities) {
		this.cities = cities;
	}
	public State getStates() {
		return states;
	}
	public void setStates(State states) {
		this.states = states;
	}
	public Country getCountries() {
		return countries;
	}
	public void setCountries(Country countries) {
		this.countries = countries;
	}
	public Set<Visit> getClients() {
		return clients;
	}
	public void setClients(Set<Visit> clients) {
		this.clients = clients;
	}	
}

