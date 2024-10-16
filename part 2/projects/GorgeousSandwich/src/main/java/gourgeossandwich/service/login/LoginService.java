package gourgeossandwich.service.login;


import gourgeossandwich.security.JWTProvider;
import gourgeossandwich.security.JWTUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTProvider jwtProvider;

    @Autowired
    private JWTUserDetailsServiceImpl jwtUserDetailsService;

    public String attemptLogin(String userEmail, String password) throws Exception{
        Authentication auth = authenticate(userEmail, password);

        final UserDetails userDetails = jwtUserDetailsService
                .loadUserByUsername(userEmail);

        final String token = jwtProvider.generateJwtToken(auth);

        return token;
    }

    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }



}
