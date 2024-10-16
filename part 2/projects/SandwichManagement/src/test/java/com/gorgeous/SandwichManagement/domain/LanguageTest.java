package com.gorgeous.SandwichManagement.domain;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.fail;

class LanguageTest {

    @Test
    public void testCreateLanguage() {
        String validArg1 = "PT";
        String validArg2 = "EN";

        try {
            new Language(validArg1);
            new Language(validArg2);
        }catch(Exception e) {
            fail("Should not thrown exception");
        }

        String invalidArg = null;

        try{
            new Language(invalidArg);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated object is null", "Should have the same message");
        }

        String invalidArg2 = "";

        try{
            new Language(invalidArg2);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated string is empty", "Should have the same message");
        }

        String invalidArg3 = "DE";

        try{
            new Language(invalidArg3);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isTrue(e.getMessage().equals("Invalid language. DE"), "Should have the same message");
        }

    }
}