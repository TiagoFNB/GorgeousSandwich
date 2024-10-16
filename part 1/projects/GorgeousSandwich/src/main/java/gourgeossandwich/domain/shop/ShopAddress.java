package gourgeossandwich.domain.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import gourgeossandwich.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public final class ShopAddress implements ValueObject<ShopAddress> {

    @JsonProperty
    @Column(nullable = false, unique = true)
    private String address;

    private static final Pattern VALID_PATTERN = Pattern.compile("^[a-zA-Z0-9 .,#;:'-]{1,40}$");

    /**
     * Constructor.
     *
     * @param address Adress string.
     */
    public ShopAddress(final String address) {
        Validate.notNull(address);
        Validate.notEmpty(address, "The ShopAdress must contain an address");
        Validate.isTrue(VALID_PATTERN.matcher(address).matches(), "The ShopAddress is not valid (does not match the pattern).");
        this.address = address;
    }

    protected ShopAddress() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopAddress other = (ShopAddress) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    @Override
    public boolean sameValueAs(ShopAddress other) {
        return other != null && this.address.equals(other.address);
    }

    @Override
    public String toString() {
        return address;
    }
}
