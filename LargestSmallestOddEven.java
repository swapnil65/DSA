/*
 * Take a series of integers as input till a zero is entered. Among these given integers, 
 * find the maximum of the odd numbers and the minimum of the even integers (not including zero) and print them.
 */
public class LargestSmallestOddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a [] = {12,13,14,18,56,57,88};
        int maxOdd=Integer.MIN_VALUE;
        int minEven=Integer.MAX_VALUE;
       
        for(int i=0;i<a.length;i++)
        {
        	if(a[i]%2==0)
        	{
        		if(a[i]<minEven)
        		{
        			minEven=a[i];
        		}
        	}
        	else
        	{
        		if(maxOdd<a[i])
        		{
        			maxOdd=a[i];
        		}
        	}
        }
        System.out.println(minEven+" "+maxOdd);
	}

}
