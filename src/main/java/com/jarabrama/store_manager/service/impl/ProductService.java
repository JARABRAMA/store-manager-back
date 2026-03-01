package com.jarabrama.store_manager.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jarabrama.store_manager.model.dtos.ProductResponse;
import com.jarabrama.store_manager.model.mappers.ProductResponseMapper;
import com.jarabrama.store_manager.repository.IProductRespository;
import com.jarabrama.store_manager.service.IProductService;

@Service
public class ProductService implements IProductService {
  private final IProductRespository respository;

  public ProductService(IProductRespository respository) {
    this.respository = respository;
  }

  public List<ProductResponse> findAll() {
    return respository.findAllWhithCategories().stream().map(ProductResponseMapper::fromEntity).toList();
  }

  public ProductResponse getById(UUID id) {
    return ProductResponseMapper.fromEntity(respository.findById(id).get());
  }

}
