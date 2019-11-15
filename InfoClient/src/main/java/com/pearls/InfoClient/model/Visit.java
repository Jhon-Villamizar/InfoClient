package com.pearls.InfoClient.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_visit")
public class Visit {
	
	@Id
	@Column(name = "clientId")
	private String clientId;
	@Column(name = "date")
	private Date date;
	@Column(name = "srId")
	private String srId;
	@Column(name = "net")
	private int net;
	@Column(name = "visitTotal")
	private int visitTotal;
	@Column(name = "description")
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clients")
	private Visit clients;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "salesRepresentatives")
	private Visit salesRepresentative;

}
