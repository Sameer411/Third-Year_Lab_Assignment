"""
NAME     : DHARA HARISH KOTAK
CLASS    : TE(A)
ROLL NO. : 38
SUBJECT  : Database Management System Lab.
  Assignment no:14
---------------------------------------------------------------------------------------------  

Create employee array objects containing employee id , name, designation, salary using JSON and write a program in python/Java to read and display the employee information.
    
Software required: Python, Mysql

---------------------------------------------------------------------------------------------
"""
import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class emp{


public static void main(String[] args) {
JSONParser parser = new JSONParser();

try {

Object obj = parser.parse(new FileReader("/home/unix/emp.txt"));

JSONObject jsonObject = (JSONObject) obj;

JSONArray emplist = (JSONArray) jsonObject.get("Employee List");

System.out.println("\nEmployee List:");
Iterator<String> iterator= emplist.iterator();
while (iterator.hasNext()) {
System.out.println(iterator.next());
} }catch (Exception e) {
e.printStackTrace();
}
}
}
"""
---------------------------------------------------------------------------------------------
unix@unix-HP-dx2480-MT-KL969AV:~$ javac emp.java
Note: emp.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
unix@unix-HP-dx2480-MT-KL969AV:~$ java emp

Employee List:
Employee id 	: 116011315
Employee Name 	: Meena
Designation 	: Manager
Salary 	: 4,00,000
Employee id 	: 116011314
Employee Name 	: Rohan 
Designation 	: CEO
Salary 	: 5,00,000
Employee id 	: 116011313
Employee Name 	: Darshana
Designation 	: Founder
Salary 	: 4,00,000
unix@unix-HP-dx2480-MT-KL969AV:~$ 

"""
