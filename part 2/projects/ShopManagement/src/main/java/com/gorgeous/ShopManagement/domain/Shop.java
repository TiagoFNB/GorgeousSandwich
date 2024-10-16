package com.gorgeous.ShopManagement.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.gorgeous.ShopManagement.shared.Entity;
import org.apache.commons.lang.Validate;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "Shop")
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
    @JsonProperty
    private List<DailySchedule> dailySchedules;

    @JsonUnwrapped
    @Embedded
    private UserInternalId shopManagerId;

    @JsonProperty
    @ElementCollection
    private List<SandwichInternalId> sandwichList;

    @Embedded
    @JsonUnwrapped
    private ShopProperties shopProperties;

    protected Shop() {
    }

    public Shop(final ShopInternalId id, final ShopDesignation designation, final ShopAddress address, List<DailySchedule> dailySchedules, final UserInternalId shopManagerId, List<SandwichInternalId> sandwichList, ShopProperties shopProperties) {
        Validate.notNull(id, "ShopInternalId is required");
        Validate.notNull(designation, "ShopDesignation is required");
        Validate.notNull(address, "ShopAddress is required");
        Validate.notNull(dailySchedules, "DailySchedules are required");
        Validate.isTrue(!dailySchedules.isEmpty(), "Must have 7 daily Schedules");
        Validate.isTrue(dailySchedules.size() == 7, "Must have 7 daily Schedules");
        Validate.isTrue(checkDays(dailySchedules), "Must have 7 daily Schedules, with all 7 different days");
        Validate.notNull(shopManagerId, "ShopManager is required");
        Validate.notNull(sandwichList, "SandwichList is required");
        Validate.isTrue(!sandwichList.isEmpty(), "Shop must have Sandwiches");
        Validate.notNull(shopProperties, "ShopProperties is required");

        this.id = id;
        this.designation = designation;
        this.address = address;
        this.dailySchedules = dailySchedules;
        this.shopManagerId = shopManagerId;
        this.sandwichList = sandwichList;
        this.shopProperties = shopProperties;
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

    public void setShopProperties(ShopProperties shopProperties) {
        this.shopProperties = shopProperties;
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
