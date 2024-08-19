package com.e_commerce.clothes.service.impl;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.order.Shipment;
import com.e_commerce.clothes.domain.entity.payment.PaymentMethod;
import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.domain.entity.product.Shippers;
import com.e_commerce.clothes.domain.entity.user.User;
import com.e_commerce.clothes.domain.exception.ResourceNotFoundException;
import com.e_commerce.clothes.repository.ShipmentRepository;
import com.e_commerce.clothes.service.ShipmentService;
import com.e_commerce.clothes.service.ShippersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;


    @Override
    public Shipment getById(Long id) {
        return shipmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Shipment with id: " + id + " not found")
        );
    }

    @Override
    public List<Shipment> getAll() {
        return shipmentRepository.findAll();
    }


    @Override
    public Shipment update(Shipment shipment) {
        if (!shipmentRepository.existsById(shipment.getId())) {
            throw new ResourceNotFoundException("Shipment with id: " + shipment.getId() + " not found");
        }
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment create(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getByUser(User user) {
        return shipmentRepository.findByUser(user).orElseThrow(
                () -> new ResourceNotFoundException("Shipment with user: " + user + " not found")
        );
    }

    @Override
    public Shipment getByOrder(Order order) {
        return shipmentRepository.findByOrder(order).orElseThrow(
                () -> new ResourceNotFoundException("Shipment with order: " + order + " not found")
        );
    }

    @Override
    public List<Shipment> getAllByPaymentMethod(PaymentMethod paymentMethod) {
        return shipmentRepository.findAllByPaymentMethod(paymentMethod);
    }

    @Override
    public void delete(Long id) {
        Shipment shipment = shipmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Shipment with id: " + id + " not found")
        );
        shipmentRepository.delete(shipment);
    }
}