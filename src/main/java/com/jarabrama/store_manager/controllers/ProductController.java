package com.jarabrama.store_manager.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarabrama.store_manager.model.dtos.ProductResponse;
import com.jarabrama.store_manager.service.IProductService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/product")
public class ProductController {
  private final IProductService service;

  public ProductController(IProductService service) {
    this.service = service;
  }

  @GetMapping()
  public ResponseEntity<List<ProductResponse>> findAll() {
    return ResponseEntity.ok().body(service.findAll());
  }

}
