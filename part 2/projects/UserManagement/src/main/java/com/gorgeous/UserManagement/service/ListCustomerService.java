package com.gorgeous.UserManagement.service;

import com.gorgeous.UserManagement.domain.user.customer.Customer;
import com.gorgeous.UserManagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCustomerService {

    protected CustomerRepository customerRepository;

    public ListCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }
}
