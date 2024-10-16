package com.gorgeous.ShopManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gorgeous.ShopManagement.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public final class ClosingHours implements ValueObject<ClosingHours> {

    @JsonProperty
    private String closingHours;

    /**
     * Constructor.
     *
     * @param closingHours ClosingHours string.
     */
    public ClosingHours(final String closingHours) {
        Validate.notNull(closingHours);
        Validate.notEmpty(closingHours, "The ClosingHours must contain an hour");
        Validate.isTrue(closingHours.contains(":"), "Introduce ClosingHours in the HH:mm format");
        String[] hourMinute = closingHours.split(":");
        Validate.isTrue(hourMinute[0].length() == 2 && isInt(hourMinute[0]), "Introduce ClosingHours in the HH:mm format");
        Validate.isTrue(hourMinute[1].length() == 2 && isInt(hourMinute[1]), "Introduce ClosingHours in the HH:mm format");
        Validate.isTrue(0 <= Integer.parseInt(hourMinute[0]) && Integer.parseInt(hourMinute[0]) <= 23, "Hour must be between 0 and 23");
        Validate.isTrue(0 <= Integer.parseInt(hourMinute[1]) && Integer.parseInt(hourMinute[1]) <= 59, "Minute must be between 0 and 59");

        this.closingHours = closingHours;
    }

    protected ClosingHours() {

    }

    public static boolean isInt(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public int returnHours() {
        String[] hourMinute = this.closingHours.split(":");
        return Integer.parseInt(hourMinute[0]);
    }

    public int returnMinutes() {
        String[] hourMinute = this.closingHours.split(":");
        return Integer.parseInt(hourMinute[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClosingHours other = (ClosingHours) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return closingHours.hashCode();
    }

    @Override
    public boolean sameValueAs(ClosingHours other) {
        return other != null && this.closingHours.equals(other.closingHours);
    }

    @Override
    public String toString() {
        return closingHours;
    }
}
