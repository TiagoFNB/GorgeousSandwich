package com.gorgeous.SandwichManagement.controller;

import com.gorgeous.SandwichManagement.domain.Sandwich;
import com.gorgeous.SandwichManagement.service.GetSandwichByIdService;
import org.springframework.stereotype.Service;

@Service
public class GetSandwichByIdController {
    protected GetSandwichByIdService getSandwichByIdService;

    public GetSandwichByIdController(GetSandwichByIdService getSandwichByIdService) {
        this.getSandwichByIdService = getSandwichByIdService;
    }

    public Sandwich get(String id) {
        return getSandwichByIdService.get(id);
    }
}
