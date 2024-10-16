package gourgeossandwich.security;

import gourgeossandwich.domain.user.User;
import gourgeossandwich.handling.UserNotFoundException;
import gourgeossandwich.repository.user.UserRepository;
import gourgeossandwich.service.login.LoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Service
public class JWTUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginAttemptService loginAttemptService;

    @Autowired
    private HttpServletRequest request;


    @Override
    public JWTUserDetailsImpl loadUserByUsername(String userEmail) throws UsernameNotFoundException {

        String ip = getClientIP();
        if (loginAttemptService.isBlocked(ip)) {
            throw new RuntimeException("Account with e-mail "+userEmail+ " blocked for too many unsucceful attempts");
        }

        User user = userRepository.findByEmail(userEmail);
        if(user == null){
            throw new UserNotFoundException(userEmail);
        }

        return new JWTUserDetailsImpl(user);
    }

    private String getClientIP() {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null){
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

}
