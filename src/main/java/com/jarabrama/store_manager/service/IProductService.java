package com.jarabrama.store_manager.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jarabrama.store_manager.model.dtos.ProductResponse;

public interface IProductService {
  List<ProductResponse> findAll(String text, String category, Optional<Integer> limit, Optional<Integer> page);

  ProductResponse getById(UUID id);
}
