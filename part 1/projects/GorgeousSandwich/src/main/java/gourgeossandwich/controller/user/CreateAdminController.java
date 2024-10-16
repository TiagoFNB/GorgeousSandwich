package gourgeossandwich.controller.user;

import gourgeossandwich.domain.user.admin.Admin;
import gourgeossandwich.dto.user.AdminDTO;
import gourgeossandwich.service.user.CreateAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateAdminController {

    protected CreateAdminService createAdminService;

    public CreateAdminController(CreateAdminService createAdminService) {
        this.createAdminService = createAdminService;
    }

    public ResponseEntity<Admin> createAdmin(AdminDTO adminDTO) {
        return ResponseEntity.ok(createAdminService.createNewAdmin(adminDTO));
    }
}
