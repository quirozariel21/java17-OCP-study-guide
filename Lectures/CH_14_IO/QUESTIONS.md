# QUESTIONS

1. What exception is expected to be thrown by the following code snippet?
```java
var oldPath = Path.get("/rodent/mouse.txt");
var newPath = Path.get("rodent/rat.txt");
Files.move(oldPath, newPath, StandardCopyOption.REPLACE_EXISTING);
```
&emsp;&emsp;
__Answer__<br/>
*D.* The code does not compile. <br/>
The code does not compile because `Path.get()` is not a valid NIO.2 method. Either `Paths.get()` or `Path.get()` should be used instead. <br/>

2. What is the result of compiling and executing the following program?
````java
package vacation;
import java.io.*;
import java.util.*;

public class Itinerary {
    private List<String> activities = new ArraysList<>();
    private static Itinerary getItinerary(String name) {
        return null;
    }
    public static void printItinerary() throws Exception {
        Console c = new Console();
        final String name = c.readLine("What is your name?");
        final var stuff = getItinerary(name);
        stuff.activities.forEach(s -> sprintf(s));
    }
    public static void main(String[] h) throws Exception {
        printItinerary();
    }
}
````
&emsp;&emsp;
__Answer__<br/>
*A.* The code does not compile <br/>
The constructor for `Console` is `private`. Therefore, attempting to call `new Console()` outside the class results in a compilation <br/>
error. The correct way to obtain a `Console` instance is to call `System.console`. <br/>

8. Assuming `/away/baseball.txt` exists and is accessible, what is the expected result of executing the following code snippet?
```java
var p1 = Path.of("baseball.txt");
var p2 = Path.of("/home");
var p3 = Path.of("/away");
Files.createDirectories(p2);
Files.copy(p3.resolve(p1), p2); // (/away/baseball.txt, /home)
```
&emsp;&emsp;
__Answer__<br/>
*D.* The code compiles, but an exception is printed at runtime. <br/>
After calling `createDirectories()`, the directory `/home` is guaranteed to exist if it does not already. The second argument of the 
`copy()` method should be the location of the new file, not the folder the new files is placed in. Therefore, the program attempts 
to write the file to the path `/home`. Since there is already a directory at the location, a `FileAlreadyExistsException` is thrown 
at runtime. <br/>

9. Assuming the file referenced in the following snippet exists and contains five lines with the word `eggs` in them, what is the
expected output?
```java
var p = Path.of("breackfast.menu");
Files.readAllLines(p)
    .filter(s -> s.contains("eggs"))
    .collect(Collectors.toList())
    .forEach(Sysytem.out::println)
```
&emsp;&emsp;
__Answer__<br/>
*E.* The code does not compile. <br/>
The code does not compile because `readAlllines()` method returns `List<String>`, not a stream. If the `lines()` was used instead, 
then five lines would be printed at runtime. <br/>

11. What does `Console` `readPassword()` return a `char` array rather than a `String`?
&emsp;&emsp;
__Answer__<br/>
*B.* It improves security. <br/>
The `readPassword()` return a `char` array for security reasons. If the data was stored as a `String`, it would enter the shared JVM string pool, 
potentially allowing a malicious user to access it, especially if there is a memory dump. By suing char array, the data can be immediately cleared 
after it is written and removed from memory. <br/>

12. How many lines of the following code contain compiler error?
```java
12: var path = Paths.get(new URI("ice.cool"));
13: var view = Files.readAttributes(path, 
14:    BasicFileAttributes.class);
15: Files.createDirectories(Path.relativize(".backup"));    // Path.relativize DOES NOT EXISTS
16: if(view.length()>0 && view.isDirectory())               // view.length() DOES NOT EXISTS instead view.size()
17:     view.setTimes(null, null, null);                    // view is an attribute class, not an attribute view
18: System.out.println(Files.deleteIfExists(path));
```
&emsp;&emsp;
__Answer__<br/>
*D.* Three
15. What is the output of the following program? Assume the file paths referenced in the class exist and are to be written to and read from.
```java
package heart;
import java.io.*;
public class Valve implements Serializable {
    private int chambers = -1;;
    private transient Double size = null;
    private static String color;
    public Valve() {
        this.chambers = 3;
        color = "BLUE";
    }
    
    public static void main(String[] love) throws Throwable {
        try (var o = new ObjectOutputStream(new FileOutputStream("scan.txt"))) {
            final Valve v = new Valve();
            v.chambers = 2;
            v.size = 10.0;
            v.color = "RED";
            o.writeObject(v);
        }
        new Valve();
        try (var i = new ObjectOutputStream(new FileInputStream("scan.txt"))) {
            Valve v = (Valve) i.readObject();
            System.out.println(v.chambers + ", " + v.size + ", " + v.color);
        }
    }
}
```
&emsp;&emsp;
__Answer__<br/>
*B.* `2, null, BLUE`
Even though the value was RED when the instance was serialized, this value was not written to disk, since it was not part of the instance. 
The constructor call `new Valve()` between the two try-with-resources blocks set this value to BLUE, which is the value printed later in 
the application.

18. The `Rose` application is run with an input argument of `/flower`. The `/flower` directory contains five subdirectories, each of which
 contains five files. What is the result of executing the following program?
```java
import java.nio.file.*;
public class Rose {
    public void tendGarden(Path p) throws Exception {
        Files.walk(p, 1)
            .map(q -> q.toRealPath())       // Unhandled exception: java.io.IOException
            .forEach(System.out::println);
    }
    public static void main(String... thorns) throws Exception {
        new Rose().tendGarden(Paths.get(thorns[0]));
    }
}
```
&emsp;&emsp;
__Answer__<br/>
*F.*  None of the above
The `toRealPath()` interacts with the file system, and therefore throws a checked IOException. Since this checked exception is not handled 
inside the lambda expression, the class does not compile. <br/>

20. What is the output of the following method applied to an `InputStream` that contains the first four prime numbers, stored as bytes: 2, 3, 5, 7.
```java
private void jumpAround(InputStream is)  throws IOException {
    try(is) {
        is.skip(1);
        is.read();
        is.skip(1);
        is.mark(4);
        is.skip(1);
        is.reset();
        System.out.println(is.read())
    }    
}
```
&emsp;&emsp;
__Answer__<br/>
*E.*  The result cannot be determined until runtime. <br/>
Not all `InputStream` support the `mark()` operation. If `mark()` is supported, then `7` is printed at runtime. Always remember to call 
`markSupported()` before using a `mark()` operation on an `InputStream`.