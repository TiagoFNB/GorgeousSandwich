package gourgeossandwich.controller.login;

import gourgeossandwich.security.requests.LoginRequest;
import gourgeossandwich.security.response.JWTResponse;
import gourgeossandwich.service.login.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginController {

    protected LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public ResponseEntity<JWTResponse> attemptLogin( LoginRequest authenticationRequest) throws Exception {

        final String token = loginService.attemptLogin(authenticationRequest.getUsername(),authenticationRequest.getPassword());

        return ResponseEntity.ok(new JWTResponse(token));
    }


}
