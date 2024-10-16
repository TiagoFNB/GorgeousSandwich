package com.gorgeous.UserManagement.repository;

import com.gorgeous.UserManagement.domain.user.UserInternalId;
import com.gorgeous.UserManagement.domain.user.customer.Customer;
import com.gorgeous.UserManagement.domain.user.shopmanager.ShopManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShopManagerRepository extends JpaRepository<ShopManager, String> {
    @Query(value="SELECT u.*, 0 AS clazz_ FROM users u WHERE u.email = :email ",nativeQuery = true)
    ShopManager findByEmail(@Param("email") String email);
    ShopManager getShopManagerrById(UserInternalId id);

}
