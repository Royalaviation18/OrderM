package com.royalaviation.OrderM.controller;

import com.royalaviation.OrderM.OrderReport;
import com.royalaviation.OrderM.entity.Order;

import com.royalaviation.OrderM.service.OrderService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class OrderController {
    
    @Autowired
    OrderService orderService;

    // get All the orders
    @GetMapping("orders")
    public List<Order> getAllCompany() {
        return orderService.readOrders();
    }

    // creating an order
    @PostMapping("orders")
    public String postMethodName(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // deleting an orders
    @DeleteMapping("orders/{id}")
    public String deleteOrder(@PathVariable Long id) {
        if (orderService.deleteOrder(id))
            return "Deleted Successfully";
        return "Not found";
    }

    // updating an order
    @PutMapping("orders/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    // searching for an order based on order id
    @GetMapping("orders/{id}")
    public Order getAllOrderById(@PathVariable Long id) {
        return orderService.readOrder(id);
    }

    // searching for an order based on company id
    @GetMapping("orders/cbased/{companyId}")
    public List<Order> getAllOrderByCompanyId(@PathVariable Long companyId) {
        return orderService.findByCompanyEntityId(companyId);
    }

    // searching for an order based on customer'sname
    @GetMapping("orders/customerName")
    public List<Order> getAllOrderByName(@RequestParam("customerName") String customerName) {
        return orderService.findByCustomerEntityCustomerName(customerName);
    }

    // @GetMapping("/orders")
    // public List<Order> getOrdersByCompanyIdAndCreatedAtGreaterThanEqual(
    // @RequestParam Long companyId,
    // @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
    // return
    // orderService.findByCompanyEntityIdAndCreatedAtGreaterThanEqual(companyId,
    // date);
    // }

    // getting reports based on companyId
    // gettting reports of a company based on there ids
    @GetMapping("orders/export/{companyId}")
    public void exportIntoExcelFileByCompany(@PathVariable Long companyId, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=orderCompany" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Order> listOfOrders = orderService.findByCompanyEntityId(companyId);
        OrderReport orderReport = new OrderReport(listOfOrders);
        orderReport.generateExcelFile(response);
    }

    // getting reports for all the company
    @GetMapping("orders/export")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=order" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Order> listOfOrders = orderService.getAllOrders();
        OrderReport generator = new OrderReport(listOfOrders);
        generator.generateExcelFile(response);

    }
}
