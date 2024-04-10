package com.royalaviation.OrderM.service;


import com.royalaviation.OrderM.entity.Company;
import com.royalaviation.OrderM.entity.CompanyEntity;
import com.royalaviation.OrderM.entity.Customer;
import com.royalaviation.OrderM.entity.CustomerEntity;
import com.royalaviation.OrderM.repository.CompanyRepository;
import com.royalaviation.OrderM.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public String createCustomer(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        // from to
        BeanUtils.copyProperties(customer,customerEntity);
        customerRepository.save(customerEntity);
        // orders.add(order);
        return "Saved Successfully";
    }

    @Override
    public List<Customer> readCustomers() {
        List<CustomerEntity> customersList = customerRepository.findAll();
        List<Customer> customers = new ArrayList<>();
        for (CustomerEntity customerEntity : customersList) {
            Customer customer = new Customer();
            customer.setId(customerEntity.getId());
            customer.setCustomerName(customerEntity.getCustomerName());
            customer.setCustomerEmail(customerEntity.getCustomerEmail());
            customer.setCustomerPhone(customerEntity.getCustomerPhone());
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public boolean deleteCustomer(Long id) {
        CustomerEntity cus = customerRepository.findById(id).get();
        customerRepository.delete(cus);
        return true;
    }

    @Override
    public String updateCustomer(Long id, Customer customer) {
        CustomerEntity existingCustomer = customerRepository.findById(id).get();
        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setCustomerEmail(customer.getCustomerEmail());
        existingCustomer.setCustomerPhone(customer.getCustomerPhone());
        customerRepository.save(existingCustomer);
        return "Update Successfully";
    }
}
