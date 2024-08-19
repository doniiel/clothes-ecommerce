package com.e_commerce.clothes.web.mappers;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.web.dto.order.OrderDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper extends Mappable<Order, OrderDTO> {
}
