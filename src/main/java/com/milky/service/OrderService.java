package com.milky.service;

import com.milky.entity.Order;
import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Integer id);
    List<Order> getOrdersByUserId(Integer userId);
    void deleteOrder(Integer id);
    boolean confirmOrder(Integer id);
}
