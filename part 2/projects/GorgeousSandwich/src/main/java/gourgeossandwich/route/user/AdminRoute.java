package gourgeossandwich.route.user;

import gourgeossandwich.controller.user.CreateAdminController;
import gourgeossandwich.dto.user.AdminDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminRoute {

    protected CreateAdminController createAdminController;

    public AdminRoute(CreateAdminController createAdminController) {
        this.createAdminController = createAdminController;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity create(@RequestBody AdminDTO adminDTO) {
        try{
            return createAdminController.createAdmin(adminDTO);
        } catch(Exception e) {
            //Handle errors here
            Map<String, String> body = new HashMap<>();
            String res = e.getMessage();
            body.put("error", res);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }

}
