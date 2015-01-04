/** 
 * Chess.java
- *
 * Description:	
 * @author			student-44
 * @version			
 */


import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class Chess extends javax.swing.JApplet {

		
	
// IMPORTANT: Source code between BEGIN/END comment pair will be regenerated
// every time the form is saved. All manual changes will be overwritten.
		
	//things do not get erased here
// BEGIN GENERATED CODE
	// member declarations
	java.awt.Label label = new java.awt.Label();
// END GENERATED CODE
	
	boolean isStandalone = false;
	

	public Chess() {
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
	public String getAppletInfo() 
	{
		return "Applet Information";
	}
	
	
	// Initialize the applet
	public void init() 
	{
		try {
			initComponents();
			//things do not get erased here
			initButtons(blocks);
			initImages();
			for (int x=0;x<64;x++)
			{
				//frame get and set methods
				getContentPane().add(blocks[x]);
				setSize(new java.awt.Dimension(800, 500));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void initComponents() throws Exception {
// IMPORTANT: Source code between BEGIN/END comment pair will be regenerated
// every time the form is saved. All manual changes will be overwritten.
// BEGIN GENERATED CODE
		// the following code sets the frame's initial state
		label.setVisible(true);
		label.setLocation(new java.awt.Point(500, 160));
		label.setText("label1");
		label.setSize(new java.awt.Dimension(150, 60));
		setLocation(new java.awt.Point(0, 0));
		getContentPane().setLayout(null);

		getContentPane().add(label);

		setSize(new java.awt.Dimension(514, 303));

		

// END GENERATED CODE
	//things do not get erased here

	}
	JButton blocks[]= new JButton[64];
	
	
	Image Wrook, Wpawn, Wqueen, Wking, Wbishop, Wknight ,
		  Brook, Bpawn, Bqueen, Bking, Bbishop, Bknight;
	Icon I[]=new Icon[12];
	Icon blank;
	String tip[]=new String[12];
	//is it the selection click? record index
	int numClick=1;
	int firstBut=0;
	//for color change
	Color firstColor=new Color(204,204,204);
		
	public void initButtons(JButton a[])
	{
		
		int x=-60,y=0;
		int line = 0;
		int z=7;//every 8 buttons ++	
		//label
		label.setSize(new java.awt.Dimension(200, 60));
		
		
		
		
		for (int c=0;c<64;c++)
		{
			a[c]=new JButton();
			
			a[c].setBackground(new Color(204,204,204));
			a[c].setVisible(true);
			a[c].setSize(new java.awt.Dimension(60, 60));
			a[c].setLabel(" " + c );	
			a[c].setForeground(new Color(204,204,204));
			//keeps counter going from end of 1 line to begin of next
			if(c%8==0 && c>0)
			{
				y+=60;
				x=-60;
			}
			a[c].setLocation(new java.awt.Point(x+=60,y));
			
			
			if(line%2==0)
			{
				if(c%2==1)				
				{
					a[c].setBackground(new Color(90,90,90));
					a[c].setForeground(new Color(90,90,90));
				}
			}
			if(line%2==1)
			{
				if(c%2 == 0)
				{
					a[c].setBackground(new Color(90,90,90));
					a[c].setForeground(new Color(90,90,90));
				}
			}
			if(c==z)
			{
				//which line is it? 
				//last button that defines a line 7,15,23,31,39,47,55,63
				z+=8;
				line++;
			}
			
			//event handling
				//gives ActionPerformed for every button
				blocks[c].addActionListener(new java.awt.event.ActionListener()
				{
					public void actionPerformed(java.awt.event.ActionEvent e) 
					{
						blocksActionPerformed(e);
					}
				}
				
				);
			
		}
				
	}
	public void initImages()
	{
		//must use getImage() b/c it uses codebase() which bypasses 
		//security
		//then make it into an icon
		Wpawn = getImage(getCodeBase(),"white_pawn.png");
		I[0]=new ImageIcon(Wpawn);
		
		Wknight = getImage(getCodeBase(),"white_knight.png");
		I[1]=new ImageIcon(Wknight);
		
		Wbishop = getImage(getCodeBase(),"white_bishop.png");
		I[2]=new ImageIcon(Wbishop);
		
		Wrook = getImage(getCodeBase(),"white_rook.png");
		I[3]=new ImageIcon(Wrook);
				
		Wqueen = getImage(getCodeBase(),"white_queen.png");
		I[4]=new ImageIcon(Wqueen);
		
		Wking = getImage(getCodeBase(),"white_king.png");
		I[5]=new ImageIcon(Wking);
		
		//black
		
		Bpawn = getImage(getCodeBase(),"black_pawn.png");
		I[6]=new ImageIcon(Bpawn);
		
		Bknight = getImage(getCodeBase(),"black_knight.png");
		I[7]=new ImageIcon(Bknight);
		
		Bbishop = getImage(getCodeBase(),"black_bishop.png");
		I[8]=new ImageIcon(Bbishop);
		
		Brook = getImage(getCodeBase(),"black_rook.png");
		I[9]=new ImageIcon(Brook);
				
		Bqueen = getImage(getCodeBase(),"black_queen.png");
		I[10]=new ImageIcon(Bqueen);
		
		Bking = getImage(getCodeBase(),"black_king.png");
		I[11]=new ImageIcon(Bking);
		
		//0 White pawn; 	6  Black pawn
		//1	White knight 	7  black knight
		//2 White bishop 	8  black bishop
		//3 White rook 		9  black rook
		//4	White queen 	10 black queen
		//5	White king 		11 black king
		tip[0]="W-Pawn";   tip[6]="B-Pawn";
		tip[1]="W-Knight"; tip[7]="B-Knight";
		tip[2]="W-Bishop"; tip[8]="B-Bishop";
		tip[3]="W-Rook";   tip[9]="B-Rook";
		tip[4]="W-Queen";  tip[10]="B-Queen";
		tip[5]="W-King";   tip[11]="B-King";
		//set black pawns
		for(int x=8;x<16;x++)
		{
			blocks[x].setIcon(I[6]);
			blocks[x].setToolTipText(tip[6]);	
		}
		//white pawns
		for(int x=48;x<56;x++)
		{
			blocks[x].setIcon(I[0]);
			blocks[x].setToolTipText(tip[0]);	
		}
		//rooks
			blocks[0].setIcon(I[9]);
			blocks[7].setIcon(I[9]);
			blocks[0].setToolTipText(tip[9]);	
			blocks[7].setToolTipText(tip[9]);	
			blocks[56].setIcon(I[3]);
			blocks[63].setIcon(I[3]);
			blocks[56].setToolTipText(tip[3]);	
			blocks[63].setToolTipText(tip[3]);	
		//knights
			blocks[1].setIcon(I[7]);
			blocks[6].setIcon(I[7]);
			blocks[1].setToolTipText(tip[7]);	
			blocks[6].setToolTipText(tip[7]);	
			blocks[57].setIcon(I[1]);
			blocks[62].setIcon(I[1]);
			blocks[57].setToolTipText(tip[1]);	
			blocks[62].setToolTipText(tip[1]);	
		//bishops
			blocks[2].setIcon(I[8]);
			blocks[5].setIcon(I[8]);
			blocks[2].setToolTipText(tip[8]);	
			blocks[5].setToolTipText(tip[8]);
			blocks[58].setIcon(I[2]);
			blocks[61].setIcon(I[2]);
			blocks[58].setToolTipText(tip[2]);	
			blocks[61].setToolTipText(tip[2]);
		//king then queen
			blocks[4].setIcon(I[11]);
			blocks[3].setIcon(I[10]);
			blocks[4].setToolTipText(tip[11]);	
			blocks[3].setToolTipText(tip[10]);
			blocks[60].setIcon(I[5]);
			blocks[59].setIcon(I[4]);
			blocks[60].setToolTipText(tip[5]);	
			blocks[59].setToolTipText(tip[4]);
	
	}
	public void paint(Graphics g)
	{
		for(int x=0;x<64;x++)
		{
			//notifies the existence of button
			blocks[x].addNotify();
			blocks[x].repaint();
		}
			
	}
	public void blocksActionPerformed(java.awt.event.ActionEvent e) 
	{
		//System.out.println("xxx");
		int index=0;
		int picTipIndex=0;
		String phrase;
		
		//System.out.println(e.getActionCommand());
		//take the number given from "e.getActionCOmmand" as index
		phrase=(e.getActionCommand()).toString();
		index=Integer.parseInt(phrase.substring( 1));
		//System.out.println(index);
		if(numClick==1 && blocks[index].getToolTipText()!=null)
		{
			
			numClick=2;
			firstBut=index;
			firstColor=blocks[firstBut].getBackground();
			//save color for later use
			blocks[firstBut].setBackground(new Color(255,0,0));	
			
		}
		else
		{
			if(numClick==2)
			{
				numClick=1;
				//change the color back to predefined color
				blocks[firstBut].setBackground(firstColor);
				for(int x=0;x<12;x++)
				{
					if((blocks[firstBut].getToolTipText()).equals(tip[x]))
						picTipIndex=x;	
				}
					//change everything of new button to old
					blocks[index].setToolTipText(tip[picTipIndex]);
					blocks[index].setIcon(I[picTipIndex]);
					//reset old button
					blocks[firstBut].setIcon(null);
					blocks[firstBut].setToolTipText(null);
					
					label.setText(firstBut+"===>"+index);		
						
			}
		}
				
			
	}
}
	










