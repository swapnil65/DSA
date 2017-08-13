import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Colorful Number: 
A number can be broken into different sub-sequence parts. Suppose, a number 3245 can be broken into parts 
like 3 2 4 5 32 24 45 324 245. And this number is a colorful number, since product of every digit of a sub-sequence 
are different. That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40 
But 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12. 
You have to write a function that tells if the given number is a colorful number or not.
 */

public class ColorfulNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number=0;
		@SuppressWarnings("resource")
		Scanner scr =new Scanner(System.in);
		System.out.println("Enter the number");
		number =scr.nextInt();
		boolean color=isColorful(number);
		if(color==true)
		{
			System.out.println("Number is colorful");
		}
		else
		{
			System.out.println("Number is not colorful");
		}

}
	public static boolean isColorful(int number)
	{
		if(number < 10) return true;
		
		String colorString = String.valueOf(number);
		int length = colorString.length();
		
		List<Integer> colorMap = new ArrayList<Integer>();
		
		for(int i = 1; i < length; i++)
		{
			for (int j = 0; j+i <= length; j++)
			{
				String sub = colorString.substring(j, j+i);
				System.out.println(sub);
				int product = getProduct(Integer.parseInt(sub));
				if(colorMap.contains(product))
				{
					return false;
				}
				else
				{
					colorMap.add(product);
				}
			}
		}
		return true;
	}

	private static int getProduct(int digits) {
		if(digits < 10) return digits;
		int num = digits;
		int product = 1;
		while(num > 0){
			product = product * (num % 10);
			num = num / 10;
		}
		return product;
	}
}
