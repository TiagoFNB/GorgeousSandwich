package gourgeossandwich.service.user;

import gourgeossandwich.domain.user.shopmanager.ShopManager;
import gourgeossandwich.repository.user.ShopManagerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListShopManagerService {

    protected ShopManagerRepository shopManagerRepository;

    public ListShopManagerService(ShopManagerRepository shopManagerRepository) {
        this.shopManagerRepository = shopManagerRepository;
    }

    public List<ShopManager> getAllShopManagers() {
        return this.shopManagerRepository.findAll();
    }
}
