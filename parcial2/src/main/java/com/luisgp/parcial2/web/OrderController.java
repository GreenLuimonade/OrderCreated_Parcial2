package com.luisgp.parcial2.web;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luisgp.parcial2.request.ProductRequest;
import com.luisgp.parcial2.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void createOrder(@RequestParam Integer customerId, @RequestBody List<ProductRequest> productList) {
        orderService.createOrder(customerId, productList);
    }
}
