package nyclab.ecommerce.ecommerceapi.productcategory.service;

import nyclab.ecommerce.ecommerceapi.productcategory.model.ProductCategory;
import nyclab.ecommerce.ecommerceapi.productcategory.repository.ProductCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public Page<ProductCategory> getProductCategories(Pageable pageable) {
        return productCategoryRepository.findAll(pageable);
    }
}
