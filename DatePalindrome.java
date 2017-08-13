/*
 * Write a program to generate all palindrome dates by taking the beginning and the 
 * ending dates as an input from the user. The format of the date is given as MMDDYYYY.
 */


import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatePalindrome {

	public static void main(String[] args) {

		String startDate = "01012000";
		String endDate = "12122090";
		generateDates(startDate, endDate);
	}

	public static void generateDates(String startDate, String endDate) {

		Calendar calStart = new GregorianCalendar(Integer.parseInt(startDate.substring(4)), Integer.parseInt(startDate
				.substring(2, 4)) - 1, Integer.parseInt(startDate.substring(0, 2)));
		Calendar calEnd = new GregorianCalendar(Integer.parseInt(endDate.substring(4)), Integer.parseInt(endDate
				.substring(2, 4)) - 1, Integer.parseInt(endDate.substring(0, 2)));

		for (int i = 1; i <= 12; i++)
		{
			String month = String.valueOf(i);
			if (month.length() == 1) 
			{
				month = "0" + month;
			}
			for (int j = 1; j <= 31; j++) 
			{
				String day = String.valueOf(j);
				if (day.length() == 1) 
				{
					day = "0" + day;
				}
				String monthDay = month + day;
				String year = new StringBuilder(monthDay).reverse().toString();
				Calendar currentDate = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
				if (Integer.parseInt(day) > checkMaxDays(currentDate)) 
				{
					continue;
				}

				if (currentDate.getTimeInMillis() < calStart.getTimeInMillis()
						|| currentDate.getTimeInMillis() > calEnd.getTimeInMillis()) 
				{
					continue;
				}
				System.out.println(monthDay + year);
			}

		}
	}

	private static int checkMaxDays(Calendar currentDate) {

		return currentDate.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}
