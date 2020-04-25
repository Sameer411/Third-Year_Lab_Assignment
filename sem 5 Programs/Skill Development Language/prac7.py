import matplotlib
from matplotlib import pyplot as plt
plt_x=[10,20,30,30,89]
plt_y=[74,58,94,90,23]
plt.plot(plt_x,plt_y,Linestyle="--",color="red",marker="*",label="income1")
plt.xlabel("age")
plt.ylabel("salary")
plt_x1=[89,34,57,67]
plt_y1=[56,68,98,67]
plt.plot(plt_x1,plt_y1,label="Income2")
plt.title("Income")
plt.legend()

fig = plt.figure()
ax1 = fig.add_subplot(131)


# Plot the data
ax1.bar([1,2,3],[3,4,5])


plt.show()
