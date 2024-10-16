package gourgeossandwich.domain.shop;

import gourgeossandwich.domain.sandwich.*;
import gourgeossandwich.domain.user.UserInternalId;
import gourgeossandwich.domain.user.shopmanager.ShopManager;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShopTest {
    @Test
    public void testCreateShop() {
        ShopInternalId validArg1 = mock(ShopInternalId.class);
        ShopDesignation validArg2 = mock(ShopDesignation.class);
        ShopAddress validArg3 = mock(ShopAddress.class);
        List<DailySchedule> validArg4 = create7DailySchedules();
        for (int i = 0; i < validArg4.size(); i++) {
            when(validArg4.get(i).dayOfTheWeek()).thenReturn(Day.values()[i].toString());
        }
        UserInternalId validArg5 = mock(UserInternalId.class);
        List<SandwichInternalId> validArg6 = new ArrayList<>();
        validArg6.add(mock(SandwichInternalId.class));

        try {
            new Shop(validArg1, validArg2, validArg3, validArg4, validArg5, validArg6);
        } catch (Exception e) {
            fail("Should not thrown exception");
        }

        try {
            new Shop(null, validArg2, validArg3, validArg4, validArg5, validArg6);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "ShopInternalId is required"), "Should have the same message");
        }

        try {
            new Shop(validArg1, null, validArg3, validArg4, validArg5, validArg6);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "ShopDesignation is required"), "Should have the same message");
        }

        try {
            new Shop(validArg1, validArg2, null, validArg4, validArg5, validArg6);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "ShopAddress is required"), "Should have the same message");
        }

        try {
            new Shop(validArg1, validArg2, validArg3, null, validArg5, validArg6);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "DailySchedules are required"), "Should have the same message");
        }

        try {
            new Shop(validArg1, validArg2, validArg3, validArg4, null, validArg6);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "ShopManager is required"), "Should have the same message");
        }

        try {
            new Shop(validArg1, validArg2, validArg3, validArg4, validArg5, null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "SandwichList is required"), "Should have the same message");
        }

        List<DailySchedule> invalidArg1 = new ArrayList<>();

        try {
            new Shop(validArg1, validArg2, validArg3, invalidArg1, validArg5, validArg6);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Must have 7 daily Schedules"), "Should have the same message");
        }

        List<DailySchedule> invalidArg2 = create7DailySchedules();
        invalidArg2.remove(0);

        try {
            new Shop(validArg1, validArg2, validArg3, invalidArg2, validArg5, validArg6);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Must have 7 daily Schedules"), "Should have the same message");
        }

        List<DailySchedule> invalidArg3 = create7DailySchedules();
        invalidArg3.remove(0);
        invalidArg3.add(mock(DailySchedule.class));

        for (int i = 0; i < invalidArg3.size() - 1; i++) {
            when(invalidArg3.get(i).dayOfTheWeek()).thenReturn(Day.values()[i].toString());
        }
        when(invalidArg3.get(invalidArg3.size() - 1).dayOfTheWeek()).thenReturn(Day.values()[invalidArg3.size() - 3].toString());

        try {
            new Shop(validArg1, validArg2, validArg3, invalidArg3, validArg5, validArg6);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Must have 7 daily Schedules, with all 7 different days"), "Should have the same message");
        }

        List<SandwichInternalId> invalidArg4 = new ArrayList<>();

        try {
            new Shop(validArg1, validArg2, validArg3, validArg4, validArg5, invalidArg4);
            fail("Should have thrown exception");
        } catch (Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class, e);
            Assert.isTrue(Objects.equals(e.getMessage(), "Shop must have Sandwiches"), "Should have the same message");
        }
    }

    private List<DailySchedule> create7DailySchedules() {
        List<DailySchedule> newList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            newList.add(mock(DailySchedule.class));
        }
        return newList;
    }
}