package gourgeossandwich.service.user;

import gourgeossandwich.domain.user.UserEmail;
import gourgeossandwich.domain.user.UserInternalId;
import gourgeossandwich.domain.user.UserName;
import gourgeossandwich.domain.user.UserPassword;
import gourgeossandwich.domain.user.shopmanager.ShopManager;
import gourgeossandwich.dto.user.ShopManagerDTO;
import gourgeossandwich.handling.UserEmailAlreadyExistsException;
import gourgeossandwich.repository.user.ShopManagerRepository;
import gourgeossandwich.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateShopManagerService {

    protected ShopManagerRepository shopManagerRepository;
    protected UserRepository userRepository;
    @Autowired
    protected PasswordEncoder passwordEncoder;


    public CreateShopManagerService(ShopManagerRepository shopManagerRepository, UserRepository userRepository) {
        this.shopManagerRepository = shopManagerRepository;
        this.userRepository = userRepository;
    }

    public ShopManager createNewShopManager(ShopManagerDTO shopManagerDTO) {

        final UserEmail email = new UserEmail(shopManagerDTO.getEmail());
        if(userRepository.findByEmail(shopManagerDTO.getEmail()) != null){
            throw new UserEmailAlreadyExistsException(email.toString());
        }

        final UserInternalId id = UserInternalId.genNewId();
        final UserName name = new UserName(shopManagerDTO.getUserName());
        final UserPassword pwd = new UserPassword(this.passwordEncoder.encode(shopManagerDTO.getPassword()));


        final ShopManager shopManager = new ShopManager(id, pwd, email, name);

        this.shopManagerRepository.save(shopManager);

        return shopManager;
    }
}