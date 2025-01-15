package com.example.demo.controller;

import com.example.demo.model.CustomerOrder;
import com.example.demo.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-orders")
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @PostMapping
    public String placeOrder(@RequestBody CustomerOrder customerOrder) {
        customerOrderService.placeOrder(customerOrder);
        return "Customer order placed successfully!";
    }

    @PutMapping("/{orderId}")
    public String updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {
        customerOrderService.updateOrderStatus(orderId, status);
        return "Customer order status updated successfully!";
    }

    @GetMapping("/{orderId}")
    public CustomerOrder getOrderDetails(@PathVariable Long orderId) {
        return customerOrderService.getOrderDetails(orderId);
    }
}
