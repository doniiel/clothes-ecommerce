package com.e_commerce.clothes.web.controller;

import com.e_commerce.clothes.domain.entity.cart.Cart;
import com.e_commerce.clothes.domain.entity.cart.CartItems;
import com.e_commerce.clothes.service.CartService;
import com.e_commerce.clothes.web.dto.cart.CartDTO;
import com.e_commerce.clothes.web.mappers.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    private final CartMapper cartMapper;


    @GetMapping("/{id}")
    public CartDTO getCart(@PathVariable Long id) {
        Cart cart = cartService.getById(id);
        return cartMapper.toDto(cart);
    }
    @GetMapping("")
    public List<CartDTO> getCarts() {
        List<Cart> carts = cartService.getAll();
        return cartMapper.toDto(carts);
    }
    @PutMapping
    public CartDTO update(@RequestBody CartDTO cartDTO) {
        Cart cart = cartMapper.toEntity(cartDTO);
        Cart newCart = cartService.update(cart);
        return cartMapper.toDto(newCart);
    }
    @GetMapping("/{id}/items")
    public List<CartItems> getAllItems(@PathVariable Long id) {
        return cartService.getAllItems(id);
    }
}
