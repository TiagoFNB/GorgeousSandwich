package com.gorgeous.PromotionManagement.domain;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.gorgeous.PromotionManagement.shared.Entity;
import org.apache.commons.lang.Validate;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Promotion")
public class Promotion implements Entity<Promotion>{

    @JsonUnwrapped
    @EmbeddedId
    private PromotionInternalId id;


    @JsonUnwrapped
    @Embedded
    private PromotionPercentage percentage;


    @JsonUnwrapped
    @Embedded
    private PromotionPeriod period;


    //@JsonProperty
    @JsonUnwrapped
    @Enumerated(EnumType.STRING)
    private PromotionType type;

    @JsonUnwrapped
    @Embedded
    private SandwichInternalId sandwichId;


    public Promotion(final PromotionInternalId id, final PromotionPercentage percentage, final PromotionPeriod period, final PromotionType type, final SandwichInternalId sandwichId){
        Validate.notNull(id, "PromotionInternalId is required");
        Validate.notNull(percentage, "Percentage of the promotion is required");
        Validate.notNull(period, "Period of the promotion is required");
        Validate.notNull(type, "Promotion type are required");
        Validate.notNull(sandwichId, "Sandwich is required");

        this.id = id;
        this.percentage = percentage;
        this.period = period;
        this.type = type;
        this.sandwichId = sandwichId;
    }

    public Promotion() {

    }

    @Override
    public boolean sameIdentityAs(Promotion other) {
       // return other != null && id.sameValueAs(other.id);
       return false;
    }
    
    /**
     * @param object to compare
     * @return True if they have the same identity
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final Promotion other = (Promotion) object;
        return sameIdentityAs(other);
    }

    
    /**
     * @return Hash code of id
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id.toString();
    }

}
