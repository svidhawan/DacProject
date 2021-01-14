package com.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.dto.ResponseDTO;
import com.app.pojos.Admin;

@Repository
public class AdminDaoImpl implements IAdminDao {

	@PersistenceContext
	EntityManager manager;

	public AdminDaoImpl() {
		System.out.println("bean " + getClass().getName() + " created");
	}

	@Override
	public ResponseDTO signup(Admin adminDetails) {
		manager.persist(adminDetails);
		return new ResponseDTO("success", "signup successFull", adminDetails);
	}

	@Override
	public ResponseDTO login(Admin adminDetails) {
		String jpql = "select a from Admin a where a.email=:email And a.password=:password";

		Admin details = manager.createQuery(jpql, Admin.class).setParameter("email", adminDetails.getEmail())
				.setParameter("password", adminDetails.getPassword()).getSingleResult();
		if (details == null)
		 	throw new NoResultException();
		return new ResponseDTO("sucess", "login successFull", details);
	}

}
