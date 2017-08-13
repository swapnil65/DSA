/*
 * Let the user enter a decimal number. The range allowed is 0.0001 to 0.9999.
 * Only four decimal places are allowed. The output should be an irreducible fraction. 
 * E.g.: If the user enters 0.35, the irreducible fraction will be 7/20.
 */

public class IrreducibleFraction
{
	public static String getIrreducibleFraction(double num)
	{
		int n = (int) (num * 10000);
		int d = 10000;

		// get greatest common divisor
		int gcd = getGCD(n, d);

		return ((n / gcd) + "/" + (d / gcd));
	}

	private static int getGCD(int a, int b)
	{
		if (a == 0)
			return b;

		while (a != b)
		{
			if (a > b)
				a = a - b;
			else if (b > a)
				b = b - a;
			else
				return a;
		}
		return a;
	}

	public static void main(String args[])
	{
		System.out.println(getIrreducibleFraction(0.35));
	}
}