import numpy as np    #Import numpy package

a=np.array([1,2,3,4])  #array function 

print(a)

print(a.shape)	    #shape() function to calculate no of elements

p = np.array([[1,2,3],[4,5,6]]) 
b = p.reshape(3,2) 
print(b)

print(np.arange(24))
q=np.arange(24)
q.ndim
r=q.reshape(2,4,3)
print(r)

