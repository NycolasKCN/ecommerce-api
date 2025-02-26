package nyclab.ecommerce.ecommerceapi.product.repository;

import nyclab.ecommerce.ecommerceapi.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
