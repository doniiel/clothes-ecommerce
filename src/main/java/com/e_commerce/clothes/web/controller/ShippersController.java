
package com.e_commerce.clothes.web.controller;

import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.domain.entity.product.Shippers;
import com.e_commerce.clothes.service.ShippersService;
import com.e_commerce.clothes.web.dto.product.ProductDTO;
import com.e_commerce.clothes.web.dto.product.ShipperDTO;
import com.e_commerce.clothes.web.mappers.ProductMapper;
import com.e_commerce.clothes.web.mappers.ShipperMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/shippers")
public class ShippersController {

    private final ShippersService shippersService;

    private final ShipperMapper shipperMapper;
    private final ProductMapper productMapper;



    @GetMapping("/{id}")
    public ShipperDTO getByID(@PathVariable Long id) {
        Shippers shippers = shippersService.getById(id);
        return shipperMapper.toDto(shippers);
    }

    @GetMapping("/email/{email}")
    public ShipperDTO getByEmail(@PathVariable String email) {
        Shippers shippers = shippersService.findByEmail(email);
        return shipperMapper.toDto(shippers);
    }

    @GetMapping("/company/{companyName}")
    public ShipperDTO getByCompanyName(@PathVariable String companyName) {
        Shippers shippers = shippersService.findByCompanyName(companyName);
        return shipperMapper.toDto(shippers);
    }

    @GetMapping("/product/{product}")
    public ShipperDTO getByProduct(@PathVariable ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Shippers shippers = shippersService.findByProducts(product);
        return shipperMapper.toDto(shippers);
    }

    @PutMapping
    public ShipperDTO update(@RequestBody ShipperDTO shipperDTO) {
        Shippers shippers = shipperMapper.toEntity(shipperDTO);
        Shippers dbShippers = shippersService.update(shippers);
        return shipperMapper.toDto(dbShippers);
    }

    @PostMapping
    public ShipperDTO create(@RequestBody ShipperDTO shipperDTO) {
        Shippers shippers = shipperMapper.toEntity(shipperDTO);
        Shippers dbShippers = shippersService.create(shippers);
        return shipperMapper.toDto(dbShippers);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        shippersService.delete(id);
    }

}
