package com.e_commerce.clothes.service;

import com.e_commerce.clothes.domain.entity.cart.Cart;
import com.e_commerce.clothes.domain.entity.cart.CartItems;
import com.e_commerce.clothes.domain.entity.user.User;

import java.util.List;

public interface CartService {
    Cart getById(Long id);
    List<Cart> getAll();
    Cart getByUser(User user);
    Cart update(Cart cart);
    Cart create(Cart cart);
    void delete(Long id);
    List<CartItems> getAllItems(Long cart_id);

}
