package com.e_commerce.clothes.web.mappers;

import com.e_commerce.clothes.domain.entity.cart.Cart;
import com.e_commerce.clothes.web.dto.cart.CartDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper extends Mappable<Cart, CartDTO> {

}
