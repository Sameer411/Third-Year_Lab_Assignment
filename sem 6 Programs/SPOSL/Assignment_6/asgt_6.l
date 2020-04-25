/*
 * Program : Yacc syntax
 * Name    : Sameer Rathod
 * Class   : TE B
 * RNo.    : 58
 */

%{
	#include "y.tab.h"
	extern int yylval;
%}

%%
"for" {return (For);}
"(" {return (Open_br);}
")" {return (Close_br);}
"{" {return (Open_curly);}
"}" {return (Close_curly);}
";" {return (Semi);}
"=" {return (Equal);}
"<"|">"|"<="|">=" {return (Rel);}
"++"|"--" {return (inc_dec);}
[a-z|A-Z] {yylval=yytext[0]; return Id;}
[0-9]+ {yylval=atof(yytext); return Num;}
%%

/*
OUTPUT : 
sameerrathod@sameer-rathod:~/Downloads$ lex asgt_9.l
sameerrathod@sameer-rathod:~/Downloads$ yacc -d asgt_9.y
sameerrathod@sameer-rathod:~/Downloads$ cc lex.yy.c y.tab.c -ll -ly
sameerrathod@sameer-rathod:~/Downloads$ ./a.out text.txt

File content is : 
for(i=0;i<n;i++){}

Accepted

*/
