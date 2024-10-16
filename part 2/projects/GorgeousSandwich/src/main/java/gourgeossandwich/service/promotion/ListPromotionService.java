package gourgeossandwich.service.promotion;

import gourgeossandwich.domain.promotion.Promotion;
import gourgeossandwich.repository.promotion.PromotionRepository;
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


}
