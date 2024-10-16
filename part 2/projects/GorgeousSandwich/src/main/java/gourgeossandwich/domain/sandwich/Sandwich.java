package gourgeossandwich.domain.sandwich;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import gourgeossandwich.domain.shared.Entity;
import org.apache.commons.lang.Validate;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "Sandwich")
public class Sandwich implements Entity<Sandwich> {

    @EmbeddedId
    @JsonUnwrapped
    private SandwichInternalId id;

    @Embedded
    @JsonUnwrapped
    private SandwichDesignation designation;

    @Embedded
    @JsonUnwrapped
    private SellingPrice price;

    @ElementCollection
    @JsonProperty
    private List<Description> descriptionList;

    protected Sandwich() {}

    public Sandwich(final SandwichInternalId id, final SandwichDesignation designation, SellingPrice price, List<Description> descriptionList) {
        Validate.notNull(id, "SandwichInternalId is required");
        Validate.notNull(designation, "SandwichDesignation is required");
        Validate.notNull(price, "SellingPrice is required");
        Validate.notNull(descriptionList, "Descriptions are required");
        Validate.notEmpty(descriptionList, "Descriptions are required");

        this.id = id;
        this.designation = designation;
        this.price = price;
        this.descriptionList = descriptionList;
    }

    @Override
    public boolean sameIdentityAs(final Sandwich other) {
        return other != null && id.sameValueAs(other.id);
    }

    /**
     * @param object to compare
     * @return True if they have the same identity
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final Sandwich other = (Sandwich) object;
        return sameIdentityAs(other);
    }

    /**
     * @return Hash code of id
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id.toString();
    }


}
