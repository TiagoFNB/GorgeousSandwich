package com.gorgeous.PromotionManagement.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.apache.commons.lang.Validate;
import com.gorgeous.PromotionManagement.shared.ValueObject;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Date;

@Embeddable
@Access(AccessType.FIELD)
public final class PromotionPeriod implements ValueObject<PromotionPeriod> {

    @JsonUnwrapped
    @Embedded
    private PromotionPeriodBeginning promotionPeriodBeginning;

    @JsonUnwrapped
    @Embedded
    private PromotionPeriodEnd promotionPeriodEnd;

       

    public PromotionPeriod(){}

    /**
     * Constructor.
     *
     * @param promotionPeriodBeginning Designation string.
     * @param promotionPeriodEnd Designation string
     */ 
    public PromotionPeriod(final PromotionPeriodBeginning promotionPeriodBeginning, final PromotionPeriodEnd promotionPeriodEnd) {
        Validate.notNull(promotionPeriodBeginning);
        Validate.notNull(promotionPeriodEnd);
        Validate.isTrue(promotionPeriodEnd.convertToDate().after(promotionPeriodBeginning.convertToDate()));
        Date todayDate = new Date();
        Validate.isTrue(todayDate.before(promotionPeriodEnd.convertToDate()),"Introduce promotion period end after today's date");


        this.promotionPeriodBeginning = promotionPeriodBeginning;
        this.promotionPeriodEnd = promotionPeriodEnd;
    }    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromotionPeriod other = (PromotionPeriod) o;

        return sameValueAs(other);
    }

    @Override
    public boolean sameValueAs(PromotionPeriod other) {
        return other != null && this.promotionPeriodEnd.equals(other.promotionPeriodEnd) && this.promotionPeriodBeginning.equals(other.promotionPeriodBeginning);
    }


    @Override
    public String toString() {
        return "Promotion Period: \n"
                + "Promotion Period Beginning: " + promotionPeriodBeginning.toString() + "\n"
                + "Promotion Period End: " + promotionPeriodEnd.toString();
    }

    
}
