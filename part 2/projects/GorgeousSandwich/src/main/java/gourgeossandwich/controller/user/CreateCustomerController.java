package gourgeossandwich.controller.user;


import gourgeossandwich.domain.user.customer.Customer;
import gourgeossandwich.dto.user.CustomerDTO;
import gourgeossandwich.service.user.CreateCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerController {

    protected CreateCustomerService createCustomerService;

    public CreateCustomerController(CreateCustomerService createCustomerService) {
        this.createCustomerService = createCustomerService;
    }

    public ResponseEntity<Customer> createCustomer(CustomerDTO customerDTO) {
        return ResponseEntity.ok(createCustomerService.createNewCustomer(customerDTO));
    }
}

