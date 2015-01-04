public class king extends piece
{

private String kingname="";


private	boolean color;

public king(boolean z)
{
color=z;
}


public String name()
{
kingname="king";
return kingname;
}

public boolean getcolor()
{

return color;

}



public space[] legalmove(space a,  board c)
{

space lmoves[]= new space[27];

int x=0;
if (c.identifypiece(a.getxcord()+1, a.getycord()+1)!= null && c.identifypiece(a.getxcord()+1, a.getycord()+1).checkpiece() ==true) 
	{
	 if(c.getspace(a.getxcord()+1, a.getycord()+1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	lmoves[x]=c.identifypiece(a.getxcord()+1, a.getycord()+1);
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()+1, a.getycord()+1);
	x++;
	}

	
	
if (c.identifypiece(a.getxcord()+1, a.getycord()-1) != null && c.identifypiece(a.getxcord()+1, a.getycord()-1).checkpiece() == true) 
	{
	 if(c.getspace(a.getxcord()+1, a.getycord()-1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	
	lmoves[x]=c.identifypiece(a.getxcord()+1, a.getycord()-1);
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()+1, a.getycord());
	x++;
	}



if (c.identifypiece(a.getxcord()+1, a.getycord())!= null && c.identifypiece(a.getxcord()+1, a.getycord()).checkpiece() ==true) 
	{
	 if(c.getspace(a.getxcord()+1, a.getycord()).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	lmoves[x]=c.identifypiece(a.getxcord()+1, a.getycord());
	x++;
	}
	}
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()+1, a.getycord());
	x++;
	}	

	


if (c.identifypiece(a.getxcord(), a.getycord()-1) != null && c.identifypiece(a.getxcord(), a.getycord()-1).checkpiece() == true) 
	{
	 if(c.getspace(a.getxcord(), a.getycord()-1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	
	lmoves[x]=c.identifypiece(a.getxcord(), a.getycord()-1);
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord(), a.getycord()-1);
	x++;
	}


if (c.identifypiece(a.getxcord(), a.getycord()+1)!= null && c.identifypiece(a.getxcord(), a.getycord()+1).checkpiece() ==true) 
	{
	 if(c.getspace(a.getxcord(), a.getycord()+1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	lmoves[x]=c.identifypiece(a.getxcord(), a.getycord()+1);
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord(), a.getycord()+1);
	x++;
	}

	
	
if (c.identifypiece(a.getxcord()-1, a.getycord()-1) != null && c.identifypiece(a.getxcord()-1, a.getycord()-1).checkpiece() == true) 
	{
	 if(c.getspace(a.getxcord()-1, a.getycord()-1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	
	lmoves[x]=c.identifypiece(a.getxcord()-1, a.getycord()-1);
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()-1, a.getycord()-1);
	x++;
	}



if (c.identifypiece(a.getxcord()-1, a.getycord()+1)!= null && c.identifypiece(a.getxcord()-1, a.getycord()+1).checkpiece() ==true) 
	{
	 if(c.getspace(a.getxcord()-1, a.getycord()+1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	lmoves[x]=c.identifypiece(a.getxcord()-1, a.getycord()+1);
	x++;
	}
	}
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()-1, a.getycord()+1);
	x++;
	}	

	


if (c.identifypiece(a.getxcord()-1, a.getycord()) != null && c.identifypiece(a.getxcord()-1, a.getycord()).checkpiece() == true) 
	{
	 if(c.getspace(a.getxcord()-1, a.getycord()).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	
	lmoves[x]=c.identifypiece(a.getxcord()-1, a.getycord());
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()-1, a.getycord());
	x++;
	}

space poss[]= new space[x];

	for (int xx=0;xx!=poss.length;xx++)
	{
	poss[xx]=lmoves[xx];
	}


return poss ;








}









}