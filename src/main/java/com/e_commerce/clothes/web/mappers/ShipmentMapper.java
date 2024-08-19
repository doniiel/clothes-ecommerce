package com.e_commerce.clothes.web.mappers;

import com.e_commerce.clothes.domain.entity.order.Shipment;
import com.e_commerce.clothes.web.dto.order.ShipmentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShipmentMapper extends Mappable<Shipment, ShipmentDTO> {
}
