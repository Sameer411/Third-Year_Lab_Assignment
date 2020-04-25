%{
	
	#include<stdio.h>
	#include<stdlib.h>
	
	extern int yylex();
	extern int yyerror();
	FILE *fp;
	int flag=0;
%}

%token Int Float Double Char Open_br Close_br Semi Equal dbl Id Num COpen CClose

%%
S: I1{printf("\nAccepted");flag=1; exit(0);} | I2 {printf("\nAccepted");flag=1; exit(0);} | I3 {printf("\nAccepted");flag=1; exit(0);} | I4 {printf("\nAccepted");flag=1; exit(0);} | F1 {printf("\nAccepted");flag=1; exit(0);} | F2 {printf("\nAccepted");flag=1; exit(0);} | F3{printf("\nAccepted");flag=1; exit(0);} | F4{printf("\nAccepted");flag=1; exit(0);} | D1  {printf("\nAccepted");flag=1;exit(0);} | D2 {printf("\nAccepted");flag=1;exit(0);} | D3 {printf("\nAccepted");flag=1;exit(0);} | D4 {printf("\nAccepted");flag=1;exit(0);};

I1: Int Id Semi;
I2: Int Id Open_br Num Close_br Semi;
I3: Int Id Open_br Num Close_br Equal COpen CClose Semi;
I4: Int Id Equal Num Semi;
F1: Float Id Semi;
F2: Float Id Open_br Num Close_br Semi;
F3: Float Id Equal Num Semi | Float Id Equal dbl Semi;
F4: Float Id Open_br Num Close_br Equal COpen CClose Semi;
D1: Double Id Semi;
D2: Double Id Open_br Num Close_br Semi;
D3: Double Id Equal Num Semi | Double Id Equal dbl Semi;
D4: Double Id Open_br Num Close_br Equal COpen CClose Semi;

%%
extern FILE *yyin;
extern int yyparse();
int main(int argc,char *argv[])
{
	fp=fopen(argv[1],"r");
	printf("\nFile content is : \n");
	char a;
	while((a = fgetc(fp)) != EOF)
      		printf("%c", a);
      	fseek(fp, 0, SEEK_SET);			//move file pointer to starting of input file
	yyin=fp;
	while(!feof(yyin))
	{
	   yyparse();
	}
	if(flag==1)
	{
		printf("\nError");
	}
	return 0;
}

