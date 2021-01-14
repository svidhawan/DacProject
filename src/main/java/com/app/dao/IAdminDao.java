package com.app.dao;

import com.app.dto.ResponseDTO;
import com.app.pojos.Admin;

public interface IAdminDao {
	
	public ResponseDTO signup(Admin adminDetails);
	public ResponseDTO login(Admin adminDetails);

}
