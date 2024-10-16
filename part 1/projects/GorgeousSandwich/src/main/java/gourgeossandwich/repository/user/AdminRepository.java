package gourgeossandwich.repository.user;

import gourgeossandwich.domain.user.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
