package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.service.IAdminService;


@RestController
@CrossOrigin(origins = { "http://localhost:4100" })
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService iaservice;

	public AdminController()
	{
		System.out.println("In class of"+getClass().getName()+" is created");
	}
	@PostMapping("/signup")
	public ResponseEntity<?> addUser(@RequestBody  Admin a)
	{
		System.out.println("In posting data of User "+a);
		Admin admin=iaservice.signup(a);
		return new ResponseEntity<>(admin,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Admin admindetails)
	{
		System.out.println("In login  of User controller "+admindetails);
	     
		return new ResponseEntity<>(iaservice.login(admindetails), HttpStatus.OK);
		
	}
	
}
