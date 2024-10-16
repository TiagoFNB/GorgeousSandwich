package gourgeossandwich.service.promotion;


import gourgeossandwich.domain.sandwich.Sandwich;
import gourgeossandwich.domain.sandwich.SandwichInternalId;
import gourgeossandwich.repository.sandwich.SandwichRepository;
import org.springframework.stereotype.Service;

import gourgeossandwich.domain.promotion.*;
import gourgeossandwich.dto.promotion.PromotionDTO;
import gourgeossandwich.dto.promotion.PromotionPeriodDTO;
import gourgeossandwich.repository.promotion.PromotionRepository;




@Service
public class CreatePromotionService {

    protected PromotionRepository promotionRepository;
    protected SandwichRepository sandwichRepository;

    public CreatePromotionService(PromotionRepository promotionRepository, SandwichRepository sandwichRepository) {
        this.promotionRepository = promotionRepository;
        this.sandwichRepository = sandwichRepository;
    }

    public Promotion createNewPromotion(PromotionDTO promotionDTO) {
        final PromotionInternalId id = PromotionInternalId.genNewId();
        final PromotionPercentage percentage = new PromotionPercentage(promotionDTO.getPromotionPercentage());
        final PromotionPeriod period = createPromotionPeriod(promotionDTO.getPromotionPeriod());
        final PromotionType type = getTypeFromDTO(promotionDTO.getPromotionType());
        final Sandwich sandwich = sandwichRepository.getSandwichById(new SandwichInternalId(promotionDTO.getSandwichId()));


        final Promotion promotion = new Promotion(id, percentage, period, type, sandwich);

        this.promotionRepository.save(promotion);


        return promotion;
    }

    private PromotionType getTypeFromDTO(String type) {
        switch (type.toLowerCase()) {
            case "local":
                return PromotionType.LOCAL;
            case "global":
                return PromotionType.GLOBAL;
            default:
                throw new IllegalArgumentException("Promotion Type must be local or global");
        }
    }

    private PromotionPeriod createPromotionPeriod(PromotionPeriodDTO promotionPeriodDTO) {
        PromotionPeriodBeginning promotionPeriodBeginning = new PromotionPeriodBeginning(promotionPeriodDTO.getPromotionPeriodBeginning());
        PromotionPeriodEnd promotionPeriodEnd = new PromotionPeriodEnd(promotionPeriodDTO.getPromotionPeriodEnd());

        return new PromotionPeriod(promotionPeriodBeginning, promotionPeriodEnd);
    }



}
