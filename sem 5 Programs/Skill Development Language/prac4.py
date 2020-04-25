word="GOOGLE"
guessword=[]

word_len=len(word)
a="_"
c=0
for i in range(word_len):
	guessword.append("_")
print(guessword)

j=0
while (j<6):
	x=input("Enter your guess")
	x.upper()
	print(x)

	for i in range(word_len):
		if word[i]==x:
			guessword[i]=x
			print(guessword)
		
	
	j+=1
		


for i in range(word_len):
	if(guessword[i]==a):
		c=1

#if str(guessword) not in word:
	#flag=1

if(c==1):
	print("WELL TRIED BUT YOU GUESS WRONG WORD😒")
else:
	print(" CONGRATULATIONS YOU WON THE GAME🙂")
		
		
