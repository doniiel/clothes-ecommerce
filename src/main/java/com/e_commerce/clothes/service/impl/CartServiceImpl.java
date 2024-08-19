package com.e_commerce.clothes.service.impl;

import com.e_commerce.clothes.domain.entity.cart.Cart;
import com.e_commerce.clothes.domain.entity.cart.CartItems;
import com.e_commerce.clothes.domain.entity.user.User;
import com.e_commerce.clothes.domain.exception.ResourceNotFoundException;
import com.e_commerce.clothes.repository.CartRepository;
import com.e_commerce.clothes.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public Cart getById(Long id) {
        return cartRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cart with id: " + id + " not found")
        );
    }
    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getByUser(User user) {
        return cartRepository.findByUser(user).orElseThrow(
                () -> new ResourceNotFoundException("Cart with user: " + user + " not found")
        );
    }

    @Override
    public Cart update(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart create(Cart cart) {
        if(cart.getUser() == null || cart.getCartItems() == null) {
            throw  new RuntimeException("Cart data can`t be null");
        }
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public void delete(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("cart with id: " + id + " not found")
        );
        cartRepository.delete(cart);
    }

    @Override
    public List<CartItems> getAllItems(Long cart_id) {
        if (!cartRepository.findById(cart_id).isPresent()) {
            throw new ResourceNotFoundException("Cart with id: " + cart_id +" not found");
        }
        return cartRepository.getAllByCart(cart_id);
    }
}
