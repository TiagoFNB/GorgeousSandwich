package com.gorgeous.UserManagement.controller;

import com.gorgeous.UserManagement.domain.user.admin.Admin;
import com.gorgeous.UserManagement.dto.AdminDTO;
import com.gorgeous.UserManagement.service.CreateAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateAdminController {

    protected CreateAdminService createAdminService;

    public CreateAdminController(CreateAdminService createAdminService) {
        this.createAdminService = createAdminService;
    }

    public Admin createAdmin(AdminDTO adminDTO) throws Exception {
        return createAdminService.createNewAdmin(adminDTO);
    }
}
