package com.gorgeous.ShopManagement.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

class ShopDesignationTest {
    @Test
    public void testCreateShopDesignation() {
        String validArg1 = "Designation";
        String validArg2 = "Designation 2, Ingredient 3";

        try {
            new ShopDesignation(validArg1);
            new ShopDesignation(validArg2);
        } catch (Exception e) {
            fail("Should not thrown exception");
        }

        try {
            new ShopDesignation(null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The validated object is null"), "Should have the same message");
        }

        String invalidArg2 = "";

        try {
            new ShopDesignation(invalidArg2);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The ShopDesignation must contain an address"), "Should have the same message");
        }

        String invalidArg3 = "Designation {3}";

        try {
            new ShopDesignation(invalidArg3);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The ShopDesignation is not valid (does not match the pattern)."), "Should have the same message");
        }

    }
}