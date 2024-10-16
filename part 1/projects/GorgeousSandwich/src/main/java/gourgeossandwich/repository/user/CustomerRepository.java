package gourgeossandwich.repository.user;


import gourgeossandwich.domain.user.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {

}