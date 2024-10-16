package com.gorgeous.UserManagement.route;


import com.gorgeous.UserManagement.controller.CreateCustomerController;
import com.gorgeous.UserManagement.controller.GetCustomerByIdController;
import com.gorgeous.UserManagement.controller.GetCustomersController;
import com.gorgeous.UserManagement.domain.user.User;
import com.gorgeous.UserManagement.domain.user.customer.Customer;
import com.gorgeous.UserManagement.dto.CustomerDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/customer")
public class CustomerRoute {

    protected GetCustomersController getCustomersController;
    protected GetCustomerByIdController getCustomerByIdController;
    protected CreateCustomerController createCustomerController;

    public CustomerRoute(CreateCustomerController createCustomerController,
                         GetCustomersController getCustomersController,
                         GetCustomerByIdController getCustomerByIdController) {
        this.createCustomerController = createCustomerController;
        this.getCustomersController =  getCustomersController;
        this.getCustomerByIdController = getCustomerByIdController;
    }

    @MutationMapping
    public Customer createCustomer(@Argument CustomerDTO customer) throws Exception {
        return createCustomerController.createCustomer(customer);
    }

    @QueryMapping
        public List<Customer> getCustomers() {
        return getCustomersController.listCustomers();
    }
    @QueryMapping
    public Customer getCustomerById(@Argument String id) {
        return getCustomerByIdController.getCustomerById(id);
    }

}

