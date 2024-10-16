package gourgeossandwich.domain.sandwich;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.Validate;
import gourgeossandwich.domain.shared.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class SellingPrice implements ValueObject<SellingPrice> {

    @JsonProperty
    @Column(nullable = false)
    private Double price;

    protected SellingPrice() {}

    /**
     * Constructor.
     *
     * @param price Designation string.
     */
    public SellingPrice(final Double price) {
        Validate.notNull(price);
        Validate.isTrue(price > 0);

        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SellingPrice other = (SellingPrice) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return price.hashCode();
    }

    @Override
    public boolean sameValueAs(SellingPrice other) {
        return other != null && this.price.equals(other.price);
    }

    @Override
    public String toString() {
        return price.toString();
    }
}
