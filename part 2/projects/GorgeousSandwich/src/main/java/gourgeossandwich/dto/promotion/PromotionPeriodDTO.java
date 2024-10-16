package gourgeossandwich.dto.promotion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PromotionPeriodDTO {
    @JsonProperty("promotionPeriodBeginning")
    private String promotionPeriodBeginning;

    @JsonProperty("promotionPeriodEnd")
    private String promotionPeriodEnd;
}
