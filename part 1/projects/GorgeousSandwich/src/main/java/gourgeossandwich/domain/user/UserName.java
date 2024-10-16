package gourgeossandwich.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import gourgeossandwich.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserName implements ValueObject<UserName> {

    @JsonProperty
    @Column(nullable = false)
    private String userName;

    /**
     * Constructor.
     *
     * @param userName Password string.
     */
    public UserName(final String userName) {
        Validate.notNull(userName);
        Validate.notEmpty(userName);
        this.userName = userName;
    }

    protected UserName() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserName other = (UserName) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }

    @Override
    public boolean sameValueAs(UserName other) {
        return other != null && this.userName.equals(other.userName);
    }

    @Override
    public String toString() {
        return userName;
    }

    public String idString() {
        return userName;
    }
}
