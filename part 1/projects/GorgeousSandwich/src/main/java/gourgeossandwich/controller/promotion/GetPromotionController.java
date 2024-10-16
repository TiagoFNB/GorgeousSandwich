package gourgeossandwich.controller.promotion;

import gourgeossandwich.domain.promotion.Promotion;
import gourgeossandwich.service.promotion.ListPromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPromotionController {
    protected ListPromotionService listPromotionService;

    public GetPromotionController(ListPromotionService listPromotionService) {
        this.listPromotionService = listPromotionService;
    }

    public ResponseEntity<List<Promotion>> listPromotion() {
        return ResponseEntity.ok(listPromotionService.getAllPromotions());
    }

    public ResponseEntity<List<Promotion>> getPromotionByType(String type) {
        return ResponseEntity.ok(listPromotionService.findByType(type));
    }



}
