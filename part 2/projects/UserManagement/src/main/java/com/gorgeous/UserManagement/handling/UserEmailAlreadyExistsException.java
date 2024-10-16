package com.gorgeous.UserManagement.handling;


public class UserEmailAlreadyExistsException extends RuntimeException {

    private final String email;

    public UserEmailAlreadyExistsException(final String email) {
        this.email = email;
    }

    @Override
    public String getMessage() {
        return "There's already an user with the e-mail :" + email.toString();
    }
}
