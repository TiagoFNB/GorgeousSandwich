package gourgeossandwich.domain.promotion;

import org.springframework.util.Assert;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PromotionPeriodTest {

    @Test
    public void testCreatePeriod() throws ParseException {

        PromotionPeriodBeginning mockedBeginning = mock(PromotionPeriodBeginning.class);
        PromotionPeriodEnd mockedEnd = mock(PromotionPeriodEnd.class);

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);

        Date promotionPeriodBeginningDate = null;
        promotionPeriodBeginningDate = df.parse("20-06-2023");
        when(mockedBeginning.convertToDate()).thenReturn(promotionPeriodBeginningDate);

        Date promotionPeriodEndDate = null;
        promotionPeriodEndDate = df.parse("23-08-2023");
        when(mockedEnd.convertToDate()).thenReturn(promotionPeriodEndDate);


        try {
            new PromotionPeriod(mockedBeginning,mockedEnd);
        }catch(Exception e) {
            fail("Should not thrown exception");
        }


        try{
            new PromotionPeriod(mockedBeginning,null);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated object is null", "Should have the same message");
        }


        try{
            new PromotionPeriod(null,mockedEnd);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated object is null", "Should have the same message");
        }

    }

}