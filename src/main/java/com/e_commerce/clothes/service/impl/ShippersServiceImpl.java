package com.e_commerce.clothes.service.impl;

import com.e_commerce.clothes.domain.entity.product.Product;
import com.e_commerce.clothes.domain.entity.product.Shippers;
import com.e_commerce.clothes.domain.exception.ResourceNotFoundException;
import com.e_commerce.clothes.repository.ShippersRepository;
import com.e_commerce.clothes.service.ShippersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippersServiceImpl implements ShippersService {

    private final ShippersRepository shippersRepository;

    @Override
    public Shippers getById(Long id) {
        return shippersRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Shippers with id: "+ id + " not found")
        );
    }
    @Override
    public Shippers findByEmail(String email) {
        return shippersRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Shippers with email: " + email + " not found")
        );
    }
    @Override
    public Shippers findByCompanyName(String companyName) {
        return shippersRepository.findByCompanyName(companyName).orElseThrow(
                () -> new ResourceNotFoundException("Shippers with companyName: " + companyName + " not found")
        );
    }

    @Override
    public Shippers findByProducts(Product product) {
        return shippersRepository.findByProducts(product).orElseThrow(
                () -> new ResourceNotFoundException("Shippers with product: " + product +" not found")
        );
    }

    @Override
    public Shippers update(Shippers shippers) {
        shippersRepository.save(shippers);
        return shippers;
    }

    @Override
    public Shippers create(Shippers shippers) {
        if (shippers.getCompanyName().isEmpty() || shippers.getPhone().isEmpty() || shippers.getEmail().isEmpty()) {
            throw new IllegalStateException("Data is not be empty");
        }
        shippersRepository.save(shippers);
        return shippers;
    }

    @Override
    public void delete(Long id) {
       Shippers shippers = shippersRepository.findById(id).orElseThrow(
               () -> new ResourceNotFoundException("Shippers with id: " + id + " not found")
       );
       shippersRepository.delete(shippers);
    }
}
