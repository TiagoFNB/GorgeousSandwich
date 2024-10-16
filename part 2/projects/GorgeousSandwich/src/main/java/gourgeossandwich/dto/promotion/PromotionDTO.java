package gourgeossandwich.dto.promotion;

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

    @JsonProperty("sandwichId")
    private String sandwichId;
}
