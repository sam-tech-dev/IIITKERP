package utilities;

import java.util.Scanner;
/**
 * @author Arushi
 *
 */
 
public class StringPermutation 
{
	static String username[]=new String[20];
	static int count=0;
	static void callAll(String...s){
		permute(0,s);
		placeDots(s);
		breakString(s);
	}
	
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
    public static void placeDots(String...s){
    	//System.out.println("hello");
    	for(int i=0;i<s.length-1;i++){
    		for(int j=i+1;j<s.length;j++){
    			username[count++]=s[i]+"."+s[j];
    			username[count++]=s[j]+"."+s[i];
    		}
    		
    	}
    	
    	
    }
    public static void breakString(String...s){
    	String s1[]=new String[s.length-1];
    	for(int i=0;i<s1.length;i++){
    		s1[i]=String.valueOf(s[i].charAt(0));
    		//System.out.println(s1[i]);
    	}
    	//System.out.println(s1.length);
    	for(int i=0;i<s1.length;i++){
    		for(int j=0;j<s.length;j++){
    			if(i!=j){
    			username[count++]=s1[i]+s[j];
    			if(j!=s.length-1)
    			username[count++]=s1[i]+s[j]+s[j+1];
    			}
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
          
          callAll("arushi","gupta","1012");
       // permute(0,"arushi","gupta","1012");
       // System.out.println(count);
       //placedots("arushi","gupta","1012");
        
        
        for(int i=0;i<count;i++){
        	
        		System.out.print(username[i]);
        	
        	System.out.println();
        	
        }
 
        sc.close();
    }
}