package gourgeossandwich.domain.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import gourgeossandwich.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public final class ShopDesignation implements ValueObject<ShopDesignation> {

    @JsonProperty
    @Column(nullable = false)
    private String designation;

    private static final Pattern VALID_PATTERN = Pattern.compile("^[a-zA-Z0-9 .,;:'-]{1,100}$");

    /**
     * Constructor.
     *
     * @param designation Designation string.
     */
    public ShopDesignation(final String designation) {
        Validate.notNull(designation);
        Validate.notEmpty(designation, "The ShopDesignation must contain an address");
        Validate.isTrue(VALID_PATTERN.matcher(designation).matches(), "The ShopDesignation is not valid (does not match the pattern).");
        this.designation = designation;
    }

    protected ShopDesignation() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopDesignation other = (ShopDesignation) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return designation.hashCode();
    }

    @Override
    public boolean sameValueAs(ShopDesignation other) {
        return other != null && this.designation.equals(other.designation);
    }

    @Override
    public String toString() {
        return designation;
    }
}
