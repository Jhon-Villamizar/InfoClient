package com.pearls.InfoClient.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_visit")
@SequenceGenerator(name="seq", initialValue=50, allocationSize=999999999)
public class Visit {
	
	@Id
	@Column(name = "clientId")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int clientId;
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
	private Client clients;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sellers")
	private Seller sellers;
	
	
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSrId() {
		return srId;
	}
	public void setSrId(String srId) {
		this.srId = srId;
	}
	public int getNet() {
		return net;
	}
	public void setNet(int net) {
		this.net = net;
	}
	public int getVisitTotal() {
		return visitTotal;
	}
	public void setVisitTotal(int visitTotal) {
		this.visitTotal = visitTotal;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Client getClients() {
		return clients;
	}
	public void setClients(Client clients) {
		this.clients = clients;
	}
	public Seller getSellers() {
		return sellers;
	}
	public void setSellers(Seller sallers) {
		this.sellers = sallers;
	}

}
