package com.e_commerce.clothes.service;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.order.OrderStatus;
import com.e_commerce.clothes.domain.entity.user.User;

import java.util.List;

public interface OrderService {
    Order getById(Long id);
    List<Order> getAll();
    List<Order> getAllByUser(User user);
    List<Order> getAllByOrderStatus(OrderStatus orderStatus);
    Order update(Order order);
    Order create(Order order);
    void delete(Long id);
}
