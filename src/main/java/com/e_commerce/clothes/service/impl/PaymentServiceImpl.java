package com.e_commerce.clothes.service.impl;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.payment.Payment;
import com.e_commerce.clothes.domain.entity.payment.PaymentMethod;
import com.e_commerce.clothes.domain.exception.ResourceNotFoundException;
import com.e_commerce.clothes.repository.PaymentRepository;
import com.e_commerce.clothes.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;


    @Override
    public Payment getById(Long id) {
        return paymentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Payment with id: " + id + " not found")
        );
    }

    @Override
    public Payment getByOrder(Order order) {
        return paymentRepository.findByOrder(order).orElseThrow(
                () -> new ResourceNotFoundException("Payment with order: " + order + " not found")
        );
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getAllByPaymentMethod(PaymentMethod paymentMethod) {
        return paymentRepository.findAllByPaymentMethod(paymentMethod);
    }

    @Override
    public Payment update(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment create(Payment payment) {
        if (payment.getPaymentDate() == null || payment.getAmount() <= 0 || payment.getPaymentMethod() == null) {
            throw new RuntimeException("Payment data can`t be null");
        }
        paymentRepository.save(payment);
        return payment;
    }

    @Override
    public void delete(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Payment with id: " + id + " not found")
        );
        paymentRepository.save(payment);
    }
}
