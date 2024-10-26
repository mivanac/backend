package com.ecommerce_fullstack.user.services.admin.coupon;

import com.ecommerce_fullstack.user.entity.Coupon;

import java.util.List;

public interface AdminCouponService {

    Coupon createCoupon(Coupon coupon);
    List<Coupon> getAllCoupons();
}
