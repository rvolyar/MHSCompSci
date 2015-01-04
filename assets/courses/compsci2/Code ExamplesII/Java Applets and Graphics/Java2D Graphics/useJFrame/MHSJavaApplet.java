/*
	JAplet using JFrame and GUI components
	and Event Handling
	
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.JApplet;
import javax.swing.*;


public class MHSJavaApplet extends JApplet
{
	
	
	private JFrame myFrame = new JFrame("My Initial Frame");
	private JLabel label1; //, label2;
	private JPanel myPanel = new JPanel();
	private JButton button1 = new JButton("ENTER");
	private JButton button2 = new JButton("HIDE");
	private JButton button3 = new JButton("ColorChooser");
	private JTextField text1 = new JTextField(30);
	private Color color = Color.lightGray;
	
	public void init() 
	{
		
		//Container c = getContentPane();
		//c.setLayout(new FlowLayout());
		
		label1 = new JLabel("Label with Text");
		label1.setToolTipText("This is LABEL1");
		
		
		// tells frame to close when user clicks X
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myPanel.add(label1);
		myPanel.add(text1);
		myPanel.add(button1);
		myPanel.add(button2);
		myPanel.add(button3);
		myPanel.setLayout(new FlowLayout());
		myPanel.setBackground(Color.orange);
		
		ButtonHandler handler = new ButtonHandler();
		button1.addActionListener(handler);
		
		ButtonHandler2 handler2 = new ButtonHandler2();
		button2.addActionListener(handler2);
		
		ButtonHandler3 handler3 = new ButtonHandler3();
		button3.addActionListener(handler3);
		
		FocusHandler fHandler = new FocusHandler();
		button1.addFocusListener(fHandler);
		button2.addFocusListener(fHandler);
		button3.addFocusListener(fHandler);
		
		/*  DONT USE !!!
		myFrame.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}  );
		
		*/
		myFrame.setContentPane(myPanel);
		myFrame.setSize(350,350);
		myFrame.setVisible(true);
		repaint();
	}
	
	
	public void paint(Graphics g) 
	{
	
	
	}
	
	// inner class to handle button event
	// displays the actual action that was executed on this GUI component
	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			text1.setText("BUTTON PRESSED== " + e.paramString());
			label1.setText(Integer.toString(e.ACTION_PERFORMED) + " " + e.getActionCommand() );
		}
	}
	
	// inner class to handle button event
	private class ButtonHandler2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		//	System.exit(0); // WONT WORK !!!
			myFrame.setVisible(false);
		}
		
	}//use JColorChooser Dialog box !!!
	private class ButtonHandler3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		
			color = JColorChooser.showDialog(JApplet.this, 
				"Choose a COlor", color);
			if(color == null)
				color = Color.red;
				
			JApplet.this.setBackground(color);
			myPanel.setBackground(color);
			repaint();
		}
	}
	
	// java.awt.event
	// since this inner class is associated with several
	// buttons, we need to determine which one received the focus
	private class FocusHandler implements FocusListener
	{
		private String s;
		public void focusGained(FocusEvent e)
		{
			if( e.getSource() == button1)
				s = "ONE";
			else if( e.getSource() == button2)
				s = "TWO";
			else
				s = "THREE";
			
			text1.setText("button " + s + " got focus");
		}
		
		public void focusLost(FocusEvent e)
		{
		}
	
	
	}
}
