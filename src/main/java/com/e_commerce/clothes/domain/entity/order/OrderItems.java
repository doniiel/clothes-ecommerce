package com.e_commerce.clothes.domain.entity.order;

import com.e_commerce.clothes.domain.entity.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_items_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "order_product_price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Transient
    @Column(name = "price_total")
    private Double totalPrice;


    @PostLoad
    private void calculateTotalPrice() {
        this.totalPrice = (price - (price * discount / 100)) * quantity;
    }

}
