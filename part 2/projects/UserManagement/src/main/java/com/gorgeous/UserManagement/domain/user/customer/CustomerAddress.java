package com.gorgeous.UserManagement.domain.user.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gorgeous.UserManagement.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerAddress implements ValueObject<CustomerAddress> {

    @JsonProperty
    @Column(nullable = false)
    private String address;

    /**
     * Constructor.
     *
     * @param address Address string.
     */
    public CustomerAddress(final String address) {
        Validate.notNull(address);
        Validate.notEmpty(address);
        this.address = address;
    }

    protected CustomerAddress() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerAddress other = (CustomerAddress) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    @Override
    public boolean sameValueAs(CustomerAddress other) {
        return other != null && this.address.equals(other.address);
    }

    @Override
    public String toString() {
        return address;
    }
}
