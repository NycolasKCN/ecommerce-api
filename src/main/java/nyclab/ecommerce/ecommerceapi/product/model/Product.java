package nyclab.ecommerce.ecommerceapi.product.model;

import jakarta.persistence.*;
import lombok.Data;
import nyclab.ecommerce.ecommerceapi.product.dto.ProductDTO;
import nyclab.ecommerce.ecommerceapi.productcategory.model.ProductCategory;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "date_created")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    public ProductDTO toDto(){
        return new ProductDTO(
                id,
                sku,
                name,
                description,
                category.toDto(),
                unitPrice,
                imageUrl,
                active,
                unitsInStock
        );
    }
}
