package com.ecommerce_fullstack.user.dto;

import lombok.Data;

@Data
public class CartItemsDto {
// Temp solution

    private Long id;

    private Long price;

    private Long quantity;

    private Long productId;

    private Long userId;

    private Long orderId;

    private String productName;

    private byte[] returnedImg;
}
