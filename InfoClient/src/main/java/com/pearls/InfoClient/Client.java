package com.pearls.InfoClient;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_client")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String description;
	private String nit;
	private String fullname;
	private String adress;
	private String phone;
	private String city;
	private String state;
	private String country;
	private Integer creditlim;
	private Integer avalcredit;
	private Integer visitsperc;
	private Date date;
	private String representative;
	private Integer visit;
	private String descVisit;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getCreditlim() {
		return creditlim;
	}
	public void setCreditlim(Integer creditlim) {
		this.creditlim = creditlim;
	}
	public Integer getAvalcredit() {
		return avalcredit;
	}
	public void setAvalcredit(Integer avalcredit) {
		this.avalcredit = avalcredit;
	}
	public Integer getVisitsperc() {
		return visitsperc;
	}
	public void setVisitsperc(Integer visitsperc) {
		this.visitsperc = visitsperc;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRepresentative() {
		return representative;
	}
	public void setRepresentative(String representative) {
		this.representative = representative;
	}
	public Integer getVisit() {
		return visit;
	}
	public void setVisit(Integer visit) {
		this.visit = visit;
	}
	public String getDescVisit() {
		return descVisit;
	}
	public void setDescVisit(String descVisit) {
		this.descVisit = descVisit;
	}
}

