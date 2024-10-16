package gourgeossandwich.domain.promotion;

import gourgeossandwich.domain.sandwich.Sandwich;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PromotionTest {

    @Test
    public void testCreatePromotion() throws ParseException {

        PromotionInternalId mockedId = mock(PromotionInternalId.class);
        PromotionPeriod mockedPeriod= mock(PromotionPeriod.class);
        PromotionPercentage mockedPercentage= mock(PromotionPercentage.class);
        PromotionType mockedType= mock(PromotionType.class);
        Sandwich mockedSandwich= mock(Sandwich.class);

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);


        try {
            new Promotion(mockedId,mockedPercentage,mockedPeriod,mockedType,mockedSandwich);
        }catch(Exception e) {
            fail("Should not thrown exception");
        }


        try{
            new Promotion(null,mockedPercentage,mockedPeriod,mockedType,mockedSandwich);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "PromotionInternalId is required", "Should have the same message");
        }

        try{
            new Promotion(mockedId,null,mockedPeriod,mockedType,mockedSandwich);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "Percentage of the promotion is required", "Should have the same message");
        }


        try{
            new Promotion(mockedId,mockedPercentage,null,mockedType,mockedSandwich);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "Period of the promotion is required", "Should have the same message");
        }

        try{
            new Promotion(mockedId,mockedPercentage,mockedPeriod,null,mockedSandwich);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "Promotion type are required", "Should have the same message");
        }

        try{
            new Promotion(mockedId,mockedPercentage,mockedPeriod,mockedType,null);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "Sandwich is required", "Should have the same message");
        }

    }

}