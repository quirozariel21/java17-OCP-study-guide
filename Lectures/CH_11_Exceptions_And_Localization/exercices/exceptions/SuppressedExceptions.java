public class SuppressedExceptions {

    public static void main(String args[]) {

        try(var mr1 = new MyFileReader("1");
            var mr2 = new MyFileReader("2")){
            throw new IllegalArgumentException("===>> IllegalArgumentException");
            //}
        } catch(IllegalArgumentException iex) {
		/*}catch(RuntimeException iex) {
			System.out.println("===>> Exception captured");
			for(Throwable e: iex.getSuppressed()) {
					System.out.println("===>> Suppressed: " + e.getMessage());
			}
		}*/
        } finally {
            throw new RuntimeException("==>> Losing exceptions...");
        }

    }
}

class MyFileReader implements AutoCloseable {
    private String tag;

    public MyFileReader(String tag){this.tag = tag;}

    @Override
    public void close() {
        throw new RuntimeException("===>> Runtime: " + tag);
    }
}