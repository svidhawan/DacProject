package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminDaoImpl;
import com.app.dao.IAdminDao;
import com.app.dto.ResponseDTO;
import com.app.pojos.Admin;
import com.app.repository.AdminRepository;

@Service
@Transactional
public class AdminService implements IAdminService{

	@Autowired
	private AdminRepository adminrepo;
	
	@Autowired
	private IAdminDao iadao;
	
	@Override
	public Admin signup(Admin a) {
		// TODO Auto-generated method stub
		Admin admin=adminrepo.save(a);
		return admin;
	}

	@Override
	public ResponseDTO login(Admin a) {
		// TODO Auto-generated method stub
		
		return iadao.login(a);
	}

}
