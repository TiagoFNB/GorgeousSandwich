package gourgeossandwich.domain.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import gourgeossandwich.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.*;

@Embeddable
@Access(AccessType.FIELD)
public class DailySchedule implements ValueObject<DailySchedule> {
    @JsonUnwrapped
    @Embedded
    private OpeningHours openingHours;

    @JsonUnwrapped
    @Embedded
    private ClosingHours closingHours;

    @Enumerated(EnumType.STRING)
    @JsonProperty
    private Day day;

    protected DailySchedule() {
    }

    public DailySchedule(final OpeningHours openingHours, final ClosingHours closingHours, final Day day) {
        Validate.notNull(openingHours, "OpeningHours is required");
        Validate.notNull(closingHours, "ClosingHours is required");
        Validate.notNull(day, "Day is required");
        Validate.isTrue(checkOpeningFirstThenClose(openingHours, closingHours), "OpeningHours must be earlier than ClosingHours");

        this.openingHours = openingHours;
        this.closingHours = closingHours;
        this.day = day;
    }

    public String dayOfTheWeek() {
        return this.day.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DailySchedule other = (DailySchedule) o;

        return sameValueAs(other);
    }

    @Override
    public boolean sameValueAs(DailySchedule other) {
        return other != null && (this.openingHours.equals(other.openingHours) && this.closingHours.equals(other.closingHours) && this.day.equals(other.day));
    }

    @Override
    public String toString() {
        return "Day: " + day.toString() + "\n"
                + "Opening Hour: " + openingHours.toString() + "\n"
                + "Closing Hour: " + closingHours.toString();
    }

    private boolean checkOpeningFirstThenClose(OpeningHours openingHours, ClosingHours closingHours) {
        boolean verification = true;
        if ((openingHours.returnHours() > closingHours.returnHours()) || (openingHours.returnHours() == closingHours.returnHours() && openingHours.returnMinutes() > closingHours.returnMinutes())) {
            verification = !((openingHours.returnHours() > closingHours.returnHours()) || (openingHours.returnHours() == closingHours.returnHours() && openingHours.returnMinutes() > closingHours.returnMinutes()));
        }
        return verification;
    }
}
