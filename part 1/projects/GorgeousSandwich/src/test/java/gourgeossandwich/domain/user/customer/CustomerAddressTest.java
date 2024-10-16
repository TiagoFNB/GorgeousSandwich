package gourgeossandwich.domain.user.customer;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class CustomerAddressTest {

    @Test
    public void testCreateCustomerAddress() {
        String validArg1 = "Rua das ruas";

        try {
            new CustomerAddress(validArg1);;
        }catch(Exception e) {
            fail("Should not thrown exception");
        }

        String invalidArg = null;

        try{
            new CustomerAddress(invalidArg);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated object is null", "Should have the same message");
        }

        String invalidArg2 = "";

        try{
            new CustomerAddress(invalidArg2);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "The validated string is empty", "Should have the same message");
        }

    }

}