package com.jarabrama.store_manager.model.mappers;

import com.jarabrama.store_manager.model.dtos.ProductResponse;
import com.jarabrama.store_manager.model.entitties.Product;

public class ProductResponseMapper {

  public static ProductResponse fromEntity(Product product) {
    return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getUrlImage(),
        product.getPrice(), product.getStock(),
        product.getCategories().stream().map(c -> c.getName()).toList());
  }
}
