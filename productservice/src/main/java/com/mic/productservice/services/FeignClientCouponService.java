package com.mic.productservice.services;

import com.mic.productservice.models.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "couponservice", url = "localhost:9091")
public interface FeignClientCouponService {

    @GetMapping("/coupon/{code}")
    Coupon getCoupon(@PathVariable("code") String coupon);
}
