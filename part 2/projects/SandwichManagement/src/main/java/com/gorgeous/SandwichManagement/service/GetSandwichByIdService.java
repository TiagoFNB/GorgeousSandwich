package com.gorgeous.SandwichManagement.service;

import com.gorgeous.SandwichManagement.SandwichRepository;
import com.gorgeous.SandwichManagement.domain.Sandwich;
import com.gorgeous.SandwichManagement.domain.SandwichInternalId;
import org.springframework.stereotype.Service;

@Service
public class GetSandwichByIdService {
    protected SandwichRepository sandwichRepository;

    public GetSandwichByIdService(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }

    public Sandwich get(String id) {
        return this.sandwichRepository.getSandwichById(new SandwichInternalId(id));
    }
}
