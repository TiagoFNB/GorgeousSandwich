package gourgeossandwich.domain.sandwich;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

class SandwichTest {

    @Test
    public void testCreateSandwich() {
        SandwichInternalId mockedId = mock(SandwichInternalId.class);
        SandwichDesignation mockedDesig = mock(SandwichDesignation.class);
        SellingPrice mockedSP = mock(SellingPrice.class);
        Description mockedDesc = mock(Description.class);
        List<Description> lds = new ArrayList<>();
        lds.add(mockedDesc);

        try {
            new Sandwich(mockedId,mockedDesig,mockedSP,lds);
        } catch(Exception e) {
            fail("Should not thrown exception");
        }

        try{
            new Sandwich(null,mockedDesig,mockedSP,lds);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "SandwichInternalId is required", "Should have the same message");
        }

        try{
            new Sandwich(mockedId,null,mockedSP,lds);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "SandwichDesignation is required", "Should have the same message");
        }

        try{
            new Sandwich(mockedId,mockedDesig,null,lds);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "SellingPrice is required", "Should have the same message");
        }

        try{
            new Sandwich(mockedId,mockedDesig,mockedSP,null);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "Descriptions are required", "Should have the same message");
        }

        List<Description> ldsEmpty = new ArrayList<>();

        try{
            new Sandwich(mockedId,mockedDesig,mockedSP,ldsEmpty);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "Descriptions are required", "Should have the same message");
        }

    }
}