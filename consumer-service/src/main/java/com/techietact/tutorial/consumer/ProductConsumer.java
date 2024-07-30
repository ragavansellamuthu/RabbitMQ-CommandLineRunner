package com.techietact.tutorial.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.techietact.tutorial.repository.OrderRepository;
import com.techietact.tutorial.request.ProductUpdateRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductConsumer {

	private final OrderRepository orderRepository;

	@RabbitListener(queues = { "${rabbitmq.product.queue.name}" })
	public void updateProductName(ProductUpdateRequest request) {
		log.info("CONSUMED : ProductUpdateRequest " + request.toString());
		orderRepository.updateProductName(request.getProductId(), request.getProductName());
	}

}
