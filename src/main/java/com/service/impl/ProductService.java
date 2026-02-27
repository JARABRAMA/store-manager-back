package com.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jarabrama.store_manager.model.dtos.ProductResponse;
import com.jarabrama.store_manager.model.mappers.ProductResponseMapper;
import com.service.IProductService;

import repository.IProductRespository;

@Service
public class ProductService implements IProductService {
  private final IProductRespository respository;

  public ProductService(IProductRespository respository) {
    this.respository = respository;
  }

  public List<ProductResponse> findAll() {
    return respository.findAll().stream().map(ProductResponseMapper::fromEntity).toList();
  }

}
