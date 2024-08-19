package com.e_commerce.clothes.service.impl;

import com.e_commerce.clothes.domain.entity.product.Category;
import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.domain.entity.product.Shippers;
import com.e_commerce.clothes.domain.exception.ResourceNotFoundException;
import com.e_commerce.clothes.repository.ProductRepository;
import com.e_commerce.clothes.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id: " + id + " not found")
        );
    }
    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name).orElseThrow(
                () -> new ResourceNotFoundException("Product with name: " + name + " not found")
        );
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getByCategory(Category category) {
        return productRepository.findByCategory(category);
    }
    @Override
    public List<Product> getAllByShippers(Shippers shippers) {
        return productRepository.findAllByShippers(shippers);
    }
    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product create(Product product) {
        if (product.getCategory() == null || product.getQuantity() <= 0 || product.getPrice() <= 0) {
            throw new RuntimeException("Product data is can`t be null");
        }
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product with id: " + id + " not found")
        );
        productRepository.delete(product);
    }
    @Override
    public Category getByCategoryName(String categoryName) {
        if (StringUtils.isEmpty(categoryName)) {
            throw new RuntimeException("category name is not be null");
        }
        return productRepository.findByCategoryName(categoryName);
    }
}
