package com.e_commerce.clothes.domain.entity.cart;

import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.domain.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_items")
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_items_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @Column(name = "discount", nullable = false)
    private Double discount;
}
