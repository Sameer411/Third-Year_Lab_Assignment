/*
 * Program : Lex Token generation
 * Name    : Sameer Rathod
 * Class   : TE B
 * RNo.    : 58
 */

%{
	#include<stdio.h>
	FILE *fp;
%}

Comment "//".*
Package "import".*;
ClassDef "class".*|Scanner
InbuiltFunction "System.out.println(".*");"
MainFunction "public static void main".*
Keyword "for"|"while"|"if"|"else"
Equality .*"==".*
Assignment [a-zA-Z]+"=".*
Function [a-zA-Z]"(".*")"
Datatype "int"|"float"|"double"
Object .*"=new".*
Sum .*="+".*

%%

{Comment} {printf("\nCOMMENT : %s",yytext);}
{Package} {printf("\nPACKAGE : %s",yytext);}
{ClassDef} {printf("\nCLASS : %s",yytext);}
{InbuiltFunction} {printf("\nINBUILT FUNCTION : %s",yytext);}
{Function} {printf("\nFUNCTION : %s",yytext);}
{MainFunction} {printf("\nMAIN FUNCTION : %s",yytext);}
{Equality} {printf("\nEQUALITY : %s",yytext);}
{Assignment} {printf("\nASSIGNMENT STATEMENT : %s",yytext);}
{Datatype} {printf("\nDATATYPE : %s",yytext);}
{Sum} {printf("\nSUM :%s",yytext);}
{Object} {printf("\nOBJECT : %s",yytext);}
{Keyword} {printf("\nKEYWORD : %s",yytext);}

%%

int main(int argc,char *argv[])
{
	fp=fopen(argv[1],"r");
	yyin=fp;
	yylex();
	return 0;
}
 
/*
unix@unix-HP-280-G1-MT:~/Documents/TEB_58$ lex asgt_6.l
unix@unix-HP-280-G1-MT:~/Documents/TEB_58$ gcc lex.yy.c -ll
unix@unix-HP-280-G1-MT:~/Documents/TEB_58$ ./a.out sample.java*/
/*
 *	Date    : 29-Dec-2018
 *	Program : FIFO Paging
 *	Name    : Sameer Rathod
 *	Class   : TE B
 * 	Roll No : 58
 */
 
/*
PACKAGE : import java.io.*;

PACKAGE : import java.util.*;


CLASS : class Paging
{
	
MAIN FUNCTION : public static void main(String args[])throws IOException
	{

OBJECT : 		int frame[]=new int[3]; 	//array of pg frame
		
KEYWORD : for(
DATATYPE : int 
ASSIGNMENT STATEMENT : i=0;i<3;i++)
			frame[i]=-1;
			

OBJECT : 		Scanner sc=new Scanner(System.in);
		System.out.pr
DATATYPE : int("\nEnter the length of reference string : ");	
COMMENT : //accepting reference frame
		
DATATYPE : int 
ASSIGNMENT STATEMENT : n=sc.nextInt();	

OBJECT : 		int reference[]=new int[30];
		
		System.out.pr
DATATYPE : int("\nEnter the reference the string : ");
		
KEYWORD : for(
DATATYPE : int 
ASSIGNMENT STATEMENT : i=0;i<n;i++)
			reference[i]=sc.nextIn
FUNCTION : t();
			
		
		
KEYWORD : for(
DATATYPE : int 
ASSIGNMENT STATEMENT : i=0;i<n;i++)
			
INBUILT FUNCTION : System.out.println(reference[i]);
			
		
DATATYPE : int check;
		
DATATYPE : int k;
		
ASSIGNMENT STATEMENT : check=0;
		
ASSIGNMENT STATEMENT : k=0;
		
KEYWORD : for(
DATATYPE : int 
ASSIGNMENT STATEMENT : i=0;i<n;i++)
		{
			System.out.pr
DATATYPE : int("\n------------------------");
			
ASSIGNMENT STATEMENT : check=isHit(frame,reference[i]);
			

EQUALITY : 			if(check==1)
				System.out.pr
DATATYPE : int("\nHIT");
				
			
KEYWORD : else
			{
				frame[k]=reference[i];
				
ASSIGNMENT STATEMENT : k=(k+1)%3;
				
				System.out.pr
DATATYPE : int("\nReplaced");
				
INBUILT FUNCTION : System.out.println();				
				
KEYWORD : for(
DATATYPE : int 
ASSIGNMENT STATEMENT : j=0;j<3;j++)
					System.out.pr
DATATYPE : int(frame[j]+"\t");
			}	
		}
	}
	
	public static 
DATATYPE : int isHi
FUNCTION : t(int frame[],int x)		
COMMENT : //checking whether hit or not 
	{
		
KEYWORD : for(
DATATYPE : int 
ASSIGNMENT STATEMENT : i=0;i<3;i++)

EQUALITY : 			if(frame[i]==x)
				return 1;
		return -1;
	}
	
}
unix@unix-HP-280-G1-MT:~/Documents/TEA_66$ 
*/ 
 
