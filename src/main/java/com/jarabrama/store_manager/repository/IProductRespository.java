package com.jarabrama.store_manager.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jarabrama.store_manager.model.entitties.Product;

@Repository
public interface IProductRespository extends JpaRepository<Product, UUID> {

  @Query("""
      SELECT DISTINCT p
      FROM Product p
      LEFT JOIN FETCH p.categories
      """)
  List<Product> findAllWhitCategories();
}
