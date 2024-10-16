package gourgeossandwich.repository.shop;

import gourgeossandwich.domain.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, String> {

}
