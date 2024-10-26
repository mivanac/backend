package com.ecommerce_fullstack.user.services.customer;

import com.ecommerce_fullstack.user.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerProductService {

    List<ProductDto> getAllProducts();

    List<ProductDto> searchProductByTitle(String name);

}
