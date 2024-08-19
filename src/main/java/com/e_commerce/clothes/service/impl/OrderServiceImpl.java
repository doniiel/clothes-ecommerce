package com.e_commerce.clothes.service.impl;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.order.OrderStatus;
import com.e_commerce.clothes.domain.entity.user.User;
import com.e_commerce.clothes.domain.exception.ResourceNotFoundException;
import com.e_commerce.clothes.repository.OrderRepository;
import com.e_commerce.clothes.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;


    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order with id: "  + id + " not found")
        );
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getAllByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

    @Override
    public List<Order> getAllByOrderStatus(OrderStatus orderStatus) {
        return orderRepository.findAllByOrderStatus(orderStatus);
    }
    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order create(Order order) {
        if (order.getUser() == null || order.getOrderDate() == null || order.getTotalPrice() == null || order.getShippingAddress() == null) {
            throw new RuntimeException("Order data can`t be null");
        }
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order with id: " + id + " not found")
        );

        orderRepository.delete(order);
    }
}
