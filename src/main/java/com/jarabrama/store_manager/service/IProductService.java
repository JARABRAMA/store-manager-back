package com.jarabrama.store_manager.service;

import java.util.List;

import com.jarabrama.store_manager.model.dtos.ProductResponse;

public interface IProductService {
  List<ProductResponse> findAll(); 
}
