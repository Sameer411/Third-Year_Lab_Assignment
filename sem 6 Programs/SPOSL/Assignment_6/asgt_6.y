%{
	
	#include<stdio.h>
	#include<stdlib.h>
	
	extern int yylex();
	extern int yyerror();
	FILE *fp;
	int flag=0;
%}

%token For Open_br Close_br Open_curly Close_curly Semi Equal Rel inc_dec Id Num

%%
S:For Open_br E1 Semi E2 Semi E3 Close_br Open_curly Close_curly {printf("\nAccepted\n");flag=1; exit(0);};
E1:Id Equal Num | Id Equal Id;
E2:Id Rel Num | Id Rel Id;
E3:Id inc_dec;

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
	if(flag==0)
	{
		printf("\nSyntax Error");
	}
	return 0;
}
