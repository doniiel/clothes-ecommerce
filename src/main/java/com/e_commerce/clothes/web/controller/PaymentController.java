package com.e_commerce.clothes.web.controller;

import com.e_commerce.clothes.domain.entity.payment.Payment;
import com.e_commerce.clothes.service.PaymentService;
import com.e_commerce.clothes.web.dto.payment.PaymentDTO;
import com.e_commerce.clothes.web.mappers.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @GetMapping("/{id}")
    public PaymentDTO getById(@PathVariable Long id) {
        Payment payment = paymentService.getById(id);
        return paymentMapper.toDto(payment);
    }

    @GetMapping
    public List<PaymentDTO> getAll() {
        List<Payment> payments = paymentService.getAll();
        return paymentMapper.toDto(payments);
    }

    @PutMapping
    public PaymentDTO update(@RequestBody Payment payment) {
        Payment dbPayment = paymentService.update(payment);
        return paymentMapper.toDto(dbPayment);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        paymentService.delete(id);
    }
}
