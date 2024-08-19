package com.e_commerce.clothes.web.mappers;

import com.e_commerce.clothes.domain.entity.product.Shippers;
import com.e_commerce.clothes.web.dto.product.ShipperDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShipperMapper extends Mappable<Shippers, ShipperDTO> {
}
