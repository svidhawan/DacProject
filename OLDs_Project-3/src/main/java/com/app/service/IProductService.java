package com.app.service;

import com.app.dto.ResponseDTO;
import com.app.pojos.Product;

public interface IProductService {

	public Product save(Product u);

	public void deleteById(int id);

	public void edit(Product newproduct);

	public Product getSingleProduct(Integer id);
	
}
