package gourgeossandwich.controller.user;


import gourgeossandwich.domain.user.customer.Customer;
import gourgeossandwich.service.user.ListCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCustomersController {

    protected ListCustomerService listCustomerService;

    public GetCustomersController(ListCustomerService listCustomerService) {
        this.listCustomerService = listCustomerService;
    }

    public ResponseEntity<List<Customer>> listCustomers() {
        return ResponseEntity.ok(listCustomerService.getAllCustomers());
    }
}

