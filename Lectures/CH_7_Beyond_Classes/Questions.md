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
__Answer__<br/>
E. Four or more <br/>
An enum must declare its values before any members. For this reason, lines 2 and 3 are reversed. Line 5 is missing parentheses
required for a record declaration. Line 6 is not allowed, as record do not allow instance variables. Line 8 is incorrect
because only static initializers, are allowed in record. Since there are at least four lines that contains errors,
option E is correct.<br/>

2. Which modifiers can be applied to a sealed subclass? <br/>
__Answer__<br/>
C. `sealed` <br/>
D. `non-sealed` <br/>
G. `final` <br/>
Sealed subclass must be declared final, sealed, non-sealed. <br/>
3. Fill in the blanks: The____________________ access modifier allows access to everything the ___________
access modifier does and more. <br/>
&emsp;&emsp;
__Answer__<br/>
E. `public`,`private` <br/>
The `public` access modifier allow access to members in the same class, package, subclass, or even classes in other packages,
whereas the `private` modifier allows access only to members in the same class. Therefore, the `public` access modifier 
allow access to everything the `private` does, and more. <br/>

4. Which set of modifiers, when added to a `default` method within an interface, prevents it from being overridden by a class 
implementing the interface? 
A. `const` <br/>
B. `final` <br/>
C. `static` <br/>
D. `private`  <br/>
E. `private static` <br/>
F. None of the above  <br/>
&emsp;&emsp;
__Answer__<br/>
F. None of the above <br/>
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
__Answer__<br/>
C. `laptop-laptop-` <br/>
Both objects are instances of the class *Laptop*. This means the overridden *startup()* method in the *Laptop* class gets 
called both times thanks to polymorphism. <br/>

6. How many lines does the following code output?
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
__Answer__<br/>
E. Five <br/>
The *static* initializers is only run once, so faster is printed exactly once. The *drive()* method is called twice, 
printing two lines each. Therefore, the program prints five lines. <br/>

7. Which statements about `static` interface methods are correct? <br/>
&emsp;&emsp;
__Answer__<br/>
B. A `static` interface method can be declared `private` <br/>
D. A `static` interface method can be declared `public` <br/>
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
__Answer__<br/>
A. Zero <br/>
While the *permits* clause is optional for sealed classes with subclasses in the same file, the `extends` clause in each 
subclass is not. For this reason, *Mercury*, *Venus*, and *Earth* do not compile. *Mars* also does not compile. When the 
*permits* clause is specified, all subclasses must be listed. <br/>

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
__Answer__<br/>
D. Exactly two lines need to be corrected for the program, to compile. <br/>
Records are implicitly *final* and cannot be extended. For this reason, The *Panda* declaration does not compile. Setting a 
value on `this.name` is not permitted in a compact constructor, although the constructor parameter name may be reassigned. The
rest of the code compiles without issue. Since two lines don't compile, option D is correct. <br/>

