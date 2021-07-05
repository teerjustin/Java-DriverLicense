package com.example.driverLicense.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="licenses")
public class License {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Date expirationDate;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    
    public static long count = 0;
      
    public static String getNextLicenseNumber() {
    	count += 1;
    	if (count < 10) {
    		return "00000" + count;
    	}
    	if (count > 10 && count < 100) {
    		return "0000" + count;
    	}
    	if (count > 100 && count < 1000) {
    		return "000" + count;
    	}
    	if (count > 1000 && count < 10000) {
    		return "00" + count;
    	}
    	if (count > 10000 && count < 100000) {
    		return "0" + count;
    	}
    	return "" + count;
    }
    
    public License() {
    	
    }
    
    public License(Date expirationDate, String state) {
    	this.expirationDate = expirationDate;
    	this.state = state;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}