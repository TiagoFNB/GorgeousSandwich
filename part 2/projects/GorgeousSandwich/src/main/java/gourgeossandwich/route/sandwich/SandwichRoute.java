package gourgeossandwich.route.sandwich;


import gourgeossandwich.controller.sandwich.CreateSandwichController;
import gourgeossandwich.controller.sandwich.GetSandwichController;
import gourgeossandwich.dto.sandwich.SandwichDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/sandwich")
public class SandwichRoute {

    protected CreateSandwichController createSandwichController;
    protected GetSandwichController getSandwichController;

    public SandwichRoute(CreateSandwichController createSandwichController, GetSandwichController getSandwichController) {
        this.createSandwichController = createSandwichController;
        this.getSandwichController = getSandwichController;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@RequestBody SandwichDTO sandwichDTO) {
        try{
            return createSandwichController.createSandwich(sandwichDTO);
        } catch(Exception e) {
            //Handle errors here
            Map<String, String> body = new HashMap<>();
            String res = e.getMessage();
            body.put("error", res);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getList() {
        try{
            return getSandwichController.listSandwich();
        } catch(Exception e) {
            //Handle errors here
            Map<String, String> body = new HashMap<>();
            String res = e.getMessage();
            body.put("error", res);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

}
