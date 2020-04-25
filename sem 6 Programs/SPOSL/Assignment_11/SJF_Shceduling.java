/*
 * Program : SJF
 * Name    : Sameer Rathod
 * Class   : TE B
 * RNo.    : 58
 */
import java.util.Scanner;

class SJF_Shceduling{
	public static void main(String args[])
	{
		int process[] = new int[10];
		int ptime[] = new int[10];
		int wtime[] = new int[10];
		int temp, n, total=0;
		float avg=0;
		Scanner get = new Scanner(System.in);

		System.out.println("Enter Number of Processes:");
		n = get.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Process "+(i+1)+" ID: ");
			process[i] = get.nextInt();
			System.out.println("Enter Process "+(i+1)+" Burst Time: ");
			ptime[i] = get.nextInt();
		}

		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++) 			
			{ 				
				if(ptime[i]>ptime[j])
				{
					temp = ptime[i];
					ptime[i] = ptime[j];
					ptime[j] = temp;
					temp = process[i];
					process[i] = process[j];
					process[j] = temp;
				}
			}
		}
wtime[0] = 0;
        for(int i=1;i<n;i++)
        {
            wtime[i] = wtime[i-1]+ptime[i-1];
            total = total + wtime[i];
        }
        avg = (float)total/n;
        System.out.println("P_ID P_TIME W_TIME");
        for(int i=0;i<n;i++)
        {
            System.out.println(process[i]+"\t"+ptime[i]+"\t"+wtime[i]);
        }
        System.out.println("Total Waiting Time: "+total);
        System.out.println("Average Waiting Time: "+avg);
    }
}
/*

Enter Number of Processes:
5
Enter Process 1 ID: 
2
Enter Process 1 Burst Time: 
2
Enter Process 2 ID: 
1
Enter Process 2 Burst Time: 
1
Enter Process 3 ID: 
4
Enter Process 3 Burst Time: 
8
Enter Process 4 ID: 
2
Enter Process 4 Burst Time: 
4
Enter Process 5 ID: 
3
Enter Process 5 Burst Time: 
5
P_ID P_TIME W_TIME
1	1	0
2	2	1
2	4	3
3	5	7
4	8	12
Total Waiting Time: 23
Average Waiting Time: 4.6

*/
