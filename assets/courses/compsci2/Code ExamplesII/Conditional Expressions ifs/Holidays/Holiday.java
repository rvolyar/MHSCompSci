/** 
 * Holiday.java
 *
 * Title:			if lecture holiday project
 * Description:		determine the date on which several holidays fall in a given year
 * @author			DAVE
 * @version			
 */
 
 /* OUTPUT:
 Labor Day -- September 2
 Election Day -- November 5
 Thanksgiving -- November 28
 Memorial Day -- May 27

*/

import java.lang.String;
import javax.swing.JOptionPane;

public class Holiday
{
	public Holiday()
	{
	}
	
	static final int daysInMonth[] = 
	{
    31, 28, 31, 30, 31, 30,
    31, 31, 30, 31, 30, 31
	};

	// Days from the beginning of the year
	//   to the beginning of the month:

	static final int daysToMonth[] = 
	{
	     0,  31,  59,  90, 120, 151,
	   181, 212, 243, 273, 304, 334
	};

	static final String dayName[] =
	{
	    "Sunday",
	    "Monday",
	    "Tuesday",
	    "Wednesday",
	    "Thursday",
	    "Friday",
	    "Saturday"
	};

	static final int DAY0 = 1; // Day of week for 01-01-1900 is Monday = 1.


	// Main entry point
	static public void main(String[] args)
	{
		new Holiday();
		
		int day, year;
	    int weekday;
	    String input;

	    input = JOptionPane.showInputDialog("Enter Year: ");
		year = Integer.parseInt(input);
	    if (year < 1900 || year >= 3000) {
	        System.out.println("Invalid input.");
	        System.exit(0);
	    }

	    // Labor Day -- first Monday in September:

	    weekday = DayOfWeek(9, 1, year);   // Day of week for 9/1.
	    day = (8 - weekday) % 7 + 1;
		/***
	    If this modulo arithmetic appears too tricky, iterative solutions
	    can be used for all holidays:

	    day = 1;                   // Start from the first of the month.
	    while (weekday % 7 != 1) { // While weekday is not Monday...
	       weekday++;              //   ..increment weekday and the date
	       day++;
	    }
		***/
	    System.out.println("Labor Day -- September " + day );
	
		// Election Day -- first Tuesday after first Monday in November:

	    weekday = DayOfWeek(11, 1, year);   // Day of week for 11/1.
	    day = (8 - weekday) % 7 + 1;        // First Monday
	    day++;
	    System.out.println("Election Day -- November " + day );

	    // Thanksgiving -- fourth Thursday in November:

	    weekday = DayOfWeek(11, 1, year);   // Day of week for 11/1.
	    day = (11 - weekday) % 7 + 1;       // First Thursday
	    day += 21;        // 1st Thursday + 3 weeks.

	    System.out.println("Thanksgiving -- November " + day );

	    // Memorial Day -- last Monday in May:

	    weekday = DayOfWeek(5, 31, year);   // Day of week for 5/31.
	    day = 31 - (weekday + 6) % 7;       // Last Monday
	    System.out.println("Memorial Day -- May " + day );
	
	 System.exit(0);
	}
	
	////
	static boolean leapYear (int year)
	// "year" must be between 1900 and 2999.
	// Returns true if "year" is a leap year.

	{
        //  true, if year is divisible by 4, and ...
        //    ... either not divisible by 100, or divisible by 400. 

    	return (year % 4 == 0 &&
                 (year % 100 != 0 || year % 400 == 0));
	}
	
	////
	static boolean ValidDate (int month, int day, int year)

	// returns true if month-day-year is a valid date between
	//   01-01-1900 and 12-31-2999.

	{
	    boolean valid = false;  // First assume the date is invalid.
	    int days;

	    // If year and month have valid values:
	    if (year >= 1900 && year <= 2999 &&
	                                month >= 1 && month <= 12) {

	        // Get the number of days in this month from the table:
	        days = daysInMonth[month-1]; // (-1, because the indices
	                                     //   of an array start from 0.)

	        // If February of a leap year -- increment the number
	        //   of days in this month:
	        if (month == 2 && leapYear(year))
	            days++;

	        // Check that the given day is within the range.
	        //   If so, set valid to true:
	        if (day >= 1 && day <= days)
	            valid = true;
	    }

	    return valid;
	}

	/////
	static long DaysSince1900 (int month, int day, int year)

	// Returns the number of days elapsed since 01-01-1900
	//  to month-day-year

	{
	    long days;

	    // Calculate days to 01-01 of this year with correction for
	    //   all the previous leap years:
	    if (year == 1900)
	        days = 0;
	    else
	        days = (long)year - (long)1900 * 365
	           + (year - 1901) / 4       // +1 for each 4th year
	           - (year - 1901) / 100     // -1 for each 100th year
	           + (year - 1601) / 400;    // +1 for each 400th year,
	                                     //     starting at 2000

	    // Add days for previous months with correction for
	    //   the current leap year:
	    days += daysToMonth[month-1];
	    if (leapYear(year) && month > 2) days++;

	    // Add days since the beginning of the month:
	    days += day - 1;

	    return days;
	}

	//////
	static int DayOfWeek (int month, int day, int year)

	// Returns the day of the week for a given date:
	//   0 -- Sunday, 1 -- Monday, etc.

	{
	    return (int)((DAY0 + DaysSince1900(month, day, year)) % 7);
	}

}