10. Which statements about instance keyword are correct? <br/>
&emsp;&emsp;
__Answer__<br/>
*B.* The `this` keyword can be used to read all members declared in a parent class. <br/>
*E.* The `this` keyword can be used to read `public` members in the direct parent class. <br/>
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
__Answer__<br/>
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
15. Which modifier can be applied to an `abstract` interface method?
A. final
B. interface
C. protected
D. volatile
E. sealed
F. None of the above
&emsp;&emsp;
_Answer_
F. None of the above
16. The following `Organ` class is included, unmodified, in a larger program at runtime. At most, how many classes can
inherit from `Organ` (excluding `Organ` itself)?
```java
package body;
public sealed class Organ {
    sealed class Heart extends Organ {}
    final class Lung extends Organ {}
    static non-sealed class Stomach extends Organ {}
    final class Valentine extends Heart {}
}
```
&emsp;&emsp;
_Answer_
G. The number cannot be determined with the information given.
Remember that the `permits` clause is optional if the sealed subclasses are in the same file. Given the class declaration, 
exactly four subclasses inherit from Organ. The Stomach class is `non-sealed`, though, which means the larger program could 
define additional classes in the same package that extend Stomach and inherit `Organ`. For this reason, option G is correct.
17. Which are true of the following code? (Choose three)
```java
1:  class Penguin {
2:     private enum Baby { EGG }
3:     static class Chick { 
4:        enum Baby { EGG }
5:     }
6:     public static void main(String[] args) {
7:        boolean match = false;
8:        Baby egg = Baby.EGG;
9:        switch (egg) {
10:          case EGG:
11:             match = true;
12:       } } }
```
&emsp;&emsp;
_Answer_
D. Removing `private` on line 2 would not create an additional compiler error.
F. Removing the `static` modifier on line 3 would not create an additional compile error.
Removing private on line 2 would not cause a compiler error in the main() method, making option D correct. Option F 
is the final correct answer because a static type such as an enum can be defined in both inner and *static* nested classes.
18. Which of the following class types cannot be marked `abstract`?
&emsp;&emsp;
_Answer_
C.Anonymous class
While an anonymous class can extend another class or implement an interface, it cannot be declared `abstract` since it 
has no class name. For this reason, option C is correct. 
19. Fill in the blanks: The_________________ access modifier allows access to everything the _____________________
access modifier does and more.
&emsp;&emsp;
_Answer_
C. protected, package 
E. public, package
F. public, protected
The public access modifier is the broadest (es el mas amplio), making options E and F correct. The protected access 
modifier adds on subclass access, making option C correct.
20. How many of the following members of the `Telephone` interface are `public`?
```java
public interface Telephone {
    static int call() { return 1; }
    default void dial() {}
    long answer();
    String home = "555-555-5555";
}
```
&emsp;&emsp;
_Answer_
E. Four
All four members of the Telephone interface are implicitly *public*. Only *private* and *private* static interface methods are not 
*public*, and they must be explicitly marked private.
21. How many lines will not compile?
```java
11: public class PrintShop {
12:    public void printVarargs(String... names) {
13:         System.out.println(Arrays.toString(names));    
14:    }
15:    public void printArray(String[] names) {
16:         System.out.println(Arrays.toString(names));    
17:    }
18:    public void stormy() {
19:         printVarargs("Arlene");    
20:         printVarargs(new String[]{"Bret"});
21:         printVarargs(null);
22:         printArray("Cindy");
23:         printArray(new String[]{"Don"});
24:         printArray(null);
25:}}
```
&emsp;&emsp;
_Answer_
B. One
From within a method, an array or varargs parameter is treated the same. However, there is a difference from the caller's 
point of view. A varargs parameters can receive either an array or individual values, making 19 and 20 compile. However, an 
array parameter can take only array, which permits line 23 but prevents line 22 from compiling. Both lines 21 nd 24 compile 
because `null` can be passed to a method taking an array or vararg parameter. Since there is only one line that doesn't 
compile, option B is the answer.
22. Which statement about records are correct?
&emsp;&emsp;
_Answer_
C. A record can implement interfaces
D. A record can contain multiple regular constructors
23. What is the output of the following application?

