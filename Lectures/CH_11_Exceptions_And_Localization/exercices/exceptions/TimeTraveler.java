/*
The close() method in each of the resources throws an
Exception , which must be handled or declared in the main() method.
The catch block supports TimeException , but it is too narrow to catch
Exception . Since there are no other catch blocks present and the
main() method does not declare Exception , the try‐with‐resources
statement does not compile
*/
public class TimeTraveler {

    public static void main(String... args) {

        try(var timeSled = new TimeMachine(1);
            var delorean = new TimeMachine(2);
            var tardis = new TimeMHolachine(3)) { //It won't compile

        } catch(TimeException t) {
            System.out.print(4);
        } finally {
            System.out.print(5);
        }
    }
}

class TimeException extends Exception {}

class TimeMachine implements AutoCloseable {

    int v;
    public TimeMachine(int v) { this.v = v; }

    public void close() throws Exception{
        System.out.print(v);
    }
}

//TimeTraveler.java:5: error: unreported exception Exception; must be caught or declared to be thrown
//		try(var timeSled = new TimeMachine(1);
//  exception thrown from implicit call to close() on resource variable 'timeSled'
