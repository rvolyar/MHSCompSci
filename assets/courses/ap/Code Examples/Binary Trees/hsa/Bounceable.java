// "The Bounceable" class
package hsa;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Bounceable
{
    private double x, y;
    private double direction, speed;
    private Color color;

    public Bounceable (double newX, double newY,
	    double newDirection, double newSpeed)
    {
	x = newX;
	y = newY;
	direction = newDirection;
	speed = newSpeed;
    } // Moveable constuctor


    public double getX ()
    {
	return x;
    } // getX method


    public double getY ()
    {
	return y;
    } // getY method


    public void setLocation (double newX, double newY)
    {
	x = newX;
	y = newY;
    } // setLocation method


    public double getDirection ()
    {
	return direction;
    } // getDirection method


    public void setDirection (double newDirection)
    {
	direction = newDirection;
    } // setDirection method


    public double getSpeed ()
    {
	return speed;
    } // getSpeed method


    public void setSpeed (double newSpeed)
    {
	speed = newSpeed;
    } // setSpeed method


    public Color getColor ()
    {
	return color;
    } // getColor method


    public void setColor (Color newColor)
    {
	color = newColor;
    } // setColor method


    // The abstract methods.  These must be defined by
    // classes that inherit from the class.
    public abstract void paint (Graphics g, int xPos, int yPos);
    public abstract double getTop ();
    public abstract double getBottom ();
    public abstract double getLeft ();
    public abstract double getRight ();
} // Bounceable class
