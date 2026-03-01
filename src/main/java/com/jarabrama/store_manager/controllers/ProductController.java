package com.jarabrama.store_manager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jarabrama.store_manager.model.dtos.ProductResponse;
import com.jarabrama.store_manager.service.IProductService;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/product")
public class ProductController {
  private final IProductService service;

  public ProductController(IProductService service) {
    this.service = service;
  }

  @GetMapping()
  public ResponseEntity<List<ProductResponse>> findAll(
    @RequestParam(required = false) String text, 
    @RequestParam(required = false) String category
  ) {
    return ResponseEntity.ok().body(service.findAll(text, category));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponse> getMethodName(@PathVariable UUID id) {
    return ResponseEntity.ok(service.getById(id));
  }

}
