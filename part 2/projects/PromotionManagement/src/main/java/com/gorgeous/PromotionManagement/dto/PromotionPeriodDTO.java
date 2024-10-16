package com.gorgeous.PromotionManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PromotionPeriodDTO {
    @JsonProperty("promotionPeriodBeginning")
    private String promotionPeriodBeginning;

    @JsonProperty("promotionPeriodEnd")
    private String promotionPeriodEnd;
}
