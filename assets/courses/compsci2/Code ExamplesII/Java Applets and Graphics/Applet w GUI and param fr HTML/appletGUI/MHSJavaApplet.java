/*
	JApplet with GUI components displayed in a Panel
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.util.Random;


// QUESTION: why is the label NOT appearing on the applet ?


public class MHSJavaApplet extends JApplet
{
	private JButton jButton1; 
	private JLabel label1 ;
	private JTextField text1;
	private Random myRandGen ;
	private JPanel myPanel = new JPanel();
	private int myParam;

	
	public void init() 
	{
		// get the input parameter from the HTML
		try 
		{
		 myParam = Integer.parseInt( this.getParameter("paramin")); 
		} 
		catch (Exception e) 
		{
		 e.printStackTrace();
	 	}
		jButton1 = new JButton();
		label1 = new JLabel("This is a Label:");
		text1 = new JTextField(40);
		myRandGen = new Random();
		
		initGUI();
		
		repaint();
	}
	
	public void paint(Graphics g) 
	{
		//g.drawString("Hello World!", 30, 30);
		
	}
	
	
	private void initGUI()
	{
	
		jButton1.setText("Generate Numbers");
		//jButton1.setLocation(new java.awt.Point(130, 260));
		//jButton1.setLocation(130, 260);
		jButton1.setVisible(true);
		//jButton1.setSize(150,100) ;   //(new java.awt.Dimension(150, 40));
		jButton1.setToolTipText("This is Button");
		label1.setText("This is a LABEL");
		
		label1.setForeground(Color.red);
		//jLabel1.setLocation(new java.awt.Point(100, 80));
		//jLabel1.setLocation(100,100);
		label1.setEnabled(true);
		label1.setVisible(true);
		//jLabel1.setSize(110, 70);
	
		//text1.setLocation(200,150);
		text1.setVisible(true);
		//text1.setSize(310, 120);
		
		ButtonHandler handler = new ButtonHandler();
		jButton1.addActionListener(handler);
		
		
		
		myPanel.add(text1);
		myPanel.add(jButton1);
		myPanel.add(label1);
		myPanel.setLayout(new FlowLayout());
		myPanel.setSize(350,350);
		myPanel.setVisible(true);
		setContentPane(myPanel);
		
		//setLocation(new java.awt.Point(0, 0));
		//getContentPane().setLayout(new FlowLayout());
		//setSize(new java.awt.Dimension(500, 500));
		
		//getContentPane().add(text1);
		//getContentPane().add(jLabel1);
		//getContentPane().add(jButton1);
	}
	
	// inner class to handle button event
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			text1.setText("BUTTON WAS PRESSED !!!");
			text1.setForeground(Color.blue);
			label1.setText(new Integer(myParam).toString());
			//label1.setEnabled(true);
			//label1.setVisible(true);
			
		int c = 0,stop = 0, heads = 0, tails = 0;
	 	
	 	while(stop < myParam)
	 	{
	 		c = getnumber();
	 		if(c == 0)
	 			{
	 			heads += 1;
	 			}
	 			else
	 			{
	 			tails += 1;	
	 			}
	 		stop++;
	 	}
	 	
	 	label1.setText(((new Integer(heads).toString())));
		}
	}
	
	// my methods
	public int getnumber()
	{
		int num=0;
		num = myRandGen.nextInt();
		if(num < 0)
			num *= -1;
			
		num = num % 2;
		
		return num;
	}
	
}
