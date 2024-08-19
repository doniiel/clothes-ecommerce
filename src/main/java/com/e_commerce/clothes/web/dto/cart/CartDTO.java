package com.e_commerce.clothes.web.dto.cart;


import com.e_commerce.clothes.domain.entity.user.User;
import lombok.Data;

@Data
public class CartDTO {
    private Long id;
    private Long userId;
    private double totalPrice;
}
