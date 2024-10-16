package com.gorgeous.UserManagement.controller;


import com.gorgeous.UserManagement.domain.user.customer.Customer;
import com.gorgeous.UserManagement.service.ListCustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomersController {

    protected ListCustomerService listCustomerService;

    public GetCustomersController(ListCustomerService listCustomerService) {
        this.listCustomerService = listCustomerService;
    }

    public List<Customer> listCustomers() {
        return listCustomerService.getAllCustomers();
    }
}

