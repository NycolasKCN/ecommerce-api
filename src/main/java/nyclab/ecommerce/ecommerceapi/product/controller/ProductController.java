package nyclab.ecommerce.ecommerceapi.product.controller;

import lombok.extern.slf4j.Slf4j;
import nyclab.ecommerce.ecommerceapi.product.dto.ProductDTO;
import nyclab.ecommerce.ecommerceapi.product.model.Product;
import nyclab.ecommerce.ecommerceapi.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/v1/api/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getProducts(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        log.debug("getProducts called with page={}, size={}", page, size);

        Page<Product> products = productService.getProducts(page, size);
        Page<ProductDTO> productsDto = products.map(Product::toDto);

        log.debug("getProducts returned {} products", products.getTotalElements());

        return ResponseEntity.ok().body(productsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(
            @PathVariable Long id
    ) {
        log.debug("getProduct called with id={}", id);

        Product product = productService.getProduct(id);
        ProductDTO dto = product.toDto();

        log.debug("getProduct returned product with id={}", product.getId());

        return ResponseEntity.ok().body(dto);
    }
}
