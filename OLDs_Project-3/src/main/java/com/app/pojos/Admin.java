package com.app.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Admin {

//	create table Admin(
//    admin_Id INTEGER PRIMARY KEY auto_increment ,
//    name varchar(100),
//    Email varchar(100),
//    Password varchar(100),
//    createdOn TIMESTAMP DEFAULT CURRENT_TIMESTAMP
//);
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer admin_Id;
	
	@Column(length=30)
	private String name; 
	
	@Column(length=30)
	private String email;
	
	private String password;
	
	@CreationTimestamp
	@Column(name="createdAt" ,nullable = false, updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd") //html 5 complaint date time format
	private Date createdAt;

	public Admin()
	{
		this.email="";
		this.name="";
		this.password="";
	}
	public Integer getAdmin_Id() {
		return admin_Id;
	}

	public void setAdmin_Id(Integer admin_Id) {
		this.admin_Id = admin_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Admin(Integer admin_Id, String name, String email, String password, Date createdAt) {
		super();
		this.admin_Id = admin_Id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}
	

}
