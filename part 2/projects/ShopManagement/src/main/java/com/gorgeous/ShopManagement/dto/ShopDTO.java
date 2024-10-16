package com.gorgeous.ShopManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gorgeous.ShopManagement.domain.ShopProperties;
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

    @JsonProperty("shopProperties")
    private ShopPropertiesDTO shopProperties;
}
