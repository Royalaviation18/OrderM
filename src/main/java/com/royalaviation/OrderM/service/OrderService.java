package com.royalaviation.OrderM.service;

import com.royalaviation.OrderM.entity.Item;
import com.royalaviation.OrderM.entity.Order;
import com.royalaviation.OrderM.entity.OrderEntity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    String createOrder(Order order);

    List<Order> readOrders();

    boolean deleteOrder(Long id);

    String updateOrder(Long id, Order order);
    Order readOrder(Long id);
    List<Order> findByCustomerEntityCustomerName(String customerName);
    List<Order> findByCompanyEntityId(Long id);
    List<Order> getAllOrders();
}
