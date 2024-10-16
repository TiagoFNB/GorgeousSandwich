package com.gorgeous.UserManagement.domain.user;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

class UserTest {
    @Test
    public void testCreateUser() {
        UserInternalId mockedId = mock(UserInternalId.class);
        UserPassword mockedPwd = mock(UserPassword.class);
        UserEmail mockedEmail = mock(UserEmail.class);
        UserName mockedUsername = mock(UserName.class);
        UserRole mockedRole = mock(UserRole.class);

        try {
            new User(mockedId,mockedPwd,mockedEmail,mockedUsername,mockedRole);
        } catch(Exception e) {
            fail("Should not thrown exception");
        }

        try{
            new User(null,mockedPwd,mockedEmail,mockedUsername,mockedRole);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserInternalId is required", "Should have the same message");
        }

        try{
            new User(mockedId,null,mockedEmail,mockedUsername,mockedRole);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserPassword is required", "Should have the same message");
        }

        try{
            new User(mockedId,mockedPwd,null,mockedUsername,mockedRole);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserEmail is required", "Should have the same message");
        }

        try{
            new User(mockedId,mockedPwd,mockedEmail,null,mockedRole);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserName is required", "Should have the same message");
        }

        try{
            new User(mockedId,mockedPwd,mockedEmail,mockedUsername,null);
            fail("Should have thrown exception");
        } catch(Exception e) {
            Assert.isInstanceOf(IllegalArgumentException.class,e);
            Assert.isTrue(e.getMessage() == "UserRole is required", "Should have the same message");
        }


    }
}