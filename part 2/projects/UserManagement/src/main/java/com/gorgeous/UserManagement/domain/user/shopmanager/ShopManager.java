package com.gorgeous.UserManagement.domain.user.shopmanager;

import com.gorgeous.UserManagement.domain.user.*;

import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "ShopManager")
public class ShopManager extends User {
    protected ShopManager() {
    }

    public ShopManager(final UserInternalId id,
                 final UserPassword pwd,
                 final UserEmail email,
                 final UserName userName) {
        super(id, pwd, email, userName, UserRole.SHOPMANAGER);
    }

    public String toString() {
        return super.toString();
    }
}
