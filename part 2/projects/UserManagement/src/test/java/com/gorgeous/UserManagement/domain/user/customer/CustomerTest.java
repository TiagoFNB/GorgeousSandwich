package com.gorgeous.UserManagement.domain.user.customer;

import com.gorgeous.UserManagement.domain.user.UserEmail;
import com.gorgeous.UserManagement.domain.user.UserInternalId;
import com.gorgeous.UserManagement.domain.user.UserName;
import com.gorgeous.UserManagement.domain.user.UserPassword;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

class CustomerTest {

    @Test
    public void testCreateCustomer() {
        UserInternalId mockedId = mock(UserInternalId.class);
        UserPassword mockedPwd = mock(UserPassword.class);
        UserEmail mockedEmail = mock(UserEmail.class);
        UserName mockedUsername = mock(UserName.class);
        CustomerAddress mockedAddrs = mock(CustomerAddress.class);
        CustomerTIN mockedTin = mock(CustomerTIN.class);


        try {
            new Customer(mockedId,mockedPwd,mockedEmail,mockedUsername,mockedAddrs,mockedTin);
        } catch(Exception e) {
            fail("Should not thrown exception");
        }

        try{
            new Customer(null,mockedPwd,mockedEmail,mockedUsername,mockedAddrs,mockedTin);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserInternalId is required", "Should have the same message");
        }

        try{
            new Customer(mockedId,null,mockedEmail,mockedUsername,mockedAddrs,mockedTin);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserPassword is required", "Should have the same message");
        }

        try{
            new Customer(mockedId,mockedPwd,null,mockedUsername,mockedAddrs,mockedTin);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserEmail is required", "Should have the same message");
        }

        try{
            new Customer(mockedId,mockedPwd,mockedEmail,null,mockedAddrs,mockedTin);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserName is required", "Should have the same message");
        }


        try{
            new Customer(mockedId,mockedPwd,mockedEmail,mockedUsername,null,mockedTin);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "CustomerAddress is required", "Should have the same message");
        }

        try{
            new Customer(mockedId,mockedPwd,mockedEmail,mockedUsername,mockedAddrs,null);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "CustomerTIN is required", "Should have the same message");
        }

    }

}