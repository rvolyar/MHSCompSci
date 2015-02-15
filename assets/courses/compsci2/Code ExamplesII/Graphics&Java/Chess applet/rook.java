public class rook extends piece
{

private String rname="";
boolean color;

public rook(boolean z)
{
color=z;
}


public String name()
{
rname="rook";
return rname;
}



public space[] legalmove(space a, board c)
{


	
	space lmoves[]= new space[27];
	
	
	int x=0;
	
	for (int x1=a.getxcord()+1;x!=7;x1++)
	{
	if (x1>7)
		break;
	
		
	if (c.identifypiece(x1, a.getycord())!= null && c.identifypiece(x1,a.getycord()).checkpiece() ==true) 
	{
	
		 if(c.getspace(x1,a.getycord()).getpiece().getcolor()!= a.getpiece().getcolor() )
		{
		lmoves[x]=c.identifypiece(x1,a.getycord());;
		
		x++;
		
		break;
		}
		else
		{
		
		break;
		}
	}
	
	lmoves[x]=c.identifypiece(x1,a.getycord());
	
	x++;
	
	
	}

	
	for (int x1=a.getycord()+1;x1!=7;x1++)
	{
	
	if (x1>7)
		break;
	
	if (c.identifypiece(a.getxcord(),x1)!= null && c.identifypiece(a.getxcord(),x1).checkpiece() ==true) 
	{
		 if(c.getspace(a.getxcord(),x1).getpiece().getcolor()!= a.getpiece().getcolor() )
		{
		lmoves[x]=c.identifypiece(a.getxcord(),x1);;
		x++;
		
		break;
		}
		else
		{
		
		break;
		}
	
	
	}
	lmoves[x]=c.identifypiece(a.getxcord(),x1);;
	x++;
	
	}
	
	for (int x1 = a.getxcord()-1;x1!=0;x1--)
	{
	
	
	if (x1<0)
		break;
	
	if (c.identifypiece(x1,a.getycord())!= null && c.identifypiece(x1,a.getycord()).checkpiece() ==true) 
	{
		 if(c.getspace(x1,a.getycord()).getpiece().getcolor()!= a.getpiece().getcolor() )
		{
		lmoves[x]=c.identifypiece(x1,a.getycord());
		x++;
		
		break;
		}
		else
		{
		break;
		}
	}
	
	lmoves[x]=c.identifypiece(x1,a.getycord());
	
	x++;
	
	}

	for (int x1=a.getycord()-1;x1!=0;x1--)
	{
	
	
	if (x1<0)
		break;
	
	if (c.identifypiece(a.getxcord(),x1)!= null && c.identifypiece(a.getxcord(),x1).checkpiece() ==true) 
	{
		 if(c.getspace(a.getxcord(),x1).getpiece().getcolor()!= a.getpiece().getcolor() )
		{
		lmoves[x]=c.identifypiece(a.getxcord(),x1);
		
		x++;
		break;
		}
		else
		{
		break;
		}
	
	
	}
	lmoves[x]=c.identifypiece(a.getxcord(),x1);
	
	}

//System.out.println(lmoves[x].getxcord());
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