package com.gorgeous.UserManagement.controller;

import com.gorgeous.UserManagement.domain.user.customer.Customer;
import com.gorgeous.UserManagement.service.GetCustomerByIdService;
import com.gorgeous.UserManagement.service.ListCustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomerByIdController {

    protected GetCustomerByIdService getCustomerService;

    public GetCustomerByIdController(GetCustomerByIdService getCustomerService) {
        this.getCustomerService = getCustomerService;
    }

    public Customer getCustomerById(String id) {
        return getCustomerService.getCustomerById(id);
    }
}
