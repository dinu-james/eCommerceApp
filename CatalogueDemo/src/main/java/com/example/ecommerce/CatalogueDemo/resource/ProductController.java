package com.example.ecommerce.CatalogueDemo.resource;

import com.example.ecommerce.CatalogueDemo.entity.Product;
import com.example.ecommerce.CatalogueDemo.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/p1/products")
@Api("Set of Endpoints")
public class ProductController {
private final ProductService productService;
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    public ProductController(ProductService productRepository) {
        this.productService = productRepository;
    }

    @ApiOperation("Get a product by ID")
    @GetMapping(value = "/{productId}")
    public ResponseEntity<Optional<Product>> retriveProductById (@PathVariable Long productId){
        return ResponseEntity.status(HttpStatus.OK).body(productService.retrieveProductById(productId));
    }

    @ApiOperation("Get all products")
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Product>> retriveAllProducts (){
        return ResponseEntity.status(HttpStatus.OK).body(productService.retrieveAllProducts());
    }

    @GetMapping(value = "/getAllProduct")
    public List<Product> getAllProducts(){
        return productService.retrieveAllProducts();
    }
    
    @ApiOperation("create product")
    @PostMapping(value="/CreateProduct")
    public ResponseEntity<String> CreateProduct(@Valid@RequestBody Product product){
        String responseRes = productService.createProduct(product);
       return ResponseEntity.status(HttpStatus.OK).body(responseRes);
    }


    @ApiOperation("Update a product. 404 if the product is not found.")
    @PutMapping(value = "/{productId}")
    public ResponseEntity<Void> updatePerson(@PathVariable Long productId,
                                             @RequestBody Product product) {
        Long version = productService.updateProduct(productId,product);
        LOG.info("Product update is successful, productId={}", productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

    //4.Delete Person
    @ApiOperation("Delete a product. 404 if the product is not found.")
    @DeleteMapping(value = "/{productId}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        LOG.info("Product delete is successful, productId={}", productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .build();
    }

}
