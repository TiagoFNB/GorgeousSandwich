package com.gorgeous.UserManagement.repository;

import com.gorgeous.UserManagement.domain.user.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
