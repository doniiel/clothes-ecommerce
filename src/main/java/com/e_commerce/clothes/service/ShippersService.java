package com.e_commerce.clothes.service;

import com.e_commerce.clothes.domain.entity.order.Order;
import com.e_commerce.clothes.domain.entity.payment.PaymentMethod;
import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.domain.entity.product.Shippers;
import com.e_commerce.clothes.domain.entity.user.User;

public interface ShippersService {
    Shippers getById(Long id);
    Shippers findByEmail(String email);
    Shippers findByCompanyName(String companyName);
    Shippers findByProducts(Product product);

    Shippers update(Shippers shippers);
    Shippers create(Shippers shippers);
    void delete(Long id);

}
