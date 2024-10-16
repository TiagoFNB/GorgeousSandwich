package gourgeossandwich.domain.user.customer;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import gourgeossandwich.domain.shared.Entity;
import gourgeossandwich.domain.user.*;
import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "Customer")
public class Customer extends User  {

    @JsonUnwrapped
    @Embedded
    private CustomerAddress address;


    @JsonUnwrapped
    @Embedded
    private CustomerTIN tin;

    protected Customer(){}

    public Customer(final UserInternalId id,
                final UserPassword pwd,
                final UserEmail email,
                final UserName userName,
                    final CustomerAddress address,
                    final CustomerTIN tin) {
        super(id,pwd,email,userName, UserRole.CUSTOMER);
        Validate.notNull(tin, "CustomerTIN is required");
        Validate.notNull(address, "CustomerAddress is required");

        this.address = address;
        this.tin = tin;

    }
    public String toString() {
        return super.toString();
    }

}
