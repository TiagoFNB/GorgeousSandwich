package gourgeossandwich.domain.sandwich;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.Validate;
import gourgeossandwich.domain.shared.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class SandwichDesignation implements ValueObject<SandwichDesignation> {

    @JsonProperty
    @Column(nullable = false)
    private String designation;

    protected SandwichDesignation() {}

    /**
     * Constructor.
     *
     * @param designation Designation string.
     */
    public SandwichDesignation(final String designation) {
        Validate.notNull(designation);
        Validate.notEmpty(designation);
        this.designation = designation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SandwichDesignation other = (SandwichDesignation) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return designation.hashCode();
    }

    @Override
    public boolean sameValueAs(SandwichDesignation other) {
        return other != null && this.designation.equals(other.designation);
    }

    @Override
    public String toString() {
        return designation;
    }
}
