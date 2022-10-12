package com.accountDetails.dto;

public class CustomerProfileDTO{
    public String name;
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
	public CustomerProfileDTO(String name, String password, String address, String state, String country,
			String emailAddress, String pan, String dateOfBirth, String accountType, String mobileNo) {
		super();
		this.name = name;
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
	public CustomerProfileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

