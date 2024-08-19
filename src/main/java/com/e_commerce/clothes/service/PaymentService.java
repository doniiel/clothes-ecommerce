package com.e_commerce.clothes.service;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.payment.Payment;
import com.e_commerce.clothes.domain.entity.payment.PaymentMethod;

import java.util.List;

public interface PaymentService {

    Payment getById(Long id);
    Payment getByOrder(Order order);
    List<Payment> getAll();
    List<Payment> getAllByPaymentMethod(PaymentMethod paymentMethod);
    Payment update(Payment payment);
    Payment create(Payment payment);
    void delete(Long id);
}
