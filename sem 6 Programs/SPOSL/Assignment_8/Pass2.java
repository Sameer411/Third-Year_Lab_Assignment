/*
 * Program : Assembler Pass II
 * Name    : Sameer Rathod
 * Class   : TE B
 * RNo.    : 58
 */

import java.io.*;
import java.util.*;

class Fun
{
	void Display(String array[][],int m,int n)
  	{
  		for(int i=0;i<m;i++)
		{
		   	for(int j=0;j<n;j++)
		   	{
				System.out.print(array[i][j]+"\t");
		   	}
	   		System.out.println();
		}
  	}
  	int ProgramMatrix(String array[][],int m,String FileName)
  	{  	String s;
  		BufferedReader br=null;
  		File file = new File(FileName);
		int i=0;
		try
		{
			br=new BufferedReader(new FileReader(file));
			while((s=br.readLine())!= null)
			{
				String[] result=s.split("\t");
				for(int j=0;j<m;j++)
				{
					array[i][j]=result[j];
			      	}
			      	i++;
			}

		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return i;
	}
	int Machine_Code(String[][] Intermediate,int n,String[][] SymTab,int Sn,String[][] LitTab,int Ln,String[][] MachineCode)
	{
		int flag=0,k=0;
		for(int i=0;i<n;i++)
		{
			flag=0;
			if(Intermediate[i][1].contains("AD")||Intermediate[i][1].contains("DL,01"))
			{
				flag=1;	
			}
			else 
			{
				MachineCode[k][0]="+";
				if(Intermediate[i][1].contains("DL"))
				{
					MachineCode[k][1]="00";
					MachineCode[k][2]="00";
					String[] temp=Intermediate[i][2].split("\\,");
					temp[1]=temp[1].replace(")","");
					MachineCode[k][3]="0"+temp[1];
				}
				else
				{
					for(int j=1;j<3;j++)
					{
			
						if(Intermediate[i][j].compareTo(" ")!=0)
						{
						String[] temp=Intermediate[i][j].split("\\,");
						temp[1]=temp[1].replace(")","");
						MachineCode[k][j]=temp[1];
						}
						else
						MachineCode[k][j]=" ";
					}
					//Address Field Third Column
					if(Intermediate[i][3].contains("S"))
					{
						String[] temp=Intermediate[i][3].split("\\,");
						temp[1]=temp[1].replace(")","");
						int index=Integer.parseInt(temp[1]);
						MachineCode[k][3]=SymTab[index][1];
					}
					else if(Intermediate[i][3].contains("L"))
					{
						String[] temp=Intermediate[i][3].split("\\,");
						temp[1]=temp[1].replace(")","");
						int index=Integer.parseInt(temp[1]);
						MachineCode[k][3]=LitTab[index][1];
					}
					else
					MachineCode[k][3]=" ";
				
				}
				k++;
			}
		}
		return k;
	}
}
class Pass2
{
	public static void main(String args[])
  	{
  		Fun f = new Fun();
		int n=0,Sn=0,Ln=0,m=0;
		String[][] Intermediate=new String[100][4];
		String[][] SymTab=new String[10][3];
		String[][] LitTab=new String[100][2];
		String[][] MachineCode=new String[100][4];
		int[] poolTAB=new int[10];
		String[][] BC ={{"LT","01"},{"LE","02"},{"EQ","03",},{"GT","04"},{"GE","05"},{"ANY","06"}};
		Scanner input=new Scanner(System.in);
		
		System.out.println("===============================");
		System.out.println("       Intermediate Code    ");
		System.out.println("-------------------------------");
		n=f.ProgramMatrix(Intermediate,4,"Intermediate.txt");
		f.Display(Intermediate,n,4);
		System.out.println("===============================");
		System.out.println();
		System.out.println("===============================");
		System.out.println("       Symbol Table   ");
		System.out.println("-------------------------------");
		Sn=f.ProgramMatrix(SymTab,3,"SymbolTable.txt");
		f.Display(SymTab,Sn,3);
		System.out.println("===============================");
		System.out.println();
		System.out.println("===============================");
		System.out.println("        Literal Table  : ");
		System.out.println("-------------------------------");
		Ln=f.ProgramMatrix(LitTab,2,"LiteralTable.txt");
		f.Display(LitTab,Ln,2);
		System.out.println("===============================");
		System.out.println();
		System.out.println("===============================");
		System.out.println("         Machine Code   ");
		System.out.println("-------------------------------");
		m=f.Machine_Code(Intermediate,n,SymTab,Sn,LitTab,Ln,MachineCode);
		f.Display(MachineCode,m,4);
		System.out.println("===============================");
    
	}
}
/*
OUTPUT : 
===============================
       Intermediate Code    
-------------------------------
 	(AD,01)	(C,100)	 	
 	(IS,04)	(RG,01)	(L,0)	
 	(IS,01)	(RG,03)	(L,1)	
(S,0)	(DL,01)	(C,3)	 	
(S,1)	(IS,04)	(RG,01)	(S,2)	
 	(IS,01)	(RG,01)	(S,3)	
 	(IS,05)	(RG,01)	(S,4)	
 	(DL,02)	(C,='5')	 	
 	(DL,02)	(C,='1')	 	
(S,4)	(AD,04)	(C,103)	 	
(S,5)	(IS,10)	(S,4)	 	
 	(AD,03)	(C,101)	 	
 	(IS,02)	(RG,01)	(L,2)	
 	(IS,03)	(RG,03)	(S,2)	
(S,6)	(DL,02)	(C,5)	 	
 	(AD,03)	(C,113)	 	
 	(IS,00)	 	 	
(S,6)	(DL,02)	(C,19)	 	
 	(AD,02)	 	 	
 	(DL,02)	(C,='1')	 	
===============================

===============================
       Symbol Table   
-------------------------------
A	102	1	
L1	105	1	
B	114	1	
C	103	1	
D	103	1	
L2	112	1	
===============================

===============================
        Literal Table  : 
-------------------------------
='5'	108	
='1'	109	
='1'	116	
===============================

===============================
         Machine Code   
-------------------------------
+	04	01	108	
+	01	03	109	
+	04	01	114	
+	01	01	103	
+	05	01	103	
+	00	00	0='5'	
+	00	00	0='1'	
+	10	4	 	
+	02	01	116	
+	03	03	114	
+	00	00	05	
+	00	 	 	
+	00	00	019	
+	00	00	0='1'	
===============================

*/
