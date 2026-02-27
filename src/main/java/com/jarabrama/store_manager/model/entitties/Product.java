package com.jarabrama.store_manager.model.entitties;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
  private String urlImage; 
  private LocalDateTime createdAt; 
}
