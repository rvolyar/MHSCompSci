public class pawn extends piece
{

private String pname="";
private boolean color;
private boolean start;
public pawn()
{
}


public String name()
{
pname="pawn";
return pname;
}





	
public pawn(boolean a)
{
start=true;
color=a;
//black is false white is true
}

public space[] legalmove(space a, board c )
{

	int y=1;

	if (a.getpiece().getcolor())
	y=-1;
	
	space lmoves[]= new space[4];
	
	int x=0;
	
	
	                          
	if(c.identifypiece(a.getxcord()+y, a.getycord())!= null && c.identifypiece(a.getxcord()+y, a.getycord()).checkpiece()==false)
	{
	
	
	
	lmoves[x]=c.identifypiece(a.getxcord()+y, a.getycord());
	x++;
	
	if (start==true)
	{
	lmoves[x]=c.identifypiece(a.getxcord()+2*y,a.getycord());
	x++;
	
	}
	
	}
	
	
	if (c.identifypiece(a.getxcord()+y, a.getycord()-1)!= null && c.identifypiece(a.getxcord()+y, a.getycord()-1).checkpiece() ==true) 
	{
	 if(c.getspace(a.getxcord()+y, a.getycord()-1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	lmoves[x]=c.identifypiece(a.getxcord()+y, a.getycord()-1);
	x++;
	}
	
	}	

	if (c.identifypiece(a.getxcord()+y, a.getycord()-1) != null && c.identifypiece(a.getxcord()+y, a.getycord()+1).checkpiece() == true) 
	{
	 if(c.getspace(a.getxcord()+y, a.getycord()+1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	
	lmoves[x]=c.identifypiece(a.getxcord()+y, a.getycord()+1);
	x++;
	}
	}	
	







start=false;

space poss[]= new space[x];

	for (int xx=0;xx!=poss.length;xx++)
	{
	
	
	poss[xx]=lmoves[xx];

	}
return poss ;


}


public boolean getcolor()
{

return color;

}






}