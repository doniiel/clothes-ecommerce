package com.e_commerce.clothes.repository;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.order.Shipment;
import com.e_commerce.clothes.domain.entity.payment.PaymentMethod;
import com.e_commerce.clothes.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment,Long> {

    @Query("SELECT sh FROM Shipment sh WHERE sh.user = :user")
    Optional<Shipment> findByUser(@Param("user") User user);

    @Query("SELECT sh FROM Shipment sh WHERE sh.order = :order")
    Optional<Shipment> findByOrder(@Param("order") Order order);

    @Query("SELECT sh FROM Shipment sh WHERE sh.paymentMethod = :paymentMethod")
    List<Shipment> findAllByPaymentMethod(@Param("paymentMethod") PaymentMethod paymentMethod);


}
