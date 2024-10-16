package gourgeossandwich.domain.promotion;

import gourgeossandwich.domain.shared.ValueObject;

public enum PromotionType implements ValueObject<PromotionType>{
    LOCAL {

        final String id = "LOCAL";

        @Override
        public boolean sameValueAs(PromotionType other) {
            // TODO Auto-generated method stub
            return false;
        }

    },
    GLOBAL {

        final String in = "GLOBAL";

        @Override
        public boolean sameValueAs(PromotionType other) {
            // TODO Auto-generated method stub
            return false;
        }

    };
}
