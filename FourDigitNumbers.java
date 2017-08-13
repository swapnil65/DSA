/*
 * Generate all possible unique 4 digit numbers such that no two adjacent numbers are the same and any number
 * starting with 4 should end with a 4 . e.g. 1234 , 1232 are both correct but 1223 is not .
 */


public class FourDigitNumbers {

	private static String digits = "0123456789";
	private static int numLength;
	private static int count=0;
	//private static char [] disallowed={'3','7','8'};

	private static void printPhoneNums(String prefix)
	{
		
		if(prefix.length() == numLength)
		{
		
			System.out.println(prefix+" "+(++count));
			return;
		}
		
		for(int i = 0; i < digits.length(); i++)
		{
			if(prefix.length() > 0)
			{
				if(prefix.charAt(prefix.length()-1) == digits.charAt(i))
					continue;
				if(i==numLength && digits.charAt(i) == '4' && prefix.charAt(0) != '4')
					continue;
				//if(digits.charAt(i) == disallowed[0] || digits.charAt(i) == disallowed[1] ||digits.charAt(i) == disallowed[2])
			       // continue;
			}
			printPhoneNums(prefix + digits.charAt(i));
		}
	}
	public static void printPhoneNums(int length)
	{
		numLength = length;
		
		printPhoneNums("");
	}
	public static void main(String[] args) 
	{
		printPhoneNums(4);

	}
}
