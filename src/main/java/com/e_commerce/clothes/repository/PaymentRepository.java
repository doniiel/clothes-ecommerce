package com.e_commerce.clothes.repository;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.payment.Payment;
import com.e_commerce.clothes.domain.entity.payment.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT py FROM Payment py WHERE py.paymentMethod = :paymentMethod")
    List<Payment> findAllByPaymentMethod(@Param("paymentMethod") PaymentMethod paymentMethod);

    @Query("SELECT py FROM Payment py JOIN py.order or where or = :order")
    Optional<Payment> findByOrder(@Param("order") Order order);

}
