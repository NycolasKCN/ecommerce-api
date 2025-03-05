package nyclab.ecommerce.ecommerceapi.product.controller;

import lombok.extern.slf4j.Slf4j;
import nyclab.ecommerce.ecommerceapi.product.dto.ProductDTO;
import nyclab.ecommerce.ecommerceapi.product.model.Product;
import nyclab.ecommerce.ecommerceapi.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/v1/api/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getProducts(
            Pageable pageable
    ) {
        log.debug("getProducts called with page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());

        Page<Product> products = productService.getProducts(pageable);
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

    @GetMapping("/search/findByCategoryId")
    public Page<ProductDTO> findByCategoryId(
            @RequestParam("id") Long id,
            Pageable pageable
    ) {
        log.debug("findByCategoryId called with id={}, page={}, size={}", id, pageable.getPageNumber(), pageable.getPageSize());

        Page<Product> products = productService.findByCategoryId(id, pageable);
        Page<ProductDTO> productsDto = products.map(Product::toDto);

        log.debug("findByCategoryId returned {} products", products.getTotalElements());

        return productsDto;
    }

    @GetMapping("/search/findByNameContaining")
    public Page<ProductDTO> findByProductNameContaining(
            @RequestParam("name") String name,
            Pageable pageable
    ) {
        log.debug("findByProductNameContaining called with name={}, page={}, size={}", name, pageable.getPageNumber(), pageable.getPageSize());

        Page<Product> products = productService.findByProductNameContaining(name, pageable);
        Page<ProductDTO> productsDto = products.map(Product::toDto);

        log.debug("findByProductNameContaining returned {} products", products.getTotalElements());

        return productsDto;
    }
}
