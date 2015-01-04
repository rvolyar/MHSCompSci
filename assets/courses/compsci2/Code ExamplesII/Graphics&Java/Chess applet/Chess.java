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
	java.awt.Label label1 = new java.awt.Label();
	java.awt.Label label3 = new java.awt.Label();
	java.awt.Label label2 = new java.awt.Label();
	java.awt.Label label4 = new java.awt.Label();
	java.awt.Label label5 = new java.awt.Label();
	java.awt.Label label6 = new java.awt.Label();
	java.awt.Label label7 = new java.awt.Label();
	java.awt.Label label8 = new java.awt.Label();
	java.awt.Label label9 = new java.awt.Label();
	java.awt.Label label10 = new java.awt.Label();
	java.awt.Label label11 = new java.awt.Label();
	java.awt.Label label12 = new java.awt.Label();
	java.awt.Label label13 = new java.awt.Label();
	java.awt.Label label14 = new java.awt.Label();
	java.awt.Label label15 = new java.awt.Label();
	java.awt.Label label16 = new java.awt.Label();
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
			
			//System.out.println(bb.toString());
			
			System.out.println("pawn to rooking test");

					
			for (int x=0;x<64;x++)
			{
				//frame get and set methods
				getContentPane().add(blocks[x]);
				setSize(new java.awt.Dimension(800, 550));
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
		label.setLocation(new java.awt.Point(650, 130));
		label.setText("label1");
		label.setSize(new java.awt.Dimension(150, 60));
		label1.setBackground(java.awt.Color.black);
		label1.setFont(new java.awt.Font("Dialog", 0, 36));
		label1.setVisible(true);
		label1.setAlignment(java.awt.Label.CENTER);
		label1.setForeground(java.awt.Color.white);
		label1.setLocation(new java.awt.Point(480, 0));
		label1.setText("0");
		label1.setSize(new java.awt.Dimension(60, 60));
		label3.setBackground(java.awt.Color.black);
		label3.setFont(new java.awt.Font("Dialog", 0, 36));
		label3.setVisible(true);
		label3.setAlignment(java.awt.Label.CENTER);
		label3.setForeground(java.awt.Color.white);
		label3.setLocation(new java.awt.Point(480, 120));
		label3.setText("2");
		label3.setSize(new java.awt.Dimension(60, 60));
		label2.setBackground(java.awt.Color.black);
		label2.setFont(new java.awt.Font("Dialog", 0, 36));
		label2.setVisible(true);
		label2.setAlignment(java.awt.Label.CENTER);
		label2.setForeground(java.awt.Color.white);
		label2.setLocation(new java.awt.Point(480, 60));
		label2.setText("1");
		label2.setSize(new java.awt.Dimension(60, 60));
		label4.setBackground(java.awt.Color.black);
		label4.setFont(new java.awt.Font("Dialog", 0, 36));
		label4.setVisible(true);
		label4.setAlignment(java.awt.Label.CENTER);
		label4.setForeground(java.awt.Color.white);
		label4.setLocation(new java.awt.Point(480, 180));
		label4.setText("3");
		label4.setSize(new java.awt.Dimension(60, 60));
		label5.setBackground(java.awt.Color.black);
		label5.setFont(new java.awt.Font("Dialog", 0, 36));
		label5.setVisible(true);
		label5.setAlignment(java.awt.Label.CENTER);
		label5.setForeground(java.awt.Color.white);
		label5.setLocation(new java.awt.Point(480, 240));
		label5.setText("4");
		label5.setSize(new java.awt.Dimension(60, 60));
		label6.setBackground(java.awt.Color.black);
		label6.setFont(new java.awt.Font("Dialog", 0, 36));
		label6.setVisible(true);
		label6.setAlignment(java.awt.Label.CENTER);
		label6.setForeground(java.awt.Color.white);
		label6.setLocation(new java.awt.Point(480, 300));
		label6.setText("5");
		label6.setSize(new java.awt.Dimension(60, 60));
		label7.setBackground(java.awt.Color.black);
		label7.setFont(new java.awt.Font("Dialog", 0, 36));
		label7.setVisible(true);
		label7.setAlignment(java.awt.Label.CENTER);
		label7.setForeground(java.awt.Color.white);
		label7.setLocation(new java.awt.Point(480, 360));
		label7.setText("6");
		label7.setSize(new java.awt.Dimension(60, 60));
		label8.setBackground(java.awt.Color.black);
		label8.setFont(new java.awt.Font("Dialog", 0, 36));
		label8.setVisible(true);
		label8.setAlignment(java.awt.Label.CENTER);
		label8.setForeground(java.awt.Color.white);
		label8.setLocation(new java.awt.Point(480, 420));
		label8.setText("7");
		label8.setSize(new java.awt.Dimension(60, 60));
		label9.setBackground(java.awt.Color.black);
		label9.setFont(new java.awt.Font("Dialog", 0, 36));
		label9.setVisible(true);
		label9.setAlignment(java.awt.Label.CENTER);
		label9.setForeground(java.awt.Color.blue);
		label9.setLocation(new java.awt.Point(0, 480));
		label9.setText("0");
		label9.setSize(new java.awt.Dimension(60, 60));
		label10.setBackground(java.awt.Color.black);
		label10.setFont(new java.awt.Font("Dialog", 0, 36));
		label10.setVisible(true);
		label10.setAlignment(java.awt.Label.CENTER);
		label10.setForeground(java.awt.Color.blue);
		label10.setLocation(new java.awt.Point(60, 480));
		label10.setText("1");
		label10.setSize(new java.awt.Dimension(60, 60));
		label11.setBackground(java.awt.Color.black);
		label11.setFont(new java.awt.Font("Dialog", 0, 36));
		label11.setVisible(true);
		label11.setAlignment(java.awt.Label.CENTER);
		label11.setForeground(java.awt.Color.blue);
		label11.setLocation(new java.awt.Point(120, 480));
		label11.setText("2");
		label11.setSize(new java.awt.Dimension(60, 60));
		label12.setBackground(java.awt.Color.black);
		label12.setFont(new java.awt.Font("Dialog", 0, 36));
		label12.setVisible(true);
		label12.setAlignment(java.awt.Label.CENTER);
		label12.setForeground(java.awt.Color.blue);
		label12.setLocation(new java.awt.Point(180, 480));
		label12.setText("3");
		label12.setSize(new java.awt.Dimension(60, 60));
		label13.setBackground(java.awt.Color.black);
		label13.setFont(new java.awt.Font("Dialog", 0, 36));
		label13.setVisible(true);
		label13.setAlignment(java.awt.Label.CENTER);
		label13.setForeground(java.awt.Color.blue);
		label13.setLocation(new java.awt.Point(240, 480));
		label13.setText("4");
		label13.setSize(new java.awt.Dimension(60, 60));
		label14.setBackground(java.awt.Color.black);
		label14.setFont(new java.awt.Font("Dialog", 0, 36));
		label14.setVisible(true);
		label14.setAlignment(java.awt.Label.CENTER);
		label14.setForeground(java.awt.Color.blue);
		label14.setLocation(new java.awt.Point(300, 480));
		label14.setText("5");
		label14.setSize(new java.awt.Dimension(60, 60));
		label15.setBackground(java.awt.Color.black);
		label15.setFont(new java.awt.Font("Dialog", 0, 36));
		label15.setVisible(true);
		label15.setAlignment(java.awt.Label.CENTER);
		label15.setForeground(java.awt.Color.blue);
		label15.setLocation(new java.awt.Point(360, 480));
		label15.setText("6");
		label15.setSize(new java.awt.Dimension(60, 60));
		label16.setBackground(java.awt.Color.black);
		label16.setFont(new java.awt.Font("Dialog", 0, 36));
		label16.setVisible(true);
		label16.setAlignment(java.awt.Label.CENTER);
		label16.setForeground(java.awt.Color.blue);
		label16.setLocation(new java.awt.Point(420, 480));
		label16.setText("7");
		label16.setSize(new java.awt.Dimension(60, 60));
		setLocation(new java.awt.Point(0, 0));
		getContentPane().setLayout(null);

		getContentPane().add(label);
		getContentPane().add(label1);
		getContentPane().add(label3);
		getContentPane().add(label2);
		getContentPane().add(label4);
		getContentPane().add(label5);
		getContentPane().add(label6);
		getContentPane().add(label7);
		getContentPane().add(label8);
		getContentPane().add(label9);
		getContentPane().add(label10);
		getContentPane().add(label11);
		getContentPane().add(label12);
		getContentPane().add(label13);
		getContentPane().add(label14);
		getContentPane().add(label15);
		getContentPane().add(label16);

		setSize(new java.awt.Dimension(901, 557));

		// event handling

// END GENERATED CODE
	//things do not get erased here

	}
	JButton blocks[]= new JButton[64];
	board ChessB=new board();
	Conversion convert=new Conversion();
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
	JLabel takenL[]=new JLabel[30];
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
	public void initLabels(JLabel a[])
	{
		int x=500,y=200;
		for (int c=0;c<30;c++)
		{
			a[x].setVisible(true);
			a[x].setSize(50,50);
			if(c%8==0 && c>0)
			{
				y+=50;
				x=-50;
			}
			
			a[c].setLocation(new java.awt.Point(x+=60,y));
			
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
		int ButtonX1, ButtonY1,ButtonX2, ButtonY2;
		
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
			if(firstBut==index)
			{
				numClick=1;
				blocks[firstBut].setBackground(firstColor);
			}
			if(numClick==2 && firstBut!=index)
			{
				numClick=1;	
				
				//change the color back to predefined color
				blocks[firstBut].setBackground(firstColor);
				for(int x=0;x<12;x++)
				{
					if((blocks[firstBut].getToolTipText()).equals(tip[x]))
						picTipIndex=x;	
				}
					
					//show pieces taken
					
					if((blocks[index].getToolTipText())!=null)
					{
						System.out.println("xxx");
						
					}	
					//change everything of new button to old
					blocks[index].setToolTipText(tip[picTipIndex]);
					blocks[index].setIcon(I[picTipIndex]);
					
					//reset old button
					blocks[firstBut].setIcon(null);
					blocks[firstBut].setToolTipText(null);
					
	//START change location of pieces in code
					ButtonX1=convert.RevertX(blocks[firstBut].getX());
					ButtonY1=convert.RevertY(blocks[firstBut].getY());
					ButtonX2=convert.RevertX(blocks[index].getX());
					ButtonY2=convert.RevertY(blocks[index].getY());
					
					ChessB.move(ButtonX1,ButtonY1,ButtonX2,ButtonY2);					
					
	//END change location of pieces in code
					
					label.setText(blocks[index].getToolTipText()
						+ " (" +convert.RevertX(blocks[firstBut].getX())+","+convert.RevertY(blocks[firstBut].getY())
						+")===>("+convert.RevertX(blocks[index].getX())+","+convert.RevertY(blocks[index].getY())+")");		
						
			}
		}
				
	
	}
}
public class Conversion
{
	public Conversion()
	{
	}
	public int ConvertX(int x)
	{
	
		//array index to button location
		int buttonX=x*60;
	
		return buttonX;
	}

	public int RevertX(int x)
	{
		//converts button location to array index
		int indexX=x/60;
		return indexX;	
	}
	public int ConvertY(int y)
	{
	
		//array index to button location
		int buttonY=y*60;
	
		return buttonY;
	}

	public int RevertY(int y)
	{
		//converts button location to array index
		int indexY=y/60;
		return indexY;	
	}

}










