package com.e_commerce.clothes.web.controller;


import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.order.Shipment;
import com.e_commerce.clothes.domain.entity.payment.PaymentMethod;
import com.e_commerce.clothes.domain.entity.user.User;
import com.e_commerce.clothes.service.OrderService;
import com.e_commerce.clothes.service.ShipmentService;
import com.e_commerce.clothes.service.UserService;
import com.e_commerce.clothes.web.dto.order.ShipmentDTO;
import com.e_commerce.clothes.web.mappers.ShipmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shipment")
public class ShipmentController {

    private final ShipmentService shipmentService;
    private final UserService userService;
    private final OrderService orderService;

    private final ShipmentMapper shipmentMapper;

    @GetMapping("/{id}")
    public ShipmentDTO getById(@PathVariable Long id) {
        Shipment shipment = shipmentService.getById(id);
        return shipmentMapper.toDto(shipment);
    }

    @GetMapping
    public List<ShipmentDTO> getAll() {
        List<Shipment> shipments = shipmentService.getAll();
        return shipmentMapper.toDto(shipments);
    }

    @GetMapping("/paymentMethod/{paymentMethodName}")
    public List<ShipmentDTO> getAllByPaymentName(@PathVariable String paymentMethodName) {
        try {
            PaymentMethod paymentMethod = PaymentMethod.valueOf(paymentMethodName.toUpperCase());
            List<Shipment> shipments = shipmentService.getAllByPaymentMethod(paymentMethod);
            return shipmentMapper.toDto(shipments);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid payment method: " + paymentMethodName);
        }
    }

    @GetMapping("/user/{user_id}")
    public ShipmentDTO getByUserID(@PathVariable Long user_id) {
        User user = userService.getById(user_id);
        Shipment shipment = shipmentService.getByUser(user);
        return shipmentMapper.toDto(shipment);
    }

    @GetMapping("/order/{order_id}")
    public ShipmentDTO getByOrderID(@PathVariable Long order_id) {
        Order order = orderService.getById(order_id);
        Shipment shipment = shipmentService.getByOrder(order);
        return shipmentMapper.toDto(shipment);
    }

    @PutMapping
    public ShipmentDTO update(@RequestBody ShipmentDTO shipmentDTO) {
        Shipment shipment = shipmentMapper.toEntity(shipmentDTO);
        Shipment dbShipment = shipmentService.update(shipment);
        return shipmentMapper.toDto(dbShipment);
    }

    @PostMapping
    public ShipmentDTO create(@RequestBody ShipmentDTO shipmentDTO) {
        Shipment shipment = shipmentMapper.toEntity(shipmentDTO);
        Shipment dbShipment = shipmentService.create(shipment);
        return shipmentMapper.toDto(dbShipment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        shipmentService.delete(id);
    }
}
