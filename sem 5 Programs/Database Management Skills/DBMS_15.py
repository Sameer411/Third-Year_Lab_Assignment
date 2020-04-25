"""
NAME     : DHARA HARISH KOTAK
CLASS    : TE(A)
ROLL NO. : 38
SUBJECT  : Database Management System Lab.
	Assignment no:15
--------------------------------------------------------------------------------------------
Create the following collection  in mongodb
     Student(rollno,name,address,contact_no,department)
     Write a menu driven program in python to connect with the database  and to perform the  following operation:
     
1. Insert details of the student
2. Update the address of John to Dwarka
3. Display the students information
4. Delete a student’s record

Software required: Python, Mysql

---------------------------------------------------------------------------------------------
PYTHON PROGRAM
---------------------------------------------------------------------------------------------
"""

import pymongo

client=pymongo.MongoClient("localhost",27017)

#client.database_names()

db=client.TEB69

#db.student.insert({'Rollno':6,'Name':"Harry",'Address':"Jail rd",'Contact':9552276211,'Dept':"Production"})
#print 'Inserted'
 
#for item in db.student.find():
#	print item

def menu():
	print 'Menu:\n'
	print '1.Insert.\n'
	print '2.Update.\n'
	print '3.Delete.\n'
	print '4.Display.\n'
	print '5.Exit.\n'
	return input('Enter your choice : \n')
	
loop=1
choice=0
while loop==1:
	choice=menu()
	if choice==1:
		roll=input('Enter the Roll No. :\n')
		name=raw_input('Enter the name :\n')
		add=raw_input('Enter the address :\n')
		cont=input('Enter the contact no. :\n')
		dept=raw_input('Enter the Department :\n')
		db.student.insert({'Rollno':roll,'Name':name,'Address':add,'Contact':cont,'Dept':dept})
		print '\nINSERTED.\n'
		
	elif choice==2:
		nme=raw_input('\nEnter the name whose address you want to update:\n')
		addr=raw_input('Enter the new address :\n')
		db.student.update({'Name':nme},{'$set':{'Address':addr}})
		print '\nUPDATED.\n'
		
	elif choice==3:
		rno=input('\nEnter the roll no. that you want to delete:\n')
		db.student.remove({'Rollno':rno})
		print '\nDELETED.\n'
		
	elif choice==4:
		for item in db.student.find():
			print item
		
	elif choice==5:
		exit()
		
