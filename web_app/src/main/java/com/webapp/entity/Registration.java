package com.webapp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@javax.persistence.Table(name="registrations")
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotEmpty
	@Size(min = 2,message = "First Name should be at least 2 characters")
	@Column(name = "first_name",length = 45)
	private String firstName;
	@Column(name = "last_name",length = 45)
	private String lastName;
	@Email
	@Column(name = "email",unique = true,length = 128)
	private String email;
	@Column(name = "mobile" ,length =10)
	private long mobile;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}
