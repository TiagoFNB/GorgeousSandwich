package com.gorgeous.PromotionManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.Validate;
import com.gorgeous.PromotionManagement.shared.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public final class SandwichInternalId implements ValueObject<SandwichInternalId> {

    @JsonProperty
    @Column(nullable = false)
    private String sandwichId;

    protected SandwichInternalId() {}

    /**
     * Constructor.
     *
     * @param sandwichId Id string.
     */
    public SandwichInternalId(final String sandwichId) {
        Validate.notNull(sandwichId);
        Validate.notEmpty(sandwichId);
        this.sandwichId = sandwichId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SandwichInternalId other = (SandwichInternalId) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return sandwichId.hashCode();
    }

    @Override
    public boolean sameValueAs(SandwichInternalId other) {
        return other != null && this.sandwichId.equals(other.sandwichId);
    }

    @Override
    public String toString() {
        return sandwichId;
    }

    /**
     * Generates a new Id
     * @return SandwichInternalId
     */
    public static SandwichInternalId genNewId() {
        return new SandwichInternalId(UUID.randomUUID().toString());
    }
}
