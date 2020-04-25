/*
 * Program : Fork System Call
 * Name    : Sameer Rathod
 * Class   : TE B
 * RNo.    : 58
 */
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<wait.h>
#include<sys/types.h>
void parent()
{
	printf("\nParents task\n");
	printf("\nMy child died that's why I am executing\n");
}
int main()
{
	pid_t pid,pid1;
    int status;
	printf("\nParent Executing");
	pid=fork();
	if(pid==0)
	{
		printf("\nChild created : ");
		printf("%d\n",pid);
		sleep(10);
		printf("\nChild after sleep : ");
		execlp("\n/bin/ls","ls",NULL);
		exit(0);	
	}
	else
	{
		printf("\nParent again executing");
		printf("\n%d ",pid);
		pid1=wait(&status);
        printf("\n%d ",pid1);
        printf("\nMy Child process terminated");
		parent();
		printf("\nParent after child exit");
		printf("\nParent Terminated");
		exit(0);	
	}
}
/*
OUTPUT : 
unix@unix-HP-280-G1-MT:~/Downloads$ gcc fork.c
unix@unix-HP-280-G1-MT:~/Downloads$ ./a.out

Parent Executing
Parent again executing
Parent Executing
Child created : 0

Child after sleep : 29698 
29698 
My Child process terminated
Parents task

My child died that's why I am executing

Parent after child exit
Parent Terminatedunix@unix-HP-280-G1-MT:~/Downloads$ 
*/
	
