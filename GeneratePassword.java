import java.util.Scanner;


public class GeneratePassword {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter the length");
		int n=scr.nextInt();
		char a[] = new char[n];
		generate(0,0,a);	
	}
	
	public static void generate(int m,int n,char a[])
	{
		int i;
		int j;
		if(n==a.length-1) 
		{ 
			for(i=m;i<=9;i++) 
			{ 
				a[n]=(char)('0'+i); 
					for(j=0; j<a.length; j++) 
						System.out.print(a[j]);
					System.out.println();
			} 
		} 
		else 
		{ 
			for(i=m;i<10-a.length+n+1;i++) 
			{ 
				a[n]=(char) ('0'+i); 
				generate(i+1,n+1,a); 
			} 
		} 
	} 

}

	
