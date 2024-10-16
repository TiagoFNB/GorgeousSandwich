package gourgeossandwich.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import gourgeossandwich.domain.shared.ValueObject;
import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Embeddable
public class UserEmail implements ValueObject<UserEmail> {

    @JsonProperty
    @Column(nullable = false,unique = true)
    private String email;

    private static final Pattern VALID_PATTERN = Pattern.compile("^(.+)@(\\S+)$");
    /**
     * Constructor.
     *
     * @param userEmail Password string.
     */
    public UserEmail(final String userEmail) {
        Validate.notNull(userEmail);
        Validate.notEmpty(userEmail);
        Validate.isTrue(VALID_PATTERN.matcher(userEmail).matches(),
                userEmail + " is not a valid e-mail (does not match pattern)");
        this.email = userEmail;
    }

    protected UserEmail() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEmail other = (UserEmail) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public boolean sameValueAs(UserEmail other) {
        return other != null && this.email.equals(other.email);
    }

    @Override
    public String toString() {
        return email;
    }

    public String idString() {
        return email;
    }
}
