#Title: Create lambda function which will return true when no is even:
import mypackage.demo
mypackage.demo.my_fun()

value=lambda no:no%2==0
no=input("Enter the no which you want to check : ")
print(value(int(no)))


#title:filter function to obtain or print even no or print even no

num_list=[1,2,3,4,5]
x=list(filter(lambda num:(num%2==0),num_list))
print(x)


#Title:create a map function to multiply no an group by 5

x=list(map(lambda num:(num*5),num_list))
print(x)
