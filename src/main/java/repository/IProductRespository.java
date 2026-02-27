package repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jarabrama.store_manager.model.entitties.Product;

@Repository
public interface IProductRespository extends JpaRepository<Product, UUID> {

}
