/*
 * In 1-9 keypad one key is not working. If some one enters a password then not working key will not be entered. 
 * You have given expected password and entered password. Check that entered password is valid or not 
 * E.x.: entered 164, expected 18684 (you need to take care as when u enter 18684 and 164 only both will be taken 
 * as 164 input)
 */
public class Keypad 
{
	public static void main(String[] args) 
	{
	  //TODO Auto-generated method stub
      String actual="64";
      String expected="886488";
      System.out.println(checkValid(actual,expected));
	}
	public static boolean checkValid(String actual, String expected)
	{
		char faultKey = '\0'; //initialized to null character
		int i = 0, j = 0;
		for(;i<actual.length() && j < expected.length();j++)
		{
			if(actual.charAt(i)!=expected.charAt(j))
			{
				if(faultKey == '\0')
				{
					faultKey = expected.charAt(j);
				}
				else
				{
					if(faultKey != expected.charAt(i))
							return false;
				}
				i--;
			}
			else if(faultKey != '\0' && actual.charAt(i) == faultKey) 
			{
				return false;
			}
			i++;
		}
		while(j<expected.length() && expected.charAt(j) == faultKey)
		{
			j++;
		}
		System.out.println(faultKey);
		return (i==actual.length() && j == expected.length())? true:false;
	}
}
