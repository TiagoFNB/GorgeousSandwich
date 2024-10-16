package com.gorgeous.SandwichManagement.controller;

import com.gorgeous.SandwichManagement.domain.Sandwich;
import com.gorgeous.SandwichManagement.dto.SandwichDTO;
import com.gorgeous.SandwichManagement.service.CreateSandwichService;
import org.springframework.stereotype.Service;

@Service
public class CreateSandwichController {
    protected CreateSandwichService createSandwichService;

    public CreateSandwichController(CreateSandwichService createSandwichService) {
        this.createSandwichService = createSandwichService;
    }

    public Sandwich createSandwich(SandwichDTO sandwichDTO) throws Exception {
        return createSandwichService.createNewSandwich(sandwichDTO);
    }
}
