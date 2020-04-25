/*
 * Program : Lex count of words, lines
 * Name    : Sameer Rathod
 * Class   : TE B
 * RNo.    : 58
 */

%{
	#include<stdio.h>
	FILE *f;
	int num=0,small_char=0,capital_char=0,space=0,spl_char=0,words=0,lines=0;
%}

Character [a-zA-Z]
Number [0-9]
Space " "
SpecialCharater "."|","|"+","-","(",")"
Line "\n"
%%

{Character} small_char++;
{Number} num++;
{Space} {space++,words++;}
{SpecialCharater} spl_char++;
{Line} {lines++,words++;}


%%

int main(int argc,char *argv[])
{
	f=fopen(argv[1],"r");
	yyin=f;
	yylex();
	printf("\nNo of  Character : %d",small_char);
	printf("\nNo of numberical Character : %d",num);
	printf("\nNo of words : %d",words);
	printf("\nNo of lines : %d",lines);
	printf("\nNo of Spaces : %d" ,space);
	printf("\nNo of Special Character : %d" ,spl_char);
	printf("\n");
	return 0;
}
/*
OUTPUT : 
sameerrathod@sameer-rathod:~/Downloads$ lex asgt_7n.l
sameerrathod@sameer-rathod:~/Downloads$ gcc lex.yy.c -ll
sameerrathod@sameer-rathod:~/Downloads$ ./a.out text.txt

No of  Character : 30
No of numberical Character : 36
No of words : 15
No of lines : 9
No of Spaces : 6
No of Special Character : 3

*/

