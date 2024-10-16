package com.gorgeous.PromotionManagement.controller;

import com.gorgeous.PromotionManagement.domain.Promotion;
import com.gorgeous.PromotionManagement.service.ListPromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPromotionController {
    protected ListPromotionService listPromotionService;

    public GetPromotionController(ListPromotionService listPromotionService) {
        this.listPromotionService = listPromotionService;
    }

    public List<Promotion> listPromotion() {
        return listPromotionService.getAllPromotions();
    }

    public List<Promotion> getPromotionByType(String type) {
        return listPromotionService.findByType(type);
    }

    public List<Promotion> findBySandwichAndPeriod(String id, String period) {
        return listPromotionService.findBySandwichAndPeriod(id,period);
    }

}
