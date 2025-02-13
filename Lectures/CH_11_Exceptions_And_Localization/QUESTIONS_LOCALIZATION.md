# QUESTIONS
1. What is the result of the following?
```java
LocalDateTime p1 = LocalDateTime.of(2022, 3, 14, 1, 59);
var formatter = DateTimeFormatter.ofPattern("M.ddhhmm");
System.out.println(formatter.format(pi));
```
&emsp;&emsp;
**Answer** <br/>
`3.140159`
<br/>
While it is traditional to include the year when outputting a date, it is not required. This code correctly prints the
month followed by a decimal point. After the decimal point. After the decimal point, it prints the day of the moth
followed by hours and minutes.<br/>
2. Assuming the key `green` is in all five of the files referenced in the options, which file will the following code
   use for the resource bundle?
```java
Locale.setDefault(new Locale("en", "US"));
var rb = ResourceBundle.getBundle("Colors", new Locale("fr"));
System.out.println(rb.getString("green"));
```
A. `Colors_default.properties` <br/>
B. `Colors.properties` <br/>
C. `Colors_en.properties` <br/>
D. `Colors_US.properties` <br/>
E. `Colors_en_US.properties` <br/>
&emsp;&emsp;
**Answer** <br/>
E. `Colors_en_US.properties` <br/>
Java starts out by looking for a properties file with the requested locale, which in this case is the fr language. It
doesn't find it, so it moves on the default locale, en_US, which it does find. <br/>
3. Assuming the following method is called with a `double` value of `1_900_000`, which values are printed?
```java
public void payBill(double t) {
    var nf1 = NumberFormat.getCompactNumberInstance(
        Locale.getDefault(), Style.LONG);
    var nf2 = NumberFormat.getCompactNumberInstance();
    
    System.out.println(nf1.format(t));
    System.out.println(nf2.format(t));
}
```
A. `1M` <br/>
B. `1.9 million` <br/>
C. `2M` <br/>
D. `1.900M` <br/>
E. `2 million` <br/>
F. `1 million` <br/>
&emsp;&emsp;
**Answer** <br/>
C, E. <br/>
A **CompactNumberFormat** rounds to the nearest whole number within the three-digit range, so the first line prints 2 million,
making option E correct. The second line prints 2M, since SHORT is used as the STYLE by default, making option C correct.<br/>
4. What is the output of the following code snippet?
```java
var d = LocalDateTime.parse("2022-01-21T12:00:00", DateTimeFormatter.ISO_LOCAL_DATE);
System.out.println(d.format(DateTimeFormatter.ISO_LOCAL_TIME));
```
&emsp;&emsp;
**Answer** <br/>
F. `An exception is thrown at runtime` <br/>
The code compiles but the first line throws an exception at runtime, making option F correct. The string sent to the 
`parse()` method contains a time component, but ISO_LOCAL_DATE is used as the formatter.<br/>
5. Fill in the blank with the option that allows the code snippet to compile and print a message without throwing an 
exception at runtime. 
```java
var x = LocalDate.of(2022, 3, 1);
var y = LocalDateTime.of(2022, 3, 1, 5, 55);
var f = DateTimeFormatter.ofPattern("MMMM' at 'h' o'clock'");
```
&emsp;&emsp;
**Answer** <br/>
F. `None of the above` <br/>
The apostrophe in o'clock should be escaped. If the pattern string was corrected.  <br/>
6. For currency, the United States uses the `$` symbol, the UK uses the `£` symbol, and Germany uses the `€` symbol. Given 
this information, what is the expected output of the following code snippet? 
```java
Locale.setDefault(Locale.US);                           //$
Locale.setDefault(Category.FORMAT, Locale.GERMANY);     //€
System.out.println(NumberFormat.getCurrencyInstance(Locale.UK).format(1.1)); //£
```
&emsp;&emsp;
**Answer** <br/>
C. `£1.10`  <br/>
7. Which correctly fills in the blank to print `2022-01-15`?
```java
LocalDate hatDay = LocalDate.of(2022, Month.JANUARY, 15);
DateFormatter f = DateFormatter.ISO_DATE;
System.out.println(____________________________________);
```
A. `f.format(hatDate)` <br/>
B. `hatDate.format(f)` <br/>
C. Both of above <br/>
D. Neither of the above <br/>
&emsp;&emsp;
**Answer** <br/>
D. Neither of the above. There is a `DateTimeFormatter` class, but not a `DateFormatter` class. <br/>
8. Given the following four properties files, what does this code print?
```java
Cars.properties
engine=moteur
country=earth
road=highway

Cars_en.properties
engine=engine
horses=241

Cars_en_US.properties
country=US
horses=45

Cars_fr_FR.properties
country=France
road=autoroute
```
```java
Locale.setDefault(new Locale("en", "US"));
var rb = ResourceBundle.getBundle("Cars", new Locale("fr", "FR"));
var s1 = rb.getString("country");
var s2 = rb.getString("horses");
var s3 = rb.getString("engine");
System.out.println(s1 + " " + s2 + " " + s3);
```
&emsp;&emsp;
**Answer** <br/>
An Exception is thrown at runtime <br/>
The getBundle() method matches `Cars_fr_FR.properties`. It will then fall back to `Cars_fr.properties` (which does not 
exist) and `Cars.properties` if the value is not available. For this reason the first and third values would be `France` and 
`moteour`. While the second value `horses` is in the default locale, it is not available if the requested locale has 
been found. As a result, the code throws a `MissingResourceException`. <br/>
9. Assuming the key `turquoise` is in all five referenced in he operations, which file will the following code use for 
the resource bundle?
```java
Locale loc = new Locale("zh", "CN");
Locale.setDefault(new Locale("en", "US"));
ResourceBundle rb = ResourceBundle.getBundle("Colors", loc);
rb.getString("turquoise");
```
A. `Colors_en.properties` <br/>
B. `Colors_CN.properties` <br/>
C. `Colors.properties` <br/>
D. `Colors_default.properties` <br/>
E. `Colors_en_CN.properties` <br/>
F. None of the above <br/>
&emsp;&emsp;
**Answer** <br/>
A. Java starts out by looking for a properties file with the requested locale, which in this case is the `zn_CN` language 
and country. It doesn't find it, so it moves onto the locale with just a language code `zn`, which it also does not find. 
It then moves on to the default locale `en_US`, but there is still no match. It drops the country code and does find a 
match with `en`, making the option A correct. <br/> 
**10.** What is the result of running this code?
```java
12: LocalDate pieDay = LocalDate.of(2022, Month.JANUARY, 23);
13: LocalTime midnight = LocalTime.of(0, 0);
14: LocalDateTime pieTime = LocalDateTime.of(pieDay, midnight);
15:
16: DateTimeFormatter f = DateTimeFormatter
17:     .ofLocalizedDate(FormatStyle.SHORT);
18: f.format(pieDay);
19: f.format(pieTime);
20: f.format(mignight);
```
&emsp;&emsp;
**Answer** <br/>
D. The code throws an exception line 20. <br/>
The `DateTimeFormatter` is created with `ofLocalizedDate()`. It knows how to format date fields but not time fields.
A `LocalTime` object does not have any date fields so the formatter throws an `UnsupportedTemporalTypeException`. <br/>
**11.** For currency, the United States uses the `$` symbol, the UK uses the `£` symbol, and Germany uses the `€` symbol. 
Given this information, what is the expected output of the following code snippet?
```java
Locale.setDefault(Locale.US);
Locale.setDefault(Category.FORMAT, Locale.GERMANY);
Locale.setDefault(Category.DISPLAY, Locale.UK);
System.out.println(NumberFormat.getCurrencyInstance().format(6.95));
```
&emsp;&emsp;
**Answer** <br/>
B. `6,95 €` <br/>
While three distinct locale values are set, the output is used for formatting text is `Category.FORMAT`. For this reason, 
the `GERMANY` locale is used to format the data with `€` symbol. <br/>
**12.** What is the output of the following code snippet?
```java
var x = Locale.of(2022, 3, 1);
var y = LocalDateTime.of(2022, 1, 1, 2, 55);
var f = DateTimeFormatter.ofPttern("'yyyy-MM'");
System.out.println(f.format(x) + " " + f.format(y));
```
&emsp;&emsp;
**Answer** <br/>
D. `yyyy-MM yyyy-MM` <br/>
The date/time pattern uses single quotes to escape the date/time values, meaning the output is `yyyy-MM` for all valid 
inputs. <br/>
13. Given the following two properties files, what does the loadPod() method output?
```java
 container.properties
 name=generic
 number=2
  
 container_en.properties
 name=Ship
 type=container
  
 void loadPod() {
    new Locale.Builder()
      .setLanguage("en")
       .setRegion("US").build();
    var rb = ResourceBundle.getBundle("container");
    String name = rb.getString("name");
    String type = rb.getString("type");
    System.out.print(name + " " + type);
 }
```
&emsp;&emsp;
**Answer** <br/>
D. The output cannot be determined without knowing the locale of the system where it will be run. <br/>
The method creates a resource bundle using a builder but never sets it. Since we don't know the default locale of the 
code, the answer depends on where it is executed. <br/>
14. Given the two properties files from Question 24, what does the following method output?
```java
void loadControlPlane() {
    Locale.setDefault(new Locale("en_US"));
    var rb = ResourceBundle.getBundle("container");
    String name = rb.getString("name");
    String type = rb.getString("type");
    System.out.println(name + " " + type);
}
```
&emsp;&emsp;
**Answer** <br/>
E. An exception is thrown at runtime. <br/>
The Locale constructor that takes a single argument expects a language code, not a concatenation of language and region 
codes. Therefore, the language is set as `en_US`, not `en`, default container.properties is used. Since `type` is not found 
in this properties a `MissingResourceExceptionException` is throw at runtime. <br/>
15. Which of the following is not an expected output printed by the following code?
```java
double p = 1_909.2;
var nf1 = NumberFormat.getCompactNumberInstance(Locale.getDefault());
var nf2 = NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.SHORT);
var nf3 = NumberFormat.getCompactNumberInstance(Locale.getDefault(), Style.LONG);
System.out.println(nf1.format(p));
System.out.println(nf2.format(p));
System.out.println(nf3.format(p));
```
&emsp;&emsp;
**Answer** <br/>
E. None of the above, as the code does not compile. <br/>
The code does not compile because the first formatter requires both a `Locale` and a `Style`. You can omit both values, 
but not one.