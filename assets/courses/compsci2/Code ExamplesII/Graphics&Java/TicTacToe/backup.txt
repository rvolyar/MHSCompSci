/** 
 * AppletIntro.java
 *
 * Description:	
 * @author			administrator
 * @version			
 */


import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class AppletIntro extends java.applet.Applet implements ActionListener
{

// IMPORTANT: Source code between BEGIN/END comment pair will be regenerated
// every time the form is saved. All manual changes will be overwritten.
// BEGIN GENERATED CODE
	// member declarations
	Button[][] board = new Button[3][3];
	java.awt.Label label1 = new java.awt.Label();
	java.awt.Button button10 = new java.awt.Button();
	java.awt.Label label2 = new java.awt.Label();
	private int turn = 1;
// END GENERATED CODE

	boolean isStandalone = false;

	public AppletIntro() {
	}

	// Retrieve the value of an applet parameter
	public String getParameter(String key, String def) {
		return isStandalone ? System.getProperty(key, def) :
			(getParameter(key) != null ? getParameter(key) : def);
	}

	// Get info on the applet parameters
	public String[][] getParameterInfo() {
		return null;
	}

	// Get applet information
	public String getAppletInfo() {
		return "Applet Information";
	}

	// Initialize the applet
	public void init() {
		try {
			initComponents();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initComponents() throws Exception {
// IMPORTANT: Source code between BEGIN/END comment pair will be regenerated
// every time the form is saved. All manual changes will be overwritten.
// BEGIN GENERATED CODE
		// the following code sets the frame's initial state
		
		
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				board[x][y] = new Button();
				board[x][y].setVisible(true);
				board[x][y].setLabel("");
				board[x][y].setLocation(new java.awt.Point(60 + 50 * x, 70 + 50 * y));
				board[x][y].setSize(new java.awt.Dimension(40, 40));
				add(board[x][y]);
			}
		}
		
		label1.setVisible(true);
		label1.setLocation(new java.awt.Point(60, 240));
		label1.setText("");
		label1.setSize(new java.awt.Dimension(120, 20));
		button10.setVisible(true);
		button10.setLabel("Restart Game");
		button10.setLocation(new java.awt.Point(220, 220));
		button10.setSize(new java.awt.Dimension(80, 40));
		label2.setVisible(true);
		label2.setLocation(new java.awt.Point(230, 90));
		label2.setText("Player " + ((turn + 1) % 2 + 1) + "'s Turn");
		label2.setSize(new java.awt.Dimension(200, 20));
		setLocation(new java.awt.Point(0, 0));
		setLayout(null);

		add(label1);
		add(button10);
		add(label2);

		setSize(new java.awt.Dimension(400, 300));

		// event handling
		
		for(int x = 0; x < 3; x++)
		{
			for(int y = 0; y < 3; y++)
			{
				board[x][y].addActionListener(this);
			}
		}
		
		button10.addActionListener(this);

// END GENERATED CODE
	}
	
	public void actionPerformed(ActionEvent l)
	{
		Button b = ((Button) l.getSource());
		if(b.getLabel().equals(""))
		{
			if(turn % 2 == 0)
				b.setLabel("O");
			else
				b.setLabel("X");
			turn++;	
			label2.setText("Player " + ((turn + 1) % 2 + 1) + "'s Turn");
			checkVictory();
			if(turn == 10)
			{
				label1.setText("draw -- restart?");
			}
		}
		else
		{
			for(int x = 0; x < 3; x++)
			{
				for(int y = 0; y < 3; y++)
				{
					board[x][y].setLabel("");
				}
			}
			turn = 1;
			label2.setText("Player " + ((turn + 1) % 2 + 1) + "'s Turn");
			label1.setText("");
		}
	}
	
	private void checkVictory()
	{
		for(int x = 0; x < 3; x++)
		{
			if((board[x][0].getLabel().equals(board[x][1].getLabel()) 
					&& board[x][1].getLabel().equals(board[x][2].getLabel()) 
					&& !board[x][2].getLabel().equals(""))
					|| (board[0][x].getLabel().equals(board[1][x].getLabel()) 
					&& board[1][x].getLabel().equals(board[2][x].getLabel()) 
					&& !board[2][x].getLabel().equals(""))
					|| (board[0][0].getLabel().equals(board[1][1].getLabel()) 
					&& board[1][1].getLabel().equals(board[2][2].getLabel()) 
					&& !board[2][2].getLabel().equals(""))
					|| (board[0][2].getLabel().equals(board[1][1].getLabel()) 
					&& board[1][1].getLabel().equals(board[2][0].getLabel()) 
					&& !board[0][2].getLabel().equals("")))
				victory();
		}
	}
	
	private void victory()
	{
		label1.setText("player " + ((turn) % 2 + 1) + " wins");
	}
}
