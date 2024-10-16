package gourgeossandwich.route.user;


import gourgeossandwich.controller.user.CreateCustomerController;
import gourgeossandwich.controller.user.GetCustomersController;
import gourgeossandwich.dto.user.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/customer")
public class CustomerRoute {

    protected GetCustomersController getCustomersController;
    protected CreateCustomerController createCustomerController;

    public CustomerRoute(CreateCustomerController createCustomerController,
                         GetCustomersController getCustomersController) {
        this.createCustomerController = createCustomerController;
        this.getCustomersController =  getCustomersController;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@RequestBody CustomerDTO customerDTO) {
        try{
            return createCustomerController.createCustomer(customerDTO);
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
            return getCustomersController.listCustomers();
        } catch(Exception e) {
            //Handle errors here
            Map<String, String> body = new HashMap<>();
            String res = e.getMessage();
            body.put("error", res);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

}

