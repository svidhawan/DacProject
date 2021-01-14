package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public void edit(Product newproduct) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Product getSingleProduct(Integer id) {
		// TODO Auto-generated method stub
		 return prorepo.getOne(id);
	}

	
}
