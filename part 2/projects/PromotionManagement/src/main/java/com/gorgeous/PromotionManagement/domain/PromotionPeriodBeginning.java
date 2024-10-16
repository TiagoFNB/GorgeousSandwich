package com.gorgeous.PromotionManagement.domain;

import org.apache.commons.lang.Validate;
import com.gorgeous.PromotionManagement.shared.ValueObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Embeddable
@Access(AccessType.FIELD)
public final class PromotionPeriodBeginning implements ValueObject<PromotionPeriodBeginning> {

    final static String DATE_FORMAT = "dd-MM-yyyy";

    @JsonProperty
    private String promotionPeriodBeginning;

    public PromotionPeriodBeginning(final String promotionPeriodBeginning){

        Validate.notNull(promotionPeriodBeginning);
        Validate.notEmpty(promotionPeriodBeginning);

        Validate.isTrue(isDateValid(promotionPeriodBeginning),"Introduce promotion period beginning in a valid date and format (DD-MM-YYYY)");

        this.promotionPeriodBeginning = promotionPeriodBeginning;
    }

    public PromotionPeriodBeginning() {

    }

    public Date convertToDate() {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setLenient(false);
        Date promotionPeriodBeginningDate = null;
        try {
            promotionPeriodBeginningDate = df.parse(promotionPeriodBeginning);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return promotionPeriodBeginningDate;
    }

    private boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }


    @Override
    public boolean sameValueAs(PromotionPeriodBeginning other) {
        // TODO Auto-generated method stub
        return false;
    }
}
