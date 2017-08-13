/*
 * Find no. of days between Jan1st and entered date
 */


public class DateDifference1 
{
	public static void main(String[] args) 
	{
		int normal[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int leap[] = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
		// Start date is always 1st of Jan and the year is same as the input year.
		// Hence here its 1/1/2016
		//2016 is leap year.

		int year = 2016;
		int month = 7;
		int day = 30;

		int numberOfDays = 0;
		if (month == 1) 
		{
			System.out.println("Number of days: " + day);
		} 
		else
		{
			for (int i = 1; i < month; i++) 
			{
				if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) 
				{
					numberOfDays = numberOfDays + leap[i];
				} 
				else 
				{
					numberOfDays = numberOfDays + normal[i];
				}
			}
			numberOfDays = numberOfDays + day;
			System.out.println("Number of days: " + numberOfDays);
		}

	}
}