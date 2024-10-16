package com.gorgeous.ShopManagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class ShopInternalIdTest {

    @Test
    public void testCreateShopInternalId() {
        ShopInternalId id1 = ShopInternalId.genNewId();

        try {
            id1 = ShopInternalId.genNewId();
        } catch (Exception e) {
            fail("Should not thrown exception");
        }

        ShopInternalId id2 = ShopInternalId.genNewId();

        if (id1.sameValueAs(id2)) {
            fail("Ids should not generate the same");
        }
    }
}