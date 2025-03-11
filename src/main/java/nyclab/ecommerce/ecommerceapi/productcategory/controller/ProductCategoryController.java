package nyclab.ecommerce.ecommerceapi.productcategory.controller;

import lombok.extern.slf4j.Slf4j;
import nyclab.ecommerce.ecommerceapi.productcategory.domain.ProductCategory;
import nyclab.ecommerce.ecommerceapi.productcategory.dto.ProductCategoryDTO;
import nyclab.ecommerce.ecommerceapi.productcategory.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/api/product-categories", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @Autowired
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public Page<ProductCategoryDTO> getProductCategories(
            Pageable pageable
    ) {
        log.debug("getProductCategories called with page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());

        Page<ProductCategory> productCategories = productCategoryService.getProductCategories(pageable);
        Page<ProductCategoryDTO> productCategoriesDto = productCategories.map(ProductCategory::toDto);

        log.debug("getProductCategories returned {} product categories", productCategories.getTotalElements());

        return productCategoriesDto;
    }
}
