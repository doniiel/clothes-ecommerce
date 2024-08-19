package com.e_commerce.clothes.web.mappers;

import com.e_commerce.clothes.domain.entity.payment.Payment;
import com.e_commerce.clothes.web.dto.payment.PaymentDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends Mappable<Payment, PaymentDTO> {
}
