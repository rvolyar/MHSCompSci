public class bishop extends piece
{

private String bname="";


private boolean color;

public bishop(boolean z)
{
color=z;
}


public String name()
{
bname="bishop";
return bname;
}



public space[] legalmove(space a, board c)
{
	space lmoves[]= new space[27];
	
	int x=0;
	
	
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
	

System.out.println(x);


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