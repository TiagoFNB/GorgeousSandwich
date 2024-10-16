package gourgeossandwich.dto.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ShopDTO {
    @JsonProperty("shopDesignation")
    private String shopDesignation;

    @JsonProperty("shopAddress")
    private String shopAddress;

    @JsonProperty("dailySchedule")
    private List<DailyScheduleDTO> dailySchedule;

    @JsonProperty("sandwichIdList")
    private List<String> sandwichIdList;

    @JsonProperty("shopManagerId")
    private String shopManagerId;
}
