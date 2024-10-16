package gourgeossandwich.service.user;

import gourgeossandwich.domain.user.customer.Customer;
import gourgeossandwich.repository.user.CustomerRepository;
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
