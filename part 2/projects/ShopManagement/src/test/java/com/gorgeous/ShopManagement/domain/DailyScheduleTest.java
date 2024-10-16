package com.gorgeous.ShopManagement.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DailyScheduleTest {
    @Test
    public void testCreateDailySchedule() {
        OpeningHours validArg1 = mock(OpeningHours.class);
        ClosingHours validArg2 = mock(ClosingHours.class);
        Day validArg3 = mock(Day.class);

        try {
            new DailySchedule(validArg1, validArg2, validArg3);
        } catch (Exception e) {
            fail("Should not thrown exception");
        }

        try {
            new DailySchedule(null, validArg2, validArg3);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "OpeningHours is required"), "Should have the same message");
        }

        try {
            new DailySchedule(validArg1, null, validArg3);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "ClosingHours is required"), "Should have the same message");
        }

        try {
            new DailySchedule(validArg1, validArg2, null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Day is required"), "Should have the same message");
        }

        OpeningHours invalidArg1 = mock(OpeningHours.class);
        when(invalidArg1.returnHours()).thenReturn(20);
        when(invalidArg1.returnMinutes()).thenReturn(20);
        ClosingHours invalidArg2 = mock(ClosingHours.class);
        when(invalidArg2.returnHours()).thenReturn(10);
        when(invalidArg2.returnMinutes()).thenReturn(10);

        try {
            new DailySchedule(invalidArg1, invalidArg2, validArg3);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "OpeningHours must be earlier than ClosingHours"), "Should have the same message");
        }
    }
}