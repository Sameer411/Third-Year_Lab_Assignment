/*
 * Program : Round Robin (RR)
 * Name    : Sameer Rathod
 * Class   : TE B
 * RNo.    : 58
 */

import java.io.*;
class RR
{
	public static void main(String args[])throws IOException
	{
		final int MAX=10;
		int array[][]=new int[MAX][6];	//process no | burst time | remaining | arrival | newstart | executed
		int gantt_chart[]=new int[30];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\nEnter the Time Quantum : ");
		int TQ=Integer.parseInt(br.readLine());
		
		System.out.print("\nEnter the Number of Processes : ");
		int n=Integer.parseInt(br.readLine());
		int time=0,max_time=0,k=0;
		
		for(int i=0;i<n;i++)
		{
			array[i][0]=i+1;
			System.out.print("Enter the  Burst Time  (BT) of Process  "+(i+1)+" : ");
			array[i][1]=Integer.parseInt(br.readLine());
			System.out.print("Enter the Arrival Time (AT) of Process  "+(i+1)+" : ");
			array[i][3]=Integer.parseInt(br.readLine());
			array[i][2]=array[i][1];
			array[i][5]=0;
			max_time=max_time+array[i][1];
		}
		System.out.print("\nMaximum Time required is : "+max_time);
		System.out.print("\n--------------------");
		System.out.print("\nPNo.    BT     AT");
		System.out.print("\n--------------------");
		for(int i=0;i<n;i++)
		{
			System.out.print("\n"+array[i][0]+"\t"+array[i][1]+"\t"+array[i][3]);
		}
		System.out.print("\n--------------------\n");
		int count=0;
		k=0;
		while(time<max_time)
		{
			for(int i=0;i<n;i++)
			{
				if(array[i][3]<=time)//arrival time
				{
					if(array[i][2]==0)//remaining
						continue;
					else if(array[i][2]>=TQ)
					{
						System.out.print("\n-------------\nTime : "+time);
						array[i][4]=time-array[i][5];
						for(int j=0;j<TQ;j++)
						{
							System.out.print("\nP"+array[i][0]);
							gantt_chart[count++]=array[i][0];
							array[i][2]=array[i][2]-1;
							array[i][5]++;
							time++;
						}
						System.out.print("\nTime : "+time);
					}
					else
					{
						System.out.print("\n-------------\nTime : "+time);
						k=array[i][2];
						array[i][4]=time-array[i][5];
						for(int j=0;j<k;j++)
						{
							System.out.print("\nP"+array[i][0]);
							gantt_chart[count++]=array[i][0];
							array[i][2]=array[i][2]-1;
							array[i][5]++;
							time++;
						}
						System.out.print("\nTime : "+time);
					}
				}
			}
		}
		float awt=0;
		for(int i=0;i<n;i++)
			array[i][4]=array[i][4]-array[i][3];
		System.out.print("\n=============");
		System.out.print("\nWaiting time");
		System.out.print("\n=============");
		for(int i=0;i<n;i++)
		{
			System.out.print("\n   P"+(i+1)+" "+array[i][4]);
			awt=awt+array[i][4];
		}
		System.out.print("\n=============");
		System.out.print("\n\nAWT : "+(awt/n));
		
		System.out.print("\n-------------");
		System.out.print("\nGantt Chart is : \n");
		for(int i=0;i<count;i++)
			System.out.print(" "+gantt_chart[i]);
		System.out.println();
			
	}
}
/*
OUTPUT : 

Enter the Time Quantum : 4

Enter the Number of Processes : 3
Enter the  Burst Time  (BT) of Process  1 : 24
Enter the Arrival Time (AT) of Process  1 : 0
Enter the  Burst Time  (BT) of Process  2 : 3
Enter the Arrival Time (AT) of Process  2 : 0
Enter the  Burst Time  (BT) of Process  3 : 3
Enter the Arrival Time (AT) of Process  3 : 0

Maximum Time required is : 30
--------------------
PNo.    BT     AT
--------------------
1	24	0
2	3	0
3	3	0
--------------------

-------------
Time : 0
P1
P1
P1
P1
Time : 4
-------------
Time : 4
P2
P2
P2
Time : 7
-------------
Time : 7
P3
P3
P3
Time : 10
-------------
Time : 10
P1
P1
P1
P1
Time : 14
-------------
Time : 14
P1
P1
P1
P1
Time : 18
-------------
Time : 18
P1
P1
P1
P1
Time : 22
-------------
Time : 22
P1
P1
P1
P1
Time : 26
-------------
Time : 26
P1
P1
P1
P1
Time : 30
=============
Waiting time
=============
   P1 6
   P2 4
   P3 7
=============

AWT : 5.6666665
-------------
Gantt Chart is : 
 1 1 1 1 2 2 2 3 3 3 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1

*/
