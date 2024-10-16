package gourgeossandwich.domain.promotion;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import gourgeossandwich.domain.sandwich.Sandwich;
import gourgeossandwich.domain.shared.Entity;
import org.apache.commons.lang.Validate;
import gourgeossandwich.domain.sandwich.Sandwich;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "Promotion")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Promotion implements Entity<Promotion>{

    @JsonUnwrapped
    @EmbeddedId
    private PromotionInternalId id;


    @JsonUnwrapped
    @Embedded
    private PromotionPercentage percentage;


    @JsonUnwrapped
    @Embedded
    private PromotionPeriod period;


    //@JsonProperty
    @JsonUnwrapped
    @Enumerated(EnumType.STRING)
    private PromotionType type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Sandwich", referencedColumnName = "id")
    @JsonUnwrapped
    private Sandwich sandwich;


    public Promotion(final PromotionInternalId id, final PromotionPercentage percentage, final PromotionPeriod period, final PromotionType type, final Sandwich sandwich){
        Validate.notNull(id, "PromotionInternalId is required");
        Validate.notNull(percentage, "Percentage of the promotion is required");
        Validate.notNull(period, "Period of the promotion is required");
        Validate.notNull(type, "Promotion type are required");
        Validate.notNull(sandwich, "Sandwich is required");

        this.id = id;
        this.percentage = percentage;
        this.period = period;
        this.type = type;
        this.sandwich = sandwich;
    }

    public Promotion() {

    }

    @Override
    public boolean sameIdentityAs(Promotion other) {
       // return other != null && id.sameValueAs(other.id);
       return false;
    }
    
    /**
     * @param object to compare
     * @return True if they have the same identity
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final Promotion other = (Promotion) object;
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
