package com.ecommerce_fullstack.user.controller.customer;

import com.ecommerce_fullstack.user.dto.AddProductInCartDto;
import com.ecommerce_fullstack.user.dto.OrderDto;
import com.ecommerce_fullstack.user.dto.PlaceOrderDto;
import com.ecommerce_fullstack.user.exceptions.ValidationException;
import com.ecommerce_fullstack.user.services.customer.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping("/cart")
    public ResponseEntity<?> addProductToCart(@RequestBody AddProductInCartDto addProductInCartDto) {
        return cartService.addProductToCart(addProductInCartDto);
    }

    @PostMapping("/addition")
    public ResponseEntity<OrderDto> increaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto) {
        OrderDto orderDto = cartService.increaseProductQuantity(addProductInCartDto);
        if (orderDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/deduction")
    public ResponseEntity<OrderDto> decreaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto) {
        OrderDto orderDto = cartService.decreaseProductQuantity(addProductInCartDto);
        if (orderDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<OrderDto> placeOrder(@RequestBody PlaceOrderDto placeOrderDto) {
        OrderDto orderDto = cartService.placeOrder(placeOrderDto);
        if (orderDto != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(orderDto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/cart/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable Long userId) {
        OrderDto orderDto = cartService.getCartByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

    @GetMapping("/coupon/{userId}/{code}")
    public ResponseEntity<?> applyCoupon(@PathVariable Long userId, @PathVariable String code) {
        try {
            OrderDto orderDto = cartService.applyCoupon(userId, code);
            return ResponseEntity.ok(orderDto);
        } catch (ValidationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
