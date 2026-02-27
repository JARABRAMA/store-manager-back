package repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarabrama.store_manager.model.entitties.Product;

public interface IProductRespository extends JpaRepository<UUID, Product> {
  List<Product> findProducts();
}
