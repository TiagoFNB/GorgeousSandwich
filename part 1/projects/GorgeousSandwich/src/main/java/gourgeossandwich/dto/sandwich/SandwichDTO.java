package gourgeossandwich.dto.sandwich;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SandwichDTO {
    @JsonProperty("sandwichDesignation")
    private String sandwichDesignation;

    @JsonProperty("sellingPrice")
    private Double sellingPrice;

    @JsonProperty("descriptionList")
    private List<String> descriptionList;
}

