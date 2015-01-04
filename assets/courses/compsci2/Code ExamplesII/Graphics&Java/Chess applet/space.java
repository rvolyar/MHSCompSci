public class space 
{
private piece spot;
private final int x;
private final int y;	

	
public space(piece a,int a1, int b)
{
	spot= a;
	x=a1;//column
	y=b;//row
}

public space(int a1, int b)
{
x=a1;
	y=b;
}

public piece getpiece()
{
return spot;
}

public int  getxcord()
{
return x;
}

public int getycord() 
{
return y;
}


public void setpiece(piece a)
{
spot=a;
}

public void setpiece()
{
spot =null;
}
public boolean checkpiece()
{
boolean b=false;
if (spot !=null)
b=true;

return b;

}

}
