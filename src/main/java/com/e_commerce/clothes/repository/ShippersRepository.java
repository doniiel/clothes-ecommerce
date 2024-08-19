package com.e_commerce.clothes.repository;

import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.domain.entity.product.Shippers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShippersRepository extends JpaRepository<Shippers,Long> {
    Optional<Shippers> findById(Long id);
    Optional<Shippers> findByCompanyName(String companyName);
    Optional<Shippers> findByEmail(String email);

   @Query("SELECT s FROM Shippers s JOIN s.products p where p = :product")
    Optional<Shippers> findByProducts(Product product);



}
