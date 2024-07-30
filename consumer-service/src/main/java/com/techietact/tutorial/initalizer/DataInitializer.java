package com.techietact.tutorial.initalizer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.techietact.tutorial.entity.OrderEntity;
import com.techietact.tutorial.repository.OrderRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
	
	private final OrderRepository orderRepository  ;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		if(orderRepository.count()==0) {
			List<OrderEntity> orders = new ArrayList<OrderEntity>();
		
			OrderEntity order = new OrderEntity();
			order.setOrderId(1);
			order.setCustomerName("Ragavan");
			order.setLocation("Chettikulam");
			order.setProductId(1);
			order.setProductName("Pencil");
			orders.add(order);
			
			order = new OrderEntity();
			order.setOrderId(2);
			order.setCustomerName("Nilan");
			order.setLocation("Chettikulam");
			order.setProductId(1);
			order.setProductName("Pencil");
			orders.add(order);
			
			order = new OrderEntity();
			order.setOrderId(3);
			order.setCustomerName("Sellamuthu");
			order.setLocation("Chettikulam");
			order.setProductId(2);
			order.setProductName("Book");
			orders.add(order);
			
			order = new OrderEntity();
			order.setOrderId(4);
			order.setCustomerName("Durga");
			order.setLocation("Chettikulam");
			order.setProductId(2);
			order.setProductName("Book");
			orders.add(order);
			
			order = new OrderEntity();
			order.setOrderId(5);
			order.setCustomerName("Vicky");
			order.setLocation("Trichy");
			order.setProductId(1);
			order.setProductName("Pencil");
			orders.add(order);
			
			orderRepository.saveAll(orders);
		}
	}

}
