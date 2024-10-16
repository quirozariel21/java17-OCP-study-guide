# QUESTIONS

1. How many lines does this print?
```java
System.out.println("""
            "ape"
            "baboon"
            "gorilla"
            """);
```
&emsp;&emsp;
__Answer__<br/>
B. Four <br/>
This is a valid text block. Since the closing triple quotes (""") are on new line, the code prints the three lines of the text 
followed by a blank. <br/>

4. Which class has a `getSeconds()` method?
&emsp;&emsp;
 __Answer__<br/>
A. A period is measured in days, weeks, months, or years. A Duration is measured in smaller units like minutes or seconds. Only 
Duration has a `getSeconds()` method.
<br/>
5. Most of the United States observes daylight saving time on March 13, 2022, by moving the clocks forward an hour at 2 a.m. What does 
the following code output?
```java
var localDate = LocalDate.of(2022, 3, 13);
var localTime = LocalTime.of(1, 0);
var zone = ZoneId.of("America/New_York");
var z = ZonedDateTime.of(localDate, localTime, zone);

var offset = z.getOfsset();
var duration = Duration.ofHours(3);
var later = z.plus(duration);

System.out.println(later.getHour() + " " + offset.equals(later.getOffset()));
```
&emsp;&emsp;
__Answer__ <br/>
C. `5 false`  <br/>
On a normal night, adding three hours to 1 a.m. makes it 4 a.m. However, this date begins daylight saving time(Horario de verano). This means we add an 
extra hour to skip the 2 a.m. hour. This makes later contain 05:00 instead of 04:00 and the offset changes. Therefore, the code prints 5 false
<br/>

7What does the following output?
```java
int year = 1874;
int month = Month.MARCH;
int day = 24;
LocalDate date = LocalDate.of(year, month, day);
System.out.println(date.isBefore(LocalDate.now));
```
&emsp;&emsp;
 __Answer__<br/>
C. The code does not compile <br/>
`LocalDate` allows passing the month as an `int` or `Month` enum parameter. However, `Month.MARCH` is an enum. It cannot be assigned
to an int variable, so the declaration of month does not compile, option C is correct.
<br/>

9. What is the output of the following? 
```java
5: var line = new StringBuilder("-");
6: var anotherLine = line.append("-");
7: System.out.print(line == anotherLine);
8: System.out.print(" ");
9: System.out.print(line.length());
```
&emsp;&emsp;
__Answer__<br/>
D. `true 2` <br/>
A `StringBuilder` is mutable, so the length is 2 after line 6 completes. The `StringBuilder` methods return a reference to the same
object, so you can chain method calls. Therefore, line and anotherLine refer to the same object. This means that line 7 prints `true`.
<br/>

10. Given the daylight time starts on March 13, 2022, at 2 a.m. and clocks jump from 1:59 a.m. to 03:00 a.m., which of the 
following can fill in blank so the code doesn't throw exception?
```java
var localDate = LocalDate.of(2022, 3, 13);
var localTime = LocalTime.of(_____);
var zone = ZoneId.of("America/New_York");
var z = ZoneDateTime.of(localDate, localTime, zone);
```
&emsp;&emsp;
__Answer__<br/>
C. `Either of the above run without throwing an exception` <br/>
While is no 2 a.m. on the clock that night, Java adjusts the time to 3 a.m. automatically and changes the time zone. It does not throw
 an exception/
<br/>
11. Which statement is true of this text block? 
```java
                                   var block = """

                                      green
                                        yellow
                                   """;
```
&emsp;&emsp;
__Answer__<br/>
A. There is only essential whitespace. <br/>
Since the closing triple quotes (""") are at the beginning of the line, there is no incidental whitespace. By contrast, there is 
essential whitespace before both green and yellow. <br/>

