package com.ecommerce_fullstack.user.entity;

import com.ecommerce_fullstack.user.dto.CartItemsDto;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;

    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Order order;

    public CartItemsDto getDto() {
        CartItemsDto cartItemsDto = new CartItemsDto();
        cartItemsDto.setId(id);
        cartItemsDto.setPrice(price);
        cartItemsDto.setQuantity(quantity);
        cartItemsDto.setOrderId(order.getId());
        cartItemsDto.setProductId(product.getId());
        cartItemsDto.setUserId(user.getId());
        cartItemsDto.setProductName(product.getName());
        cartItemsDto.setReturnedImg(product.getImg());
        return cartItemsDto;
    }
}
