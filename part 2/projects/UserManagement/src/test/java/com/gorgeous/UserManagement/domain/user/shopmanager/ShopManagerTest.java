package com.gorgeous.UserManagement.domain.user.shopmanager;

import com.gorgeous.UserManagement.domain.user.UserEmail;
import com.gorgeous.UserManagement.domain.user.UserInternalId;
import com.gorgeous.UserManagement.domain.user.UserName;
import com.gorgeous.UserManagement.domain.user.UserPassword;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

class ShopManagerTest {

    @Test
    public void testCreateShopManager() {
        UserInternalId mockedId = mock(UserInternalId.class);
        UserPassword mockedPwd = mock(UserPassword.class);
        UserEmail mockedEmail = mock(UserEmail.class);
        UserName mockedUsername = mock(UserName.class);

        try {
            new ShopManager(mockedId,mockedPwd,mockedEmail,mockedUsername);
        } catch(Exception e) {
            fail("Should not thrown exception");
        }

        try{
            new ShopManager(null,mockedPwd,mockedEmail,mockedUsername);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserInternalId is required", "Should have the same message");
        }

        try{
            new ShopManager(mockedId,null,mockedEmail,mockedUsername);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserPassword is required", "Should have the same message");
        }

        try{
            new ShopManager(mockedId,mockedPwd,null,mockedUsername);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserEmail is required", "Should have the same message");
        }

        try{
            new ShopManager(mockedId,mockedPwd,mockedEmail,null);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserName is required", "Should have the same message");
        }


    }
}