package com.example.demo.service;

import com.example.demo.model.CustomerOrder;
import com.example.demo.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    private final CustomerOrderRepository customerOrderRepository;

    @Autowired
    public CustomerOrderServiceImpl(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    @Override
    public void placeOrder(CustomerOrder customerOrder) {
        customerOrderRepository.save(customerOrder);
    }

    @Override
    public void updateOrderStatus(Long orderId, String status) {
        Optional<CustomerOrder> optionalOrder = customerOrderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            CustomerOrder customerOrder = optionalOrder.get();
            customerOrder.updateDeliveryStatus(status);
            customerOrderRepository.save(customerOrder);
        }
    }

    @Override
    public CustomerOrder getOrderDetails(Long orderId) {
        return customerOrderRepository.findById(orderId).orElse(null);
    }
}
