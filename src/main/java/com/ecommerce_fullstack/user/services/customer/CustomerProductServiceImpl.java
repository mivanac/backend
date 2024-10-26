package com.ecommerce_fullstack.user.services.customer;

import com.ecommerce_fullstack.user.dto.ProductDto;
import com.ecommerce_fullstack.user.entity.Product;
import com.ecommerce_fullstack.user.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream().map(Product::getDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> searchProductByTitle(String name) {
        return productRepository.findAllByNameContaining(name).stream().map(Product::getDto).collect(Collectors.toList());
    }



}
