package gourgeossandwich.service.user;

import gourgeossandwich.domain.user.UserEmail;
import gourgeossandwich.domain.user.UserInternalId;
import gourgeossandwich.domain.user.UserName;
import gourgeossandwich.domain.user.UserPassword;
import gourgeossandwich.domain.user.customer.Customer;
import gourgeossandwich.domain.user.customer.CustomerAddress;
import gourgeossandwich.domain.user.customer.CustomerTIN;
import gourgeossandwich.dto.user.CustomerDTO;
import gourgeossandwich.handling.UserEmailAlreadyExistsException;
import gourgeossandwich.repository.user.CustomerRepository;
import gourgeossandwich.repository.user.UserRepository;
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

    public Customer createNewCustomer(CustomerDTO customerDTO) {
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