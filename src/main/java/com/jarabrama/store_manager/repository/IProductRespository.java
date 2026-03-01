package com.jarabrama.store_manager.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jarabrama.store_manager.model.entitties.Product;

@Repository
public interface IProductRespository extends JpaRepository<Product, UUID> {

	@Query("""
			SELECT DISTINCT p FROM Product p
			LEFT JOIN FETCH p.categories
			LEFT JOIN p.categories c
			WHERE (UPPER(p.name) LIKE UPPER(CONCAT('%', :search, '%'))
			OR UPPER(p.description) LIKE UPPER(CONCAT('%', :search, '%')))
			AND UPPER(c.name) = UPPER(:category)
			ORDER BY p.name
			""")
	Page<Product> findAll(
			String search,
			String category,
			Pageable pageable);

	@Query("""
			SELECT DISTINCT p FROM Product p
			LEFT JOIN FETCH p.categories
			WHERE UPPER(p.name) LIKE UPPER(CONCAT('%', :search, '%'))
			OR UPPER(p.description) LIKE UPPER(CONCAT('%', :search, '%'))
			ORDER BY p.name
			""")
	Page<Product> findAll(
			String search,
			Pageable pageable);

	@Query("""
			SELECT DISTINCT p FROM Product p
			LEFT JOIN FETCH p.categories
			WHERE p.id = :id
			""")
	Optional<Product> findAllById(@Param("id") UUID id);

}
