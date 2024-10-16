package com.gorgeous.PromotionManagement.service;

import com.gorgeous.PromotionManagement.domain.Promotion;
import com.gorgeous.PromotionManagement.PromotionRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPromotionService {
    protected PromotionRepository promotionRepository;

    public ListPromotionService(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public List<Promotion> getAllPromotions() {
        return this.promotionRepository.findAll();
    }

    public List<Promotion> findByType(String type) {
        return this.promotionRepository.findByType(type);
    }

    public List<Promotion> findBySandwichAndPeriod(String id, String period) {
        return this.promotionRepository.findBySandwichAndPeriod(id, period);
    }


}