```java
interface Toy {
    String play();
}

public class Gift {
    public static void main(String[] matrix) {
        abstract class Robot {
        }

        class Transformer extends Robot implements Toy {
            public String name = "GiantRobot";
            
            public String play() {
                return "DinosaurRobot";                 // y1
            }
        }
        
        Transformer prime = new Transformer() {
          public String play() {return name; }          // y2
        };
        System.out.print(prime.play() + "." + name);
    }
}
```
&emsp;&emsp;
_Answer_
A. GianRobot
B. GiantRobot DinosaurRobot
C. DinosaurRobot
D. The code does not compile because of line `y1`
E. The code does not compile because of line `y2`
F. None of the above
The declaration of the local classes Robot and Transformer compile without issue. The only compilation problem in this 
program is the last line of the `main()` method. The variable name is defined inside the local class and not accessible 
outside class declaration without a reference to the local class. Due to scope, this last line of the main() method does 
not compile, making option F the correct answer. Note that the first part of the `print()` statement in the main() 
method, if the code compiled, prints `GiantRobot`. <br/>
24. What is the output of the following application?
```java
package space;
public class Bottle {
    public static class Ship {
        private enum Sail {                     // w1
            TALL { protected int getHeight() { return 100;}},
            SHORT { protected int getHeight() { return 2;}};
            protected abstract int getHeight();
        }
        public Sail getSail() {
            return Sail.TALL;
        }
    }
    
    public static void main(String[] stars) {
        var bottle = new Bottle();
        Ship q = bottle.new Ship();             // w2
        System.out.print(q.getSail());
    }
}
```
&emsp;&emsp;
_Answer_
C. The code does not compile because of line `w2`
The *Bottle* class includes a *static* nested class *Ship* that must be instantiated in a static manner. Line `w2` uses 
an instance of Bottle to instantiate the *Ship*. Therefore, ine `w2` does not compile, and option C is the correct answer. <br/>
25. Which of the following are not reasons to use encapsulation when designing a class? (Choose two)
A. Improve security
B. Increase concurrency and improve performance
C. Maintain class data integrity of the data element
D. Prevent users from modifying the internal attributes
E. Prevent variable state from changing
F. Promote usability by other packages
&emsp;&emsp;
_Answer_
Option A is true because encapsulation improves security because instance variables cannot be accessed directly. Implementing
encapsulation prevents internal attributes of a class from being modified directly, so option D is true statement. By preventing
 access to internal attributes, we can also maintain class data integrity between elements, making option C a true 
statement. Option F is also a true statement about encapsulation, since well-encapsulated classes are often easier to use. 
Encapsulation makes no guarantees about performance and concurrency, making option `B` on of the answer. Option `E` i the other 
answer because it describes immutability, not encapsulation. <br/>
26. Given the following method signature used in a class, which classes can call it?
```java
void run(String government)
```
&emsp;&emsp;
_Answer_
B. Classes in the same package
The method signature has package, or default, access therefore, it is accessible to classes in the same package, making 
option B the correct answer. <br/>
27. Which is the first declaration to not compile?
```java
package desert;

interface CanBurrow {
    public abstract void burrow();
} 

@FunctionalInterfcae interface HashHardShell 
extends CanBurrow { }

abstract class Tortoise implements HashHardShell {
    public abstract int toughness();
}

public class DesertTortoise extends Torsoise {
    public int toughness() { return 11; }
}
```
&emsp;&emsp;
__Answer__ <br/>
D. `DesertTortoise` <br/>
First, both *CanBurrow* and *HashHardShell* compile as functional interfaces since they contain exactly one *abstract* method, 
although only the latter uses the optional `@FunctionalInterface` annotation. The declaration of these two interfaces, along 
with the abstract class *Tortoise*, compile without issue. The class *DesertTortoise* inherits two abstract methods, one from 
the interface *CanBurrow* and the other from the *abstract* parent class *Tortoise*. Since the class implements only one of them 
and the class is concrete, the class declaration of *DesertTortoise* fails to compile, making option D the correct answer. 
<br/>
28. Which is the first line to not compile?
```java
interface Building {
    default Double getHeight() { return 1.0; }              // m1
}
interface Office {
    public default String getHeight() { return null; }      // m2
}
abstract class Tower implements Building, Office {}         // m3
public class Restaurant extends Tower {}                    // m4
```
&emsp;&emsp;
__Answer__ <br/>
C. Line `m3` <br/>
The interface declarations compile without issue. When inheriting two default methods with the same signature, the `Tower` 
class required to override both methods even if the class is marked `abstract`. For thi reason, line `m3` is the first line 
that does not compile, and option C is correct. Note that there is no possible overridden method that can fulfill both 
inherited default methods since the return types are not covariant. <br/>

29. Fill in the blanks:_______________________________________ is used to call a constructor in the parent class, while
_____________________________ is used to reference a member of the parent class.
&emsp;&emsp;
__Answer__ <br/>
D. `super()`, `super` <br/>
The `super()` statement is used to call a constructor in the parent class, while `super` is used to reference a member of 
the parent class. The `this()` statement is used to call a constructor in the current class, while `this` is used to reference 
a member of the current class. For these reason, option D is correct answer. <br/>

30. 