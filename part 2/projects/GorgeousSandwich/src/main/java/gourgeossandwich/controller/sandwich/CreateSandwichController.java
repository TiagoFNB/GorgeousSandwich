package gourgeossandwich.controller.sandwich;

import gourgeossandwich.domain.sandwich.Sandwich;
import gourgeossandwich.dto.sandwich.SandwichDTO;
import gourgeossandwich.service.sandwich.CreateSandwichService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateSandwichController {

    protected CreateSandwichService createSandwichService;

    public CreateSandwichController(CreateSandwichService createSandwichService) {
        this.createSandwichService = createSandwichService;
    }

    public ResponseEntity<Sandwich> createSandwich(SandwichDTO sandwichDTO) throws Exception {
        return ResponseEntity.ok(createSandwichService.createNewSandwich(sandwichDTO));
    }
}
