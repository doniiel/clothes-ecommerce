package com.e_commerce.clothes.service;

import com.e_commerce.clothes.domain.entity.product.Category;
import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.domain.entity.product.Shippers;


import java.util.List;

public interface ProductService {
    Product getById(Long id);
    Product getByName(String name);
    List<Product> getAll();
    List<Product> getByCategory(Category category);
    List<Product> getAllByShippers(Shippers shippers);
    Product update(Product product);
    Product create(Product product);
    void delete(Long id);
    Category getByCategoryName(String categoryName);

}
