package gourgeossandwich.domain.sandwich;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class SandwichDesignationTest {

    @Test
    public void testCreateSandwichDesignation() {
        String validArg1 = "id1";
        String validArg2 = "id2";

        try {
            new SandwichDesignation(validArg1);
            new SandwichDesignation(validArg2);
        }catch(Exception e) {
            fail("Should not thrown exception");
        }

        String invalidArg = null;

        try{
            new SandwichDesignation(invalidArg);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated object is null", "Should have the same message");
        }

        String invalidArg2 = "";

        try{
            new SandwichDesignation(invalidArg2);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated string is empty", "Should have the same message");
        }

    }
}