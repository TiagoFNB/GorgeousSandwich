package gourgeossandwich.domain.promotion;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class PromotionPeriodEndTest {
    @Test
    public void testCreatePeriodEnd(){

        String validArg1 = "31-03-2026";
        String validArg2 = "28-02-2026";

        try {
            new PromotionPeriodEnd(validArg1);
            new PromotionPeriodEnd(validArg2);
        }catch(Exception e) {
            fail("Should not thrown exception");
        }

        String invalidArgNull = null;
        String invalidArgEmpty = "";

        try{
            new PromotionPeriodEnd(invalidArgNull);
            new PromotionPeriodEnd(invalidArgEmpty);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated object is null", "Should have the same message");
        }


        String invalidArg1 = "31-02-2025";
        String invalidArg2 = "31-11-2025";
        String invalidArg3 = "10-11-2000";
        String invalidArg4 = "10/11/2000";



        try{
            new PromotionPeriodEnd(invalidArg1);
            new PromotionPeriodEnd(invalidArg2);
            new PromotionPeriodEnd(invalidArg3);
            new PromotionPeriodEnd(invalidArg4);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "Introduce promotion period end in a valid date and format (DD-MM-YYYY)", "Should have the same message");
        }
    }
}