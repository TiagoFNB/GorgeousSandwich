package  com.gorgeous.PromotionManagement;

import com.gorgeous.PromotionManagement.controller.CreatePromotionController;
import com.gorgeous.PromotionManagement.controller.GetPromotionController;
import com.gorgeous.PromotionManagement.domain.Promotion;
import com.gorgeous.PromotionManagement.dto.PromotionDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/promotion")
public class Router {

    protected CreatePromotionController createPromotionController;
   protected GetPromotionController getPromotionController;

    public Router(CreatePromotionController createPromotionController, GetPromotionController getPromotionController) {
        this.createPromotionController = createPromotionController;
        this.getPromotionController = getPromotionController;
    }


    @MutationMapping
    public Promotion create(@Argument PromotionDTO promotionDTO) {
        return createPromotionController.createPromotion(promotionDTO);
    }

    @QueryMapping
    public List<Promotion> getList() {
        return getPromotionController.listPromotion();
    }

    @QueryMapping
    public List<Promotion> getPromotionByType(@Argument String type) {
        return getPromotionController.getPromotionByType(type);
    }

    @QueryMapping
    public List<Promotion> findBySandwichAndPeriod(@Argument String sandwichInternalId, @Argument String date) {
        return getPromotionController.findBySandwichAndPeriod(sandwichInternalId,date);
    }


}