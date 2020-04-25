file=open("file1.txt","r")
print(" The contents of file: ")
if file.mode=='r':
	contents=file.read()
print(contents)
file1=open("file2.txt","r")
print(" The contents of file: ")
if file1.mode=='r':
	contents1=file1.read()
print(contents1)
sp1=contents.split()
sp2=contents1.split()

set1=set(sp1)
set2=set(sp2)
print(set1)
print(set2)
  
dict_word=dict()
for i in set1:
	y=sp1.count(i)
	dict_word[i]=y
dict_word2=dict()
for i in set2:
	y1=sp2.count(i)
	dict_word2[i]=y1
print("Print 1st dictionary:",dict_word)
print("print 2nd  dictionary:",dict_word2)
len1=len(sp1)
len2=len(sp2)
for i in sp1:
	tf=dict_word[i]/len1
	print("Total frequency of word ",i," is:",tf)
# add data in set
#set1.add("Added")
print(set1)
print("common words:",set1.intersection(set2))
ar=set1.intersection(set2)
print("Uncommon words of two files:")
print(set1.difference(set2))
result=(len(ar)/(len1*len2)*100)

print("Frequency of repeated word is",result)
