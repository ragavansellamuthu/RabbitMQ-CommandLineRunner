package com.techietact.tutorial.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techietact.tutorial.model.ProductModel;
import com.techietact.tutorial.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService ;

	@PutMapping
	public ResponseEntity<ProductModel> saveProduct(@RequestBody ProductModel model){
		model=productService.saveProduct(model);
		if(model==null) {
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity.ok(model);
	}
	
}
