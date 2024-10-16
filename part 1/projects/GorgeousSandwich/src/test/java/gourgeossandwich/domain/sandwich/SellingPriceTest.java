package gourgeossandwich.domain.sandwich;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.fail;

public class SellingPriceTest {

    @Test
    public void testCreateSellingPrice() {
        Double validArg1 = 23.0;
        Double validArg2 = 24.0;

        try {
            new SellingPrice(validArg1);
            new SellingPrice(validArg2);
        }catch(Exception e) {
            fail("Should not thrown exception");
        }

        Double invalidArg = null;

        try{
            new SellingPrice(invalidArg);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated object is null", "Should have the same message");
        }

        Double invalidArg2 = -2.0;

        try{
            new SellingPrice(invalidArg2);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated expression is false", "Should have the same message");
        }

    }
}
