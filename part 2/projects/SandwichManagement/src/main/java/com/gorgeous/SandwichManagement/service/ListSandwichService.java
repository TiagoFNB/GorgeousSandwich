package com.gorgeous.SandwichManagement.service;

import com.gorgeous.SandwichManagement.SandwichRepository;
import com.gorgeous.SandwichManagement.domain.Sandwich;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListSandwichService {

    protected SandwichRepository sandwichRepository;

    public ListSandwichService(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }

    public List<Sandwich> getAllSandwiches() {
        return this.sandwichRepository.findAll();
    }
}
