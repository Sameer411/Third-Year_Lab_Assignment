/*
 * Program : Yacc datatype syntax
 * Name    : Sameer Rathod
 * Class   : TE B
 * RNo.    : 58
 */

%{
	#include "y.tab.h"
	extern int yylval;
%}

%%
"int" {return (Int);}
"float" {return (Float);}
"double" {return (Double);}
"char" {return (Char);}
"{" {return (COpen);}
"}" {return (CClose);}
"[" {return (Open_br);}
"]" {return (Close_br);}
";" {return (Semi);}
"=" {return (Equal);}
[0-9]+.[0-9]+ {return (dbl);}
[a-z|A-Z]+[a-z|A-Z|0-9]* {yylval=yytext[0]; return Id;}
[0-9]+ {yylval=atof(yytext); return Num;}
%%

/*
OUTPUT : 
sameerrathod@sameer-rathod:~/Downloads$ lex asgt_8.l
sameerrathod@sameer-rathod:~/Downloads$ yacc -d asgt_8.y
sameerrathod@sameer-rathod:~/Downloads$ cc lex.yy.c y.tab.c -ll -ly
sameerrathod@sameer-rathod:~/Downloads$ ./a.out text.txt

File content is : 
int a=10;
 
sameerrathod@sameer-rathod:~/Downloads$ 

*/


