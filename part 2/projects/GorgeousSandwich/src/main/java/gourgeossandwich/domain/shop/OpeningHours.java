package gourgeossandwich.domain.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import gourgeossandwich.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public final class OpeningHours implements ValueObject<OpeningHours> {

    @JsonProperty
    private String openingHours;

    /**
     * Constructor.
     *
     * @param openingHours OpeningHours string.
     */
    public OpeningHours(final String openingHours) {
        Validate.notNull(openingHours);
        Validate.notEmpty(openingHours, "The OpeningHours must contain an hour");
        Validate.isTrue(openingHours.contains(":"), "Introduce OpeningHours in the HH:mm format");
        String[] hourMinute = openingHours.split(":");
        Validate.isTrue(hourMinute[0].length() == 2 && isInt(hourMinute[0]), "Introduce OpeningHours in the HH:mm format");
        Validate.isTrue(hourMinute[1].length() == 2 && isInt(hourMinute[1]), "Introduce OpeningHours in the HH:mm format");
        Validate.isTrue(0 <= Integer.parseInt(hourMinute[0]) && Integer.parseInt(hourMinute[0]) <= 23, "Hour must be between 0 and 23");
        Validate.isTrue(0 <= Integer.parseInt(hourMinute[1]) && Integer.parseInt(hourMinute[1]) <= 59, "Minute must be between 0 and 59");

        this.openingHours = openingHours;
    }

    protected OpeningHours() {

    }

    public int returnHours() {
        String[] hourMinute = this.openingHours.split(":");
        return Integer.parseInt(hourMinute[0]);
    }

    public int returnMinutes() {
        String[] hourMinute = this.openingHours.split(":");
        return Integer.parseInt(hourMinute[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpeningHours other = (OpeningHours) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return openingHours.hashCode();
    }

    @Override
    public boolean sameValueAs(OpeningHours other) {
        return other != null && this.openingHours.equals(other.openingHours);
    }

    @Override
    public String toString() {
        return openingHours;
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
}
