public class knight extends piece
{

private String kname="";


private boolean color;

public knight(boolean z)
{
color=z;
}

public String name()
{
kname="knight";
return kname;
}




public space[] legalmove(space a, board c)
{
space lmoves[]= new space[27];

int x=0;
if (c.identifypiece(a.getxcord()+2, a.getycord()+1)!= null && c.identifypiece(a.getxcord()+2, a.getycord()+1).checkpiece() ==true) 
	{
	 if(c.getspace(a.getxcord()+2, a.getycord()+1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	lmoves[x]=c.identifypiece(a.getxcord()+2, a.getycord()+1);
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()+2, a.getycord()+1);
	x++;
	}

	
	
if (c.identifypiece(a.getxcord()+2, a.getycord()-1) != null && c.identifypiece(a.getxcord()+2, a.getycord()-1).checkpiece() == true) 
	{
	 if(c.getspace(a.getxcord()+2, a.getycord()-1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	
	lmoves[x]=c.identifypiece(a.getxcord()+2, a.getycord()-1);
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()+2, a.getycord()-1);
	x++;
	}



if (c.identifypiece(a.getxcord()+1, a.getycord()+2)!= null && c.identifypiece(a.getxcord()+1, a.getycord()+2).checkpiece() ==true) 
	{
	 if(c.getspace(a.getxcord()+1, a.getycord()+2).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	lmoves[x]=c.identifypiece(a.getxcord()+1, a.getycord()+2);
	x++;
	}
	}
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()+1, a.getycord()+2);
	x++;
	}	

	


if (c.identifypiece(a.getxcord()+1, a.getycord()-2) != null && c.identifypiece(a.getxcord()+1, a.getycord()+2).checkpiece() == true) 
	{
	 if(c.getspace(a.getxcord()+1, a.getycord()-2).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	
	lmoves[x]=c.identifypiece(a.getxcord()+1, a.getycord()-2);
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()+1, a.getycord()-2);
	x++;
	}


if (c.identifypiece(a.getxcord()-2, a.getycord()+1)!= null && c.identifypiece(a.getxcord()-2, a.getycord()+1).checkpiece() ==true) 
	{
	 if(c.getspace(a.getxcord()-2, a.getycord()+1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	lmoves[x]=c.identifypiece(a.getxcord()-2, a.getycord()+1);
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()-2, a.getycord()+1);
	x++;
	}

	
	
if (c.identifypiece(a.getxcord()-2, a.getycord()-1) != null && c.identifypiece(a.getxcord()-2, a.getycord()-1).checkpiece() == true) 
	{
	 if(c.getspace(a.getxcord()-2, a.getycord()-1).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	
	lmoves[x]=c.identifypiece(a.getxcord()-2, a.getycord()-1);
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()-2, a.getycord()-1);
	x++;
	}



if (c.identifypiece(a.getxcord()-1, a.getycord()+2)!= null && c.identifypiece(a.getxcord()-1, a.getycord()+2).checkpiece() ==true) 
	{
	 if(c.getspace(a.getxcord()-1, a.getycord()+2).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	lmoves[x]=c.identifypiece(a.getxcord()-1, a.getycord()+2);
	x++;
	}
	}
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()+1, a.getycord()+2);
	x++;
	}	

	


if (c.identifypiece(a.getxcord()-1, a.getycord()-2) != null && c.identifypiece(a.getxcord()-1, a.getycord()+2).checkpiece() == true) 
	{
	 if(c.getspace(a.getxcord()-1, a.getycord()-2).getpiece().getcolor()!= a.getpiece().getcolor() )
	{
	
	lmoves[x]=c.identifypiece(a.getxcord()-1, a.getycord()-2);
	x++;
	}
	}	
else
	{
	lmoves[x]=c.identifypiece(a.getxcord()-1, a.getycord()-2);
	x++;
	}

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