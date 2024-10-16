package com.gorgeous.ShopManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gorgeous.ShopManagement.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class MinimumAcceptableAdvance implements ValueObject<MinimumAcceptableAdvance> {

    @JsonProperty
    private String minimumAcceptableAdvance;

    /**
     * Constructor.
     *
     * @param minimumAcceptableAdvance MinimumAcceptableAdvance string.
     */
    public MinimumAcceptableAdvance(final String minimumAcceptableAdvance) {
        Validate.notNull(minimumAcceptableAdvance);
        Validate.notEmpty(minimumAcceptableAdvance, "The MinimumAcceptableAdvance must contain a positive number");
        Validate.isTrue(isInt(minimumAcceptableAdvance), "The MinimumAcceptableAdvance must contain a positive number");
        Validate.isTrue(0 <= Integer.parseInt(minimumAcceptableAdvance), "The MinimumAcceptableAdvance must contain a positive number");

        this.minimumAcceptableAdvance = minimumAcceptableAdvance;
    }

    protected MinimumAcceptableAdvance() {

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

        MinimumAcceptableAdvance other = (MinimumAcceptableAdvance) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return minimumAcceptableAdvance.hashCode();
    }

    @Override
    public boolean sameValueAs(MinimumAcceptableAdvance other) {
        return other != null && this.minimumAcceptableAdvance.equals(other.minimumAcceptableAdvance);
    }

    @Override
    public String toString() {
        return minimumAcceptableAdvance;
    }
}
