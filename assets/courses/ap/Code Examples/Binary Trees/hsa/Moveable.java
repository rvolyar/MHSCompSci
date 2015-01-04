// The "Moveable" class.
package hsa;

import java.awt.Color;
import java.awt.Graphics;

public class Moveable
{
    public static final int DIAMETER = 40;

    private double x, y;
    private double direction, speed;
    private Color color;

    public Moveable (double newX, double newY,
	    double newDirection, double newSpeed)
    {
	x = newX;
	y = newY;
	direction = newDirection;
	speed = newSpeed;
	color = Color.red;
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


    public void paint (Graphics g, int xPos, int yPos)
    {
	g.setColor (color);
	g.fillOval (xPos - 20, yPos - 20, DIAMETER, DIAMETER);
    } // paint method
} // Moveable class
