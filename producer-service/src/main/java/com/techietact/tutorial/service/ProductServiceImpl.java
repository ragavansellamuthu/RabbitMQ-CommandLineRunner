package com.techietact.tutorial.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.techietact.tutorial.entity.ProductEntity;
import com.techietact.tutorial.model.ProductModel;
import com.techietact.tutorial.producer.ProductProducer;
import com.techietact.tutorial.repository.ProductRepository;
import com.techietact.tutorial.request.ProductUpdateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository repository;

	private final ProductProducer productProducer;

	@Override
	public ProductModel saveProduct(ProductModel model) {
		try {
			if (model != null) {
				ProductEntity entity = repository.findById(model.getProductId()).orElse(null);
				if (entity != null) {
					BeanUtils.copyProperties(model, entity);
					entity = repository.save(entity);
					if (entity != null) {

						ProductUpdateRequest request = new ProductUpdateRequest();
						request.setProductId(entity.getProductId());
						request.setProductName(entity.getProductName());
						productProducer.updateProduct(request);

						BeanUtils.copyProperties(entity, model);
						return model;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
