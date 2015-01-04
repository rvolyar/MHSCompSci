/*
	USING JAPPLET WITH GUI Components 
	and JApplet as the Content Pane
	( no JFrame of Panel )


	Since JApplet is itself a container JApplet is a content pane so
	you can apply GUI components directly in the pane
	
	NOT COMPLETLY WORKING !!!


*/

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;




public class MHSJavaApplet extends JApplet
{
	private JButton jButton1; 
	private JLabel label1 ;
	private JTextField text1;
	
	public void init() 
	{
		jButton1 = new JButton();
		label1 = new JLabel("This is a Label:");
		text1 = new JTextField(40);
	
		
		
		
		repaint();
	}
	
	public void paint(Graphics g) 
	{
		jButton1.setText("Generate Numbers");
		jButton1.setVisible(true);
		jButton1.setToolTipText("This is Button");
		label1.setText("This is a LABEL");
		label1.setForeground(Color.red);
		label1.setEnabled(true);
		label1.setVisible(true);
		text1.setVisible(true);
		
		// this refers to this instance of JApplet
		// we are returning the reference of its content pane
		// and adding a gui component to it
		this.getContentPane().add(text1);
		this.getContentPane().add(jButton1);
		this.getContentPane().add(label1);
		this.getContentPane().setLayout(new FlowLayout());
		this.show();
		
	}
}
