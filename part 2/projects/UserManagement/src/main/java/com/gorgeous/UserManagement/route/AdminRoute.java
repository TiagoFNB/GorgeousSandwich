package com.gorgeous.UserManagement.route;

import com.gorgeous.UserManagement.controller.CreateAdminController;
import com.gorgeous.UserManagement.domain.user.admin.Admin;
import com.gorgeous.UserManagement.dto.AdminDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminRoute {

    protected CreateAdminController createAdminController;

    public AdminRoute(CreateAdminController createAdminController) {
        this.createAdminController = createAdminController;
    }

    @MutationMapping
    public Admin createAdmin(@Argument AdminDTO admin) throws Exception {
            return createAdminController.createAdmin(admin);
    }

}
