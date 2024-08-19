package com.e_commerce.clothes.repository;

import com.e_commerce.clothes.domain.entity.product.Category;
import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.domain.entity.product.Shippers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    @Query("SELECT p FROM Product p JOIN p.category c WHERE c = :category")
    List<Product> findByCategory(@Param("category") Category category);
    @Query("SELECT p FROM  Product p JOIN p.shippers sh WHERE sh = :shippers")
    List<Product> findAllByShippers(@Param("shippers") Shippers shippers);

    @Query("SELECT p.category FROM Product p WHERE p.category.name = :category_name")
    Category findByCategoryName(@Param("category_name") String categoryName);

}
