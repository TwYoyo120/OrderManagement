package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.ShippingInfo;
import com.example.ordermanagement.service.OrderService;
import com.example.ordermanagement.service.ShippingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/shipping")
public class ShippingInfoController {

    @Autowired
    private ShippingInfoService shippingInfoService;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Map<String, Object>> getOrderShippingInfo(
            @RequestParam(required = false) Long orderId,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Long buyerId) {
        return shippingInfoService.getOrderShippingInfo(orderId, status, buyerId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateShippingInfo(@PathVariable Long id, @RequestBody ShippingInfo updatedInfo) {
        boolean updated = shippingInfoService.updateShippingInfo(id, updatedInfo);
        return updated ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ShippingInfo> getShippingInfoById(@PathVariable Long id) {
        return shippingInfoService.getShippingInfoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
}
