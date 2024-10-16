package com.gorgeous.ShopManagement.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

public class ShopPropertiesTest {

    @Test
    public void testCreateShopProperties() {
        MinimumAcceptableAdvance validArg1 = mock(MinimumAcceptableAdvance.class);
        MaximumNumberDeliveries validArg2 = mock(MaximumNumberDeliveries.class);
        Period validArg3 = mock(Period.class);

        try {
            new ShopProperties(validArg1, validArg2, validArg3);
        } catch (Exception e) {
            fail("Should not thrown exception");
        }

        try {
            new ShopProperties(null, validArg2, validArg3);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "MinimumAcceptableAdvance is required"), "Should have the same message");
        }

        try {
            new ShopProperties(validArg1, null, validArg3);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "MaximumNumberDeliveries is required"), "Should have the same message");
        }

        try {
            new ShopProperties(validArg1, validArg2, null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Period is required"), "Should have the same message");
        }
    }
}
