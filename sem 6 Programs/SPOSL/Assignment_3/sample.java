/*
 *	Date    : 29-Dec-2018
 *	Program : FIFO Paging
 *	Name    : Sameer Rathod
 *	Class   : TE B
 * 	Roll No : 58
 */
import java.io.*;
import java.util.*;

class Paging
{
	public static void main(String args[])throws IOException
	{
		int frame[]=new int[3]; 	//array of pg frame
		for(int i=0;i<3;i++)
			frame[i]=-1;
			
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter the length of reference string : ");	//accepting reference frame
		int n=sc.nextInt();	
		int reference[]=new int[30];
		
		System.out.print("\nEnter the reference the string : ");
		for(int i=0;i<n;i++)
			reference[i]=sc.nextInt();
			
		
		/*for(int i=0;i<n;i++)
			System.out.println(reference[i]);*/
			
		int check;
		int k;
		check=0;
		k=0;
		for(int i=0;i<n;i++)
		{
			System.out.print("\n------------------------");
			check=isHit(frame,reference[i]);
			
			if(check==1)
				System.out.print("\nHIT");
				
			else
			{
				frame[k]=reference[i];
				k=(k+1)%3;
				
				System.out.print("\nReplaced");
				System.out.println();				
				for(int j=0;j<3;j++)
					System.out.print(frame[j]+"\t");
			}	
		}
	}
	
	public static int isHit(int frame[],int x)		//checking whether hit or not 
	{
		for(int i=0;i<3;i++)
			if(frame[i]==x)
				return 1;
		return -1;
	}
	
}
