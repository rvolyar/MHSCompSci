/** 
 * playing.java
 *
 * Description:	
 * @author			student-52
 * @version			
 */


public class playing {
	public playing() {
	}

	// Main entry point
	static public void main(String[] args) {
		new playing();
	System.out.println("pawn to rooking test");
	board b= new board();
	//first row second column
	b.move(1,0,2,0);
	b.move(2,0,3,0);
	b.move(3,0,4,0); //pawn  check kinda working
	b.move(4,0,5,0);
	System.out.println(b.getspace(5,0).getpiece().name());
	//b.move(1,1,1,2); rook 
	/*b.move(0,0,3,0);
	b.move(3,0,2,0);
	b.move(2,0,2,4);
	b.move(2,4,3,4);
	b.move(3,4,2,4);
	b.move(2,4,2,6);
	
	
	// time to test the bitchop
	System.out.println("BITCHOP TIME");
	//b.move(1,0,2,0);
	/*b.move(1,1,2,1);
	b.move(1,2,2,2);
	b.move(1,3,2,3);
	
	
	b.move(0,2,1,1);
	b.move(1,1,2,0);
	//b.move();

// horse shit	
	System.out.println("HORseY");
	
	b.move(0,1,2,0);
	b.move(2,0,0,1);
	b.move(0,1,1,3);
	
	
	//b.move(2,3,3,3);
	//b.move(3,1,4,1);
	//space c= b.getspace(2,1);
	//piece g = c.getpiece();
	//String gg=g.name();
	//System.out.println(gg);
	
	*/
	
	}
	
}



