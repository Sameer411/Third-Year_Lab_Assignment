/*
 * Program : First Come First Serve (FCFS)
 * Name    : Sameer Rathod
 * Class   : TE B
 * RNo.    : 58
 */
import java.io.*;
class FCFS
{
	public static void main(String args[])throws IOException
	{
		final int MAX=10;
		int array[][]=new int[MAX][6];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nEnter the Number of Processes : ");
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
		{
			array[i][0]=i+1;
			System.out.print("Enter the AT of Process  "+(i+1)+" : ");
			array[i][1]=Integer.parseInt(br.readLine());
			System.out.print("Enter the BT of Process  "+(i+1)+" : ");
			array[i][2]=Integer.parseInt(br.readLine());
			if(i==0)
				array[i][3]=array[i][1]+array[i][2];
			else
			{	
				//CT using CT of last process OR AT of current process
				array[i][3]=max(array[i-1][3],array[i][1])+array[i][2];
			}
			
			array[i][4]=array[i][3]-array[i][1];//TAT
			array[i][5]=array[i][4]-array[i][2];//WT
		}
		System.out.print("\n\t FIRST COME FIRST SERVE");
		System.out.print("\n===========================================");
		System.out.print("\nProcess\tAT\tBT\tCT\tTAT\tWT");
		System.out.print("\n-------------------------------------------");
		for(int i=0;i<n;i++)
		{
			System.out.print("\n  "+array[i][0]+"\t"+array[i][1]+"\t"+array[i][2]+"\t"+array[i][3]+"\t"+array[i][4]+"\t"+array[i][5]);
		}
		System.out.print("\n===========================================");	
		float ATAT=0,AWT=0;
		for(int i=0;i<n;i++)
		{
			ATAT=array[i][4]+ATAT;
			AWT=array[i][5]+AWT;
		}
		ATAT=ATAT/n;
		AWT=AWT/n;
		System.out.print("\nATAT : "+ATAT+"\nAWT  : "+AWT);
		System.out.println();
	}
	public static int max(int m,int n)
	{
		if(m>=n)
			return m;
		return n;
	}
}
/*
OUTPUT:
Enter the Number of Processes : 4
Enter the AT of Process  1 : 0
Enter the BT of Process  1 : 2
Enter the AT of Process  2 : 1
Enter the BT of Process  2 : 2
Enter the AT of Process  3 : 5
Enter the BT of Process  3 : 3
Enter the AT of Process  4 : 6
Enter the BT of Process  4 : 4

	 FIRST COME FIRST SERVE
===========================================
Process	AT	BT	CT	TAT	WT
-------------------------------------------
  1	0	2	2	2	0
  2	1	2	4	3	1
  3	5	3	8	3	0
  4	6	4	12	6	2
===========================================
ATAT : 3.5
AWT  : 0.75

*/
