package nyclab.ecommerce.ecommerceapi.productcategory.repository;

import nyclab.ecommerce.ecommerceapi.productcategory.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
