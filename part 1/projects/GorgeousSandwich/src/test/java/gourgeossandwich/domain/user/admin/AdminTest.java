package gourgeossandwich.domain.user.admin;

import gourgeossandwich.domain.sandwich.Description;
import gourgeossandwich.domain.user.UserEmail;
import gourgeossandwich.domain.user.UserInternalId;
import gourgeossandwich.domain.user.UserName;
import gourgeossandwich.domain.user.UserPassword;
import gourgeossandwich.domain.user.customer.Customer;
import gourgeossandwich.domain.user.customer.CustomerAddress;
import gourgeossandwich.domain.user.customer.CustomerTIN;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AdminTest {

    @Test
    public void testCreateAdmin() {
        UserInternalId mockedId = mock(UserInternalId.class);
        UserPassword mockedPwd = mock(UserPassword.class);
        UserEmail mockedEmail = mock(UserEmail.class);
        UserName mockedUsername = mock(UserName.class);

        try {
            new Admin(mockedId,mockedPwd,mockedEmail,mockedUsername);
        } catch(Exception e) {
            fail("Should not thrown exception");
        }

        try{
            new Admin(null,mockedPwd,mockedEmail,mockedUsername);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserInternalId is required", "Should have the same message");
        }

        try{
            new Admin(mockedId,null,mockedEmail,mockedUsername);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserPassword is required", "Should have the same message");
        }

        try{
            new Admin(mockedId,mockedPwd,null,mockedUsername);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserEmail is required", "Should have the same message");
        }

        try{
            new Admin(mockedId,mockedPwd,mockedEmail,null);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserName is required", "Should have the same message");
        }


    }
}