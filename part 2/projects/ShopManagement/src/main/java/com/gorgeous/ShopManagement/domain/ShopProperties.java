package com.gorgeous.ShopManagement.domain;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.gorgeous.ShopManagement.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Access(AccessType.FIELD)
public class ShopProperties implements ValueObject<ShopProperties> {
    @JsonUnwrapped
    @Embedded
    private MinimumAcceptableAdvance minimumAcceptableAdvance;

    @JsonUnwrapped
    @Embedded
    private MaximumNumberDeliveries maximumNumberDeliveries;

    @JsonUnwrapped
    @Embedded
    private Period period;

    protected ShopProperties() {
    }

    public ShopProperties(final MinimumAcceptableAdvance minimumAcceptableAdvance, final MaximumNumberDeliveries maximumNumberDeliveries, final Period period) {
        Validate.notNull(minimumAcceptableAdvance, "MinimumAcceptableAdvance is required");
        Validate.notNull(maximumNumberDeliveries, "MaximumNumberDeliveries is required");
        Validate.notNull(period, "Period is required");

        this.minimumAcceptableAdvance = minimumAcceptableAdvance;
        this.maximumNumberDeliveries = maximumNumberDeliveries;
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopProperties other = (ShopProperties) o;

        return sameValueAs(other);
    }

    @Override
    public boolean sameValueAs(ShopProperties other) {
        return other != null && (this.minimumAcceptableAdvance.equals(other.minimumAcceptableAdvance) && this.maximumNumberDeliveries.equals(other.maximumNumberDeliveries) && this.period.equals(other.period));
    }

    @Override
    public String toString() {
        return "Minimum Acceptable Advance: " + minimumAcceptableAdvance.toString() + "\n"
                + "Maximum Number Deliveries: " + maximumNumberDeliveries.toString() + "\n"
                + "Period: " + period.toString();
    }
}
