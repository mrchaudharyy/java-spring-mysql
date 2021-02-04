package com.mic.couponservice.controllers;

import com.mic.couponservice.models.Coupon;
import com.mic.couponservice.repository.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CouponServiceController {

    @Autowired
    private CouponRepo repo;

    @PostMapping("/coupon")
    private Coupon addCoupon(@RequestBody Coupon coupon){
        return repo.save(coupon);
    }

    @GetMapping("/coupon/{code}")
    private Coupon getCoupon(@PathVariable("code") String coupon){
        return repo.findByCode(coupon);
    }
}
