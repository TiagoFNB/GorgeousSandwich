package gourgeossandwich.domain.user;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import gourgeossandwich.domain.shared.Entity;
import gourgeossandwich.domain.shop.Day;
import org.apache.commons.lang.Validate;

import javax.persistence.*;


@javax.persistence.Entity
@Table(name = "Users")
@Inheritance(
        strategy = InheritanceType.JOINED
)
public class User implements Entity<User> {

    @JsonUnwrapped
    @EmbeddedId
    private UserInternalId id;

    @JsonIgnore
    @Embedded
    private UserPassword pwd;

    @JsonUnwrapped
    @Embedded
    private UserEmail email;

    @JsonUnwrapped
    @Embedded
    private UserName userName;

    @Enumerated(EnumType.STRING)
    @JsonProperty
    private UserRole role;

    protected User(){}

    public User(final UserInternalId id,
                    final UserPassword pwd,
                    final UserEmail email,
                    final UserName userName,
                final UserRole userRole) {
        Validate.notNull(id, "UserInternalId is required");
        Validate.notNull(pwd, "UserPassword is required");
        Validate.notNull(email, "UserEmail is required");
        Validate.notNull(userName, "UserName is required");
        Validate.notNull(userRole, "UserRole is required");

        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.userName = userName;
        this.role = userRole;
    }


    public UserRole role() {
        return role;
    }

    public UserPassword password() {
        return pwd;
    }

    public UserName name() {
        return userName;
    }

    public UserEmail email() {
        return email;
    }





    @Override
    public boolean sameIdentityAs(final User other) {
        return other != null && id.sameValueAs(other.id);
    }

    /**
     * @param object to compare
     * @return True if they have the same identity
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final User other = (User) object;
        return sameIdentityAs(other);
    }

    /**
     * @return Hash code of id
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id.toString();
    }



}
