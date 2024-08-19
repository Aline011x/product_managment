package gm.inventarios.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import gm.inventarios.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}