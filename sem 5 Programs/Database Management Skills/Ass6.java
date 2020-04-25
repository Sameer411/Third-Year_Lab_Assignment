//sudo apt-get install libmysql-java
//export  CLASSPATH=$CLASSPATH:/usr/share/java/mysql-connector-java.jar
import java.sql.*;
import java.util.*;
import java.io.*;
import java.sql.DriverManager;
public class Ass6
{
    public static void main(String args[])
    {
     try
     {
     
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ass6?useSSL=false","root","manager");
     System.out.println("Success");
     Statement stmt=con.createStatement();
     ResultSet rs=stmt.executeQuery("Select * from Student natural join Dept where dept_name='comp';");
     while(rs.next())
     { 
        System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
     }
     
     con.close();
     }
     catch(Exception e)
     {
        System.out.println(e);
     }
    }
     

}


/*unix@unix-HP-dx2480-MT-KL969AV:~$ cd TEA32
unix@unix-HP-dx2480-MT-KL969AV:~/TEA32$ export CLASSPATH=$CLASSPATH:/usr/share/java/mysql-connector-java.jar
unix@unix-HP-dx2480-MT-KL969AV:~/TEA32$ javac Ass6.java
unix@unix-HP-dx2480-MT-KL969AV:~/TEA32$ java Ass6
Success
100 10 Abiali
100 14 rahul*/

