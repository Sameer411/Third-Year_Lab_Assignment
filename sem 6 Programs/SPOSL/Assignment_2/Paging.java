/*
 * Program : Page Replacement FIFO LRU Optimal
 * Name    : Sameer Rathod
 * Class   : TE B
 * RNo.    : 58
 */

import java.io.*;
import java.util.*;

class Paging
{
	public static void main(String args[])throws IOException
	{
		int hit=0;
		int frame[]=new int[3]; 	//array of pg frame
		for(int i=0;i<3;i++)
			frame[i]=-1;

		Scanner sc=new Scanner(System.in);
		System.out.print("\n=========================");
		System.out.print("\n\tPAGING");
		System.out.print("\n=========================");
		System.out.print("\n1.FIFO Paging\n2.LRU Paging\n3.Optimal Paging \n4.Exit");		//choice for cases
		System.out.print("\n=========================");
		System.out.print("\n\nEnter your choice : ");
		int choice=sc.nextInt();
		while(choice!=1 && choice!=2 && choice!=3 && choice!=4)
		{
			System.out.print("\nEnter valid choice !!!");
			choice=sc.nextInt();
		}
		System.out.print("\nEnter the length of reference string : ");	//accepting length of reference string
		int n=sc.nextInt();	
		int reference[]=new int[30];
		
		System.out.print("\nEnter the reference the string : ");	//accepting reference string
		for(int i=0;i<n;i++)
			reference[i]=sc.nextInt();
				
		int check=0;
		int k=0,h=0,z=0;
		int temp[]=new int[3];
		int flag;
		
		switch(choice)
		{
			case 1:	System.out.print("\n-------------------------------------------");
				System.out.print("\n\t\tFIFO Paging");
				System.out.print("\n-------------------------------------------");
				for(int i=0;i<n;i++)		//FIFO Paging
				{
					check=isHit(frame,reference[i]);
					
					if(check==1)
					{
						System.out.print("\n--------------------\t\tHIT");
						hit++;
					}		
					else
					{
						frame[k]=reference[i];
						k=(k+1)%3;
						System.out.println();
						for(int j=0;j<3;j++)
							System.out.print(frame[j]+"\t");
							
						System.out.print("\tReplaced");
					}	
				}
				System.out.print("\n-------------------------------------------");
				break;
			
			case 2:	System.out.print("\n-------------------------------------------");
				System.out.print("\n\t\tLRU Paging");
				System.out.print("\n-------------------------------------------");
				while(z<3)			//LRU Paging
				{
					check=isHit(frame,reference[h]);
					if(check==1)
					{
						System.out.print("\n----------------------\t\tHIT");
						h++;
						hit++;
					}
					if(check==-1)
					{
						frame[z]=reference[h];
						z++;
						h++;
						check=0;
						System.out.println();
						for(int j=0;j<3;j++)
							System.out.print(frame[j]+"\t");
							
						System.out.print("\tReplaced");
					}	
				}
				z=h;
				
				for(int i=z;i<n;i++)
				{
					check=isHit(frame,reference[i]);
					
					if(check==1)
					{
						System.out.print("\n--------------------\t\tHIT");
						hit++;
					}
						
					else
					{
						k=i-1;
						flag=0;
						h=-1;
						
						for(int j=0;j<3;j++)
							temp[j]=frame[j];
										
						while(k>=0)
						{
							if(reference[k]==temp[0]||reference[k]==temp[1]||reference[k]==temp[2])
							{
								for(int m=0;m<3;m++)
								{
									if(flag==2)
										break;
									if(temp[m]==reference[k])
									{
										temp[m]=-1;
										flag++;
									}
								}
								k--;
							}
							if(flag==2)
								break;
						}	
						
						k=0;
						while(h==-1 && k<3)
						{
							if(temp[k]!=-1)
							{
								h=k;
								break;
							}
							k++;
						}
						
						frame[h]=reference[i];
						System.out.println();
						for(int j=0;j<3;j++)
							System.out.print(frame[j]+"\t");
			
						System.out.print("\tReplaced");
					}//else	
				}//for
				System.out.print("\n-------------------------------------------");
				break;
				
			case 3:	System.out.print("\n-------------------------------------------");
				System.out.print("\n\t\tOptimal Paging");
				System.out.print("\n-------------------------------------------");
				while(z<3)			
				{
					
					check=isHit(frame,reference[h]);
					if(check==1)
					{
						System.out.print("\n--------------------\t\tHIT");
						h++;
						hit++;
					}
					if(check==-1)
					{
						frame[z]=reference[h];
						z++;
						h++;
						check=0;
						
							System.out.println();				
							for(int j=0;j<3;j++)
								System.out.print(frame[j]+"\t");
								
							System.out.print("\tReplaced");
					}	
				}
				z=h;
				
				for(int i=z;i<n;i++)
				{
					check=isHit(frame,reference[i]);
					
					if(check==1)
					{
						System.out.print("\n--------------------\t\tHIT");
						hit++;
					}
						
					else
					{
						k=i+1;
						flag=0;
						h=-1;
						
						for(int j=0;j<3;j++)
							temp[j]=frame[j];
										
						while(k>=0 && k<n)
						{
							if(reference[k]==temp[0]||reference[k]==temp[1]||reference[k]==temp[2])
							{
								for(int m=0;m<3;m++)
								{
									if(flag==2)
										break;
									if(temp[m]==reference[k])
									{
										temp[m]=-1;
										flag++;
									}
								}	
							}
							k++;
							if(flag==2)
								break;
						}	
						
						k=0;
						while(h==-1 && k<3)
						{
							if(temp[k]!=-1)
							{
								h=k;
								break;
							}
							k++;
						}
						
						frame[h]=reference[i];
					
						System.out.println();				
						for(int j=0;j<3;j++)
							System.out.print(frame[j]+"\t");
							
						System.out.print("\tReplaced");
					}	
				}
				System.out.print("\n-------------------------------------------");
				break;
				
			case 4: System.exit(0);

		}//switch
		System.out.println();
		double ratio=0.00,dbl_n=n,dbl_hit=hit;
		ratio=dbl_hit/dbl_n;
		System.out.println("Hit Ratio  : "+ratio);
		System.out.println("Miss Ratio : "+(1-ratio));
	}//main
	
	public static int isHit(int frame[],int x)
	{
		for(int i=0;i<3;i++)
			if(frame[i]==x)
				return 1;
		return -1;
	}
}

/*
OUTPUT : 
sameerrathod@sameer-rathod:~/Desktop/SPOL/SPOSL/Assignment_2$ java Paging

=========================
	PAGING
=========================
1.FIFO Paging
2.LRU Paging
3.Optimal Paging 
4.Exit
=========================

Enter your choice : 1

Enter the length of reference string : 6

Enter the reference the string : 5
8
2
1
0
4

-------------------------------------------
		FIFO Paging
-------------------------------------------
5	-1	-1		Replaced
5	8	-1		Replaced
5	8	2		Replaced
1	8	2		Replaced
1	0	2		Replaced
1	0	4		Replaced
-------------------------------------------
Hit Ratio  : 0.0
Miss Ratio : 1.0
*/

