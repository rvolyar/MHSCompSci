public class queen extends piece
{

private String queenname="";


private	boolean color;

public queen(boolean z)
{
color=z;
}


public String name()
{
queenname="queen";
return queenname;
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
		System.out.println(x1 + "    " + a.getycord());
		x++;
		System.out.println(x);
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
			int temp=0;
	int y=1;
	while(temp!=1){
	
	
	int axc=a.getxcord();
	int ayc=a.getycord();
	
	if (c.identifypiece(axc+y,ayc+y)!= null && c.identifypiece(axc+y,ayc+y).checkpiece() ==true) 
	{
		
		 
		 if(c.getspace(axc+y,ayc+y).getpiece().getcolor()!= a.getpiece().getcolor() )
		{
		lmoves[x]=c.identifypiece(axc+y,ayc+y);
		x++;
		break;
		}
		else
		{
		
		break;
		}
	}
	
	System.out.println( x+" "+ y);
	lmoves[x]=c.identifypiece(axc+y,ayc+y);
	y++;
	x++;
	
	if (axc+y>7 || ayc+y>7)
		break;
	
	}
	 y=1;
	while(temp!=1){
	
	
	int axc=a.getxcord();
	int ayc=a.getycord();

	if (c.identifypiece(axc-y,ayc+y)!= null && c.identifypiece(axc-y,ayc+y).checkpiece() ==true) 
	{
		 if(c.getspace(axc-y,ayc+y).getpiece().getcolor()!= a.getpiece().getcolor() )
		{
		lmoves[x]=c.identifypiece(axc-y,ayc+y);
		x++;
		break;
		}
		else
		{
		break;
		}
	}
	
	lmoves[x]=c.identifypiece(axc-y,ayc+y);
	x++;
	y++;
	
	if (axc-y<0 || ayc+y>7)
		break;
	
	} 
	
	y=1;
	while(temp!=1){
	

	int axc=a.getxcord();
	int ayc=a.getycord();

	if (c.identifypiece(axc-y,ayc-y)!= null && c.identifypiece(axc-y,ayc-y).checkpiece() ==true) 
	{
		 if(c.getspace(axc-y,ayc-y).getpiece().getcolor()!= a.getpiece().getcolor() )
		{
		lmoves[x]=c.identifypiece(axc-y,ayc-y);
		x++;
		break;
		}
		else
		{
		break;
		}
	}
	
	lmoves[x]=c.identifypiece(axc-y,ayc-y);
	x++;
	y++;
	
	if (axc-y<0 || ayc-y<0)
		break;
	
	
	}
	y=1;
	while(temp!=1){
	
	int axc=a.getxcord();
	int ayc=a.getycord();
	
	if (c.identifypiece(axc+y,ayc-y)!= null && c.identifypiece(axc+y,ayc-y).checkpiece() ==true) 
	{
		 if(c.getspace(axc+y,ayc-y).getpiece().getcolor()!= a.getpiece().getcolor() )
		{
		lmoves[x]=c.identifypiece(axc+y,ayc-y);
		x++;
		break;
		}
		else
		{
		break;
		}
	
	}
	
	lmoves[x]=c.identifypiece(axc+y,ayc-y);
	x++;
	y++;
	
	if (axc+y>7 || ayc-y<0)
		break;
	
	}
	

//System.out.println(x);


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