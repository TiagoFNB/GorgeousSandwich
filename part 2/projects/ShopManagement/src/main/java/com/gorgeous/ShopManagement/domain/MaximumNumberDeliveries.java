package com.gorgeous.ShopManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gorgeous.ShopManagement.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class MaximumNumberDeliveries implements ValueObject<MaximumNumberDeliveries> {
    @JsonProperty
    private String maximumNumberDeliveries;

    /**
     * Constructor.
     *
     * @param maximumNumberDeliveries MaximumNumberDeliveries string.
     */
    public MaximumNumberDeliveries(final String maximumNumberDeliveries) {
        Validate.notNull(maximumNumberDeliveries);
        Validate.notEmpty(maximumNumberDeliveries, "The MaximumNumberDeliveries must contain a positive number");
        Validate.isTrue(isInt(maximumNumberDeliveries), "The MaximumNumberDeliveries must contain a positive number");
        Validate.isTrue(0 <= Integer.parseInt(maximumNumberDeliveries), "The MaximumNumberDeliveries must contain a positive number");

        this.maximumNumberDeliveries = maximumNumberDeliveries;
    }

    protected MaximumNumberDeliveries() {

    }

    public static boolean isInt(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaximumNumberDeliveries other = (MaximumNumberDeliveries) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return maximumNumberDeliveries.hashCode();
    }

    @Override
    public boolean sameValueAs(MaximumNumberDeliveries other) {
        return other != null && this.maximumNumberDeliveries.equals(other.maximumNumberDeliveries);
    }

    @Override
    public String toString() {
        return maximumNumberDeliveries;
    }
}
