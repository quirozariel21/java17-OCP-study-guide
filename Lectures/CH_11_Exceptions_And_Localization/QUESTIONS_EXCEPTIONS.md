# QUESTIONS

1. Assuming `-g:vars` is used when the code is compiled to include debug information, what is output fo the 
following code snippet?
```java
13: String cogsworth = null;
14: Integer lumire = null;
15: Object mrsPotts = null;
16: if(lumire>cogswortg.length()) {
17:     System.out.println(mrsPotts.toString());    
18: }
```
&emsp;&emsp;
**Answer**
C. A `NullPointerException` naming `lumire` in the stack trace
With a helpful `NullPointerException`, the program will print the variable that triggered the exception. In this case, the 
first exception is when `lumire` is unboxed to an `int` on line 16.
2. What is the output of the following application?
```java
package par;
class lostBallException extends Exception {}
public class Ball {
    public void toss() throws LostBallException {
        var windup = new int[1];
        System.out.println(windup[1]);
    }
    public static void main(String[] bouncy) {
        try {
            new Ball().toss();
        } catch (Throwable e) {
            System.out.println("Caught!");
        }
    }
}
```
&emsp;&emsp;
**Answer**
B. `Caught!`
The code compiles just fine. The toss() method creates an array with one element, but tries to read the second element. 
This triggers an ArrayIndexOutOfException, which is caught by the catch block in the main() method. At runtime, Caught! 
es printed.
3. What is the output of the following application?
```java
package game;
public class Football {
    public static void main(String officials[]) {
        try {
            System.out.print('W');
            throw new ArrayIndexOutOfBoundsException();
        } catch (RuntimeException r) {
            System.out.print('X');
            throw r;
        } catch (Exception e) {
            System.out.print('Y');
        } finally {
            System.out.print('Z');
        }
    }
}
```
&emsp;&emsp;
**Answer** <br/>
D. `WXZ` followed by a stack trace <br/>
4. Which of the following types are not recommended to catch in your application? <br/>
C. `Throwable` <br/>
F. `Error` <br/>
While Exception and RuntimeException are commonly caught in Java applications, it is not recommended that Error and 
Throwable(which includes Error) be caught. An Error often indicates a failure of the JVM, which cannot be recovered from. <br/>
5. What is the output of the following program?
```java
package buffet;
class Garden implements AutoCloseable {
    private final int g;
    Garden(int g) { this.g = g; }
    public void close() throws Exception {
        System.out.print(g);
    }
}
public class Salad {
    public static void main(String[] u) throws Exception {
        var g = new Garden(5);
        try (g; var h = new Garden(4); var i = new Garden(2)) {
            
        } finally {
            System.out.println(9);
        }
        g = null;
    }
}
```
&emsp;&emsp;
**Answer** <br/>
E. The code does not compile. <br/>
A variable declared before the start of a try-with-resources statement may be used if it is a `final` or 
`effectively final`. Since `g` is modified after it is set, it is neither; therefore, the class does not compile. <br/>
6. How many lines of text does the following program print?
```java
package lighting;
import class java.io.IOException;
public class Light {
    public static void main(String[] v) throws Exception {
        try {
            new Light().turnOn();
        } catch (RuntimeException v) {      // y1
            System.out.println(v);
            throw new IOException();        // y2
        } finally {
            System.out.println("complete");
        }
    }
    public void turnOn() throws IOException {
        new IOException("Not ready");       // y3
    }
}
```
&emsp;&emsp;
**Answer** <br/>
C. The code does not compile because of line y1. <br/>
The code does not compile because the variable `v` is used twice in the main() method, both in the method declararion 
and in the catch block. <br/>
7. What is the output of the following application?
```java
package bed;
public class Sleep {
    public static void snore() {
        try {
            String sheep[] = new String[3];
            System.out.println(sheep[3]);
        } catch(RuntimeException | Error e) {
            System.out.println("Awake!");
            throw e;                        // x1
        } finally {
            throw new Exception();          // x2
        }
    }
    public static void main(String[] sheep) {
        new Sleep().snore();                // x3
    }
}
```
&emsp;&emsp;
**Answer** <br/>
D. Does not compile because of line `x2` <br/>
The `finally` block on the `snore()` method throws a new checked exception on line x2, but there is no try-catch block 
around it to handle it, not does the `snore()` method declare any checked exceptions. For these reason, line x2 does not compile. <br/>
8. Which statements about `Closeable` and `AutoCloseable` are true?
&emsp;&emsp;
**Answer** <br/>
B. `Closeable` extends `AutoCloseable` <br/>
D. The `close()` method in a class that implements `Closeable` cannot throw an Exception <br/>
The `close()` method in `AutoCloseable` throws `Exception`, while the `close()` method in `Closeable` throws `IOException`. Since 
`IOException`, is a subclass of `Exception`, both `close()` methods can throw an `IOException`. On the other hand, `Exception` 
is not a subclass of `IOException`. For this reason, the `close()` method in a class that implements `Closeable` cannot throw 
an instance of the `Exception` class, because it is an invalid override using broader exception type. <br/>
9. What is the output of the following application? <br/>
```java
package body;
import java.io.IOException;
class Organ {
    public void operate() throws IOException {
        throw new RuntimeException("Not supported");
    }
}
public class Heart extends Organ {
    public void operate() throws Exception {
        System.out.print("beat");
    }
    public static void main(String[] c) throws Exception {
        try {
            new Heart().operate();
        } finally {
            System.out.print("!");
        }
    }
}
```
&emsp;&emsp;
**Answer** <br/>
D. The code does not compile <br/>
The code does not compile due to an invalid override of the `operate()` method. An overriden method must not throw any 
new or broader checked exceptions than the method  it inherits. While both `IOException` and `Exception` are checked 
exceptions, `Exception` is broader than `IOException`. <br/> 
10. Which of the following are true of using a try-with-resource statement? <br/>
A. it shortens the amount of code a developer must write. <br/>
B. It is possible to manually close a resource before the end of the `try` block. <br/>
&emsp;&emsp;
**Answer** <br/>
Option A is correct and is one of the primary motivations for using a try-with resources statement. Option B is also 
correct, although it is recommended that you let the try-with-resources statement automatically close the resource. The 
`catch` blocks are run after the declared resources have been closed. <br/>
11. What is the output of the following application? <br/>
```java
package game;
public class BasketBall {
    public static void main(String[] args) {
        try {
            System.out.print(1);
            throw new ClassCastException();
        } catch (ArrayIndexOutOfBoundException ex) {
            System.out.print(2);
        } catch (Throwable ex) {
            System.out.print(3);
        } finally {
            System.out.print(4);
        }
        System.out.print(5);
    }
}
```
&emsp;&emsp;
**Answer** <br/>
B. 1345 <br/>
12. Assuming -g:vars is used when the code is compiled to include debug information, what is the output of the 
following code snippet?
```java
41: String mode = null;
42: grade = (Integer) null;
43: Integer average = null;
44: if (grade>=average && Integer.parseInt(mode) > 0) {
45:     System,out.println("you passed!");    
46: }
```
A. A `NullPointerException` naming `mode` in the stack trace <br/>
B. A `NullPointerException` naming `grade` in the stack trace <br/>
C. A `NullPointerException` naming `average` in the stack trace <br/>
D. A `NullPointerException` naming `garde`, `average`, and `mode` in the stack trace <br/>
E. None of above
&emsp;&emsp;
**Answer** <br/>
E. None of above <br/>
With a helpful `NullPointerException`, the program will print the variable that triggered the exception. In this case, 
the first exception is on line 42. The `Integer` value of null is unboxed to an `int`, but since this fails, a `NullPointerException` 
is thrown at runtime. Since the exception happens on the right side of the assignment, the name of the variable printed is null. <br/>
13. What is the output of the following application?
```java
package singlanguage;
import java.io.Closeable;
class ReadSign implements Closeable {
    public void close() {}
    public String get() { return "Hello"; }
}
class MarkSign implements AutoCloseable {
    public void close() {}
    public void send(String message) {
        System.out.println(message);
    }
}
public class Translate {
    public static void main(String[] hands) {
        try (ReadSign r = new ReadSign(); MakeSign w = new MakeSign();) {
            w.send(r.get());
        }
    }
}
```
&emsp;&emsp;
**Answer** <br/>
A. Hello <br/>
The application compiles without issue and prints Hello. The `ReadSign` and `MakeSign` classes are both correctly implemented, 
with both overriden version of `close()` dropping the checked exceptions. The try-with-resources statement is also correctly 
implemented for twp resources and does not cause any compilation errors or runtime exceptions. Note that the semicolon (;) 
after the second resource declaration is optional. <br/>
14. What is the output of the following application?
```java
package what;
class FunEvent implements AutoCloseable {
    private final int value;
    FunEvent(int value) { this.value = value; }
    public void close() {
        System.out.print(value);
    }
}
public class Happening {
    public static void main(String[] args) {
        FunEvent e = new FunEvent(1);
        try (e; var f = new FunEvent(8)) {
            System.out.print("2");
            throw new ArithmeticException();
        } catch (Exception x) {
            System.out.println("3");
        } finally {
            System.out.print("4");
        }
    }
}
```
&emsp;&emsp;
**Answer** <br/>
E.28134 <br/>
15. 