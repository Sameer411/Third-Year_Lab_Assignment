
import pandas as pd
miss_val=[' ','-']
df=pd.read_csv("Game_medal.csv",na_values=miss_val)
df.isnull()
print(df.isnull().sum())
#means=df['age'].mean()
#print(means)
str='unknown'
df['City'].fillna(str,inplace=True)
print(df)
print(df.isnull().sum())
