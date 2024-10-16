package gourgeossandwich.service.user;

import gourgeossandwich.domain.user.UserEmail;
import gourgeossandwich.domain.user.UserInternalId;
import gourgeossandwich.domain.user.UserName;
import gourgeossandwich.domain.user.UserPassword;
import gourgeossandwich.domain.user.admin.Admin;
import gourgeossandwich.dto.user.AdminDTO;
import gourgeossandwich.handling.UserEmailAlreadyExistsException;
import gourgeossandwich.repository.user.AdminRepository;
import gourgeossandwich.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
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