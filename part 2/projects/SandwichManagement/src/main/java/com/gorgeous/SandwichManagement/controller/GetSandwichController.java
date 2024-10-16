package com.gorgeous.SandwichManagement.controller;

import com.gorgeous.SandwichManagement.domain.Sandwich;
import com.gorgeous.SandwichManagement.service.ListSandwichService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSandwichController {
    protected ListSandwichService listSandwichService;

    public GetSandwichController(ListSandwichService listSandwichService) {
        this.listSandwichService = listSandwichService;
    }

    public List<Sandwich> listSandwich() {
        return listSandwichService.getAllSandwiches();
    }
}
