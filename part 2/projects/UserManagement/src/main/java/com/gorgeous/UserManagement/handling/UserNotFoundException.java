package com.gorgeous.UserManagement.handling;

public class UserNotFoundException  extends RuntimeException {

    private final String email;

    public UserNotFoundException(final String email) {
        this.email = email;
    }

    @Override
    public String getMessage() {
        return "There's no user registered with the e-mail :" + email.toString();
    }
}
