package gourgeossandwich.domain.shop;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import gourgeossandwich.domain.sandwich.Sandwich;
import gourgeossandwich.domain.shared.Entity;
import gourgeossandwich.domain.user.shopmanager.ShopManager;
import org.apache.commons.lang.Validate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "Shop")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class Shop implements Entity<Shop> {

    @JsonUnwrapped
    @EmbeddedId
    private ShopInternalId id;

    @JsonUnwrapped
    @Embedded
    private ShopDesignation designation;

    @JsonUnwrapped
    @Embedded
    private ShopAddress address;

    @ElementCollection
    @JsonUnwrapped
    private List<DailySchedule> dailySchedules;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopManager", referencedColumnName = "id")
    @JsonUnwrapped
    private ShopManager shopManager;

    @ManyToMany
    @JsonUnwrapped
    private List<Sandwich> sandwichList;

    protected Shop() {
    }

    public Shop(final ShopInternalId id, final ShopDesignation designation, final ShopAddress address, List<DailySchedule> dailySchedules, final ShopManager shopManager, List<Sandwich> sandwichList) {
        Validate.notNull(id, "ShopInternalId is required");
        Validate.notNull(designation, "ShopDesignation is required");
        Validate.notNull(address, "ShopAddress is required");
        Validate.notNull(dailySchedules, "DailySchedules are required");
        Validate.isTrue(!dailySchedules.isEmpty(), "Must have 7 daily Schedules");
        Validate.isTrue(dailySchedules.size() == 7, "Must have 7 daily Schedules");
        Validate.isTrue(checkDays(dailySchedules), "Must have 7 daily Schedules, with all 7 different days");
        Validate.notNull(shopManager, "ShopManager is required");
        Validate.notNull(sandwichList, "SandwichList is required");
        Validate.isTrue(!sandwichList.isEmpty(), "Shop must have Sandwiches");

        this.id = id;
        this.designation = designation;
        this.address = address;
        this.dailySchedules = dailySchedules;
        this.shopManager = shopManager;
        this.sandwichList = sandwichList;
    }

    @Override
    public boolean sameIdentityAs(final Shop other) {
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

        final Shop other = (Shop) object;
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

    private boolean checkDays(List<DailySchedule> dailySchedules) {
        List<String> listDay = new ArrayList<>();
        boolean good = false;
        for (DailySchedule dailySchedule : dailySchedules) {
            if (!listDay.contains(dailySchedule.dayOfTheWeek())) {
                listDay.add(dailySchedule.dayOfTheWeek());
            }
        }
        if (listDay.size() == 7) {
            good = true;
        }
        return good;
    }
}
