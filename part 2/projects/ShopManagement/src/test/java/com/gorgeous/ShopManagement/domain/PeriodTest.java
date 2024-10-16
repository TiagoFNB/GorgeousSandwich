package com.gorgeous.ShopManagement.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;


public class PeriodTest {

    @Test
    public void testCreatePeriodTest() {
        String validArg1 = "20";

        try {
            new Period(validArg1);
        } catch (Exception e) {
            fail("Should not thrown exception");
        }

        try {
            new Period(null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The validated object is null"), "Should have the same message");
        }

        String invalidArg2 = "";

        try {
            new Period(invalidArg2);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The Period must contain a positive number"), "Should have the same message");
        }

        String invalidArg3 = "Test";

        try {
            new Period(invalidArg3);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The Period must contain a positive number"), "Should have the same message");
        }

        String invalidArg4 = "-20";

        try {
            new Period(invalidArg4);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The Period must contain a positive number"), "Should have the same message");
        }
    }
}
