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
import javax.persistence.Table;

@Entity
@Table(name = "tbl_salesRepresenative")
public class SalesRepresentative {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int id;
	@Column(name = "name")
	private String name;
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "salesRepresentatives")
	private Set<SalesRepresentative> salesrepresentatives;
	
}
