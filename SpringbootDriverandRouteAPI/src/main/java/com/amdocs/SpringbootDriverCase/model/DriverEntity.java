package com.amdocs.SpringbootDriverCase.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ValidationException;
import javax.validation.constraints.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "DRIVER")
public class DriverEntity {
	@Id
	@Column(name = "DRIVERID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverid;
	@Column(name = "FirstName")
	private String firstname;
	
	
	@Column(name = "LastName")
	private String lastname;
	
	@Column(name = "MobileNumber")
	@Pattern(regexp = "\\d{10}", message = "Mobile number must be exactly 10 digits")
	private String mobilenumber;
	
	@Column(name = "LicenseNumber")
	private String licensenumber;
	@OneToMany(mappedBy = "drivers", cascade = CascadeType.ALL)
    private Set<RouteEntity> routeid=new HashSet<RouteEntity>();

	
	public DriverEntity(int driverid, String firstname, String lastname, String mobilenumber, String licensenumber) {
		super();
		this.driverid = driverid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mobilenumber = mobilenumber;
		this.licensenumber = licensenumber;
	}
	public DriverEntity() {
		super();
	}
	public int getDriverid() {
		return driverid;
	}
	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		if (mobilenumber.matches("\\d{10}")) {
	        this.mobilenumber = mobilenumber;
	    } else {
	        throw new ValidationException("Mobile number must be exactly 10 digits");
	    }
		this.mobilenumber = mobilenumber;
	}
	public String getLicensenumber() {
		return licensenumber;
	}
	public void setLicensenumber(String licensenumber) {
		this.licensenumber = licensenumber;
	}
	
	
	
	}


