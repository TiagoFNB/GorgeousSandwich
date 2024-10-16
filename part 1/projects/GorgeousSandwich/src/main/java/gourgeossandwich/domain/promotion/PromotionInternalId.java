package gourgeossandwich.domain.promotion;

import gourgeossandwich.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PromotionInternalId implements ValueObject<PromotionInternalId>{
    
    @JsonProperty
    @Column(unique = true)
    private String id;

    /**
     * Constructor.
     *
     * @param id Id string.
     */
    private PromotionInternalId(final String id) {
        Validate.notNull(id);
        Validate.notEmpty(id);
        this.id = id;
    }

    protected PromotionInternalId() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PromotionInternalId other = (PromotionInternalId) o;

        return sameValueAs(other);
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean sameValueAs(PromotionInternalId other) {
        return other != null && this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return id;
    }


    /**
     * Generates a new Id
     * @return PromotionInternalId
     */
    public static PromotionInternalId genNewId() {

        return new PromotionInternalId(UUID.randomUUID().toString());
    }


}
