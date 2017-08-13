
public class FibonacciRecursion {
	
	public static int printFiboRec(int n){
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else if(n==2)
			return 1;
		else
			return printFiboRec(n-1) + printFiboRec(n-2);
	}

	public static void main(String[] args) {
		
		for(int i = 0 ; i <=10 ; i++)
			System.out.print(printFiboRec(i) + " ");
		// TODO Auto-generated method stub

	}

}
