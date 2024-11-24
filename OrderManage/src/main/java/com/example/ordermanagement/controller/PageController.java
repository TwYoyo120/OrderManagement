package com.example.ordermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    // 訂單管理頁面
    @GetMapping("/order-management")
    public String adminOrderManagement() {
        return "adminOrderManagement"; // 對應 resources/templates/adminOrderManagement.html
    }

    // 物流追蹤頁面
    @GetMapping("/shipping-tracking")
    public String adminShippingTracking() {
        return "adminShippingTracking"; // 對應 resources/templates/adminShippingTracking.html
    }
}