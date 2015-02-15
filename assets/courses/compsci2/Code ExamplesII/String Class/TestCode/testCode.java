/** 
 * testCode.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */


import EasyReader;

public class testCode 
{
	public testCode() 
	{
	}

	// Main entry point
	static public void main(String[] args) 
	{
		new testCode();
		
	
	// test questions
	
	EasyReader console = new EasyReader();
	
	
	System.out.println("Enter a Word: ");
	
	String s = new String(console.readWord());
	
	
	s = s.trim();
	
	if (s.indexOf('c') >= 0)
			{
			System.out.println("Letter Was Not Found");
			}
			else
			{
			System.out.println("Letter Was Not Found");
			}
			
	
	// guessWord();
		
		
		
	}

	static public void guessWord()
	{
		EasyReader console = new EasyReader();
		String s = new String();
		String word = new String(" sub ");
		
		word = word.trim();
		word = word.toUpperCase();
		System.out.println(word);

		char c;
		
		int a = 1, i=0, f = 0;
		
		while(a < 10)
			{
			
				System.out.print("Enter a Character: ");
				
				s = console.readWord();
				s = s.toUpperCase();
				c = s.charAt(0);
				
				i = word.indexOf(c);
				System.out.println(i);
				
				if (i >= 0)
				{
					System.out.println("Letter " + c + " Found");
					f++;
				}
					else
				{
					System.out.println("Letter " + c + " NOT Found");	
					a++;
				}
			
			
				if(f == word.length())
				{
					System.out.println("YOU WON");
					break;
				}
				
			}	
	}
		
}
