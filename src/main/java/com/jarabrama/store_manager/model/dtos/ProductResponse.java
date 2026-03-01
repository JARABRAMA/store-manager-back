package com.jarabrama.store_manager.model.dtos;

import java.util.List;
import java.util.UUID;

public record ProductResponse(
  UUID id, String name, String description, 
  String urlImage, int price, int stock, List<String> categories
) {
}