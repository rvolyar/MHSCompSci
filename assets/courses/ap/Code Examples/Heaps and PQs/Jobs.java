// The "Jobs" class.
import hsa.Stdin;

public class Jobs
{
    public static void main (String[] args)
    {
	String command;
	String jobDescription;
	String jobPriority;
	int jobPriorityNumber;
	PriorityString job;
	PriorityQueue jobQueue;

	jobQueue = new ArrayPriorityQueue ();

	System.out.println ("Enter command");
	System.out.println ("  s - service request");
	System.out.println ("  j - get next job");
	System.out.println ("  q - quit");

	// Obtain a command from the user.
	System.out.print ("Command: ");
	command = Stdin.readLine ();

	while (!command.equalsIgnoreCase ("q"))
	{
	    if (command.equalsIgnoreCase ("s"))
	    {
		// Obtain job description.
		System.out.print ("Enter job description: ");
		jobDescription = Stdin.readLine ();

		// Obtain job priority.
		while (true)
		{
		    System.out.println ("Set job priority");
		    System.out.println ("  f - fast track");
		    System.out.println ("  n - normal");
		    System.out.println ("  e - economy");
		    System.out.print ("Enter job priority: ");
		    jobPriority = Stdin.readLine ();
		    if (jobPriority.equalsIgnoreCase ("f"))
		    {
			jobPriorityNumber = 1;
			break;
		    }
		    else if (jobPriority.equalsIgnoreCase ("n"))
		    {
			jobPriorityNumber = 2;
			break;
		    }
		    else if (jobPriority.equalsIgnoreCase ("e"))
		    {
			jobPriorityNumber = 3;
			break;
		    }
		    else
		    {
			System.out.println ("Bad priority.");
			System.out.println ("Must be one of f, n, e");
		    }

		    // Obtain a command from the user.
		    System.out.print ("Command: ");
		    command = Stdin.readLine ();
		} // while (true)

		// Create the PriorityString object and
		// add it to the priority queue.
		job = new PriorityString (jobDescription,
			jobPriorityNumber);
		jobQueue.add (job);
	    }
	    else if (command.equalsIgnoreCase ("j"))
	    {
		// Remove the highest priority job from the queue.
		job = (PriorityString) jobQueue.removeMin ();
		System.out.println ("Next job: " + job.getString ());
	    }
	    else
	    {
		System.out.println ("Bad command.");
		System.out.println ("Must be one of s, j, or q");
	    }

	    // Obtain a command from the user.
	    System.out.print ("Command: ");
	    command = Stdin.readLine ();
	} // while
    } // main method
} // Jobs class
