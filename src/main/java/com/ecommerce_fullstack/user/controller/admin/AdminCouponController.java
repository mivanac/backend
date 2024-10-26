package com.ecommerce_fullstack.user.controller.admin;

import com.ecommerce_fullstack.user.entity.Coupon;
import com.ecommerce_fullstack.user.exceptions.ValidationException;
import com.ecommerce_fullstack.user.services.admin.coupon.AdminCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/coupons")
@RequiredArgsConstructor
public class AdminCouponController {


    private final AdminCouponService adminCouponService;

    @PostMapping
    public ResponseEntity<?> createCoupon(@RequestBody Coupon coupon) {
        try {
            Coupon createdCoupon = adminCouponService.createCoupon(coupon);
            return ResponseEntity.ok(createdCoupon);
        } catch (ValidationException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        return ResponseEntity.ok(adminCouponService.getAllCoupons());
    }
}
