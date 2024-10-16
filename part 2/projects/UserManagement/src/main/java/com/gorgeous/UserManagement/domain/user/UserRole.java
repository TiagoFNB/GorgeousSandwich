package com.gorgeous.UserManagement.domain.user;

import com.gorgeous.UserManagement.domain.shared.ValueObject;

public enum UserRole implements ValueObject<UserRole> {
    ADMIN {
        final int roleId = 1;

        @Override
        public String toString() {
            return "ADMIN";
        }

        @Override
        public boolean sameValueAs(UserRole other) {
            return false;
        }
    },
    CUSTOMER {
        final int roleId = 2;

        @Override
        public String toString() {
            return "CUSTOMER";
        }

        @Override
        public boolean sameValueAs(UserRole other) {
            return false;
        }
    },
    SHOPMANAGER {
        final int roleId = 3;

        @Override
        public String toString() {
            return "SHOPMANAGER";
        }

        @Override
        public boolean sameValueAs(UserRole other) {
            return false;
        }
    },
}

