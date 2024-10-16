package com.gorgeous.UserManagement.service;

import com.gorgeous.UserManagement.domain.user.UserEmail;
import com.gorgeous.UserManagement.domain.user.UserInternalId;
import com.gorgeous.UserManagement.domain.user.UserName;
import com.gorgeous.UserManagement.domain.user.UserPassword;
import com.gorgeous.UserManagement.domain.user.customer.Customer;
import com.gorgeous.UserManagement.domain.user.customer.CustomerAddress;
import com.gorgeous.UserManagement.domain.user.customer.CustomerTIN;
import com.gorgeous.UserManagement.dto.CustomerDTO;
import com.gorgeous.UserManagement.handling.UserEmailAlreadyExistsException;
import com.gorgeous.UserManagement.repository.CustomerRepository;
import com.gorgeous.UserManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService {

    protected CustomerRepository customerRepository;
    protected UserRepository userRepository;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    public CreateCustomerService(CustomerRepository customerRepository, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    public Customer createNewCustomer(CustomerDTO customerDTO) throws Exception {
        final UserEmail email = new UserEmail(customerDTO.getEmail());
        if(userRepository.findByEmail(customerDTO.getEmail()) != null){
            throw new UserEmailAlreadyExistsException(email.toString());
        }

        final UserInternalId id = UserInternalId.genNewId();
        final UserName name = new UserName(customerDTO.getUserName());

        final UserPassword pwd = new UserPassword(this.passwordEncoder.encode(customerDTO.getPassword()));
        final CustomerTIN tin = new CustomerTIN(customerDTO.getTin());
        final CustomerAddress address = new CustomerAddress(customerDTO.getAddress());


        final Customer customer = new Customer(id, pwd, email, name, address, tin);

        this.customerRepository.save(customer);

        return customer;
    }
}