package nyclab.ecommerce.ecommerceapi.productcategory.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nyclab.ecommerce.ecommerceapi.product.model.Product;
import nyclab.ecommerce.ecommerceapi.productcategory.dto.ProductCategoryDTO;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_categories")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;

    public ProductCategoryDTO toDto() {
        return new ProductCategoryDTO(
                id,
                categoryName
        );
    }
}
