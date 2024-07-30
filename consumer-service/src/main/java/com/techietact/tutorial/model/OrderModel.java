package com.techietact.tutorial.model;

import lombok.Data;

@Data
public class OrderModel {

	private int orderId ; 
	
	private String customerName ; 
	
	private String location ; 
	
	private int productId ; 
	
	private String productName ;
}
