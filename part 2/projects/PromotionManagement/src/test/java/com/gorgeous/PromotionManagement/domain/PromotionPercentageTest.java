package com.gorgeous.PromotionManagement.domain;


import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.*;

class PromotionPercentageTest {
    @Test
    public void testCreatePercentage() {
        Double validArg1 = 23.0;
        Double validArg2 = 24.0;

        try {
            new PromotionPercentage(validArg1);
            new PromotionPercentage(validArg2);
        }catch(Exception e) {
            fail("Should not thrown exception");
        }

        Double invalidArg = null;

        try{
            new PromotionPercentage(invalidArg);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated object is null", "Should have the same message");
        }

        Double invalidArg2 = 112.0;
        Double invalidArg3 = -3.4;

        try{
            new PromotionPercentage(invalidArg2);
            new PromotionPercentage(invalidArg3);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "Percentage needs to be between 0 and 100", "Should have the same message");
        }

    }
}