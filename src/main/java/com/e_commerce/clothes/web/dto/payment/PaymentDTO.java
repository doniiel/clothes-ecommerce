package com.e_commerce.clothes.web.dto.payment;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.payment.Payment;
import com.e_commerce.clothes.domain.entity.payment.PaymentMethod;
import lombok.Data;
import org.mapstruct.Mapper;
import org.springframework.core.SpringVersion;

import java.time.LocalDate;

@Data
public class PaymentDTO {
    private Long id;
    private Order order;
    private LocalDate paymentDate;
    private double amount;
    private PaymentMethod paymentMethod;
}
