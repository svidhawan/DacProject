package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ResponseDTO;
import com.app.pojos.Admin;
import com.app.repository.AdminRepository;

@Service
@Transactional
public class AdminService implements IAdminService{

	@Autowired
	private AdminRepository adminrepo;
	
	
	@Override
	public Admin signup(Admin a) {
		// TODO Auto-generated method stub
		Admin admin=adminrepo.save(a);
		return admin;
	}

	@Override
	public ResponseDTO login(Admin adminDetails) {
		// TODO Auto-generated method stub
		
		Admin temp = adminrepo.findByEmail(adminDetails.getEmail());
		if (temp != null) {
			if (adminDetails.getPassword().equals(temp.getPassword()))
				return new ResponseDTO("success", "Details Found Successfully", temp);
			else
				return new ResponseDTO("error", "Admin Details Not Found");

		} else {
			return new ResponseDTO("error", "Admin Details Not Found");
		}
	}

}
