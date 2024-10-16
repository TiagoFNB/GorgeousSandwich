package gourgeossandwich.repository.user;

import gourgeossandwich.domain.user.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {


    @Query(value="SELECT u.*, 0 AS clazz_ FROM users u WHERE u.email = :email ",nativeQuery = true)
    User findByEmail(@Param("email") String email);


}
