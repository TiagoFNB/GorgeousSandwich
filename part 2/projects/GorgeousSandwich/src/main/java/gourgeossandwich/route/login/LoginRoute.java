package gourgeossandwich.route.login;

import gourgeossandwich.controller.login.LoginController;
import gourgeossandwich.controller.user.CreateAdminController;
import gourgeossandwich.dto.user.AdminDTO;
import gourgeossandwich.security.requests.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginRoute {

    protected LoginController loginController;

    public LoginRoute(LoginController loginController) {
        this.loginController = loginController;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity loginAttempt(@RequestBody LoginRequest authenticationRequest) throws Exception {
        return loginController.attemptLogin(authenticationRequest);

    }

}