""" 
--------------------------------------------------------------------------------------------Output
--------------------------------------------------------------------------------------------

Menu:

1.Insert.

2.Update.

3.Delete.

4.Display.

5.Exit.

Enter your choice : 
1
Enter the Roll No. :
8
Enter the name :
Lee
Enter the address :
Dwarka
Enter the contact no. :
48798842
Enter the Department :
Mech
Inserted.
Menu:

1.Insert.

2.Update.

3.Delete.

4.Display.

5.Exit.

Enter your choice : 
4
{u'Name': u'Naksh', u'Rollno': 1.0, u'Dept': u'Comp', u'Contact': 9899214356.0, u'Address': u'Nasik', u'_id': ObjectId('5ba5d12e012a4063040c9ecb')}
{u'Name': u'Jay', u'Rollno': 2.0, u'Dept': u'Chemical', u'Contact': 9899277530.0, u'Address': u'Dwarka', u'_id': ObjectId('5ba5d170012a4063040c9ecc')}
{u'Name': u'John', u'Rollno': 3.0, u'Dept': u'Civil', u'Contact': 9392277530.0, u'Address': u'Cidco', u'_id': ObjectId('5ba5d18d012a4063040c9ecd')}
{u'Name': u'Ray', u'Rollno': 4.0, u'Dept': u'Mech', u'Contact': 9392276211.0, u'Address': u'Nskrd', u'_id': ObjectId('5ba5d1ab012a4063040c9ece')}
{u'Name': u'Henry', u'Rollno': 5.0, u'Dept': u'Mech', u'Contact': 9392276211.0, u'Address': u'Sharanpur rd', u'_id': ObjectId('5ba5d207012a4063040c9ecf')}
{u'Name': u'Harry', u'Rollno': 6, u'Dept': u'Production', u'Contact': 9552276211L, u'Address': u'Jail rd', u'_id': ObjectId('5ba5d854dffe070e748648df')}
{u'Name': u'Garry', u'Rollno': 7, u'Dept': u'Civil', u'Contact': 5658768957L, u'Address': u'Indira ngr', u'_id': ObjectId('5ba5ded6dffe070f77100862')}
{u'Name': u'Lee', u'Rollno': 8, u'Dept': u'Mech', u'Contact': 48798842, u'Address': u'Dwarka', u'_id': ObjectId('5ba5dfcadffe070fa5bf3894')}
Menu:

1.Insert.

2.Update.

3.Delete.

4.Display.

5.Exit.
2

Enter the name whose address you want to update:
John
Enter the new address :
Dwarka
Updated.

Menu:

1.Insert.

2.Update.

3.Delete.

4.Display.

5.Exit.

Enter your choice : 
3

Enter the roll no. that you want to delete:
8
Deleted.
Menu:

1.Insert.

2.Update.

3.Delete.

4.Display.

5.Exit.

Enter your choice : 
5

--------------------------------------------------------------------------------------------
DATABASE:

---------------------------------------------------------------------------------------------

> db.createCollection("Student")
{
	"ok" : 0,
	"errmsg" : "a collection 'TEB70.Student' already exists",
	"code" : 48,
	"codeName" : "NamespaceExists"
}
> db.createCollection("student")
{ "ok" : 1 }

---------------------------------------------------------------------------------------------
INSERTING VALUES
---------------------------------------------------------------------------------------------
> db.student.insert({Rollno:1,Name:"Naksh",Address:"Nasik",Contact:9899214356,Dept:"Comp"})
WriteResult({ "nInserted" : 1 })
> db.student.insert({Rollno:2,Name:"Jay",Address:"Dwarka",Contact:9899277530,Dept:"Chemical"})
WriteResult({ "nInserted" : 1 })
> db.student.insert({Rollno:3,Name:"John",Address:"Cidco",Contact:9392277530,Dept:"Civil"})
WriteResult({ "nInserted" : 1 })
> db.student.insert({Rollno:4,Name:"Ray",Address:"Nskrd",Contact:9392276211,Dept:"Mech"})
WriteResult({ "nInserted" : 1 })
> db.student.insert({Rollno:5,Name:"Henry",Address:"Sharanpur rd",Contact:9392276211,Dept:"Mech"})
WriteResult({ "nInserted" : 1 })

---------------------------------------------------------------------------------------------
DISPLAYING RECORDS
---------------------------------------------------------------------------------------------
> db.student.find().pretty()
{
	"_id" : ObjectId("5ba5d12e012a4063040c9ecb"),
	"Rollno" : 1,
	"Name" : "Naksh",
	"Address" : "Nasik",
	"Contact" : 9899214356,
	"Dept" : "Comp"
}
{
	"_id" : ObjectId("5ba5d170012a4063040c9ecc"),
	"Rollno" : 2,
	"Name" : "Jay",
	"Address" : "Dwarka",
	"Contact" : 9899277530,
	"Dept" : "Chemical"
}
{
	"_id" : ObjectId("5ba5d18d012a4063040c9ecd"),
	"Rollno" : 3,
	"Name" : "John",
	"Address" : "Cidco",
	"Contact" : 9392277530,
	"Dept" : "Civil"
}
{
	"_id" : ObjectId("5ba5d1ab012a4063040c9ece"),
	"Rollno" : 4,
	"Name" : "Ray",
	"Address" : "Nskrd",
	"Contact" : 9392276211,
	"Dept" : "Mech"
}
{
	"_id" : ObjectId("5ba5d207012a4063040c9ecf"),
	"Rollno" : 5,
	"Name" : "Henry",
	"Address" : "Sharanpur rd",
	"Contact" : 9392276211,
	"Dept" : "Mech"
}
{
	"_id" : ObjectId("5ba5d854dffe070e748648df"),
	"Name" : "Harry",
	"Rollno" : 6,
	"Dept" : "Production",
	"Contact" : NumberLong("9552276211"),
	"Address" : "Jail rd"
}
> db.student.find().pretty()
{
	"_id" : ObjectId("5ba5d12e012a4063040c9ecb"),
	"Rollno" : 1,
	"Name" : "Naksh",
	"Address" : "Nasik",
	"Contact" : 9899214356,
	"Dept" : "Comp"
}
{
	"_id" : ObjectId("5ba5d170012a4063040c9ecc"),
	"Rollno" : 2,
	"Name" : "Jay",
	"Address" : "Dwarka",
	"Contact" : 9899277530,
	"Dept" : "Chemical"
}
{
	"_id" : ObjectId("5ba5d18d012a4063040c9ecd"),
	"Rollno" : 3,
	"Name" : "John",
	"Address" : "Cidco",
	"Contact" : 9392277530,
	"Dept" : "Civil"
}
{
	"_id" : ObjectId("5ba5d1ab012a4063040c9ece"),
	"Rollno" : 4,
	"Name" : "Ray",
	"Address" : "Nskrd",
	"Contact" : 9392276211,
	"Dept" : "Mech"
}
{
	"_id" : ObjectId("5ba5d207012a4063040c9ecf"),
	"Rollno" : 5,
	"Name" : "Henry",
	"Address" : "Sharanpur rd",
	"Contact" : 9392276211,
	"Dept" : "Mech"
}
{
	"_id" : ObjectId("5ba5d854dffe070e748648df"),
	"Name" : "Harry",
	"Rollno" : 6,
	"Dept" : "Production",
	"Contact" : NumberLong("9552276211"),
	"Address" : "Jail rd"
}
{
	"_id" : ObjectId("5ba5ded6dffe070f77100862"),
	"Name" : "Garry",
	"Rollno" : 7,
	"Dept" : "Civil",
	"Contact" : NumberLong("5658768957"),
	"Address" : "Indira ngr"
}
> db.student.find().pretty()
{
	"_id" : ObjectId("5ba5d12e012a4063040c9ecb"),
	"Rollno" : 1,
	"Name" : "Naksh",
	"Address" : "Nasik",
	"Contact" : 9899214356,
	"Dept" : "Comp"
}
{
	"_id" : ObjectId("5ba5d170012a4063040c9ecc"),
	"Rollno" : 2,
	"Name" : "Jay",
	"Address" : "Dwarka",
	"Contact" : 9899277530,
	"Dept" : "Chemical"
}
{
	"_id" : ObjectId("5ba5d18d012a4063040c9ecd"),
	"Rollno" : 3,
	"Name" : "John",
	"Address" : "Dwarka",
	"Contact" : 9392277530,
	"Dept" : "Civil"
}
{
	"_id" : ObjectId("5ba5d1ab012a4063040c9ece"),
	"Rollno" : 4,
	"Name" : "Ray",
	"Address" : "Nskrd",
	"Contact" : 9392276211,
	"Dept" : "Mech"
}
{
	"_id" : ObjectId("5ba5d207012a4063040c9ecf"),
	"Rollno" : 5,
	"Name" : "Henry",
	"Address" : "Sharanpur rd",
	"Contact" : 9392276211,
	"Dept" : "Mech"
}
{
	"_id" : ObjectId("5ba5d854dffe070e748648df"),
	"Name" : "Harry",
	"Rollno" : 6,
	"Dept" : "Production",
	"Contact" : NumberLong("9552276211"),
	"Address" : "Jail rd"
}
{
	"_id" : ObjectId("5ba5ded6dffe070f77100862"),
	"Name" : "Garry",
	"Rollno" : 7,
	"Dept" : "Civil",
	"Contact" : NumberLong("5658768957"),
	"Address" : "Indira ngr"
}
> 
==============================================================================================="""

