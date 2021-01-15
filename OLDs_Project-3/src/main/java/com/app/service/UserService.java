package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ResponseDTO;
import com.app.pojos.Admin;
import com.app.pojos.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserService implements IUserService{


	
	@Autowired
	private UserRepository userrepo; 
	@Override
	public User signup(User u) {
		// TODO Auto-generated method stub
		User user=userrepo.save(u);
		return user;
	}

	@Override
	public ResponseDTO login(User userdetails) {
		// TODO Auto- method stub
		
		User temp = userrepo.findByEmail(userdetails.getEmail());
		if (temp != null) {
			if (userdetails.getPassword().equals(temp.getPassword()))
				return new ResponseDTO("success", "Details Found Successfully", temp);
			else
				return new ResponseDTO("error", "User Details Not Found");

		} else {
			return new ResponseDTO("error", "User Details Not Found");
		}
	
	}

}
