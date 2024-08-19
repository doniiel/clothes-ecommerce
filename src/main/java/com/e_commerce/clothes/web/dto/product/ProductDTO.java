package com.e_commerce.clothes.web.dto.product;

import com.e_commerce.clothes.domain.entity.product.Category;
import com.e_commerce.clothes.domain.entity.product.Review;
import com.e_commerce.clothes.domain.entity.product.Shippers;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private double price;
    private String description;
    private int quantity;


}
