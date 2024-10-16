package gourgeossandwich.domain.promotion;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.lang.Validate;

import gourgeossandwich.domain.shared.ValueObject;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Embeddable
@Access(AccessType.FIELD)
public class PromotionPeriodEnd implements ValueObject<PromotionPeriodEnd>{

    final static String DATE_FORMAT = "dd-MM-yyyy";

    @JsonProperty
    private String promotionPeriodEnd;

    public PromotionPeriodEnd(final String promotionPeriodEnd){

        Validate.notNull(promotionPeriodEnd);
        Validate.notEmpty(promotionPeriodEnd);

        Validate.isTrue(isDateValid(promotionPeriodEnd),"Introduce promotion period end in a valid date and format (DD-MM-YYYY)");

        this.promotionPeriodEnd = promotionPeriodEnd;
    }

    public Date convertToDate() {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        df.setLenient(false);
        Date promotionPeriodEndDate = null;
        try {
            promotionPeriodEndDate = df.parse(promotionPeriodEnd);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return promotionPeriodEndDate;
    }

    public PromotionPeriodEnd() {

    }


    @Override
    public boolean sameValueAs(PromotionPeriodEnd other) {
        // TODO Auto-generated method stub
        return false;
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

}
