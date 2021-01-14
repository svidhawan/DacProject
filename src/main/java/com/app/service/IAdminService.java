package com.app.service;

import com.app.dto.ResponseDTO;
import com.app.pojos.Admin;

public interface IAdminService {

	public Admin signup(Admin a);
	
	public ResponseDTO login(Admin a);
	
}
