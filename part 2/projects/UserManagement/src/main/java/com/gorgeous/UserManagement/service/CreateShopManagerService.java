package com.gorgeous.UserManagement.service;

import com.gorgeous.UserManagement.domain.user.UserEmail;
import com.gorgeous.UserManagement.domain.user.UserInternalId;
import com.gorgeous.UserManagement.domain.user.UserName;
import com.gorgeous.UserManagement.domain.user.UserPassword;
import com.gorgeous.UserManagement.domain.user.shopmanager.ShopManager;
import com.gorgeous.UserManagement.dto.ShopManagerDTO;
import com.gorgeous.UserManagement.handling.UserEmailAlreadyExistsException;
import com.gorgeous.UserManagement.repository.ShopManagerRepository;
import com.gorgeous.UserManagement.repository.UserRepository;
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

    public ShopManager createNewShopManager(ShopManagerDTO shopManagerDTO) throws Exception {

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