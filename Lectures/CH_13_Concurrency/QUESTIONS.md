# QUESTIONS
1. How many times does the following code print `How rude!` at runtime?
```java
public class Speaking {
    
}
```
2. What is the output of the following ode snippet?
```java
Callable c = new Callable() {
    public object run() {
        System.out.print("x");
        return 10;
    }    
}
var s = Executors.newScheduleThreadPool(1);
for(int i = 0; i<10; i++) {
    Future f = s.submit(c);
    f.get();
}
s.shutdown();
System.out.println("Done!");
```
&emsp;&emsp;
__Answer__<br/>
C. The code does not compile. <br/>
The code does not compile because `Callable` mut define a `call()` method, not a `run()` method.