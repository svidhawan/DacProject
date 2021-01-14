package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.app.pojos.Brand;
//import com.app.pojos.Category;
import com.app.pojos.Product;
import com.app.repository.ProductRepository;
import com.app.service.IProductService;
import com.app.dto.ResponseDTO;

//add Option Based Object Retrieval

@RequestMapping("/products")
@RestController
@Validated//to add Validation on request body or path variable
public class ProductController {

	public ProductController()
	{
		System.out.println("In class of"+getClass().getName());
	}
	@Autowired
	private IProductService proservice;
	
	private ProductRepository prorepo;
	@GetMapping("/")
	public ResponseEntity<?> listAllProducts()
	{
		System.out.println("List all products");
		List<Product> products = prorepo.findAll();
		//invoke service layers method contro--->service impl(p)--->Jpa impl by service
		
		return  ResponseEntity.ok(products);///status code--Ok
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> addNewProduct(@RequestBody Product prod )
	{
		System.out.println("In add Products"+prod);
		
		 return new ResponseEntity<>(new ResponseDTO("success","Product Strored SuccessFully",proservice.save(prod)),HttpStatus.OK);
	}
	@PutMapping("/edit")
	public ResponseEntity<?> editProduct(@RequestBody Product product) {
		proservice.edit(product);
		return new ResponseEntity<>(new ResponseDTO("success","Product Updated SuccessFully",product),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable int id) {
		proservice.deleteById(id);
		  return new ResponseEntity<>(new ResponseDTO("success","Product Deleted"),HttpStatus.OK);
	}

//	@PostMapping("/brand")
//	public ResponseEntity<?> getProductByBrand(@RequestBody Brand brand) {
//		return new ResponseEntity<>(productService.getProductByBrand(brand), HttpStatus.OK);
//	}
//
//	@PostMapping("/category")
//	public ResponseEntity<?> getProductByCategory(@RequestBody Category category) {
//		return new ResponseEntity<>(productService.getProductByCategory(category), HttpStatus.OK);
//	}
	@GetMapping("/single/{id}")
	public ResponseEntity<?> getSignleProduct(@PathVariable Integer id) {
		return new ResponseEntity<>(new ResponseDTO("success","Product Selected",proservice.getSingleProduct(id)), HttpStatus.OK);
	}
	
}
