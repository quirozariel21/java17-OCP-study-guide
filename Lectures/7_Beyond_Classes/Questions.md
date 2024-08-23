# QUESTIONS

1. How many lines would have to be changed for the following code to compile?
```java
1: enum Color {
2:    public static Color DEFAULT = BROWN;
3:    BROWN, YELLOW, BLACK;
4: }
5: public record Pony {
6:    String name;
7:    static int age;
8:    { age = 10;}
9: }
```
&emsp;&emsp;
_Answer_
E. Four or more
An enum must declare its values before any members. For this reason, lines 2 and 3 are reversed. Lin 5 is missing parentheses
required for a record declaration. Line 6 is not allowed, as record do not allow instance variables. Line 8 is incorrect
because only static initializers, are allowed in record. Since there are at least four lines that contains errors,
option E is correct.<br/>
2. Which modifiers can be applied to a sealed subclass?
&emsp;&emsp;
_Answer_
C. `sealed`
D. `non-sealed`
G. `final`
Sealed subclass must be declared final, sealed, non-sealed. <br/>
3. Fill in the blanks: The____________________ access modifier allows access to everything the ___________
access modifier does and more.
&emsp;&emsp;
_Answer_
E. `public`,`private`
The `public` access modifier allow access to members in the same class, package, subclass, or even classes in other packages,
whereas the `private` modifier allows access only to members in the same class. Therefore, the `public` access modifier 
allow access to everything the `private` does, and more. <br/>
4. Which set of modifiers, when added to a `default` method within an interface, prevents it from being overridden by a 
class implementing the interface?
A. `const`
B. `final`
C. `static`
D. `private` 
E. `private static`
F. None of the above
&emsp;&emsp;
_Answer_
F. None of the above
There is no modifier that can prevent a default method from being overridden in a class implementing an interface. <br/>
5. What is the output of the Computer program?
```java
class Laptop extends Computer {
    public void startup() {
        System.out.print("laptop-");
    }
}
public class Computer {
    public void startup() {
        System.out.println("computer-");
    }
    public static void main(String[] args) {
        Computer computer = new Laptop();
        Laptop laptop = new Laptop();
        computer.startup();
        laptop.startup();
    }
}
```
&emsp;&emsp;
_Answer_
C. `laptop-laptop-`
Both objects are instances of the class *Laptop*. This means the overridden *startup()* method in the *Laptop* class gets 
called both times thanks to polymorphism. <br/>
6. how many lines does the following code output?
```java
public class Cars {
    private static void drive() {
        {
            System.out.println("zoom");
        }
        System.out.println("fast");
    }
    static { System.out.println("faster"); }
    public static void main(String[] args) {
        drive();
        drive();
    }
}
```
&emsp;&emsp;
_Answer_
E. Five
The *static* initializers is only run once, so faster is printed exactly once. The *drive()* method is called twice, 
printing two lines each. Therefore, the program prints five lines. <br/>
7. Which statements about `static` interface methods are correct?
&emsp;&emsp;
_Answer_
B. A `static` interface method can be declared `private`
D. A `static` interface method can be declared `public`
F. A `static` interface method can be declared without an access modifier. <br/>
8. Not counting the `Planet` declaration, how many declarations compile?
Assume they are all declared within the same `.java` file.
```java
public abstract sealed class Planet permits Mercury, Venus, Earth {}

non-sealed class Venus {}
non-sealed class Mars extends Planet {}
non-sealed class Mercury {}
abstract non-sealed class Earth {}
```
&emsp;&emsp;
_Answer_
A. Zero
While the *permits* clause is optional for sealed classes with subclasses in the same file, the `extends` clause in each 
subclass is not. For this reason, *Mercury*, *Venus*, and *Earth* do not compile. *Mars* also does not compile. When the 
*permits* clause is specified, all subclasses must be listed.
9. What is the output of the following program?
```java
record Animal(boolean isMammal) {}
public record Panda(String name) extends Animal {
    public Panda() {
        this("TaiShan");
    }
    public Panda {
        this.name = name.toLowerCase();
    }
    public static void main(String[] args) {
        System.out.print(new Panda().name());
    }
}
```
&emsp;&emsp;
_Answer_
D. Exactly two lines need to be corrected for the program, to compile.
Records are implicitly *final* and cannot be extended. For this reason, The *Panda* declaration does not compile. Setting a 
value on `this.name` is not permitted in a compact constructor, although the constructor parameter name may be reassigned. The
rest of the code compiles without issue. Since two lines don't compile, option D is correct. <br/>
10. Which statements about instance keyword are correct?
&emsp;&emsp;
_Answer_
B. The `this` keyword can be used to read all members declared in a parent class.
E. The `this` keyword can be used to read `public` members in the direct parent class.
Option E is correct, as *this* allows access to members declared in the class and those inherited from a parent. <br/>
11. What is the output of the following application?
```java
package musical;
interface Speak { default int talk() { return 7; } }
interface Sing { default talk() { return 5; } }
public class Performance implements Speak, Sing {
    public int talk(String... x) {
        return x.length;
    }
    public static void main(String[] notes) {
        System.out.printn(new Performance().talk());
    }
}
```
&emsp;&emsp;
_Answer_
C. The code does not compile
Java does not allow multiple inheritance, so having one class implement two interfaces that both define the same `default` 
method signature leads to a compiler error, unless the class overrides the method. In this case `talks(String...)` method defined 
in the *Performance* class is an overloaded method, not an overridden one, because the signatures do not match. Therefore, 
the Performance class does not compile. <br/>
12. What is the output of the following application?
```java
package ai;
interface Pump { public abstract String toString(); }
interface Bend extends Pump { void bend(double tensileStrength); }
public class Robot {
    public static final void apply(Bend instruction, double input) {
        instruction.bend(input);
    }
    public static void main(String... future) {
        final Robot r = new Robot();
        r.apply(x -> System.out.print(x+" bent!"), 5);
    }
}
```
&emsp;&emsp;
_Answer_
B. `5.0 bent!`
First off, *Pump* is not a functional interface. The `toString()` method will be overridden by any class inheriting the 
interface (via *lang.lang.Object*), so it does not count as an abstract method. On the other hand, Bend is a functional 
interface and contains one abstract method. The code compiles and prints `5.0 bent!` at runtime. <br/>
13. Which statement about the following interface is correct?
```java
public interface Swimming { 
    String DEFAULT = "Diving!";         // k1
    abstract int breath();
    private static void stroke() {
        if(breath() == 1) {             // k2
            System.out.print("Go!");     
        } else {
            System.out.print(dive());   // k3
        }
    }
    static String dive() {
        return DEFAULT;                 // k4
    }
}
```
&emsp;&emsp;
_Answer_
C. The code does not compile because of line `k2`
The `stroke()` method is *static*, which means it cannot change, and immutability means it cannot. <br/> 
14. Which is the first line to fail to compile?
```java
class Tool {
    private void repair() {}            // r1
    void use() {}                       // r2
}
class Hammer extends Tool {
    private int repair() { return 0; }  // r3
    private void use() {}               // r4
    private void bang() {}              // r5
}
```
&emsp;&emsp;
_Answer_
D. `r4`
The `use()` method has package level access in Tool, with the overridden version in Hammer reducing the visibility to
private. This is an invalid override, making option D correct.
15. 