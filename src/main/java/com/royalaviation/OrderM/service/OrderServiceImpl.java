package com.royalaviation.OrderM.service;

import com.royalaviation.OrderM.entity.*;
import com.royalaviation.OrderM.repository.OrderRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public String createOrder(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        // from to
        BeanUtils.copyProperties(order, orderEntity);
        orderEntity.setOrderDate(new Date());
        orderRepository.save(orderEntity);
        // orders.add(order);
        return "Saved Successfully";
    }

    @Override
    public List<Order> readOrders() {
        List<OrderEntity> ordersList = orderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        for (OrderEntity orderEntity : ordersList) {
            Order order = new Order();
            order.setId(orderEntity.getId());
            order.setTotalAmount(orderEntity.getTotalAmount());
            order.setTotalQuantity(orderEntity.getTotalQuantity());
            order.setOrderDate(orderEntity.getOrderDate());
            order.setCompanyEntity(orderEntity.getCompanyEntity());
            order.setCustomerEntity(orderEntity.getCustomerEntity());
            order.setItemEntity(orderEntity.getItemEntity());
            orders.add(order);
        }
        return orders;
    }

    @Override
    public boolean deleteOrder(Long id) {
        OrderEntity ord = orderRepository.findById(id).get();
        orderRepository.delete(ord);
        return true;
    }

    @Override
    public String updateOrder(Long id, Order order) {
        OrderEntity existingOrder = orderRepository.findById(id).get();
        existingOrder.setTotalAmount(order.getTotalAmount());
        existingOrder.setTotalQuantity(order.getTotalQuantity());
        existingOrder.setCompanyEntity(order.getCompanyEntity());
        existingOrder.setCustomerEntity(order.getCustomerEntity());
        existingOrder.setItemEntity(order.getItemEntity());
        orderRepository.save(existingOrder);
        return "Update Successfully";
    }

    @Override
    public Order readOrder(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).get();
        Order order = new Order();
        // from to
        BeanUtils.copyProperties(orderEntity, order);
        return order;
    }

    @Override
    public List<Order> findByCustomerEntityCustomerName(String customerName) {
        List<OrderEntity> ordersList = orderRepository.findByCustomerEntityCustomerName(customerName);
        List<Order> orders = new ArrayList<>();
        for (OrderEntity orderEntity : ordersList) {
            Order ord = new Order();
            ord.setId(orderEntity.getId());
            ord.setTotalAmount(orderEntity.getTotalAmount());
            ord.setTotalQuantity(orderEntity.getTotalQuantity());
            ord.setCompanyEntity(orderEntity.getCompanyEntity());
            ord.setCustomerEntity(orderEntity.getCustomerEntity());
            ord.setItemEntity(orderEntity.getItemEntity());
            orders.add(ord);
        }
        return orders;

    }

    @Override
    public List<Order> getAllOrders() {
        List<OrderEntity> ordersList = orderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        for (OrderEntity orderEntity : ordersList) {
            Order order = new Order();
            order.setId(orderEntity.getId());
            order.setTotalAmount(orderEntity.getTotalAmount());
            order.setTotalQuantity(orderEntity.getTotalQuantity());
            order.setCompanyEntity(orderEntity.getCompanyEntity());
            order.setCustomerEntity(orderEntity.getCustomerEntity());
            order.setItemEntity(orderEntity.getItemEntity());
            orders.add(order);
        }
        return orders;

    }

    @Override
    public List<Order> findByCompanyEntityId(Long id) {
        List<OrderEntity> ordersList = orderRepository.findByCompanyEntityId(id);
        List<Order> orders = new ArrayList<>();
        for (OrderEntity orderEntity : ordersList) {
            Order ord = new Order();
            ord.setId(orderEntity.getId());
            ord.setTotalAmount(orderEntity.getTotalAmount());
            ord.setTotalQuantity(orderEntity.getTotalQuantity());
            ord.setCompanyEntity(orderEntity.getCompanyEntity());
            ord.setCustomerEntity(orderEntity.getCustomerEntity());
            ord.setItemEntity(orderEntity.getItemEntity());
            orders.add(ord);
        }
        return orders;
    }

    // @Override
    // public List<Order> findByCompanyEntityIdAndCreatedAtGreaterThanEqual(Long companyId, Date date) {
    //     List<OrderEntity> ordersList = orderRepository.findByCompanyEntityIdAndCreatedAtGreaterThanEqual(companyId,
    //             date);
    //     LocalDate providedDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    //     LocalDate currentDate = LocalDate.now();
    //     long daysDifference = ChronoUnit.DAYS.between(providedDate, currentDate);
    //     if (daysDifference >= 2) {
    //         List<Order> orders = new ArrayList<>();
    //         for (OrderEntity orderEntity : ordersList) {
    //             Order ord = new Order();
    //             ord.setId(orderEntity.getId());
    //             ord.setTotalAmount(orderEntity.getTotalAmount());
    //             ord.setTotalQuantity(orderEntity.getTotalQuantity());
    //             ord.setCompanyEntity(orderEntity.getCompanyEntity());
    //             ord.setCustomerEntity(orderEntity.getCustomerEntity());
    //             ord.setItemEntity(orderEntity.getItemEntity());
    //             orders.add(ord);
    //         }
    //         return orders;
    //     }
    //     else {
    //         return new ArrayList<>(); 
    //     }
        
    // }
}
