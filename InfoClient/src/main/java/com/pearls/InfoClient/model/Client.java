package com.pearls.InfoClient.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_client")
public class Client {
	@Id
	@Column(name = "nit")
	private String nit;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private String phone;
	@Column(name = "creditLimit")
	private int creditLimit;
	@Column(name = "availableCredit")
	private int availableCredit;
	@Column(name = "visitPercentage")
	private int visitPercentage;
	@Column(name = "description")
	private int description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "cities")
	private Client cities;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "states")
	private Client states;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "countries")
	private Client countries;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name ="clinets")
	private Set<Client> clients;
	
}

