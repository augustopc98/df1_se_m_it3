package com.example.demo.service;

import com.example.demo.model.CustomerOrder;

public interface CustomerOrderService {
    void placeOrder(CustomerOrder customerOrder);
    void updateOrderStatus(Long orderId, String status);
    CustomerOrder getOrderDetails(Long orderId);
}
