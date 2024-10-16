package com.gorgeous.UserManagement.domain.user;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.fail;

class UserEmailTest {

    @Test
    public void testCreateUserEmail() {
        String validArg1 = "teste@email.com";

        try {
            new UserEmail(validArg1);;
        }catch(Exception e) {
            fail("Should not thrown exception");
        }

        String invalidArg = null;

        try{
            new UserEmail(invalidArg);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated object is null", "Should have the same message");
        }

        String invalidArg2 = "";

        try{
            new UserEmail(invalidArg2);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated string is empty", "Should have the same message");
        }

        String invalidArg3 = "testeemail";

        try{
            new UserEmail(invalidArg3);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage().equals("testeemail is not a valid e-mail (does not match pattern)"), "Should have the same message");
        }

    }
}