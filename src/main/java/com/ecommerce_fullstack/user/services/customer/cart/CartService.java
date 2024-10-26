package com.ecommerce_fullstack.user.services.customer.cart;

import com.ecommerce_fullstack.user.dto.AddProductInCartDto;
import com.ecommerce_fullstack.user.dto.OrderDto;
import com.ecommerce_fullstack.user.dto.PlaceOrderDto;
import org.springframework.http.ResponseEntity;

public interface CartService {

    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);
    OrderDto getCartByUserId(Long userId);
    OrderDto applyCoupon(Long userId, String code);
    OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);
    OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);
    OrderDto placeOrder(PlaceOrderDto placeOrderDto);
}
