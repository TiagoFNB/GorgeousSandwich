package com.gorgeous.UserManagement.controller;


import com.gorgeous.UserManagement.domain.user.customer.Customer;
import com.gorgeous.UserManagement.dto.CustomerDTO;
import com.gorgeous.UserManagement.service.CreateCustomerService;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerController {

    protected CreateCustomerService createCustomerService;

    public CreateCustomerController(CreateCustomerService createCustomerService) {
        this.createCustomerService = createCustomerService;
    }


    public Customer createCustomer(CustomerDTO customerDTO) throws Exception {
        return createCustomerService.createNewCustomer(customerDTO);
    }
}

