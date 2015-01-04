package hsa;

/**
 * Internal to hsa package.
 * <p>
 * The ConsoleEdges class draws the edges around the ConsoleCanvas to
 * help produce the "well" or "3-D" effect. The "edge" field specifies
 * which edge the object stands for.
 * <p>
 * Full documentation for the classes in the hsa package available at:
 * <br>
 *                      http://www.holtsoft.com/java/hsa_package.html
 * <p>
 * @author Tom West
 * @version 2.0 99/02/01
 */

import java.awt.*;

class ConsoleEdges extends Canvas
{
    protected static final int TOP = 1;
    protected static final int BOTTOM = 2;
    protected static final int LEFT = 3;
    protected static final int RIGHT = 4;

    private int edge;
    
    /**
     * Creates the ConsoleEdge.
     */
    public ConsoleEdges (int edge)
    {
	super ();

	this.edge = edge;

	switch (edge)
	{
	    case TOP:
	    case BOTTOM:
		setBackground (Color.lightGray);
		setSize (100, ConsoleCanvas.DEPTH + ConsoleCanvas.GREY_MARGIN);
		break;
	    case LEFT:
	    case RIGHT:
		setBackground (Color.lightGray);
		setSize (ConsoleCanvas.DEPTH + ConsoleCanvas.GREY_MARGIN, 100);
		break;
	}
    } // Constructor - ConsoleEdges (int)


    /**
     * Draws the console edge with a 3-D effect.
     */
    public void paint (Graphics g)
    {
	int gm = ConsoleCanvas.GREY_MARGIN;
	int depth = ConsoleCanvas.DEPTH;

	switch (edge)
	{
	    case TOP:
		for (int cnt = 1 ; cnt < depth ; cnt++)
		{
		    g.setColor (Color.gray);
		    g.drawLine (gm + cnt - 1, gm + cnt - 1, getSize ().width - gm - cnt - 1, gm + cnt - 1);
		    g.drawLine (gm + cnt - 1, gm + cnt - 1, gm + cnt - 1, getSize ().height);
		    g.setColor (Color.white);
		    g.drawLine (getSize ().width - gm - depth + cnt, gm + depth - cnt - 1, getSize ().width - gm - depth + cnt, getSize ().height);
		}

		g.setColor (Color.black);
		g.drawLine (gm + depth - 1, gm + depth - 1, getSize ().width - gm - depth - 1, gm + depth - 1);
		g.setColor (Color.lightGray);
		g.drawLine (getSize ().width - gm - depth, gm + depth - 1, getSize ().width - gm - depth, gm + depth - 1);
		break;
	    case BOTTOM:
		g.setColor (Color.lightGray);
		g.drawLine (gm + depth - 1, 0, getSize ().width, 0);
		g.setColor (Color.white);
		g.drawLine (getSize ().width - gm - depth + 1, 0, getSize ().width - gm - 1, 0);

		for (int cnt = 1 ; cnt < depth ; cnt++)
		{
		    g.setColor (Color.white);
		    g.drawLine (gm + cnt, depth - cnt, getSize ().width - gm - 1, depth - cnt);
		    g.setColor (Color.gray);
		    g.drawLine (gm + cnt - 1, depth - cnt, gm + cnt - 1, 0);
		}
		break;
	    case LEFT:
		g.setColor (Color.gray);
		for (int cnt = 1 ; cnt < depth ; cnt++)
		{
		    g.drawLine (gm + cnt - 1, 0, gm + cnt - 1, getSize ().height);
		}

		g.setColor (Color.black);
		g.drawLine (gm + depth - 1, 0, gm + depth - 1, getSize ().height);
		break;
	    case RIGHT:
		g.setColor (Color.lightGray);
		g.drawLine (0, 0, 0, getSize ().height);

		g.setColor (Color.white);
		for (int cnt = 1 ; cnt < depth ; cnt++)
		{
		    g.drawLine (cnt, 0, cnt, getSize ().height);
		}
		break;
	} // switch
    } // paint (Graphics)
} // ConsoleEdges class
