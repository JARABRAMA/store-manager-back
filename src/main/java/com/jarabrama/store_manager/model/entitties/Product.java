package com.jarabrama.store_manager.model.entitties;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Id
  private UUID id;

  private String name;
  private String description;
  private int price;
  private int stock;

  @Column(name = "url_image")
  private String urlImage;
  private LocalDateTime createdAt;

  @ManyToMany
  @JoinTable(
    name = "product_category", 
    joinColumns = @JoinColumn(name = "product_id"), 
    inverseJoinColumns = @JoinColumn(name = "cateogory_id")
  )
  private List<Category> categories = new ArrayList<>();

}
