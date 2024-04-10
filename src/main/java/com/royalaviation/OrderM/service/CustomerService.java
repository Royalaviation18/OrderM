package com.royalaviation.OrderM.service;

import com.royalaviation.OrderM.entity.Company;
import com.royalaviation.OrderM.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    String createCustomer(Customer customer);

    List<Customer> readCustomers();

    boolean deleteCustomer(Long id);

    String updateCustomer(Long id, Customer customer);
}
