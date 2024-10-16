package com.gorgeous.UserManagement.domain.user;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.fail;

class UserNameTest {
    @Test
    public void testCreateUserName() {
        String validArg1 = "123456789";

        try {
            new UserName(validArg1);;
        }catch(Exception e) {
            fail("Should not thrown exception");
        }

        String invalidArg = null;

        try{
            new UserName(invalidArg);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated object is null", "Should have the same message");
        }

        String invalidArg2 = "";

        try{
            new UserName(invalidArg2);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated string is empty", "Should have the same message");
        }

    }
}