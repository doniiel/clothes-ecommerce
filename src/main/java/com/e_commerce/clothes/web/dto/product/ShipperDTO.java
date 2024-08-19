package com.e_commerce.clothes.web.dto.product;

import com.e_commerce.clothes.domain.entity.product.Product;
import lombok.Data;

import java.util.List;

@Data
public class ShipperDTO {
    private Long id;
    private String companyName;
    private String phone;
    private String email;
}
