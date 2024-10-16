package com.gorgeous.ShopManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gorgeous.ShopManagement.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public final class UserInternalId implements ValueObject<UserInternalId> {

    @JsonProperty
    @Column(nullable = false)
    private String shopManagerId;

    /**
     * Constructor.
     *
     * @param shopManagerId Id string.
     */
    public UserInternalId(final String shopManagerId) {
        Validate.notNull(shopManagerId);
        Validate.notEmpty(shopManagerId);
        this.shopManagerId = shopManagerId;
    }

    protected UserInternalId() {

    }

    /**
     * Generates a new Id
     *
     * @return UserInternalId
     */
    public static UserInternalId genNewId() {
        return new UserInternalId(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInternalId other = (UserInternalId) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return shopManagerId.hashCode();
    }

    @Override
    public boolean sameValueAs(UserInternalId other) {
        return other != null && this.shopManagerId.equals(other.shopManagerId);
    }

    @Override
    public String toString() {
        return shopManagerId;
    }

    public String idString() {
        return shopManagerId;
    }
}

