thislist=input("enter any string")
a=thislist.split()

list=[]
for i in a:
   if i not in list:
     list.append(i)

for i in range(0,len(list)):
 print(list[i],a.count(list[i]))

