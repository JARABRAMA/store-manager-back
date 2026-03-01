package com.jarabrama.store_manager.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
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

  public List<ProductResponse> findAll(
      String text,
      String category,
      Optional<Integer> limit,
      Optional<Integer> page) {

    // check if limit and page exists
    int actualLimit = limit.isPresent() ? limit.get() : 10;
    int actualPage = page.isPresent() ? page.get() : 0;

    text = (text == null) ? "" : text;
    Pageable pageable = Pageable.ofSize(actualLimit)
        .withPage(actualPage);

    if (category == null) {
      return respository.findAll(text, pageable)
          .stream().map(ProductResponseMapper::fromEntity).toList();
    }
    return respository.findAll(text, category, pageable)
        .stream().map(ProductResponseMapper::fromEntity).toList();
  }

  public ProductResponse getById(UUID id) {
    return ProductResponseMapper.fromEntity(respository.findById(id).get());
  }

}
