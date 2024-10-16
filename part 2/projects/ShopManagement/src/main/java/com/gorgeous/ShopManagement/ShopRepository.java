package com.gorgeous.ShopManagement;

import com.gorgeous.ShopManagement.domain.Shop;
import com.gorgeous.ShopManagement.domain.ShopAddress;
import com.gorgeous.ShopManagement.domain.ShopInternalId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, String> {

    Shop getShopById(ShopInternalId id);

    Shop getShopByAddress(ShopAddress address);
}
