package com.e_commerce.clothes.domain.entity.order;

import com.e_commerce.clothes.domain.entity.payment.PaymentMethod;
import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.domain.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shipment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(mappedBy = "shipment", fetch = FetchType.LAZY)
    private List<Product> products;

    @Enumerated(EnumType.STRING)
    @Column(name = "shipment_type")
    private ShipmentType shipmentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @Column(name = "delivery_cost")
    private double deliveryCost;

    @Column(name = "discount")
    private double discount;

    @Column(name = "total_price")
    private double price;
}
