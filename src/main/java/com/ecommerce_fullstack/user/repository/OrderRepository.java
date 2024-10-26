package com.ecommerce_fullstack.user.repository;

import com.ecommerce_fullstack.user.entity.CartItems;
import com.ecommerce_fullstack.user.entity.Order;
import com.ecommerce_fullstack.user.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public Order findByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);
}
