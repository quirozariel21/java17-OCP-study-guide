# QUESTIONS
2. Which of these can replace the following line of code without changing the behaviour?
```java
void updateRecord(PreparedStatement stmt) throws SQLException {
    stmt.setString(2, null);    
}
```
&emsp;&emsp;
__Answer__<br/>
*C.* `stms.setNull(2, Types.VARCHAR);` <br/>
The `setNull()` method requires you to pass the data type in the database. <br/>

4. Which is responsible for getting a connection to the database?
&emsp;&emsp;
__Answer__<br/>
*A.* `Driver` <br.>
The `Driver` interface is responsible for getting a connection to the database. The `Connection` interface is responsible for communication 
with the database but not making the initial connection. `The Statement` interface knows how to run the SQL Query, and the `ResultSet`
interface knows what was returned by a SELECT query. <br/>
5. Which of these obtains a `Connection`?
&emsp;&emsp;
__Answer__<br/>
*C*. `DriverManager.getConnection(url)` <br/>
`Connection is an interface`. <br/>
6. Which method in `DriverManager` is overloaded to allow passing a username and password?
&emsp;&emsp;
__Answer__<br/>
*F.* None of the above <br/>
The `DriverManager.getConnection()` method can be called with just URL. It also overloaded to take the URL, username, and password. <br/>
7. What is the output if the animals database exists and contains an empty names table?
```java
var url = "jdbc:hsqldb:file:animals";
var sql = "SELECT count(*) FROM names";
try (var conn = DriverManager.getConnection(url);
    var stms = conn.prepareStatement(sql, 
    ResultSet.TYPE_SCROLL_INSENSITIVE, 
    ResultSet.CONCUR_UPDATABLE);
    var rs = stms.executeQuery()) {
    
    System.out.println(rs.getInt(1));
}
```
&emsp;&emsp;
__Answer__<br/>
*D.* The code compiles but throws an exception at runtime. <br/>
This code is missing a call to `rs.next()`. As a result, `rs.getInt(1)` throws a `SQLException` with the **message invalid cursor state**. <br/>
8. Consider the three methods `execute()`, `executeQuery()`, and `executeUpdate()`. Fill in the blanks: ____________ of these is/are 
allowed to run `DELETE` SQL statement while ____________________ of these methods is/are allowed to run `UPDATE` SQL statement.
&emsp;&emsp;
__Answer__<br/>
*E.* Two, two <br/>
The `execute()` method is allowed to run any type of SQL statements. The `executeUpdate()` method is allowed to run any type of the SQL statement 
that returns a row count rather than a `ResultSet`. Both `DELETE` and `UPDATE` SQL statements are allowed to be run with either `execute()`
 or `executeUpdate()`. They are not allowed to be run with `executeQuery()` because they do not return a `ResultSet`.
9. Suppose the `pandas` table has one row with the name `Mei Xiang` and the location `DC`. What does the following code output?
```java
var url = "jdbc:hsqldb:file:mammals";
var sql = "SELECT name FROM pandas WHERE location = 'DC'";
try (var conn = DriverManager.getConnection(url);           // s1
    var stms = conn.preparestatement(sql);                  // s2
    var rs = stmt.executeQuery()) {
    
    if(rs.next()) 
        System.out.println(rs.getString("name"));
    else
        System.out.println("No match");
}
```
__Answer__<br/>
*A.* `Mei Xiang` <br/>

12. Suppose cats is an empty table. Where can `conn.rollback()` be inserted so that the table remains empty?
```java
try (var conn = DriverManager.getConnection(url)) {
    String insert = "INSERT INTO ats VALUES (?, ?)";
    try (var stms = conn.preparedStateent(insert, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
        stmt.setInt(1, 1);
        stmt.setString(2, "Kitty");
        stmt.executeUpdate();
        // line x
    }
    // line y
    con.commit();
}
```
__Answer__<br/>
*D.* None of the above <br/>
Since `conn.setAutoCommit(false)` is not called, each update is automatically committed. Therefore, there is nothing to roll back. <br/>
13. Given the books table and the following method, which option prints the value 379? <br/>
__Answer__<br/>
*B.* rs.getInt(2) <br/>
Unlike arrays, JDBC uses one-based indexes. Since `num_pages` is in the second column, the parameter needs  to be 2.
16. Suppose we have a stored procedure named `summon` that has one `OUT` parameter names `superpower` that always returns the value 
`fly`. Fill in the blank so that the output is `fly`.
````java
var sql = "{call summon(?)}";
try (var conn = DirverManager.getConnection(url);
    var cs = conn.prepareCall(sql)) {
    
    cs.__________________(1, Types.VARCHAR);
    var rs = cs.______________________();
    
    System.out.println(cs.getString("suporpower"));
}
````
__Answer__<br/>
*A.* `registerOutParamater` and `execute` <br/>
Stored procedure use the `registerOutParameter()` method. Since this stored procedure returns a value, we need to call `execute()`. <br/>
17. Suppose cats is an empty table. Where can `conn.rollback(sp)` be inserted so that exactly one row is in the table?
```java
try (var conn = DriverManager.getConnection(url)) {
    conn.setAutocommit(false);
    String insert = "INSERT INTO cats VALUES (?, ?)";
    SavePoint sp = null;
    try (var stmt = conn.prepareStatement(insert)) {
        stmt.setInt(1, 1);
        stmt.setString(2, "Kitty");
        stmt.executeUpdate();
        //line x
    }
    sp = conn.setSavepoint();
    try (var stmt = conn.preparestatement(inert)) {
        stmt.setInt(1, 2);
        stmt.setString(2, "Baverly");
        stmt.executeUpdate();
        // line y
    }
    conn.commit();
}
```
__Answer__<br/>
*B.* Line `y` <br/>
The Kitty insert is before the SavePoint so it is remembered. The `rollack()` method prevents the Beverly commit. When the code calls 
`commit()`, only Kitty is committed and option B is correct.