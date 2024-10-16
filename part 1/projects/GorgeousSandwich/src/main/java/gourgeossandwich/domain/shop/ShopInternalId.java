package gourgeossandwich.domain.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import gourgeossandwich.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public final class ShopInternalId implements ValueObject<ShopInternalId> {

    @JsonProperty
    @Column(unique = true)
    private String id;

    /**
     * Constructor.
     *
     * @param id Id string.
     */
    private ShopInternalId(final String id) {
        Validate.notNull(id);
        Validate.notEmpty(id);
        this.id = id;
    }

    protected ShopInternalId() {

    }

    /**
     * Generates a new Id
     *
     * @return ShopInternalId
     */
    public static ShopInternalId genNewId() {
        return new ShopInternalId(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopInternalId other = (ShopInternalId) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean sameValueAs(ShopInternalId other) {
        return other != null && this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return id;
    }
}
