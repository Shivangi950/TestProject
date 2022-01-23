package com.example.CustomerService.Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CustomerService.Exception.CustomSQLException;
import com.example.CustomerService.Exception.CustomerNotFoundException;
import com.example.CustomerService.Exception.DataAlreadyExistsException;
import com.example.CustomerService.Repository.ProductRepository;
import com.example.CustomerService.model.InputProduct;
import com.example.CustomerService.model.Product;
import com.example.CustomerService.util.ProductValidator;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product getProductById(int id) {
		Product product = null;
		try {
			product = productRepository.findByProductId(id);
		} catch (Exception e) {
			throw new CustomerNotFoundException("product not found");
		}
		return product;
	}

	public Product addProduct(@Valid InputProduct inputProduct) {
		Product product = new Product();
		product.setProductName(inputProduct.getProductName());
		product.setProductPrice(inputProduct.getProductPrice());
		product.setCompany(inputProduct.getCompany());
		product.setInventory(inputProduct.getInventory());
		return productRepository.save(product);
	}
	
	public Product deductInventory(Integer productId, Integer quantity) {
		Product product = getProductById(productId);
		if(product.getInventory() - quantity > 0) {
		  product.setInventory(product.getInventory() - quantity);
		}
		else {
			System.out.println("required qty is not present");
		}
		return productRepository.save(product);
	}
	
	@Transactional(rollbackFor = {CustomSQLException.class})
	public Product createProduct(@Valid InputProduct inputProduct) {
		/**
		 *	below throws 400 for invalid input
		 */
		ProductValidator.validateProduct(inputProduct);
				
		Product existingProduct = productRepository.findByProductNameAndProductPriceAndCompany(inputProduct.getProductName(), inputProduct.getProductPrice(), inputProduct.getCompany());
		Product addedProduct = null;
		
		if (existingProduct == null) {
			addedProduct = addProduct(inputProduct);
			System.out.println("Product successfully added");
			
          if(addedProduct.getInventory() < 0 ) {
        	  System.out.println("Inventory can not be negative");
        	  throw new CustomSQLException("Throwing exception for Rollback");
          }  
			
		} else {
				System.out.println("This product already exists!");
				throw new DataAlreadyExistsException("product already Exists");
			}
		return addedProduct; 
		}
}
