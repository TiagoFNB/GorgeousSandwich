package com.gorgeous.ShopManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gorgeous.ShopManagement.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Period implements ValueObject<Period> {

    @JsonProperty
    private String period;

    /**
     * Constructor.
     *
     * @param period MinimumAcceptableAdvance string.
     */
    public Period(final String period) {
        Validate.notNull(period);
        Validate.notEmpty(period, "The Period must contain a positive number");
        Validate.isTrue(isInt(period), "The Period must contain a positive number");
        Validate.isTrue(0 <= Integer.parseInt(period), "The Period must contain a positive number");

        this.period = period;
    }

    protected Period() {

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

        Period other = (Period) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return period.hashCode();
    }

    @Override
    public boolean sameValueAs(Period other) {
        return other != null && this.period.equals(other.period);
    }

    @Override
    public String toString() {
        return period;
    }
}
