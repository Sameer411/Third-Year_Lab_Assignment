import pandas as pd
import matplotlib
from matplotlib import pyplot as plt
pf=pd.read_csv("student_data.csv")
pf['Total_marks']=pf['TOC']+pf['SDL']+pf['ISEE']+pf['CN']+pf['SEPM']
pf['per']=(pf['Total_marks']/500)*100
print(pf)
plt.plot(Total_marks,SDL)
plt.show()
