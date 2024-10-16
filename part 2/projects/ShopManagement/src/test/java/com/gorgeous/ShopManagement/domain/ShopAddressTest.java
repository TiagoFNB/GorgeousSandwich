package com.gorgeous.ShopManagement.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

class ShopAddressTest {
    @Test
    public void testCreateShopAddress() {
        String validArg1 = "Rua 1";
        String validArg2 = "Rua 2 , 4460-340";

        try {
            new ShopAddress(validArg1);
            new ShopAddress(validArg2);
        } catch (Exception e) {
            fail("Should not thrown exception");
        }

        try {
            new ShopAddress(null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The validated object is null"), "Should have the same message");
        }

        String invalidArg2 = "";

        try {
            new ShopAddress(invalidArg2);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The ShopAdress must contain an address"), "Should have the same message");
        }

        String invalidArg3 = "Rua {3}";

        try {
            new ShopAddress(invalidArg3);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The ShopAddress is not valid (does not match the pattern)."), "Should have the same message");
        }
    }
}