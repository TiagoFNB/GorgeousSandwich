package com.gorgeous.PromotionManagement;

import com.gorgeous.PromotionManagement.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, String> {
    @Query(value = "SELECT p.* FROM promotion p WHERE p.type = ?1", nativeQuery = true)
    public List<Promotion> findByType(String type);

    @Query(value = "SELECT p.* FROM promotion p WHERE p.sandwich_id = ?1 AND TO_DATE(p.promotion_period_beginning,'DD-MM-YYYY')< TO_DATE(?2,'DD-MM-YYYY') AND TO_DATE(p.promotion_period_end,'DD-MM-YYYY')> TO_DATE(?2,'DD-MM-YYYY') ", nativeQuery = true)
    public List<Promotion> findBySandwichAndPeriod(String id, String period);
}
