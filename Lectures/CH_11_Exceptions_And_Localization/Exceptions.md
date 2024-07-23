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