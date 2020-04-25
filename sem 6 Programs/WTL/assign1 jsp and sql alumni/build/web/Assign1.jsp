<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>

<%
String user=request.getParameter("user");
String pass=request.getParameter("pass");

Class.forName("com.mysql.jdbc.Driver");
java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login?zeroDateTimeBehavior=convertToNull","root","");

PreparedStatement ps=conn.prepareStatement("select * from login_details where username=? and password=?");
ps.setString(1,user);
ps.setString(2,pass);

ResultSet rs=ps.executeQuery();
int flag=0;
String name="Name";
while(rs.next())
{
	name=rs.getString(3);
	flag=1;
}
conn.close();
if(flag==1)
{
	int batch=0;
	java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alumni","root","");
	PreparedStatement ps1=con.prepareStatement("select BatchYr from alumnidetails where Name=?");
	ps1.setString(1,name);
	ResultSet rs1=ps1.executeQuery();
	while(rs1.next())
	{
		batch=rs1.getInt(1);
	}
	PreparedStatement ps2=con.prepareStatement("select Name from alumnidetails where BatchYr=?");
	ps2.setInt(1,batch);
	ResultSet rs2=ps2.executeQuery();
	out.println("Your Batchmates:");
	while(rs2.next())
	{
		String name2=rs2.getString(1);
		if(!name.equals(name2))
		{
			out.println("\n"+name2);
		}
		
	}
	PreparedStatement ps3=con.prepareStatement("select * from alumnidetails where name=?");
	ps3.setString(1,name);
	ResultSet rs3=ps3.executeQuery();
	while(rs3.next())
	{
		out.println("Name:"+rs3.getString(1)+" Address:"+rs3.getString(2)+" BatchYr:"+rs3.getInt(3)+" Department:"+rs3.getString(4)+" Designation:"+rs3.getString(5)+" Company Name:"+rs3.getString(6)+" Email:"+rs3.getString(7)+" Phone:"+rs3.getInt(8));
	}
}
else
{
	out.println("Login Unsuccessfully");
}






%>
