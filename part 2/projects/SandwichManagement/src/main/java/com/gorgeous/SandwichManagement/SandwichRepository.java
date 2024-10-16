package com.gorgeous.SandwichManagement;

import com.gorgeous.SandwichManagement.domain.Sandwich;
import com.gorgeous.SandwichManagement.domain.SandwichInternalId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichRepository extends JpaRepository<Sandwich, String> {

    Sandwich getSandwichById(SandwichInternalId id);
}
