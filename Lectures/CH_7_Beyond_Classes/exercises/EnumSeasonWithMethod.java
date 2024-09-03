public enum EnumSeasonWithMethod {

    WINTER {
        @Override
        public String getHours() {
            return "10am-3pm";
        }
    },
    SUMMER {
        @Override
        public String getHours() {
            return "9am-7pm";
        }
    },
    SPRING,
    FALL;


    /**
     * If we do not want each and every enum value to have a method, we can create a default
     * implementation and override it only for the special cases.
     */
    public String getHours() {
        return "9am-10pm";
    }
}