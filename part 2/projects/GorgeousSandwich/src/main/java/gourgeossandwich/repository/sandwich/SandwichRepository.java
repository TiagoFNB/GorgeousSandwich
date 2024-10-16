package gourgeossandwich.repository.sandwich;

import gourgeossandwich.domain.sandwich.Sandwich;
import gourgeossandwich.domain.sandwich.SandwichInternalId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRepository extends JpaRepository<Sandwich, String> {

    Sandwich getSandwichById(SandwichInternalId id);
}
