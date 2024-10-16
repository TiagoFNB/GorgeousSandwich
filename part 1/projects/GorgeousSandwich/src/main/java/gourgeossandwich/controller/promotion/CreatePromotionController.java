package gourgeossandwich.controller.promotion;

import org.springframework.http.ResponseEntity;

import gourgeossandwich.domain.promotion.Promotion;
import gourgeossandwich.dto.promotion.PromotionDTO;
import gourgeossandwich.service.promotion.CreatePromotionService;
import org.springframework.stereotype.Service;

@Service
public class CreatePromotionController {
    
    protected CreatePromotionService createPromotionService;

    public CreatePromotionController(CreatePromotionService createPromotionService) {
        this.createPromotionService = createPromotionService;
    }

    public ResponseEntity<Promotion> createPromotion(PromotionDTO promotionDTO) {
        return ResponseEntity.ok(createPromotionService.createNewPromotion(promotionDTO));
    }

}
