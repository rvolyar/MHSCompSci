public class board
{
private space cboard[][] = new space[8][8];	
	
	public board()
	{
	// need to set the board
	for (int x=0;x< cboard.length;x++)
		{
		cboard[1][x]=new space( new pawn(false),1,x);
		cboard[6][x]=new space( new pawn(true),6,x);
		}
	//setting up the rooks
		cboard[0][0]=new space( new rook(false),0,0);
		cboard[0][7]=new space( new rook(false),0,7);
		cboard[7][0]=new space( new rook(true),7,0);
		cboard[7][7]=new space( new rook(true),7,7);
   // setting up the knights	
		cboard[0][1]=new space( new knight(false),0,1);
		cboard[0][6]=new space( new knight(false),0,6);
		cboard[7][1]=new space( new knight(true),7,1);
		cboard[7][6]=new space( new knight(true),7,6);
	// setting up the bishop
		cboard[0][2]=new space( new bishop(false),0,2);
		cboard[0][5]=new space( new bishop(false),0,5);
		cboard[7][2]=new space( new bishop(true),7,2);
		cboard[7][5]=new space( new bishop(true),7,5);
	// setting up the major bitch(queeN)
		cboard[0][3]=new space( new queen(false),0,3);
		cboard[7][3]=new space( new queen(true),7,3);
	// setting up the player IE king
		cboard[0][4]=new space( new king(false),0,4);
		cboard[7][4]=new space( new king(true),7,4);
	for (int x=2;x!=6;x++)
		{
			for (int y=0; y!=8;y++)
			
			{
			cboard[x][y]=new space(x,y);
			}
		}
	
	}
	

public void move(int x1,int y, int a1, int b1)
{

space a= cboard[x1][y];
space b = cboard[a1][b1];

space pmoves[];
String Check="dontwork";

pmoves = ((a.getpiece()).legalmove(a,this) );

System.out.println(" getting legal moves ====> " + pmoves.length + " from " + x1 + " to " + a1);

for(int x=0;x!=pmoves.length; x++)
{


if (pmoves[x]==null)
	;
else
{

if(pmoves[x].equals(b))
{
b.setpiece(a.getpiece());
a.setpiece();
Check= "work";

break;
}


}

}	
System.out.println(Check);
}
public space getspace (int a, int b )	
	{
	return(cboard[a][b]);
	}



public space identifypiece(int x, int y)
	{
	space a=null;
	
	if (x>-1 && x<8)
	{
	if (y>-1 && y<8)
	{ 
	a =cboard[x][y];
	}
	}
	
	return a;
	}







}