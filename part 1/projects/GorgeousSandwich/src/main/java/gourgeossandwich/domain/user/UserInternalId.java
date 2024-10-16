package gourgeossandwich.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.Validate;
import gourgeossandwich.domain.shared.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public final class UserInternalId implements ValueObject<UserInternalId> {

    @JsonProperty
    @Column(unique = true)
    private String id;

    /**
     * Constructor.
     *
     * @param id Id string.
     */
    private UserInternalId(final String id) {
        Validate.notNull(id);
        Validate.notEmpty(id);
        this.id = id;
    }

    protected UserInternalId() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInternalId other = (UserInternalId) o;

        return sameValueAs(other);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean sameValueAs(UserInternalId other) {
        return other != null && this.id.equals(other.id);
    }

    @Override
    public String toString() {
        return id;
    }

    public String idString() {
        return id;
    }
    /**
     * Generates a new Id
     * @return UserInternalId
     */
    public static UserInternalId genNewId() {
        return new UserInternalId(UUID.randomUUID().toString());
    }
}

