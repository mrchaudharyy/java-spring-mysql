package com.mic.productservice.controllers;

import com.mic.productservice.models.Coupon;
import com.mic.productservice.models.Product;
import com.mic.productservice.repository.ProductRepo;
import com.mic.productservice.services.FeignClientCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductServiceController {

    @Autowired
    private ProductRepo repo;

    @Autowired
    private FeignClientCouponService couponService;

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {
        Coupon coupon = couponService.getCoupon(product.getCoupon());
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return repo.save(product);
    }

    @GetMapping("/product/{name}")
    public Product getProduct(@PathVariable("name") String productName) {
        return repo.getProductByName(productName);
    }
}
