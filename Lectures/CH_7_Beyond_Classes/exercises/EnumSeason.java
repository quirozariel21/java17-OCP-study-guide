public enum EnumSeason {

    WINTER {
        @Override
        public String getHours() {
            return "10am-3pm";
        }
    },
    SPRING {
        @Override
        public String getHours() {
            return "9am-5pm";
        }
    },
    SUMMER {
        @Override
        public String getHours() {
            return "9am-7pm";
        }
    },
    FALL {
        @Override
        public String getHours() {
            return "9am-5pm";
        }
    }

    public abstract String getHours();
}