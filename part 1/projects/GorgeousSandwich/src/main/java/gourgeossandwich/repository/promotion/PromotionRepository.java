package gourgeossandwich.repository.promotion;

import gourgeossandwich.domain.promotion.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, String> {
    @Query(value = "SELECT p.* FROM promotion p WHERE p.type = ?1", nativeQuery = true)
    public List<Promotion> findByType(String type);

}
