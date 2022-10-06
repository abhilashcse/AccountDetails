package com.accountDetails.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_profile")
public class Account {

	@Id
	private Integer id;
	public String name;
    public String username;
    public String password;
    public String address;
    public String state;
    public String country;
    public String emailAddress;
    public String pan;
    public String dateOfBirth;
    public String accountType;
    public String MobileNo;
    
    public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Account(Integer id, String name, String username, String password, String address, String state,
			String country, String emailAddress, String pan, String dateOfBirth, String accountType, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.state = state;
		this.country = country;
		this.emailAddress = emailAddress;
		this.pan = pan;
		this.dateOfBirth = dateOfBirth;
		this.accountType = accountType;
		MobileNo = mobileNo;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
