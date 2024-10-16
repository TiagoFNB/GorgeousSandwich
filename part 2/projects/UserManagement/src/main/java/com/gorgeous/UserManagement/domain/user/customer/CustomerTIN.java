package com.gorgeous.UserManagement.domain.user.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gorgeous.UserManagement.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerTIN implements ValueObject<CustomerTIN> {

    @JsonProperty
    @Column(nullable = false,unique = true)
    private String tin;

    /**
     * Constructor.
     *
     * @param customerTIN TIN string.
     */
    public CustomerTIN(final String customerTIN) {
        Validate.notNull(customerTIN);
        Validate.notEmpty(customerTIN);
        this.tin = customerTIN;
    }

    protected CustomerTIN() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerTIN other = (CustomerTIN) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return tin.hashCode();
    }

    @Override
    public boolean sameValueAs(CustomerTIN other) {
        return other != null && this.tin.equals(other.tin);
    }

    @Override
    public String toString() {
        return tin;
    }
}