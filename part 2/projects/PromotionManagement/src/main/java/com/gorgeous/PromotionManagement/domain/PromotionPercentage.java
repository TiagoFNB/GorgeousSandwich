package com.gorgeous.PromotionManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.Validate;
import com.gorgeous.PromotionManagement.shared.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public final class PromotionPercentage implements ValueObject<PromotionPercentage> {
    
    @JsonProperty
    private Double percentage;

    /**
     * Constructor.
     *
     * @param percentage Designation string.
     */
    public PromotionPercentage(final Double percentage) {
        Validate.notNull(percentage);
        Validate.isTrue(percentage > 0, "Percentage needs to be between 0 and 100");
        Validate.isTrue(percentage < 100, "Percentage needs to be between 0 and 100");

        this.percentage = percentage;
    }

    protected PromotionPercentage() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromotionPercentage other = (PromotionPercentage) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return percentage.hashCode();
    }

    @Override
    public boolean sameValueAs(PromotionPercentage other) {
        return other != null && this.percentage.equals(other.percentage);
    }

    @Override
    public String toString() {
        return percentage.toString();
    }


}
