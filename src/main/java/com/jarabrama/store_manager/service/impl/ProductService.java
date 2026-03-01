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

  public List<ProductResponse> findAll(String text, String category) {
    System.out.println(String.format("FIND ALL PRODUCTS PARAMETERS: TEXT: %s CATEGORY %s", text, category));
    if (text == null) {
      text = "";
    }
    if (category == null) {
      return respository.findAll(text)
          .stream().map(ProductResponseMapper::fromEntity).toList();
    }
    return respository.findAll(text, category)
        .stream().map(ProductResponseMapper::fromEntity).toList();
  }

  public ProductResponse getById(UUID id) {
    return ProductResponseMapper.fromEntity(respository.findById(id).get());
  }

}
