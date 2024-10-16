package com.gorgeous.ShopManagement.domain;

import com.gorgeous.ShopManagement.shared.ValueObject;

public enum Day implements ValueObject<Day> {
    MONDAY {
        final int dayId = 1;

        @Override
        public String toString() {
            return "Monday";
        }

        @Override
        public boolean sameValueAs(Day other) {
            return false;
        }
    },
    TUESDAY {
        final int dayId = 2;

        @Override
        public String toString() {
            return "Tuesday";
        }

        @Override
        public boolean sameValueAs(Day other) {
            return false;
        }
    },
    WEDNESDAY {
        final int dayId = 3;

        @Override
        public String toString() {
            return "Wednesday";
        }

        @Override
        public boolean sameValueAs(Day other) {
            return false;
        }
    },
    THURSDAY {
        final int dayId = 4;

        @Override
        public String toString() {
            return "Thursday";
        }

        @Override
        public boolean sameValueAs(Day other) {
            return false;
        }
    },
    FRIDAY {
        final int dayId = 5;

        @Override
        public String toString() {
            return "Friday";
        }

        @Override
        public boolean sameValueAs(Day other) {
            return false;
        }
    },
    SATURDAY {
        final int dayId = 6;

        @Override
        public String toString() {
            return "Saturday";
        }

        @Override
        public boolean sameValueAs(Day other) {
            return false;
        }
    },
    SUNDAY {
        final int dayId = 7;

        @Override
        public String toString() {
            return "Sunday";
        }

        @Override
        public boolean sameValueAs(Day other) {
            return false;
        }
    };
}
