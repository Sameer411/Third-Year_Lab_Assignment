
/*Assignment number 2: Write a program for error detection 
 and correction for 7/8 bits ASCII codes using CRC */

#include<iostream>
using namespace std;

int main()
{
        int i;
        
        // data
        int datasize;
        cout<<"\n Enter size of data:";
        cin>>datasize;
        
        int data[30];
        cout<<"\n Enter data:";
        for(i=0;i<datasize;i++)
        {
                cin>>data[i];
        }
        
 
        
        // divisor
        int divisorsize;
        cout<<"\n Enter divisor size: ";
        cin>>divisorsize;
        
        int divisor[30];
        cout<<"\n Enter divisior =";
        for(i=0;i<divisorsize;i++)
        {
                cin>>divisor[i];
        }
        
        
        //append i.e insert zeros
        int z=datasize-1;
        cout<<"\n no of zeros to be appended ="<<z;
        
        
        // newdata
        for(i=datasize;i<datasize+z;i++)
        {
                data[i]=0;
        }
        
        int newdata[20];
        for(i=0;i<20;i++)
        {
                newdata[i]=data[i];
        }
        
        cout<<"\n Newdata =";
        for(i=0;i<datasize+z;i++)
        {
                cout<<newdata[i];
        }       
                               
}              
                
/**************OUTPUT********************

 enter size of data =8

 enter data =1 0 1 0 1 1 1 0  

 enter divisor size =4

 enter divisior =1 0 0 1

 no of zeros to be appended =7
 newdata =101011100000000
 
*/                
