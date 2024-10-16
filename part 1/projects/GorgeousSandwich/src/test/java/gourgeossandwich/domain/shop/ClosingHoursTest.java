package gourgeossandwich.domain.shop;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

class ClosingHoursTest {
    @Test
    public void testCreateClosingHours() {
        String validArg1 = "20:30";
        String validArg2 = "10:00";

        try {
            new ClosingHours(validArg1);
            new ClosingHours(validArg2);
        } catch (Exception e) {
            fail("Should not thrown exception");
        }

        try {
            new ClosingHours(null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The validated object is null"), "Should have the same message");
        }

        String invalidArg2 = "";

        try {
            new ClosingHours(invalidArg2);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "The ClosingHours must contain an hour"), "Should have the same message");
        }

        String invalidArg3 = "20h20";

        try {
            new ClosingHours(invalidArg3);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Introduce ClosingHours in the HH:mm format"), "Should have the same message");
        }

        String invalidArg4 = "2:20";

        try {
            new ClosingHours(invalidArg4);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Introduce ClosingHours in the HH:mm format"), "Should have the same message");
        }

        String invalidArg5 = "20:2";

        try {
            new ClosingHours(invalidArg5);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Introduce ClosingHours in the HH:mm format"), "Should have the same message");
        }

        String invalidArg6 = "AA:20";

        try {
            new ClosingHours(invalidArg6);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Introduce ClosingHours in the HH:mm format"), "Should have the same message");
        }

        String invalidArg7 = "20:AA";

        try {
            new ClosingHours(invalidArg7);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Introduce ClosingHours in the HH:mm format"), "Should have the same message");
        }

        String invalidArg8 = "25:20";

        try {
            new ClosingHours(invalidArg8);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Hour must be between 0 and 23"), "Should have the same message");
        }

        String invalidArg9 = "-1:20";

        try {
            new ClosingHours(invalidArg9);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Hour must be between 0 and 23"), "Should have the same message");
        }

        String invalidArg10 = "20:70";

        try {
            new ClosingHours(invalidArg10);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Minute must be between 0 and 59"), "Should have the same message");
        }

        String invalidArg11 = "20:-1";

        try {
            new ClosingHours(invalidArg11);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Minute must be between 0 and 59"), "Should have the same message");
        }
    }
}