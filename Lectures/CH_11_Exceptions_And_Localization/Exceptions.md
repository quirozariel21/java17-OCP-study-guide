# EXCEPTIONS

Se trata de una situacion que altera la ejecucion normal de un programa. En ese momento, el sistema crea un objeto, que 
se llama objeto de exception y lo pasa de ua llamada de metodo a otra, buscando quien pueda hacerse cargo Si no existe 
nadie, sera la propia JVM quien lo haga.

![alt text](https://github.com/quirozariel21/java17-OCP-study-guide/blob/main/Lectures/CH_11_Exceptions_And_Localization/images/Selection_174.png)
![alt text](https://github.com/quirozariel21/java17-OCP-study-guide/blob/main/Lectures/CH_11_Exceptions_And_Localization/images/Selection_175.png)
![alt text](https://github.com/quirozariel21/java17-OCP-study-guide/blob/main/Lectures/CH_11_Exceptions_And_Localization/images/Selection_176.png)

- [x] **CHECKED EXCEPTIONS**
These are the exceptions that are checked at compile time.
Con excepciones comprobadas, es decir que pueden surgur internamente en un programa, pero al estar bien escrito, 
podemos tratar y de las que nos podemos recuperar. Heredan de **Exception** y pueden producirse por errores de 
programacion y otras situaciones inesperadas, pero en cualquier caso al compilarlas nos obliga a capturarlas. 
Ejemplos: `ClassNotFoundException`, `InterruptedException`, `IOException`, `IntantiationException`, `SQLExcepton`, 
`FileNotFoundException`.
- [x] **UNCHECKED EXCEPTIONS(Runtime Exceptions)**
Conocidas tambien como errores de exceptiones del sistema, son errores de programacion y JAVA **no obliga** a capturar 
este tipo de excepciones. Salvo algunas que si tendriamos que capturarlas.
Son situaciones internas de la aplicacion, de las que problablemente no podamos recuperarnos.
- [x] **ERRORS**
Situaciones externas que no son anticipadas, y de las que puede que no podamos recuperarnos (error de hardware por 
ejemplo) **pues afecta al funcionamiento de la JVM**. Ejemplos:
`StackoverflowError`, `InternalError`, `OutOfMemoryError`, etc.

## TRY/CATCH/FINALLY
A `try` without resources statement must always have a `catch` or `finally` or both associated with it.

## MULTIPLE CATCH's
You can visualize multiple catch blocks like a series of baskets put one below the other. If you put a bigger basket on 
the top, the smaller basket below will not be able to catch anything.
&emsp;&emsp;
Similarly, if you put a catch block wih a generic exception (i.e. a super class exception) above a specific (a sub class  
exception), then the lower catch block will never catch any exception. That is why, a catch block with more specific 
exception can only be put Exception and E2 extends E1. This means, E2 is more specific that E1 is more specific than 
Exception. Th catch blocks must then be placed like this:
```java
try {
    // some code that might throw any of the three exceptions    
} catch (E2 e2) {
        
} catch(E1 e1) {
    
} catch(Exception e) {
    
}
```
&emsp;&emsp;
If the exception classes are unrelated, then the order is not important. See the below example.
&emsp;&emsp;
**Example:**
`catch(IOEXception | FileNotFoundException e) {}`
The exception listed in a multi-catch clause must not be in a subclass relationship with each other. Since
`FileNotFoundException` is a subclass of `IOException`, this code will not compile.

## TRY-WITH-RESOURCES STATEMENT
![alt text](https://github.com/quirozariel21/java17-OCP-study-guide/blob/main/Lectures/CH_11_Exceptions_And_Localization/images/Selection_177.png)

It shortens the amount of code a developer must write.
Primero corre el codigo que esta dentro del `try`, despues corre el codigo para cerrar el recurso y despues se ejecuta 
el codigo dentro del `catch` y `finally`. 
It is compatible with all classes that implement the `Autocloseable` interface.
Muchas veces durante los programas se abren conexiones a base de datos, archivos u otros objetos. Entonces Java incluye 
este feature para automaticamente cerrar los recursos abiertos en el bloque `try{}`.
```java
public void readFile(String file) {
    try(FileInputStream us = new FileInputStream("myFile.txt")) {
        // manejo de archivo
    } catch (IOException e) { // IT is optional
        //code
    }
}
```
&emsp;&emsp;
El compilador internamente reemplaza el try-with-resources por un `try{}finally{}`.
Se pueden declarar varios recursos pero separados por ",". En este caso, los cierres se daran en el orden contrario al 
que fueron declarados.
El bloque catch no es necesario dado que hay un bloque `finally` implicito.
El programador solo podra colocar un bloque finally que se ejecutara siempre despues del `finally` implicito.
Las variables declaradas en los parentesis try _try()_ no seran visibles en el _catch_ ni en el _finally_.
Los recursos son cerrados despues del bloque _try()_, y antes de cualquier catch/finally.
Los recursos se crean en el orden inverso en que fueron cerrados.
El `try-with-resources` no asegura que se cierren los recursos, pero si asegurar que se llamanda a su metodo `close()`.
It is possible to close a resource bfore the end of the try block.
It is compatible with all classes that implement the `Closeable` and `AutoCloseable` interface.
Las variables dentro del bloque try deben ser __finales__ o __efectivamenet finales__.
&emsp;&emsp;
**Example:**
```java
import java.io.IOException;

public class Device implements AutoCloseable {
    String header = null;
    
    public Device(String name) throws IOException {
        header = name;
        if ("D2".equals(name)) throw new IOExcception("Unknown");
        System.out.println(header + " Opened");
    }
    
    public String read() throws IOException {
        return "";
    }
    
    public void close() {
        System.out.println("Closing device " + header);
        throw new RuntimeException("RTE while closing " + header);
    }
    
    public static void main(String[] args) throws Exception {
        try(Device d1 = new Device("D1"); Device d2 = new Device("D2")) {
            throw new Exception("test");
        }
    }
}
```
__Output:__
D1 Opened
Closing device D1
Exception in thread "main" java.io.IOException: Unknown
        at trywithresources.Device.<init>(Device.java:9)
        at trywithresources.Device.main(Device.java:24)
    Suppressed: java.lang.RuntimeException: RTE while closing D1
        at trywithresources.Device.close(Device.java:19)
        at trywithresources.Device.main(Device.java:26)
Java Result: 1

**Explanation**
Device D1 is created successfully but an IOException is thrown while creating Device D2. Thus, the control never enters 
the try block and throw new Exception(“test”) is never executed. Since one resource was created, its close method will 
be called (which prints Closing device D1). Any exception that is thrown while closing a resource is added to the list 
of suppressed exceptions of the exception thrown while opening a resource (or thrown from the try block).
