import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class GenerateCombinations {

	private static HashSet<String> hs = new HashSet<String>();
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter the password");
		String t = scr.next();
		permute(t.toCharArray(),0);
		Iterator<String> itr = hs.iterator();
    	while(itr.hasNext())
    	{
    		String temp=itr.next().toString();
    		if(!temp.equals(t))
    		System.out.println(temp);
    	}     
	}
	public static void permute(char[] s,int i) 
	{   
	
	    
	    if (i == s.length)
	    {
	    	String tempStr = "";
	    	for(int k=0;k<s.length;k++)
	    	{
	    		tempStr+=s[k];
	    	}
	    	hs.add(tempStr);  	
	    }
        
	    else 
	    	for (int j = i; j < s.length;j++) 
	    	{
	    		char temp=s[i];
	    		s[i]=s[j];
	    		s[j]=temp;
	    		
	    		permute(s,i+1);
	    		
	    		char temp1=s[i];
	    		s[i]=s[j];
	    		s[j]=temp1;
	    		
	         }
	}
}
