#1.create array of element 1 to 10

import numpy as np

a=np.array(10)

print(a)

#create evenly place 6 elements
b=np.arange(0,10,2)

print(b)

#shape()

q=b.shape
print(q)

#reshape 
q=np.arange(24)
print(q)
r=q.reshape(2,4,3)
print(r)

#Random array of 3*3

#Identity matrix
print(np.identity(4))

#min
print(np.amin(b))

#max

print(np.amax(b))

#non zero
countzero_in2 = np.count_nonzero(q) 
print(countzero_in2 )
