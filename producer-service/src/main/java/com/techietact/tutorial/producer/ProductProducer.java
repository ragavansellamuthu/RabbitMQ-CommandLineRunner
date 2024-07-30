package com.techietact.tutorial.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.techietact.tutorial.request.ProductUpdateRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductProducer {
	
	@Value("${rabbitmq.product.exchange.name}")
	private String productExchange ; 
	
	@Value("${rabbitmq.product.routing.key}")
	private String productKey ;
	
	private final RabbitTemplate rabbitTemplate ; 

	public void updateProduct(ProductUpdateRequest request) {
		log.info("PRODUCED : ProductUpdateRequest " + request.toString()) ;
		rabbitTemplate.convertAndSend(productExchange,productKey,request);
	}
	
}
