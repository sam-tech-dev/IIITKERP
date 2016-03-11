package utilities;

import java.util.Scanner;
 
public class StringPermutation 
{
	static String username[]=new String[6];
	static int count=0;
	
    static void permute(int k,String...a) //send value of k as 0 initially
    {
        if (k == a.length) 
        {
        	
            for (int i = 0; i < a.length; i++) 
            {
                //System.out.print(a[i]);
            	if(i==0){username[count]=a[i];}
            	else{username[count]=username[count]+a[i];}
              }
            //System.out.println();
            count++;
        } 
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                String temp = a[k];
                a[k] = a[i];
                a[i] = temp;
 
                permute(k+1,a);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }
 
    public static void main(String args[]) 
    {
        
        Scanner sc = new Scanner(System.in);
        //System.out.println("Enter the length of list: ");
        //int N = sc.nextInt();
        //String[] sequence = new String[N];
        //System.out.println("enter firstname,lastname and id");
 
        //for (int i = 0; i < N; i++)
        	//sequence[i]=sc.next();
        
          System.out.println("\nThe permuted sequences are: ");
        permute(0,"arushi","gupta","1012");
        for(int i=0;i<6;i++){
        	
        		System.out.print(username[i]+"...");
        	
        	System.out.println();
        	
        }
 
        sc.close();
    }
}