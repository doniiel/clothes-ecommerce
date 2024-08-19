package com.e_commerce.clothes.repository;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.order.OrderStatus;
import com.e_commerce.clothes.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);

    @Query("SELECT or FROM Order or JOIN or.user u WHERE u = :user")
    List<Order> findAllByUser(@Param("user") User user);
    @Query("SELECT or FROM Order or WHERE or.orderStatus = :orderStatus ")
    List<Order> findAllByOrderStatus(@Param("orderStatus") OrderStatus orderStatus);
}
