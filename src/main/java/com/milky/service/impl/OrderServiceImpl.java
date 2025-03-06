package com.milky.service.impl;

import com.milky.entity.Order;
import com.milky.repository.OrderRepository;
import com.milky.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getOrdersByUserId(Integer userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
    
    @Override
    public boolean confirmOrder(Integer id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setIsConfirmed(true);
            orderRepository.save(order);
            return true;
        }
        return false;
    }
}
