package com.jarabrama.store_manager.model.mappers;

import com.jarabrama.store_manager.model.entitties.Category;

import com.jarabrama.store_manager.model.dtos.CategoryResponse;

public class CategoryResponseMapper {
  public static CategoryResponse fromEntity(Category entity) {
    return new CategoryResponse(entity.getId(), entity.getName());
  }
}
