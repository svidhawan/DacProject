package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.CustomExp.ResourceNotFoundException;
import com.app.dto.ResponseDTO;
import com.app.pojos.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements IProductService{

	@Autowired
	private ProductRepository prorepo;
	@Override
	public Product save(Product pro) {
		// TODO Auto-generated method stub
		 Product prod=prorepo.save(pro);
		 return prod;
		 
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		prorepo.deleteById(id);
		
	}
	@Override
	public Product edit(int proid,Product updatedprod) {
		// TODO Auto-generated method stub
		 Optional<Product> pro=prorepo.findById(proid);
		 if(pro.isPresent())
		 {
//			 Employee existingEmp = optional.get();// DETACHED
//				System.out.println("existing emp " + existingEmp);
//				existingEmp.setDesignation(emp.getDesignation());
//				existingEmp.setSalary(emp.getSalary());
//				// update detached POJO
//				return new ResponseEntity<>(empRepo.save(existingEmp), HttpStatus.OK);
//				// save or update (insert: transient(value of ID : default
//				// or non default value BUT existing on DB -- update
//			} else
//				throw new ResourceNotFoundException("Emp ID Invalid");
			 Product existingpro=pro.get();
			 existingpro.setPrice(updatedprod.getPrice());
			 existingpro.setProduct_Title(updatedprod.getProduct_Title());
			 existingpro.setDescription(updatedprod.getDescription());
			 existingpro.setCategory_Id(updatedprod.getCategory_Id());
			 Product newpro= prorepo.save(existingpro);
			 return newpro;
		 }else
		  throw new ResourceNotFoundException("EmpId Invalid");
	}
	
	@Override
	public Product getSingleProduct(Integer id) {
		// TODO Auto-generated method stub
		 return prorepo.getOne(id);
	}

	
}
