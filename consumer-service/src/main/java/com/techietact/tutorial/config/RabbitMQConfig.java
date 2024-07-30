package com.techietact.tutorial.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${rabbitmq.product.queue.name}")
	private String productQueue ; 
	
	@Value("${rabbitmq.product.exchange.name}")
	private String productExchange ; 
	
	@Value("${rabbitmq.product.routing.key}")
	private String productKey ;
	
	@Bean
	TopicExchange productExchange() { 
		return new TopicExchange(productExchange);
	}
	
	@Bean
	Queue productQueue() {
		return new Queue(productQueue);
	}
	
	@Bean
	Binding productBinding() {
		return BindingBuilder.bind(productQueue()).to(productExchange()).with(productKey);
	}
	
	@Bean
	MessageConverter converter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	AmqpTemplate ampqTemplate(ConnectionFactory connectionfactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionfactory);
		rabbitTemplate.setMessageConverter(converter());
		return rabbitTemplate;		
	}

	
}
