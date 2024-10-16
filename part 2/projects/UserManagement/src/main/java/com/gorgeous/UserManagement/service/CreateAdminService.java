package com.gorgeous.UserManagement.service;

import com.gorgeous.UserManagement.domain.user.UserEmail;
import com.gorgeous.UserManagement.domain.user.UserInternalId;
import com.gorgeous.UserManagement.domain.user.UserName;
import com.gorgeous.UserManagement.domain.user.UserPassword;
import com.gorgeous.UserManagement.domain.user.admin.Admin;
import com.gorgeous.UserManagement.dto.AdminDTO;
import com.gorgeous.UserManagement.handling.UserEmailAlreadyExistsException;
import com.gorgeous.UserManagement.repository.AdminRepository;
import com.gorgeous.UserManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class CreateAdminService {

    protected AdminRepository adminRepository;
    protected UserRepository userRepository;
    @Autowired
    protected PasswordEncoder passwordEncoder;

    public CreateAdminService(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    public Admin createNewAdmin(AdminDTO adminDTO) {

        final UserEmail email = new UserEmail(adminDTO.getEmail());
        if(userRepository.findByEmail(adminDTO.getEmail()) != null){
            throw new UserEmailAlreadyExistsException(email.toString());
        }

        final UserInternalId id = UserInternalId.genNewId();
        final UserName name = new UserName(adminDTO.getUserName());
        final UserPassword pwd = new UserPassword(this.passwordEncoder.encode(adminDTO.getPassword()));


        final Admin admin = new Admin(id, pwd, email, name);

        this.adminRepository.save(admin);

        return admin;
    }
}