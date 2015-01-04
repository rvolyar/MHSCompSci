/*
	USE THE ARRAYLIST TO IMPLEMENT MY OWN SET
*/

import java.util.*;

public class MyOwnSet 
{

	public static void main(String args[]) 
	{
		
		MySet ms = new MySet(100);
		
		Integer i1 = new Integer(7);
		Integer i2 = new Integer(2);
		Integer i3 = new Integer(3);
		Integer i4 = new Integer(2);
		Integer i5 = new Integer(9);
		Integer i6 = new Integer(14);
		Integer i7 = new Integer(25);
		Integer i8 = new Integer(7);
		
		ms.add(i1);
		ms.add(i2);
		ms.add(i3);
		ms.add(i4);
		ms.add(i5);
		ms.add(i6);
		ms.add(i7);
		ms.add(i8);
		
		System.out.println("there are " + ms.size() + " unique elements in the set");
		
		for(int f=0; f < ms.size(); f++)
		{
			Integer d;
			d = (Integer)ms.getI(f);
			
			System.out.println(d.toString());
		}
		
		// remove
		if (!(ms.remove(i8))) // # 7
			{
				System.out.println("Remove failed");
			}
			else
			{
				System.out.println(i8.toString() + " element removed there are " + ms.size() + " left");
			}
			
		for(int f=0; f < ms.size(); f++)
		{
			Integer d;
			d = (Integer)ms.getI(f);
			
			System.out.println(d.toString());
		}
	}
}