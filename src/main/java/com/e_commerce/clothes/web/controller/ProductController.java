package com.e_commerce.clothes.web.controller;


import com.e_commerce.clothes.domain.entity.product.Category;
import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.service.ProductService;
import com.e_commerce.clothes.web.dto.product.ProductDTO;
import com.e_commerce.clothes.web.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        return productMapper.toDto(product);
    }

    @GetMapping("/name/{name}")
    public ProductDTO getByName(@PathVariable String name) {
        Product product = productService.getByName(name);
        return productMapper.toDto(product);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        List<Product> product = productService.getAll();
        return productMapper.toDto(product);
    }

    @GetMapping("/category/{categoryName}")
    public List<ProductDTO> getByCategory(@PathVariable String categoryName) {
        Category category = productService.getByCategoryName(categoryName);
        List<Product> products = productService.getByCategory(category);
        return productMapper.toDto(products);
    }

    @PutMapping
    public ProductDTO update(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product dbProduct = productService.update(product);
        return productMapper.toDto(dbProduct);
    }

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product dbProduct = productService.create(product);
        return productMapper.toDto(dbProduct);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
