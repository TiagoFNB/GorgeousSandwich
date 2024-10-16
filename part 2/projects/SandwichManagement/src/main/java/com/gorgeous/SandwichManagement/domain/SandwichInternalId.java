package com.gorgeous.SandwichManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gorgeous.SandwichManagement.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public final class SandwichInternalId implements ValueObject<SandwichInternalId> {

    @JsonProperty
    @Column(unique = true)
    private String id;

    protected SandwichInternalId() {}

    /**
     * Constructor.
     *
     * @param id Id string.
     */
    public SandwichInternalId(final String id) {
        Validate.notNull(id);
        Validate.notEmpty(id);
        this.id = id;
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
        return id.hashCode();
    }

    @Override
    public boolean sameValueAs(SandwichInternalId other) {
        return other != null && this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return id;
    }

    /**
     * Generates a new Id
     * @return SandwichInternalId
     */
    public static SandwichInternalId genNewId() {
        return new SandwichInternalId(UUID.randomUUID().toString());
    }
}
