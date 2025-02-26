package nyclab.ecommerce.ecommerceapi.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import nyclab.ecommerce.ecommerceapi.productcategory.dto.ProductCategoryDTO;

@Data
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String sku;
    private String name;
    private String description;
    private ProductCategoryDTO category;
    private double unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;
}
