import java.lang.String;

// MY STRING CLASS
	public class myString extends Object
	{
		// variables available only to class "CalcIt"
		private final int maxLength;
		private String theString;

		// class constructor called when an Instance of a class
		// is created
		public myString(String initValue)
		{
			// set the initial values 
			maxLength = 21;
			setTheString(initValue);
			
		}
	
		// set or modifier method
		public void setTheString(String strIn)
		{
			if(strIn.length() > maxLength)
					System.out.println("CAN NOT SET STRING TOO LONG");
				else
					theString = strIn;
					
			return ;
		}
		
		// return the length of theString
		public int theLength()
		{
			return theString.length();
		}
		
		// return the max length
		public int getMaxLength()
		{
			return maxLength;
		}
		
		// convert to a number
		public int getNumber()
		{
			int n = Integer.parseInt(theString);
			return n;
		}
		
		// compare 2 instances of mySring class
		// case matters
		public boolean CompMyString(myString ms)
		{
			boolean TF = true;
			
			if(!theString.equals(ms))
				{
					TF = false;
				} 
			
			return TF;
		}
		
		// my tostring
		public String toString()
		{
			return  "return of my toString: " + theString;		
		}
	
	}
	