13. What is the result of the following?
```java
11: var waffleDay = LocalDate.of(2022, Month.MARCH, 25);
12: var period = Period.of(1, 6, 3);
13: var later = waffleDay.plus(period);
14: later.plusDays(1);
15: var thisOne = LocalDate.of(2023, Month.SEPTEMBER, 28);
16: var thatOne = LocalDate.of(2023, Month.SEPTEMBER, 29);
17: System.out.println(later.isBefore(thisOne) + " " 
18:    + later.isBefore(thatOne));
```
&emsp;&emsp;
__Answer__<br/>
B. `false` `true` <br/>
Line 14 has no effect, as the return ale is ignored.
<br/>
15. What is the possible output of the following? <br/>
```java
var montyPythonDay = LocalDate.of(2023, Month.MAY, 10);
var aprilFools = LocalDate.of(2023, Month.APRIL, 1);
var duration = Duration.ofDays(1);
var result = monthPythonDay.minus(duration);
System.out.println(result + " " + aprilFools.isBefore(result));
```
&emsp;&emsp;
__Answer__<br/>
D. `None of the above` <br/>
`Durations` is supposed to be used with objects that contain times. While it has an `ofDays()` method, this is a convenience method 
to represent a large number of seconds. This means that calling `Duration.ofDays(1)` is fine. However, this code throws and 
`UnsuportedTemporalTypeException` when you try pass it to the `minus()` method on `LocalDate`, making option D correct. Note that 
the question asks a possible result rather that the definitive result because the format of dates varies by region.
<br/>
16. What is the output of the following? <br/>
```java
5: var line = new String("-");
6: var anotherLine = line.concat("-");
7: System.out.println(line == anotherLine);
8: System.out.println(" ");
9: System.out.println(line.length());
```
&emsp;&emsp;
__Answer__<br/>
A. `false` `1` <br/>
<br/>

18. In the United States, daylight saving time ends on November 6, 2022 at 02:00 a.m. and we repeat the previous hour.  What is the 
output of the following ?
```java
var localDate = LocalDate.of(2022, Month.NOVEMBER, 6);
var localTime = LocalTime.of(1, 0);
var z = ZoneId.of("America/New_York");
var z = ZonedDateTime.of(localDate, localTime, zone);
var offset = z.getOffset();

for (int i = 0; i < 6; i++)
    z.plusHours(1);

System.out.print(z.getHour() + " " + offset.equals(z.getOffset()));
```
&emsp;&emsp;
__Answer__<br/>
G. `None of the above` <br/>
This question is tricky. It appears to be about daylight saving time. However, the result of `z.plusHours(1)` is never stored in 
a variable or used. Since ZonedDateTime is immutable, the time remains at 01:00. The code prints ` 1 true`.
<br/>
19. What does the following code output?
```java
var baa = 8;
var bleat =  ~baa;
var sheep = ~bleat;
System.out.printf(bleat + " " + sheep);
```
&emsp;&emsp;
__Answer__<br/>
C. `-9 8` <br/>
The bitwise complement operator (~) inverts all bits in the number. You can calculate this by negating the number and subtracting one, which is ~9 
in this case. Applying the bitwise complement operator twice gives you the original number, which is 8. 
<br/>

22. Which statement are true about the output of this code? (Choose three)
```java
var text = """
    ant   antepoler \s \n
    cat "kitten" \
    seal sea lion
""";
System.out.print(text);
```
&emsp;&emsp;
__Answer__<br/>
A. It contains two quotes <br/>
E. Two lines are blank <br/>
F. The first line contains tailing whitespace. <br/>
Option A is correct, as only two quotes around "kitten" are output. The \n gives a blank line since it is at the end of the line. The 
last line is also blank, making option E correct. Finally, option F is correct, as \s preserves trailing whitespace.
<br/>
23. Fill in the blanks: The operators `!=`, _____, _____, _____, and `++` are listed in the same or increasing levels of the operator 
precedence.(Choose two)
&emsp;&emsp;
__Answer__<br/>
A. `==`, `*`, `!` <br/>
B. `/`, `%`, `*` <br/>
24. How many of the `LocalDate`, `Period`, and `ZonedDate` classes have a method to get year? <br/>
&emsp;&emsp;
__Answer__<br/>
C. Two <br/>
The `LocalDate` class represents a date using year, month, and day fields. There is a `getYear()` method to get the year. The `Period` class 
holds units of years, months, and days. It has a `getYears()` method. There is no a date/time class called `ZonedDate`. There is a class 
called `ZonedDateTime`, which does have a `getYear()` method.
<br/>
26. What is a possible output of this code?
```java
var time = LocalTime.of(1, 2, 3, 4);
System.out.println(time);
```
B. `01:02:03.00000004` <br/>
28. Which of the following local variable declarations does not compile? <br/>
A. double num1, int num2 = 0; <br/>
B. int num1, num2; <br/>
C. int num1, num2 = 0; <br/>
D. int num1 = 0, num2 = 0; <br/>
E. All of the above <br/>
F. None of the above <br/>
&emsp;&emsp;
__Answer__<br/>
Option A does not compile because Java does not allow declaring different types as part of the same declaration. <br/>
29. Which methods, when combined, match the functionality of the `strip()` method? (Choose two)
&emsp;&emsp;
__Answer__<br/>
D. `stripIndent()` <br/>
F. `stripTrailing()` <br/>




