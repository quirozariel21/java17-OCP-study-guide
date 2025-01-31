# QUESTIONS
6. What is true of the following program?
```java
enum Admission { ADULT, SENIOR, CHILD}
public class Movie {
    public static void main(String[] args) {
        var price = switch (Admission.CHILD) {
            case ADULT -> 12.50;
            case SENIOR, CHILD -> 10; 
        };
        System.out.println(price);
    }
}
```
A. The code does not compile because the return type of the `case` branches are different.
B. The code oes not compile because one of the `case` branches has two values.
C. The code does not compile because the value being evaluated in the switch is hard coded.
D. The code does not compile because there are too many semicolons.
E. The code compiles and prints `10`.
F. The code compiles and prints `10.0`.
&emsp;&emsp;
__Answer__<br/>
*F.* The code compiles and prints `10.0`. <br/>
The `switch` expression returns values of two different types, `double` and `int`, but since they both can be implicitly cast to the 
same type, `double`, option A is incorrect, This makes option F the answer.
<br/>
8. Which of the following rules about adding a `default` branch to this `switch` statement are correct?
```java
switch (numPenguins) {
    case 0 : System.out.println("no penguins");
    case 1 : System.out.println("one penguin");
}
```
&emsp;&emsp;
__Answer__<br/>
*B.* A `default` statement must be placed between any `case` statement.
*D.* Unlike a `case` statement, a `default` statement does not take a parameter value.
<br/>

14. What is true about the following code? 
```java
23: var race = "";
24: loop:
25: do {
26:         race += "x";
27:         break loop; 
28:    } while (true);
29: System.out.println(race);
```
&emsp;&emsp;
__Answer__<br/>
*A.* It outputs `x` <br/>
*D.* With lines 25 and 28 removed, it does not compile.
The code compiles as is. Due to the break statement on line 27, the loop executes only once. It prints a single x, which means option A 
is the first correct answer. While the label on line 24 is present with lines 25 and 28 removed, it no longer points to a loop. This 
causes the code to not compile, and option E is the other correct answer.
<br/>

15. What does the following code output?
```java
int count = 0;
char letter = 'A';
switch (letter) {
    case 'A' -> count++;
    case 'B' -> count ++;
}
System.out.println(count);
```
&emsp;&emsp;
__Answer__<br/>
*B.* `1` <br/>
This code is correct. The `default` case is optional since there is no return value assigned. Since this is a switch expression, rather than 
switch statement, the cases do not fall through and option B is the answer.

22. How many lines of the `magic()` method contain compilation errors?
```java
10: public void magic() {
11:     do {
12:             int trick = 0;
13:             LOOP: do {
14:                     trick++;
15:             } while (trick < 2--);
16:             continue LOOP;
17:     } while (1 > 2);
18: System.out.println(trick);
19:}
```
&emsp;&emsp;
__Answer__<br/>
*D.* Three <br/>
Line 15 does not compile because the post-decrement operator can be applied only to variables, not values. Line 16 also does not compile 
because the label LOOP is out of scope after line 15. Finally, line 18 does not compile because trick is declared within the do/while 
loop and is out of scope after line 17. <br/>

23. How may of these statements can be inserted after the `println` to have the code flow the arrow in this diagram?
 ```java
break;
break letters;
break numbers;
contonue;
continue letters;
continue numbers;
```
```java
letters: for (char ch = 'a'; ch<= 'z'; ch++) {
    numbers: for (int n = 0; n<=10; n++) {
        System.out.print(ch);
        ///  HERE statement
    }    
}
```
&emsp;&emsp;
__Answer__<br/>
*C.* Three <br/>