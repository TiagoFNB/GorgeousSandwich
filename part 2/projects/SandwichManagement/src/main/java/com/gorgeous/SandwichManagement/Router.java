package com.gorgeous.SandwichManagement;

import com.gorgeous.SandwichManagement.controller.CreateSandwichController;
import com.gorgeous.SandwichManagement.controller.GetSandwichByIdController;
import com.gorgeous.SandwichManagement.controller.GetSandwichController;
import com.gorgeous.SandwichManagement.domain.Sandwich;
import com.gorgeous.SandwichManagement.dto.SandwichDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/sandwich")
public class Router {

    protected CreateSandwichController createSandwichController;
    protected GetSandwichController getSandwichController;
    protected GetSandwichByIdController getSandwichByIdController;

    public Router(CreateSandwichController createSandwichController, GetSandwichController getSandwichController, GetSandwichByIdController getSandwichByIdController) {
        this.createSandwichController = createSandwichController;
        this.getSandwichController = getSandwichController;
        this.getSandwichByIdController = getSandwichByIdController;
    }

    @MutationMapping
    public Sandwich create(@Argument SandwichDTO sandwichDTO) throws Exception {
            return createSandwichController.createSandwich(sandwichDTO);
    }

    @QueryMapping
    public List<Sandwich> getList() {
        return getSandwichController.listSandwich();
    }

    @QueryMapping
    public Sandwich getSandwichById(@Argument String id) {
        return getSandwichByIdController.get(id);
    }

}