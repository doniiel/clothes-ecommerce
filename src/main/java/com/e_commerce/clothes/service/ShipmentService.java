package com.e_commerce.clothes.service;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.order.Shipment;
import com.e_commerce.clothes.domain.entity.payment.PaymentMethod;
import com.e_commerce.clothes.domain.entity.user.User;

import java.util.List;

public interface ShipmentService {
    Shipment getById(Long id);
    List<Shipment> getAll();
    Shipment update(Shipment shipment);
    Shipment create(Shipment shipment);
    Shipment getByUser(User user);
    Shipment getByOrder(Order order);
    List<Shipment> getAllByPaymentMethod(PaymentMethod paymentMethod);
    void delete(Long id);
}
