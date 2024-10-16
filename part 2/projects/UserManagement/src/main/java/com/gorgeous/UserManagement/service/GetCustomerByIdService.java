package com.gorgeous.UserManagement.service;
import com.gorgeous.UserManagement.domain.user.UserInternalId;
import com.gorgeous.UserManagement.domain.user.customer.Customer;
import com.gorgeous.UserManagement.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomerByIdService {

    protected CustomerRepository customerRepository;

    public GetCustomerByIdService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String id) {
        return this.customerRepository.getCustomerById(new UserInternalId(id));
    }
}

