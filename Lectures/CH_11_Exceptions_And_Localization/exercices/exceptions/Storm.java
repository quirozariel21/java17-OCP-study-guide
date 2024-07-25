public class Storm {

    public static void main(String... args) throws Exception {

        var weatherTracker = new AutoCloseable() {
            public void close() throws RuntimeException {
                System.out.println("Thunder (4)"); // Run Second
            }
        };

        try(weatherTracker) {
            System.out.println("Tracking (1)"); // Run first
            throw new Exception();
        } catch(Exception e) {
            System.out.println("Lightning (2)");
        } finally {
            System.out.println("Storm gone (3)"); // Run third
            weatherTracker.close(); // Run four
        }


    }
}