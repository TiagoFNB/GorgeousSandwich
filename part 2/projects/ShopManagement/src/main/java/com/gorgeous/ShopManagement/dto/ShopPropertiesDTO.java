package com.gorgeous.ShopManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShopPropertiesDTO {
    @JsonProperty("maximumNumberDeliveries")
    private String maximumNumberDeliveries;

    @JsonProperty("minimumAcceptableAdvance")
    private String minimumAcceptableAdvance;

    @JsonProperty("period")
    private String period;
}
