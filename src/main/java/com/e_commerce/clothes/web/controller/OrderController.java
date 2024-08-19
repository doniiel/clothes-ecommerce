package com.e_commerce.clothes.web.controller;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.service.OrderService;
import com.e_commerce.clothes.web.dto.order.OrderDTO;
import com.e_commerce.clothes.web.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    @GetMapping("/{id}")
    public OrderDTO getById(@PathVariable  Long id) {
        Order order = orderService.getById(id);
        return orderMapper.toDto(order);
    }

    @GetMapping
    public List<OrderDTO> getAll() {
        List<Order> orders = orderService.getAll();
        return orderMapper.toDto(orders);
    }

    @PutMapping
    public OrderDTO update(@RequestBody OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        Order dbOrder = orderService.update(order);
        return orderMapper.toDto(dbOrder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}
