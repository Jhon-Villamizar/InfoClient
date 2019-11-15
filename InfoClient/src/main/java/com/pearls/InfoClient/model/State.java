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
@Table(name="tbl_state")
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
	private Set<State> states;
}
