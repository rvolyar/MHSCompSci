public class AirFlight
{
	private String Destination;
	private int flightNum;
	
	public AirFlight(String s, int num)
	{
		Destination = s;
		flightNum = num;
	}
		
	public String getDestination()
	{
		return Destination;
	}
	
	public int getFlightNum()
	{
		return flightNum;
	}
	
	public String toString()
	{
		return Destination + " flight #" + flightNum;
	}
}	
