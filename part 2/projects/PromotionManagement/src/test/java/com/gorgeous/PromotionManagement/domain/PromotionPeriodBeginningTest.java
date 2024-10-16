package com.gorgeous.PromotionManagement.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class PromotionPeriodBeginningTest {

    @Test
    public void testCreatePeriodBeginning(){

        String validArg1 = "31-03-2026";
        String validArg2 = "28-02-2026";

        try {
            new PromotionPeriodBeginning(validArg1);
            new PromotionPeriodBeginning(validArg2);
        }catch(Exception e) {
            fail("Should not thrown exception");
        }

        String invalidArgNull = null;
        String invalidArgEmpty = "";

        try{
            new PromotionPeriodBeginning(invalidArgNull);
            new PromotionPeriodBeginning(invalidArgEmpty);
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
            new PromotionPeriodBeginning(invalidArg1);
            new PromotionPeriodBeginning(invalidArg2);
            new PromotionPeriodBeginning(invalidArg3);
            new PromotionPeriodBeginning(invalidArg4);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "Introduce promotion period beginning in a valid date and format (DD-MM-YYYY)", "Should have the same message");
        }
    }
}