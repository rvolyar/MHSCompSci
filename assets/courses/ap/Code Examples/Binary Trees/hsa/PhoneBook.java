package hsa;

public class PhoneBook
{
    int numEntries;
    String [] names;
    String [] phoneNumbers;

    public PhoneBook ()
    {
	numEntries = 0;
	names = new String [100];
	phoneNumbers = new String [100];
    } // PhoneBook constructor


    public void add (String name, String phoneNumber)
    {
	names [numEntries] = name;
	phoneNumbers [numEntries] = phoneNumber;
	numEntries++;
    } // add method


    public String lookUp (String name)
    {
	for (int cnt = 0 ; cnt < numEntries ; cnt++)
	{
	    if (name.equals (names [cnt]))
	    {
		return phoneNumbers [cnt];
	    }
	}

	return "";
    } // lookUp method


    public void remove (String name)
    {
	for (int cnt = 0 ; cnt < numEntries ; cnt++)
	{
	    if (name.equals (names [cnt]))
	    {
		// Delete the entry
		for (int cnt1 = cnt + 1 ; cnt++ < numEntries ; cnt1++)
		{
		    names [cnt1 - 1] = names [cnt1];
		    phoneNumbers [cnt1 - 1] = phoneNumbers [cnt1];
		}
		return;
	    }
	}
    } // lookUp method
} // PhoneBook class

