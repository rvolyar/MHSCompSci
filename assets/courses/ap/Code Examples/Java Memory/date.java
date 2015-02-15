public class date extends Object
{
	private int day=01,  month=12,  year=1900;

	public date ( )
	{
	}
	
	public date(date d)
	{
	this.setMonth(d.getMonth());
	// could also say:  this.month = d.month;
	this.setYear(d.getYear());
	this.setDay(d.getDay());
	}

	public date (int m, int d, int y)
	{
		setMonth(m);
		setDay(d);
		setYear(y);
	}

	public boolean setMonth (int m)
	{
		// other code here
		if(m < 1 || m > 12)
			return false;
		 else
		 	{
			month = m;
			return true;
			} 
			


	}

	public boolean setDay (int d)
	{
		// other code here
		day = d;
		return true;
	}

	public boolean setYear (int y)
	{
		// other code here
		year = y;
		return true;
	}

	public int getMonth( )
	{
		// code here
		return month;
	}

	public int getDay( )
	{
		// code here
		return day;
	}

	public int getYear( )
	{
		// code here
		return year;
	}

	


	
	public String toString( )
	{
		// code to return the date in "mm-dd-yyyy" format
		String s = Integer.toString(month) + "-" +
			Integer.toString(year);
		return s;
	}
}

