package com.gorgeous.UserManagement.repository;


import com.gorgeous.UserManagement.domain.user.UserInternalId;
import com.gorgeous.UserManagement.domain.user.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
  Customer getCustomerById(UserInternalId id);
}