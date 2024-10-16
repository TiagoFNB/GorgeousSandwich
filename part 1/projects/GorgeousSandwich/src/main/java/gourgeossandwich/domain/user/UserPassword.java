package gourgeossandwich.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import gourgeossandwich.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserPassword implements ValueObject<UserPassword> {

    @JsonProperty
    @Column(nullable = false)
    private String password;

    /**
     * Constructor.
     *
     * @param pwd Password string.
     */
    public UserPassword(final String pwd) {
        Validate.notNull(pwd);
        Validate.notEmpty(pwd);
        this.password = pwd;
    }

    protected UserPassword() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPassword other = (UserPassword) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return password.hashCode();
    }

    @Override
    public boolean sameValueAs(UserPassword other) {
        return other != null && this.password.equals(other.password);
    }

    @Override
    public String toString() {
        return password;
    }

    public String idString() {
        return password;
    }
}
