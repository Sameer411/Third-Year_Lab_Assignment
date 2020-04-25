import pandas as pd

df=pd.read_csv("iris.csv")
print(df)

print("HEAD DATA")

print(df.head())

print("Tail Data")

print(df.tail())

print("Cloumns:   \n")

print(df.columns)

print("Values rather than columns\n")

print(df.values)

print("Describes columns")

print(df.describe())

print("ADD extra column")

df['NAME']="XYZ"

print(df)

print(df.petal_length)


#print("Total no of lines")
#print(df.line_num)


print("sorted")
print(df.sort_values(by='petal_length',ascending=True))
