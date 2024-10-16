package com.gorgeous.PromotionManagement.controller;


import com.gorgeous.PromotionManagement.domain.Promotion;
import com.gorgeous.PromotionManagement.dto.PromotionDTO;
import com.gorgeous.PromotionManagement.service.CreatePromotionService;
import org.springframework.stereotype.Service;

@Service
public class CreatePromotionController {
    
    protected CreatePromotionService createPromotionService;

    public CreatePromotionController(CreatePromotionService createPromotionService) {
        this.createPromotionService = createPromotionService;
    }

    public Promotion createPromotion(PromotionDTO promotionDTO) {
        return createPromotionService.createNewPromotion(promotionDTO);
    }

}
