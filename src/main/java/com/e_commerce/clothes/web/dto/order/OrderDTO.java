package com.e_commerce.clothes.web.dto.order;

import com.e_commerce.clothes.domain.entity.order.OrderItems;
import com.e_commerce.clothes.domain.entity.order.OrderStatus;
import com.e_commerce.clothes.domain.entity.user.User;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private User user;
    private List<OrderItems> orderItems;
    private LocalDate orderDate;
    private String shippingAddress;
    private Double totalPrice;
    private OrderStatus orderStatus;

}
