package com.gorgeous.PromotionManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class PromotionDTO {
    @JsonProperty("promotionPercentage")
    private Double promotionPercentage;

    @JsonProperty("promotionPeriod")
    private PromotionPeriodDTO promotionPeriod;

    @JsonProperty("promotionType")
    private String promotionType;

    @JsonProperty("sandwichInternalId")
    private String sandwichInternalId;
}
