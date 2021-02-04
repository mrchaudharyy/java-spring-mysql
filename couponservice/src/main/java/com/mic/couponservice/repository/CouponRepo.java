package com.mic.couponservice.repository;

import com.mic.couponservice.models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Long> {
    Coupon findByCode(String couponId);
}
