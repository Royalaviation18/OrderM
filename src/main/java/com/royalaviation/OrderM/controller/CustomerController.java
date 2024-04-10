package com.royalaviation.OrderM.controller;

import com.royalaviation.OrderM.entity.Company;
import com.royalaviation.OrderM.entity.Customer;
import com.royalaviation.OrderM.service.CompanyService;
import com.royalaviation.OrderM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("customers")
    public List<Customer> getAllCustomer(){
        return customerService.readCustomers();
    }

    @PostMapping("customers")
    public String postMethodName(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @DeleteMapping("customers/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        if (customerService.deleteCustomer(id))
            return "Deleted Successfully";
        return "Not found";
    }

    @PutMapping("customers/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }
}
