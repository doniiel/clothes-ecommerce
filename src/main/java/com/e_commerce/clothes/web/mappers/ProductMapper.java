package com.e_commerce.clothes.web.mappers;

import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.web.dto.product.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper extends Mappable<Product, ProductDTO> {
}
