package com.jarabrama.store_manager.service.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jarabrama.store_manager.model.dtos.Meta;
import com.jarabrama.store_manager.model.dtos.ProductResponse;
import com.jarabrama.store_manager.model.dtos.Response;
import com.jarabrama.store_manager.model.entitties.Product;
import com.jarabrama.store_manager.model.mappers.ProductResponseMapper;
import com.jarabrama.store_manager.repository.IProductRespository;
import com.jarabrama.store_manager.service.IProductService;

@Service
public class ProductService implements IProductService {
  private final IProductRespository respository;

  public ProductService(IProductRespository respository) {
    this.respository = respository;
  }

  public Response<ProductResponse> findAll(
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

    Page<Product> pageResult;
    if (category == null) {
      pageResult = respository.findAll(text, pageable);
    } else {
      pageResult = respository.findAll(text, category, pageable);
    }

    Meta meta = Meta.builder()
        .totalElements((int) pageResult.getTotalElements())
        .totalPages(pageResult.getTotalPages())
        .page(pageResult.getNumber())
        .pageSize(pageResult.getSize())
        .hasNext(pageResult.hasNext())
        .hasPrevious(pageResult.hasPrevious())
        .build();

    return new Response<ProductResponse>(
        meta,
        pageResult.getContent()
            .stream().map(ProductResponseMapper::fromEntity).toArray(ProductResponse[]::new));

  }

  public ProductResponse getById(UUID id) {
    return ProductResponseMapper.fromEntity(respository.findById(id).get());
  }

}
