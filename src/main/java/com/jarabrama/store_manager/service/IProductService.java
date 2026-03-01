package com.jarabrama.store_manager.service;

import java.util.List;
import java.util.UUID;

import com.jarabrama.store_manager.model.dtos.ProductResponse;

public interface IProductService {
  List<ProductResponse> findAll(String text, String category);

  ProductResponse getById(UUID id);
}
