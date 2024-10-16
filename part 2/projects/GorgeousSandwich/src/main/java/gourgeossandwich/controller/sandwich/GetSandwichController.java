package gourgeossandwich.controller.sandwich;

import gourgeossandwich.domain.sandwich.Sandwich;
import gourgeossandwich.service.sandwich.ListSandwichService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSandwichController {

    protected ListSandwichService listSandwichService;

    public GetSandwichController(ListSandwichService listSandwichService) {
        this.listSandwichService = listSandwichService;
    }

    public ResponseEntity<List<Sandwich>> listSandwich() {
        return ResponseEntity.ok(listSandwichService.getAllSandwiches());
    }
}
