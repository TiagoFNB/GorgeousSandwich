package gourgeossandwich.dto.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DailyScheduleDTO {
    @JsonProperty("openingHours")
    private String openingHours;

    @JsonProperty("closingHours")
    private String closingHours;

    @JsonProperty("day")
    private String day;
}
