package com.e_commerce.clothes.repository;

import com.e_commerce.clothes.domain.entity.cart.Cart;
import com.e_commerce.clothes.domain.entity.cart.CartItems;
import com.e_commerce.clothes.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("SELECT c FROM Cart c JOIN c.user u WHERE u = :user")
    Optional<Cart> findByUser(@Param("user") User user);

    @Query("SELECT ci FROM CartItems ci JOIN ci.cart c WHERE c.id = :cart_id")
    List<CartItems> getAllByCart(@Param("cart_id") Long id);
}
