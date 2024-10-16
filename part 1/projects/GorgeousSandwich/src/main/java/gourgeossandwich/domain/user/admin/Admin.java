package gourgeossandwich.domain.user.admin;

import gourgeossandwich.domain.user.*;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "Admin")
public class Admin extends User {
    protected Admin() {
    }

    public Admin(final UserInternalId id,
                    final UserPassword pwd,
                    final UserEmail email,
                    final UserName userName) {
        super(id, pwd, email, userName, UserRole.ADMIN);
    }

    public String toString() {
        return super.toString();
    }
}