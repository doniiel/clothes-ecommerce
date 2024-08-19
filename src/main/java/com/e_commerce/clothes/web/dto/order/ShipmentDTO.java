package com.e_commerce.clothes.web.dto.order;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.payment.PaymentMethod;
import com.e_commerce.clothes.domain.entity.user.User;
import lombok.Data;

@Data
public class ShipmentDTO {
    private Long id;
    private Order order;
    private User user;
    private PaymentMethod paymentMethod;
    private double deliveryCost;
    private double discount;
    private double price;
}
