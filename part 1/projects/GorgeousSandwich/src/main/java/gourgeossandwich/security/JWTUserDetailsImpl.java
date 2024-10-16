package gourgeossandwich.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import gourgeossandwich.domain.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class JWTUserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;

    private List<GrantedAuthority> authorities;

    public JWTUserDetailsImpl(User user) {
        this.userName = user.email().toString();
        this.password = user.password().toString();
        this.authorities = Arrays.stream(user.role().toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public JWTUserDetailsImpl() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {

        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
