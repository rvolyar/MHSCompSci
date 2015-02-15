/** 
 * GraphicConnectFour.java
 *
 * Description:	
 * @author			aaron
 * @version			
 */


import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.HashMap;
import java.util.Iterator;

public class GraphicConnectFour extends java.applet.Applet 
{
	public GraphicConnectFour() 
	{
	}
	static public void main(String[] args) 
	{
		new GraphicConnectFour();
		GraphicsStarter g = new GraphicsStarter();
		g.startGraphics();
		//System.exit(0);
	}
}
public class GraphicsStarter
{

	boolean turn = true;
	boolean done = true;
	long w = 100;
	int level1 = 0;
	int level2 = 0;
	long start = 0;
	long stop = 0;
	int firstwins = 0;
	int secondwins = 0;
	int draws = 0;
	Board b = new Board();
	java.awt.Button button1 = new java.awt.Button();
	java.awt.Button button2 = new java.awt.Button();
	java.awt.Button button3 = new java.awt.Button();
	java.awt.Button button4 = new java.awt.Button();
	java.awt.Button button5 = new java.awt.Button();
	java.awt.Button button6 = new java.awt.Button();
	java.awt.Button button7 = new java.awt.Button();
	java.awt.Button button8 = new java.awt.Button();
	java.awt.Button button9 = new java.awt.Button();
	java.awt.Button button10 = new java.awt.Button();
	java.awt.Button button11 = new java.awt.Button();
	java.awt.Button button12 = new java.awt.Button();
	java.awt.Button button13 = new java.awt.Button();
	java.awt.Button button14 = new java.awt.Button();
	java.awt.Button button15 = new java.awt.Button();
	java.awt.Button button16 = new java.awt.Button();
	java.awt.Button button17 = new java.awt.Button();
	java.awt.Button button18 = new java.awt.Button();
	java.awt.Button button19 = new java.awt.Button();
	java.awt.Button button20 = new java.awt.Button();
	java.awt.Button button21 = new java.awt.Button();
	java.awt.Button button22 = new java.awt.Button();
	java.awt.Button button23 = new java.awt.Button();
	java.awt.Button button24 = new java.awt.Button();
	java.awt.Button button25 = new java.awt.Button();
	java.awt.Button button26 = new java.awt.Button();
	java.awt.Button button27 = new java.awt.Button();
	java.awt.Button button28 = new java.awt.Button();
	java.awt.Button button29 = new java.awt.Button();
	java.awt.Button button30 = new java.awt.Button();
	java.awt.Button button31 = new java.awt.Button();
	java.awt.Button button32 = new java.awt.Button();
	java.awt.Button button33 = new java.awt.Button();
	java.awt.Button button34 = new java.awt.Button();
	java.awt.Button button35 = new java.awt.Button();
	java.awt.Button button36 = new java.awt.Button();
	java.awt.Button button37 = new java.awt.Button();
	java.awt.Button button38 = new java.awt.Button();
	java.awt.Button button39 = new java.awt.Button();
	java.awt.Button button40 = new java.awt.Button();
	java.awt.Button button41 = new java.awt.Button();
	java.awt.Button button42 = new java.awt.Button();
	java.awt.Button button43 = new java.awt.Button();
	java.awt.Button button44 = new java.awt.Button();
	java.awt.Button button45 = new java.awt.Button();
	java.awt.Button button46 = new java.awt.Button();
	java.awt.Button button47 = new java.awt.Button();
	java.awt.Button button48 = new java.awt.Button();
	java.awt.Button button49 = new java.awt.Button();
	java.awt.Label label1 = new java.awt.Label();
	java.awt.Label label2 = new java.awt.Label();
	java.awt.Button button50 = new java.awt.Button();
	java.awt.Label label3 = new java.awt.Label();
	java.awt.Label label4 = new java.awt.Label();
	java.awt.Label label5 = new java.awt.Label();
	java.awt.Choice choice1 = new java.awt.Choice();
	java.awt.Choice choice2 = new java.awt.Choice();
	java.awt.Label label6 = new java.awt.Label();
	java.awt.Label label7 = new java.awt.Label();
	java.awt.Label label8 = new java.awt.Label();
	java.awt.Label label9 = new java.awt.Label();
	java.awt.Label label10 = new java.awt.Label();
	java.awt.TextField textField1 = new java.awt.TextField();
	java.awt.Label label11 = new java.awt.Label();
	java.awt.Label label12 = new java.awt.Label();
	java.awt.Label label13 = new java.awt.Label();
	java.awt.Label label14 = new java.awt.Label();
	java.awt.Button button51 = new java.awt.Button();
	java.awt.Frame frame = new java.awt.Frame();
// IMPORTANT: Source code between BEGIN/END comment pair will be regenerated
// every time the form is saved. All manual changes will be overwritten.
// BEGIN GENERATED CODE
	// member declarations
	public GraphicsStarter() 
	{
	}

	// Main entry point
	public void startGraphics()
	{
		try 
		{
		button1.setBackground(java.awt.Color.white);
		button1.setVisible(true);
		button1.setForeground(java.awt.Color.blue);
		button1.setLocation(new java.awt.Point(30, 340));
		button1.setSize(new java.awt.Dimension(30, 30));
		button2.setBackground(java.awt.Color.white);
		button2.setVisible(true);
		button2.setForeground(java.awt.Color.blue);
		button2.setLocation(new java.awt.Point(30, 300));
		button2.setSize(new java.awt.Dimension(30, 30));
		button3.setBackground(java.awt.Color.white);
		button3.setVisible(true);
		button3.setForeground(java.awt.Color.blue);
		button3.setLocation(new java.awt.Point(30, 260));
		button3.setSize(new java.awt.Dimension(30, 30));
		button4.setBackground(java.awt.Color.white);
		button4.setVisible(true);
		button4.setForeground(java.awt.Color.blue);
		button4.setLocation(new java.awt.Point(30, 220));
		button4.setSize(new java.awt.Dimension(30, 30));
		button5.setBackground(java.awt.Color.white);
		button5.setVisible(true);
		button5.setForeground(java.awt.Color.blue);
		button5.setLocation(new java.awt.Point(30, 180));
		button5.setSize(new java.awt.Dimension(30, 30));
		button6.setBackground(java.awt.Color.white);
		button6.setVisible(true);
		button6.setForeground(java.awt.Color.blue);
		button6.setLocation(new java.awt.Point(30, 140));
		button6.setSize(new java.awt.Dimension(30, 30));
		button7.setBackground(java.awt.Color.white);
		button7.setVisible(true);
		button7.setForeground(java.awt.Color.blue);
		button7.setLocation(new java.awt.Point(70, 340));
		button7.setSize(new java.awt.Dimension(30, 30));
		button8.setBackground(java.awt.Color.white);
		button8.setVisible(true);
		button8.setForeground(java.awt.Color.blue);
		button8.setLocation(new java.awt.Point(70, 300));
		button8.setSize(new java.awt.Dimension(30, 30));
		button9.setBackground(java.awt.Color.white);
		button9.setVisible(true);
		button9.setForeground(java.awt.Color.blue);
		button9.setLocation(new java.awt.Point(70, 260));
		button9.setSize(new java.awt.Dimension(30, 30));
		button10.setBackground(java.awt.Color.white);
		button10.setVisible(true);
		button10.setForeground(java.awt.Color.blue);
		button10.setLocation(new java.awt.Point(70, 220));
		button10.setSize(new java.awt.Dimension(30, 30));
		button11.setBackground(java.awt.Color.white);
		button11.setVisible(true);
		button11.setForeground(java.awt.Color.blue);
		button11.setLocation(new java.awt.Point(70, 180));
		button11.setSize(new java.awt.Dimension(30, 30));
		button12.setBackground(java.awt.Color.white);
		button12.setVisible(true);
		button12.setForeground(java.awt.Color.blue);
		button12.setLocation(new java.awt.Point(70, 140));
		button12.setSize(new java.awt.Dimension(30, 30));
		button13.setBackground(java.awt.Color.white);
		button13.setVisible(true);
		button13.setForeground(java.awt.Color.blue);
		button13.setLocation(new java.awt.Point(110, 340));
		button13.setSize(new java.awt.Dimension(30, 30));
		button14.setBackground(java.awt.Color.white);
		button14.setVisible(true);
		button14.setForeground(java.awt.Color.blue);
		button14.setLocation(new java.awt.Point(110, 300));
		button14.setSize(new java.awt.Dimension(30, 30));
		button15.setBackground(java.awt.Color.white);
		button15.setVisible(true);
		button15.setForeground(java.awt.Color.blue);
		button15.setLocation(new java.awt.Point(110, 260));
		button15.setSize(new java.awt.Dimension(30, 30));
		button16.setBackground(java.awt.Color.white);
		button16.setVisible(true);
		button16.setForeground(java.awt.Color.blue);
		button16.setLocation(new java.awt.Point(110, 220));
		button16.setSize(new java.awt.Dimension(30, 30));
		button17.setBackground(java.awt.Color.white);
		button17.setVisible(true);
		button17.setForeground(java.awt.Color.blue);
		button17.setLocation(new java.awt.Point(110, 180));
		button17.setSize(new java.awt.Dimension(30, 30));
		button18.setBackground(java.awt.Color.white);
		button18.setVisible(true);
		button18.setForeground(java.awt.Color.blue);
		button18.setLocation(new java.awt.Point(110, 140));
		button18.setSize(new java.awt.Dimension(30, 30));
		button19.setBackground(java.awt.Color.white);
		button19.setVisible(true);
		button19.setForeground(java.awt.Color.blue);
		button19.setLocation(new java.awt.Point(150, 340));
		button19.setSize(new java.awt.Dimension(30, 30));
		button20.setBackground(java.awt.Color.white);
		button20.setVisible(true);
		button20.setForeground(java.awt.Color.blue);
		button20.setLocation(new java.awt.Point(150, 300));
		button20.setSize(new java.awt.Dimension(30, 30));
		button21.setBackground(java.awt.Color.white);
		button21.setVisible(true);
		button21.setForeground(java.awt.Color.blue);
		button21.setLocation(new java.awt.Point(150, 260));
		button21.setSize(new java.awt.Dimension(30, 30));
		button22.setBackground(java.awt.Color.white);
		button22.setVisible(true);
		button22.setForeground(java.awt.Color.blue);
		button22.setLocation(new java.awt.Point(150, 220));
		button22.setSize(new java.awt.Dimension(30, 30));
		button23.setBackground(java.awt.Color.white);
		button23.setVisible(true);
		button23.setForeground(java.awt.Color.blue);
		button23.setLocation(new java.awt.Point(150, 180));
		button23.setSize(new java.awt.Dimension(30, 30));
		button24.setBackground(java.awt.Color.white);
		button24.setVisible(true);
		button24.setForeground(java.awt.Color.blue);
		button24.setLocation(new java.awt.Point(150, 140));
		button24.setSize(new java.awt.Dimension(30, 30));
		button25.setBackground(java.awt.Color.white);
		button25.setVisible(true);
		button25.setForeground(java.awt.Color.blue);
		button25.setLocation(new java.awt.Point(190, 340));
		button25.setSize(new java.awt.Dimension(30, 30));
		button26.setBackground(java.awt.Color.white);
		button26.setVisible(true);
		button26.setForeground(java.awt.Color.blue);
		button26.setLocation(new java.awt.Point(190, 300));
		button26.setSize(new java.awt.Dimension(30, 30));
		button27.setBackground(java.awt.Color.white);
		button27.setVisible(true);
		button27.setForeground(java.awt.Color.blue);
		button27.setLocation(new java.awt.Point(190, 260));
		button27.setSize(new java.awt.Dimension(30, 30));
		button28.setBackground(java.awt.Color.white);
		button28.setVisible(true);
		button28.setForeground(java.awt.Color.blue);
		button28.setLocation(new java.awt.Point(190, 220));
		button28.setSize(new java.awt.Dimension(30, 30));
		button29.setBackground(java.awt.Color.white);
		button29.setVisible(true);
		button29.setForeground(java.awt.Color.blue);
		button29.setLocation(new java.awt.Point(190, 180));
		button29.setSize(new java.awt.Dimension(30, 30));
		button30.setBackground(java.awt.Color.white);
		button30.setVisible(true);
		button30.setForeground(java.awt.Color.blue);
		button30.setLocation(new java.awt.Point(190, 140));
		button30.setSize(new java.awt.Dimension(30, 30));
		button31.setBackground(java.awt.Color.white);
		button31.setVisible(true);
		button31.setForeground(java.awt.Color.blue);
		button31.setLocation(new java.awt.Point(230, 340));
		button31.setSize(new java.awt.Dimension(30, 30));
		button32.setBackground(java.awt.Color.white);
		button32.setVisible(true);
		button32.setForeground(java.awt.Color.blue);
		button32.setLocation(new java.awt.Point(230, 300));
		button32.setSize(new java.awt.Dimension(30, 30));
		button33.setBackground(java.awt.Color.white);
		button33.setVisible(true);
		button33.setForeground(java.awt.Color.blue);
		button33.setLocation(new java.awt.Point(230, 260));
		button33.setSize(new java.awt.Dimension(30, 30));
		button34.setBackground(java.awt.Color.white);
		button34.setVisible(true);
		button34.setForeground(java.awt.Color.blue);
		button34.setLocation(new java.awt.Point(230, 220));
		button34.setSize(new java.awt.Dimension(30, 30));
		button35.setBackground(java.awt.Color.white);
		button35.setVisible(true);
		button35.setForeground(java.awt.Color.blue);
		button35.setLocation(new java.awt.Point(230, 180));
		button35.setSize(new java.awt.Dimension(30, 30));
		button36.setBackground(java.awt.Color.white);
		button36.setVisible(true);
		button36.setForeground(java.awt.Color.blue);
		button36.setLocation(new java.awt.Point(230, 140));
		button36.setSize(new java.awt.Dimension(30, 30));
		button37.setBackground(java.awt.Color.white);
		button37.setVisible(true);
		button37.setForeground(java.awt.Color.blue);
		button37.setLocation(new java.awt.Point(270, 340));
		button37.setSize(new java.awt.Dimension(30, 30));
		button38.setBackground(java.awt.Color.white);
		button38.setVisible(true);
		button38.setForeground(java.awt.Color.blue);
		button38.setLocation(new java.awt.Point(270, 300));
		button38.setSize(new java.awt.Dimension(30, 30));
		button39.setBackground(java.awt.Color.white);
		button39.setVisible(true);
		button39.setForeground(java.awt.Color.blue);
		button39.setLocation(new java.awt.Point(270, 260));
		button39.setSize(new java.awt.Dimension(30, 30));
		button40.setBackground(java.awt.Color.white);
		button40.setVisible(true);
		button40.setForeground(java.awt.Color.blue);
		button40.setLocation(new java.awt.Point(270, 220));
		button40.setSize(new java.awt.Dimension(30, 30));
		button41.setBackground(java.awt.Color.white);
		button41.setVisible(true);
		button41.setForeground(java.awt.Color.blue);
		button41.setLocation(new java.awt.Point(270, 180));
		button41.setSize(new java.awt.Dimension(30, 30));
		button42.setBackground(java.awt.Color.white);
		button42.setVisible(true);
		button42.setForeground(java.awt.Color.blue);
		button42.setLocation(new java.awt.Point(270, 140));
		button42.setSize(new java.awt.Dimension(30, 30));
		button43.setBackground(java.awt.Color.white);
		button43.setVisible(true);
		button43.setLabel("drop");
		button43.setLocation(new java.awt.Point(30, 100));
		button43.setSize(new java.awt.Dimension(30, 30));
		button44.setBackground(java.awt.Color.white);
		button44.setVisible(true);
		button44.setLabel("drop");
		button44.setLocation(new java.awt.Point(70, 100));
		button44.setSize(new java.awt.Dimension(30, 30));
		button45.setBackground(java.awt.Color.white);
		button45.setVisible(true);
		button45.setLabel("drop");
		button45.setLocation(new java.awt.Point(110, 100));
		button45.setSize(new java.awt.Dimension(30, 30));
		button46.setBackground(java.awt.Color.white);
		button46.setVisible(true);
		button46.setLabel("drop");
		button46.setLocation(new java.awt.Point(150, 100));
		button46.setSize(new java.awt.Dimension(30, 30));
		button47.setBackground(java.awt.Color.white);
		button47.setVisible(true);
		button47.setLabel("drop");
		button47.setLocation(new java.awt.Point(190, 100));
		button47.setSize(new java.awt.Dimension(30, 30));
		button48.setBackground(java.awt.Color.white);
		button48.setVisible(true);
		button48.setLabel("drop");
		button48.setLocation(new java.awt.Point(230, 100));
		button48.setSize(new java.awt.Dimension(30, 30));
		button49.setBackground(java.awt.Color.white);
		button49.setVisible(true);
		button49.setLabel("drop");
		button49.setLocation(new java.awt.Point(270, 100));
		button49.setSize(new java.awt.Dimension(30, 30));
		label1.setFont(new java.awt.Font("Dialog", 0, 24));
		label1.setVisible(true);
		label1.setForeground(java.awt.Color.red);
		label1.setLocation(new java.awt.Point(80, 10));
		label1.setText("Connect Four");
		label1.setSize(new java.awt.Dimension(160, 40));
		label2.setVisible(true);
		label2.setForeground(java.awt.Color.cyan);
		label2.setLocation(new java.awt.Point(110, 60));
		label2.setSize(new java.awt.Dimension(90, 20));
		button50.setBackground(java.awt.Color.white);
		button50.setVisible(true);
		button50.setForeground(java.awt.Color.black);
		button50.setLabel("New game");
		button50.setLocation(new java.awt.Point(250, 20));
		button50.setSize(new java.awt.Dimension(70, 30));
		label3.setVisible(true);
		label3.setLocation(new java.awt.Point(320, 300));
		label3.setText("Note: To start a game where");
		label3.setSize(new java.awt.Dimension(160, 20));
		label4.setVisible(true);
		label4.setLocation(new java.awt.Point(320, 320));
		label4.setText("the computer plays first,");
		label4.setSize(new java.awt.Dimension(160, 20));
		label5.setVisible(true);
		label5.setLocation(new java.awt.Point(320, 340));
		label5.setText("press the new game button");
		label5.setSize(new java.awt.Dimension(160, 20));
		choice1.setVisible(true);
		choice1.setLocation(new java.awt.Point(330, 130));
		choice1.setSize(new java.awt.Dimension(150, 21));
		choice2.setVisible(true);
		choice2.setLocation(new java.awt.Point(330, 200));
		choice2.setSize(new java.awt.Dimension(150, 21));
		label6.setVisible(true);
		label6.setLocation(new java.awt.Point(330, 100));
		label6.setText("Player 1 level");
		label6.setSize(new java.awt.Dimension(150, 20));
		label7.setVisible(true);
		label7.setLocation(new java.awt.Point(330, 170));
		label7.setText("Player 2 level");
		label7.setSize(new java.awt.Dimension(150, 20));
		label8.setVisible(true);
		label8.setLocation(new java.awt.Point(330, 230));
		label8.setText("Note: level changes take");
		label8.setSize(new java.awt.Dimension(150, 20));
		label9.setVisible(true);
		label9.setLocation(new java.awt.Point(330, 250));
		label9.setText("effect at the beginning of");
		label9.setSize(new java.awt.Dimension(140, 20));
		label10.setVisible(true);
		label10.setLocation(new java.awt.Point(330, 270));
		label10.setText("each game");
		label10.setSize(new java.awt.Dimension(140, 20));
		textField1.setLocation(new java.awt.Point(330, 70));
		textField1.setVisible(true);
		textField1.setText("100");
		textField1.setSize(new java.awt.Dimension(50, 20));
		label11.setVisible(true);
		label11.setLocation(new java.awt.Point(330, 40));
		label11.setText("ms to fall one place");
		label11.setSize(new java.awt.Dimension(150, 20));
		label12.setVisible(true);
		label12.setLocation(new java.awt.Point(30, 390));
		label12.setText("Player 1 wins: 0");
		label12.setSize(new java.awt.Dimension(150, 20));
		label13.setVisible(true);
		label13.setLocation(new java.awt.Point(30, 420));
		label13.setText("Player 2 wins: 0");
		label13.setSize(new java.awt.Dimension(150, 20));
		label14.setVisible(true);
		label14.setLocation(new java.awt.Point(30, 450));
		label14.setText("draws: 0");
		label14.setSize(new java.awt.Dimension(150, 20));
		button51.setBackground(java.awt.Color.white);
		button51.setVisible(true);
		button51.setLabel("Reset games");
		button51.setLocation(new java.awt.Point(220, 380));
		button51.setSize(new java.awt.Dimension(80, 20));
		frame.setLocation(new java.awt.Point(0, 0));
		frame.setLayout(null);
		frame.setForeground(null);
		frame.setBackground(java.awt.Color.blue);

		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
		frame.add(button7);
		frame.add(button8);
		frame.add(button9);
		frame.add(button10);
		frame.add(button11);
		frame.add(button12);
		frame.add(button13);
		frame.add(button14);
		frame.add(button15);
		frame.add(button16);
		frame.add(button17);
		frame.add(button18);
		frame.add(button19);
		frame.add(button20);
		frame.add(button21);
		frame.add(button22);
		frame.add(button23);
		frame.add(button24);
		frame.add(button25);
		frame.add(button26);
		frame.add(button27);
		frame.add(button28);
		frame.add(button29);
		frame.add(button30);
		frame.add(button31);
		frame.add(button32);
		frame.add(button33);
		frame.add(button34);
		frame.add(button35);
		frame.add(button36);
		frame.add(button37);
		frame.add(button38);
		frame.add(button39);
		frame.add(button40);
		frame.add(button41);
		frame.add(button42);
		frame.add(button43);
		frame.add(button44);
		frame.add(button45);
		frame.add(button46);
		frame.add(button47);
		frame.add(button48);
		frame.add(button49);
		frame.add(label1);
		frame.add(label2);
		frame.add(button50);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(choice1);
		frame.add(choice2);
		frame.add(label6);
		frame.add(label7);
		frame.add(label8);
		frame.add(label9);
		frame.add(label10);
		frame.add(textField1);
		frame.add(label11);
		frame.add(label12);
		frame.add(label13);
		frame.add(label14);
		frame.add(button51);

		frame.setSize(new java.awt.Dimension(500, 500));
		frame.setVisible(true);

		// event handling
		button1.addPropertyChangeListener(new java.beans.PropertyChangeListener() 
		{
			public void propertyChange(java.beans.PropertyChangeEvent e) 
			{
				button1PropertyChange(e);
			}
		});
		button2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button2PropertyChange(e);
			}
		});
		button3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button3PropertyChange(e);
			}
		});
		button4.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button4PropertyChange(e);
			}
		});
		button5.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button5PropertyChange(e);
			}
		});
		button6.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button6PropertyChange(e);
			}
		});
		button7.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button7PropertyChange(e);
			}
		});
		button8.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button8PropertyChange(e);
			}
		});
		button9.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button9PropertyChange(e);
			}
		});
		button10.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button10PropertyChange(e);
			}
		});
		button11.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button11PropertyChange(e);
			}
		});
		button12.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button12PropertyChange(e);
			}
		});
		button13.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button13PropertyChange(e);
			}
		});
		button14.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button14PropertyChange(e);
			}
		});
		button15.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button15PropertyChange(e);
			}
		});
		button16.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button16PropertyChange(e);
			}
		});
		button17.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button17PropertyChange(e);
			}
		});
		button18.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button18PropertyChange(e);
			}
		});
		button19.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button19PropertyChange(e);
			}
		});
		button20.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button20PropertyChange(e);
			}
		});
		button21.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button21PropertyChange(e);
			}
		});
		button22.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button22PropertyChange(e);
			}
		});
		button23.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button23PropertyChange(e);
			}
		});
		button24.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button24PropertyChange(e);
			}
		});
		button25.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button25PropertyChange(e);
			}
		});
		button26.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button26PropertyChange(e);
			}
		});
		button27.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button27PropertyChange(e);
			}
		});
		button28.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button28PropertyChange(e);
			}
		});
		button29.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button29PropertyChange(e);
			}
		});
		button30.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button30PropertyChange(e);
			}
		});
		button31.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button31PropertyChange(e);
			}
		});
		button32.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button32PropertyChange(e);
			}
		});
		button33.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button33PropertyChange(e);
			}
		});
		button34.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button34PropertyChange(e);
			}
		});
		button35.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button35PropertyChange(e);
			}
		});
		button36.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button36PropertyChange(e);
			}
		});
		button37.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button37PropertyChange(e);
			}
		});
		button38.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button38PropertyChange(e);
			}
		});
		button39.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button39PropertyChange(e);
			}
		});
		button40.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button40PropertyChange(e);
			}
		});
		button41.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button41PropertyChange(e);
			}
		});
		button42.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent e) {
				button42PropertyChange(e);
			}
		});
		button43.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				button43ActionPerformed(e);
			}
		});
		button44.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				button44ActionPerformed(e);
			}
		});
		button45.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				button45ActionPerformed(e);
			}
		});
		button46.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				button46ActionPerformed(e);
			}
		});
		button47.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				button47ActionPerformed(e);
			}
		});
		button48.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				button48ActionPerformed(e);
			}
		});
		button49.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				button49ActionPerformed(e);
			}
		});
		button50.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				button50ActionPerformed(e);
			}
		});
		choice1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				choice1ItemStateChanged(e);
			}
		});
		choice2.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent e) {
				choice2ItemStateChanged(e);
			}
		});
		textField1.addTextListener(new java.awt.event.TextListener() {
			public void textValueChanged(java.awt.event.TextEvent e) {
				textField1TextValueChanged(e);
			}
		});
		button51.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				button51ActionPerformed(e);
			}
		});

// END GENERATED CODE
	choice1.insert("human player", 0);
	choice1.insert("Computer level 1", 1);
	choice1.insert("Computer level 2", 2);
	choice1.insert("Computer level 3", 3);
	choice1.insert("Computer level 4", 4);
	choice1.insert("Computer level 5", 5);
	choice1.insert("Computer level 6", 6);
	choice1.insert("Expert comp", 7);
	choice2.insert("human player", 0);
	choice2.insert("Computer level 1", 1);
	choice2.insert("Computer level 2", 2);
	choice2.insert("Computer level 3", 3);
	choice2.insert("Computer level 4", 4);
	choice2.insert("Computer level 5", 5);
	choice2.insert("Computer level 6", 6);
	choice2.insert("Expert comp", 7);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	boolean isStandalone = false;


	// Retrieve the value of an applet parameter
	/*public String getParameter(String key, String def) {
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
	}*/

	// Initialize the applet
	/*public void init() 
	{
		try 
		{
			initComponents();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}*/

	public void button43ActionPerformed(java.awt.event.ActionEvent e)
	{
		if (!done || b.b[5] != 0)
		{
		}
		else if ((turn && level1==0) || (!turn && level2 == 0))
		{
			done = false;
			dropPiece(0, turn);
		}
	}
	public void button44ActionPerformed(java.awt.event.ActionEvent e)
	{
		if (!done || b.b[11] != 0)
		{
		}
		else if ((turn && level1==0) || (!turn && level2 == 0))
		{
			done = false;
			dropPiece(1, turn);
		}
	}
	public void button45ActionPerformed(java.awt.event.ActionEvent e)
	{
		if (!done || b.b[17] != 0)
		{
		}
		else if ((turn && level1==0) || (!turn && level2 == 0))
		{
			done = false;
			dropPiece(2,turn);
		}
	}
	public void button46ActionPerformed(java.awt.event.ActionEvent e)
	{
		if (!done || b.b[23] != 0)
		{
		}
		else if ((turn && level1==0) || (!turn && level2 == 0))
		{
			done = false;
			dropPiece(3,turn);
		}
	}
	public void button47ActionPerformed(java.awt.event.ActionEvent e)
	{
		if (!done || b.b[29] != 0)
		{
		}
		else if ((turn && level1==0) || (!turn && level2 == 0))
		{
			done = false;
			dropPiece(4,turn);
		}
	}
	public void button48ActionPerformed(java.awt.event.ActionEvent e)
	{
		if (!done || b.b[35] != 0)
		{
		}
		else if ((turn && level1==0) || (!turn && level2 == 0))
		{
			done = false;
			dropPiece(5,turn);
		}
	}
	public void button49ActionPerformed(java.awt.event.ActionEvent e)
	{
		if (!done || b.b[41] != 0)
		{
		}
		else if ((turn && level1==0) || (!turn && level2 == 0))
		{
			done = false;
			dropPiece(6,turn);
		}
	}
	public void button50ActionPerformed(java.awt.event.ActionEvent e)
	{
		
		turn = true;
		done = true;
		b.reset();
		level1 = choice1.getSelectedIndex();
		level2 = choice2.getSelectedIndex();
		label2.setText("");
		Button[] buttons = new Button[49];
		buttons[0] = button1;
		buttons[1] = button2;
		buttons[2] = button3;
		buttons[3] = button4;
		buttons[4] = button5;
		buttons[5] = button6;
		buttons[6] = button7;
		buttons[7] = button8;
		buttons[8] = button9;
		buttons[9] = button10;
		buttons[10] = button11;
		buttons[11] = button12;
		buttons[12] = button13;
		buttons[13] = button14;
		buttons[14] = button15;
		buttons[15] = button16;
		buttons[16] = button17;
		buttons[17] = button18;
		buttons[18] = button19;
		buttons[19] = button20;
		buttons[20] = button21;
		buttons[21] = button22;
		buttons[22] = button23;
		buttons[23] = button24;
		buttons[24] = button25;
		buttons[25] = button26;
		buttons[26] = button27;
		buttons[27] = button28;
		buttons[28] = button29;
		buttons[29] = button30;
		buttons[30] = button31;
		buttons[31] = button32;
		buttons[32] = button33;
		buttons[33] = button34;
		buttons[34] = button35;
		buttons[35] = button36;
		buttons[36] = button37;
		buttons[37] = button38;
		buttons[38] = button39;
		buttons[39] = button40;
		buttons[40] = button41;
		buttons[41] = button42;
		buttons[42] = button43;
		buttons[43] = button44;
		buttons[44] = button45;
		buttons[45] = button46;
		buttons[46] = button47;
		buttons[47] = button48;
		buttons[48] = button49;
		for (int x = 0; x < 49; x++)
		{
			buttons[x].setBackground(Color.white);
		}
		for (int x = 0; x < 42; x++)
		{
			buttons[x].setLabel("");
		}
		long l = System.currentTimeMillis();
		while (System.currentTimeMillis() - l < 500)
		{
		}
		if (turn && level1 > 0 && b.nummoves < 42)
		{
			if (level1 == 7)
			{
				b.n = 5;
				b.n2 = 2;
				b.learns1 = true;
				b.learns2 = true;
			}
			else
			{
				b.learns1 = false;
				b.learns2 = false;
				if (level1 <= 3)
				{
					b.n = 0;
				}
				else
				{
					b.n = 5;
				}
				b.n2 = (level1-1)%3;
			}
			b.block = false;
			b.numcolumns = 6;
			for (int y = 0; y < 7; y++)
			{
				int p = b.possible[y];
				if (p == -1)
				{
					b.numcolumns--;
				}
			}
			if (b.n == 5)
			{
				b.n += 2*(3 - (b.numcolumns+1)/2);
			}
			b.max = b.n;
			done = false;
			dropPiece(b.findMoveX(), turn);
		}
	}
	public void dropPiece(int x, boolean t)
	{
		if (b.win() || b.nummoves == 42)
		{
			return;
		}
		Button[] buttons = new Button[49];
		buttons[0] = button1;
		buttons[1] = button2;
		buttons[2] = button3;
		buttons[3] = button4;
		buttons[4] = button5;
		buttons[5] = button6;
		buttons[6] = button7;
		buttons[7] = button8;
		buttons[8] = button9;
		buttons[9] = button10;
		buttons[10] = button11;
		buttons[11] = button12;
		buttons[12] = button13;
		buttons[13] = button14;
		buttons[14] = button15;
		buttons[15] = button16;
		buttons[16] = button17;
		buttons[17] = button18;
		buttons[18] = button19;
		buttons[19] = button20;
		buttons[20] = button21;
		buttons[21] = button22;
		buttons[22] = button23;
		buttons[23] = button24;
		buttons[24] = button25;
		buttons[25] = button26;
		buttons[26] = button27;
		buttons[27] = button28;
		buttons[28] = button29;
		buttons[29] = button30;
		buttons[30] = button31;
		buttons[31] = button32;
		buttons[32] = button33;
		buttons[33] = button34;
		buttons[34] = button35;
		buttons[35] = button36;
		buttons[36] = button37;
		buttons[37] = button38;
		buttons[38] = button39;
		buttons[39] = button40;
		buttons[40] = button41;
		buttons[41] = button42;
		buttons[42] = button43;
		buttons[43] = button44;
		buttons[44] = button45;
		buttons[45] = button46;
		buttons[46] = button47;
		buttons[47] = button48;
		buttons[48] = button49;
		Color c = Color.white;
		if (t)
		{
			c = Color.red;
		}
		else
		{
			c = Color.black;
		}
		buttons[42+x].setBackground(c);
		start = System.currentTimeMillis();
		stop = System.currentTimeMillis();
		while ((stop - start) < w)
		{
			stop = System.currentTimeMillis();
		}
		buttons[42+x].setBackground(Color.white);
		buttons[6*x + 5].setBackground(c);
		if (!done)
		{
			start = System.currentTimeMillis();
			stop = System.currentTimeMillis();
			while ((stop - start) < w)
			{
				stop = System.currentTimeMillis();
			}
			buttons[6*x + 5].setBackground(Color.white);
			buttons[6*x + 4].setBackground(c);
		}
		if (!done)
		{
			start = System.currentTimeMillis();
			stop = System.currentTimeMillis();
			while ((stop - start) < w)
			{
				stop = System.currentTimeMillis();
			}
			buttons[6*x + 4].setBackground(Color.white);
			buttons[6*x + 3].setBackground(c);
		}
		if (!done)
		{
			start = System.currentTimeMillis();
			stop = System.currentTimeMillis();
			while ((stop - start) < w)
			{
				stop = System.currentTimeMillis();
			}
			buttons[6*x + 3].setBackground(Color.white);
			buttons[6*x + 2].setBackground(c);
		}
		if (!done)
		{
			start = System.currentTimeMillis();
			stop = System.currentTimeMillis();
			while ((stop - start) < w)
			{
				stop = System.currentTimeMillis();
			}
			buttons[6*x + 2].setBackground(Color.white);
			buttons[6*x + 1].setBackground(c);
		}
		if (!done)
		{
			start = System.currentTimeMillis();
			stop = System.currentTimeMillis();
			while ((stop - start) < w)
			{
				stop = System.currentTimeMillis();
			}
			buttons[6*x + 1].setBackground(Color.white);
			buttons[6*x].setBackground(c);
		}
		if (b.win())
		{
			done = false;
			int[] winner = b.findWin();
			if (!turn)
			{
				firstwins++;
				label12.setText("Player 1 wins: " + firstwins);
				label2.setText("Player 1 wins!");
				for (int y = 1; y <= winner[0]; y++)
				{
					buttons[winner[y]].setLabel("W");
				}
			}
			else
			{
				secondwins++;
				label13.setText("Player 2 wins: " + secondwins);
				label2.setText("Player 2 wins!");
				for (int y = 1; y <= winner[0]; y++)
				{
					buttons[winner[y]].setLabel("W");
				}
			}
		}
		if (b.nummoves == 42)
		{
			draws++;
			label14.setText("draws: " + draws);
			done = false;
			label2.setText("Draw");
		}
		if (turn && level1 > 0 && b.nummoves < 42)
		{
			if (level1 == 7)
			{
				b.n = 5;
				b.n2 = 2;
				b.learns1 = true;
				b.learns2 = true;
			}
			else
			{
				b.learns1 = false;
				b.learns2 = false;
				if (level1 <= 3)
				{
					b.n = 0;
				}
				else
				{
					b.n = 5;
				}
				b.n2 = (level1-1)%3;
			}
			b.block = false;
			b.numcolumns = 6;
			for (int y = 0; y < 7; y++)
			{
				int p = b.possible[y];
				if (p == -1)
				{
					b.numcolumns--;
				}
			}
			if (b.n == 5)
			{
				b.n += 2*(3 - (b.numcolumns+1)/2);
			}
			b.max = b.n;
			done = false;
			dropPiece(b.findMoveX(), turn);
		}
		else if (!turn && level2 > 0 && b.nummoves < 42)
		{
			if (level2 == 7)
			{
				b.n = 5;
				b.n2 = 2;
				b.learns1 = true;
				b.learns2 = true;
			}
			else
			{
				b.learns1 = false;
				b.learns2 = false;
				if (level2 <= 3)
				{
					b.n = 0;
				}
				else
				{
					b.n = 5;
				}
				b.n2 = (level2-1)%3;
			}
			b.block = false;
			b.numcolumns = 6;
			for (int y = 0; y < 7; y++)
			{
				int p = b.possible[y];
				if (p == -1)
				{
					b.numcolumns--;
				}
			}
			if (b.n == 5)
			{
				b.n += 2*(3 - (b.numcolumns+1)/2);
			}
			b.max = b.n;
			done = false;
			dropPiece(b.findMoveO(), turn);
		}
	}
	public void button6PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button6.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[4] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(5);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(5);
				turn = true;
				done = true;
			}
		}
	}
	public void button5PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button5.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[3] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(4);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(4);
				turn = true;
				done = true;
			}
		}
	}
	public void button4PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button4.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[2] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(3);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(3);
				turn = true;
				done = true;
			}
		}
	}
	public void button3PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button3.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[1] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(2);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(2);
				turn = true;
				done = true;
			}
		}
	}
	public void button2PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button2.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[0] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(1);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(1);
				turn = true;
				done = true;
			}
		}
	}
	public void button1PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button1.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (turn)
			{
				b.moveX(0);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(0);
				turn = true;
				done = true;
			}
		}
	}
	public void button12PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button12.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[10] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(11);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(11);
				turn = true;
				done = true;
			}
		}
	}
	public void button11PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button11.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[9] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(10);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(10);
				turn = true;
				done = true;
			}
		}
	}
	public void button10PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button10.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[8] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(9);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(9);
				turn = true;
				done = true;
			}
		}
	}
	public void button9PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button9.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[7] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(8);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(8);
				turn = true;
				done = true;
			}
		}
	}
	public void button8PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button8.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[6] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(7);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(7);
				turn = true;
				done = true;
			}
		}
	}
	public void button7PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button7.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (turn)
			{
				b.moveX(6);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(6);
				turn = true;
				done = true;
			}
		}
	}
	public void button18PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button18.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[16] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(17);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(17);
				turn = true;
				done = true;
			}
		}
	}
	public void button17PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button17.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[15] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(16);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(16);
				turn = true;
				done = true;
			}
		}
	}
	public void button16PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button16.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[14] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(15);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(15);
				turn = true;
				done = true;
			}
		}
	}
	public void button15PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button15.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[13] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(14);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(14);
				turn = true;
				done = true;
			}
		}
	}
	public void button14PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button14.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[12] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(13);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(13);
				turn = true;
				done = true;
			}
		}
	}
	public void button13PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button13.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (turn)
			{
				b.moveX(12);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(12);
				turn = true;
				done = true;
			}
		}
	}
	public void button24PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button24.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[22] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(23);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(23);
				turn = true;
				done = true;
			}
		}
	}
	public void button23PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button23.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[21] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(22);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(22);
				turn = true;
				done = true;
			}
		}
	}
	public void button22PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button22.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[20] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(21);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(21);
				turn = true;
				done = true;
			}
		}
	}
	public void button21PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button21.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[19] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(20);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(20);
				turn = true;
				done = true;
			}
		}
	}
	public void button20PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button20.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[18] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(19);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(19);
				turn = true;
				done = true;
			}
		}
	}
	public void button19PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button19.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (turn)
			{
				b.moveX(18);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(18);
				turn = true;
				done = true;
			}
		}
	}
	public void button30PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button30.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[28] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(29);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(29);
				turn = true;
				done = true;
			}
		}
	}
	public void button29PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button29.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[27] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(28);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(28);
				turn = true;
				done = true;
			}
		}
	}
	public void button28PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button28.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[26] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(27);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(27);
				turn = true;
				done = true;
			}
		}
	}
	public void button27PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button27.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[25] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(26);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(26);
				turn = true;
				done = true;
			}
		}
	}
	public void button26PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button26.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[24] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(25);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(25);
				turn = true;
				done = true;
			}
		}
	}
	public void button25PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button25.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (turn)
			{
				b.moveX(24);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(24);
				turn = true;
				done = true;
			}
		}
	}
	public void button36PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button36.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[34] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(35);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(35);
				turn = true;
				done = true;
			}
		}
	}
	public void button35PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button35.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[33] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(34);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(34);
				turn = true;
				done = true;
			}
		}
	}
	public void button34PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button34.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[32] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(33);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(33);
				turn = true;
				done = true;
			}
		}
	}
	public void button33PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button33.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[31] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(32);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(32);
				turn = true;
				done = true;
			}
		}
	}
	public void button32PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button32.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[30] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(31);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(31);
				turn = true;
				done = true;
			}
		}
	}
	public void button31PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button31.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (turn)
			{
				b.moveX(30);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(30);
				turn = true;
				done = true;
			}
		}
	}
	public void button42PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button42.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[40] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(41);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(41);
				turn = true;
				done = true;
			}
		}
	}
	public void button41PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button41.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[39] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(40);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(40);
				turn = true;
				done = true;
			}
		}
	}
	public void button40PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button40.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[38] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(39);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(39);
				turn = true;
				done = true;
			}
		}
	}
	public void button39PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button39.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[37] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(38);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(38);
				turn = true;
				done = true;
			}
		}
	}
	public void button38PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button38.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (b.b[36] == 0)
			{
			}
			else if (turn)
			{
				b.moveX(37);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(37);
				turn = true;
				done = true;
			}
		}
	}
	public void button37PropertyChange(java.beans.PropertyChangeEvent e) 
	{
		Color c = button37.getBackground();
		if (c.equals(Color.red) || c.equals(Color.black))
		{
			if (turn)
			{
				b.moveX(36);
				turn = false;
				done = true;
			}
			else
			{
				b.moveO(36);
				turn = true;
				done = true;
			}
		}
	}
	public void choice1ItemStateChanged(java.awt.event.ItemEvent e) 
	{
		label12.setText("Player 1 wins: 0");
		label13.setText("Player 2 wins: 0");
		label14.setText("draws: 0");
		firstwins = 0;
		secondwins = 0;
		draws = 0;
		if (b.nummoves == 0)
		{
			level1 = choice1.getSelectedIndex();
		}
	}
	public void choice2ItemStateChanged(java.awt.event.ItemEvent e) 
	{
		label12.setText("Player 1 wins: 0");
		label13.setText("Player 2 wins: 0");
		label14.setText("draws: 0");
		firstwins = 0;
		secondwins = 0;
		draws = 0;
		if (b.nummoves == 0)
		{
			level2 = choice2.getSelectedIndex();
		}
	}
	
	public void textField1TextValueChanged(java.awt.event.TextEvent e) 
	{
		try
		{
			w = Long.parseLong(textField1.getText());
			if (w > 1000)
			{
				textField1.setText("1000");
			}
			if (w < 0)
			{
				textField1.setText("0");
			}
		}
		catch (Exception d)
		{
		}
	}
	public void button51ActionPerformed(java.awt.event.ActionEvent e) 
	{
		label12.setText("Player 1 wins: 0");
		label13.setText("Player 2 wins: 0");
		label14.setText("draws: 0");
		firstwins = 0;
		secondwins = 0;
		draws = 0;
	}
}
public class Board
{
	private boolean killedcolumns[] = new boolean[7];
	public boolean learns1 = false;
	public boolean learns2 = false;
	public HashMap records;
	public HashMap temprecords;
	
	//public String filename = "C:/Documents and Settings/student-117/My Documents/connect four/records.txt";
	//public String filename = "G:/Back To School Stuff/GraphicConnectFour/records.txt";
	public String filename = "C:/Documents and Settings/David Farrell/My Documents/Dave Java/Selected Student Projects/Aarons Connect4 Graphic Version/GraphicConnectFour/records.txt";

	//private EasyWriter recorder;
	public EasyReader reader;
	public String game = "";
	public int nummoves = 0;
	private boolean win = false;
	private int winvalue = 9000;
	private int p = 0;
	public int trial = 0;
	public int[] b = new int[42];
	public int[] possible = {0,6,12,18,24,30,36};
	private boolean[] danger1 = new boolean[42];
	private boolean[] danger2 = new boolean[42];
	public int n = 5;
	public int n2 = 2;
	public int numcolumns = 6;
	public int max = 5;
	public boolean block = false;
	boolean recorded = false;
	private String endgame = "";
	public Board()
	{
		records = new HashMap();
		temprecords = new HashMap();
		reader = new EasyReader(filename);
		String s = reader.readLine();
		String value = reader.readLine();
		while (s != null)
		{
			records.put(s, value);
			s = reader.readLine();
			value = reader.readLine();
		}
		records.put("3333322", "500");
	}
	private boolean isLeft(String g)
	{
		return (g.compareTo("3333333") <= 0);
	}
	private String mirrorGame(String g)
	{
		String mirror = "";
		for (int x = 0; x < g.length(); x++)
		{
			int y = 6 - Integer.parseInt(g.substring(x,x+1));
			mirror += y;
		}
		return mirror;
	}
	public void repeatGame(String g)
	{
		game = "";
		b = new int[42];
		for (int x = 0; x <7; x++)
		{
			possible[x] = 6*x;
		}
		danger1 = new boolean[42];
		danger2 = new boolean[42];
		numcolumns = 6;
		nummoves = 0;
		for (int x = 0; x < g.length(); x++)
		{
			if (x%2 == 0)
			{
				moveX(possible[Integer.parseInt(g.substring(x,x+1))]);
			}
			else
			{
				moveO(possible[Integer.parseInt(g.substring(x,x+1))]);
			}
		}
		//System.out.println("Analysing game... please wait");
		//display();
	}
	/*public void addToRecords()
	{
		recorder = new EasyWriter(filename);
		Iterator i = records.keySet().iterator();
		while (i.hasNext())
		{
			String s = (String)i.next();
			recorder.println(s);
			recorder.println(records.get(s));
		}
		recorder.close();
	}*/
	/*public void analyzeGame()
	{
		boolean storelearns1 = learns1;
		boolean storelearns2 = learns2;
		learns1 = true;
		learns2 = true;
		int length = endgame.length();
		while (length > 0)
		{
			endgame = endgame.substring(0, length-1);
			length = endgame.length();
			repeatGame(endgame);
			n = 5;
			n2 = 2;
			numcolumns = 6;
			for (int x = 0; x < 7; x++)
			{
				int p = possible[x];
				if (p == -1)
				{
					numcolumns--;
				}
			}
			if (n == 5)
			{
				n += 2*(3 - (numcolumns+1)/2);
			}
			max = n;
			recorded = false;
			if (length % 2 == 0)
			{
				findMoveX();
			}
			else
			{
				findMoveO();
			}
		}
		Iterator i = temprecords.keySet().iterator();
		while (i.hasNext())
		{
			Object key = i.next();
			records.put(key, temprecords.get(key));
		}
		temprecords = new HashMap();
		//records.put("3", "100");
		records.put("3333322", "500");
		learns1 = storelearns1;
		learns2 = storelearns2;
		if (!win)
		{
			nummoves = 42;
		}
	}*/
	public int[] findWin()
	{
		int[] winner = new int[50];
		int[] u = new int[8];
		int[] storeb = new int[42];
		for (int x = 0; x < 42; x++)
		{
			storeb[x] = b[x];
		}
		for (int x = 0; x < 42; x++)
		{
			danger1 = new boolean[42];
			danger2 = new boolean[42];
			b = new int[42];
			if (storeb[x] == 1)
			{
				for (int y = 0; y < 42; y++)
				{
					if (y != x)
					{
						if (storeb[y] == 1)
						{
							b[y] = 1;
							modifyDanger1(y,u);
						}
					}
				}
				if (danger1[x])
				{
					winner[0]++;
					winner[winner[0]] = x;
				}
			}
			if (storeb[x] == -1)
			{
				for (int y = 0; y < 42; y++)
				{
					if (y != x)
					{
						if (storeb[y] == -1)
						{
							b[y] = -1;
							modifyDanger2(y,u);
						}
					}
				}
				if (danger2[x])
				{
					winner[0]++;
					winner[winner[0]] = x;
				}
			}
		}
		return winner;
	}
	public void reset()
	{
		b = new int[42];
		for (int x = 0; x <7; x++)
		{
			possible[x] = 6*x;
		}
		danger1 = new boolean[42];
		danger2 = new boolean[42];
		numcolumns = 6;
		nummoves = 0;
		win = false;
		game = "";
		temprecords = new HashMap();
		recorded = false;
	}
	public void moveX(int p)
	{
		block = false;
		if (p == -1)
		{
			return;
		}
		boolean good = false;
		for (int x = 0; x < 7; x++)
		{
			if (possible[x] == p)
			{
				good = true;
				possible[x]++;
				if (possible[x] % 6 == 0)
				{
					possible[x] = -1;
				}
			}
		}
		if (good)
		{
			int[] undo = new int[8];
			b[p] = 1;
			if (danger1[p])
			{
				win = true;
				return;
			}
			modifyDanger1(p, undo);
			if (danger2[p])
			{
				danger2[p] = false;
			}
			nummoves++;
			int x = p/6;
			game += x;
			return;
		}
		System.out.println("Error: Place not available");
	}
	public void moveO(int p)
	{
		block = false;
		if (p == -1)
		{
			return;
		}
		boolean good = false;
		for (int x = 0; x < 7; x++)
		{
			if (possible[x] == p)
			{
				good = true;
				possible[x]++;
				if (possible[x] % 6 == 0)
				{
					possible[x] = -1;
				}
			}
		}
		if (good)
		{
			int[] undo = new int[8];
			b[p] = -1;
			if (danger2[p])
			{
				win = true;
				return;
			}
			modifyDanger2(p, undo);
			if (danger1[p])
			{
				danger1[p] = false;
			}
			nummoves++;
			int x = p/6;
			game += x;
			return;
		}
		System.out.println("Error: Place not available");
	}
	public boolean win()
	{
		return win;
	}
	public int findMoveX()
	{
		if (learns1 && learns2 && n < max)
		{
			if (isLeft(game))
			{
				if (temprecords.containsKey(game))
				{
					trial = Integer.parseInt(temprecords.get(game).toString());
					return 0;
				}
				if (records.containsKey(game))
				{
					trial = Integer.parseInt(records.get(game).toString());
					//System.out.println(n);
					//System.out.println(game + " " + trial);
					return 0;
				}
			}
			else
			{
				String g = mirrorGame(game);
				if (temprecords.containsKey(g))
				{
					trial = Integer.parseInt(temprecords.get(g).toString());
					return 0;
				}
				if (records.containsKey(g))
				{
					trial = Integer.parseInt(records.get(g).toString());
					//System.out.println(n);
					//System.out.println(game + " " + trial);
					return 0;
				}
			}				
		}
		int best = -9999;
		int bestp = 0;
		int rand = 1;
		String storegame = game;
		int[] u = new int[8];
		for (int x = 0; x < 7; x++)
		{
			if (possible[x] != -1 && danger1[possible[x]])
			{
				p = possible[x];
				trial = winvalue + n - nummoves;
				game = storegame;
				return x;
			}
		}
		for (int x = 0; x < 7; x++)
		{
			if (possible[x] != -1 && danger2[possible[x]])
			{
				p = possible[x];
				game += x;
				b[p] = 1;
				modifyDanger1(p, u);
				possible[x]++;
				danger2[p] = false;
				if (possible[x] % 6 == 0)
				{
					possible[x] = -1;
				}
				if (block)//
				{
					block = false;
					n+=2;
				}
				else
				{
					block = true;
				}//
				if (n != 0)
				{
					n--;
					findMoveO();
					n++;
				}
				else
				{
					trial = countPoints(false);
				}
				if (!block)
				{
					n-=2;
					block = true;
				}
				else
				{
					block = false;
				}
				possible[x]--;
				if (possible[x] == -2)
				{
					possible[x] = 6*x + 5;
				}
				b[possible[x]] = 0;
				p = possible[x];
				danger2[p] = true;
				undod1(u);
				game = storegame;
				/*if (!recorded && learns1 && learns2 && n == 5 + 2*(3 - (numcolumns+1)/2))
				{
					if (isLeft(game))
					{
						temprecords.put(game, new Integer(trial));
						if (trial <= -2000 || trial >= 2000)
						{
							recorded = true;
							endgame = game;
						}
						System.out.println("Adding     " + game + " " + trial);
					}
					else
					{
						String g = mirrorGame(game);
						temprecords.put(g, new Integer(trial));
						if (trial <= -2000 || trial >= 2000)
						{
							recorded = true;
							endgame = g;
						}
						System.out.println("Adding     " + g + " " + trial);
					}
				}*/
				return x;
			}
		}
		for (int x = 0; x < 7; x++)
		{
			if (possible[x] != -1)
			{
				String storegame2 = game;
				game += x;
				p = possible[x];
				b[p] = 1;
				modifyDanger1(p, u);
				possible[x]++;
				if (possible[x] % 6 == 0)
				{
					possible[x] = -1;
				}
				if (n != 0)
				{
					n--;
					findMoveO();
					n++;
				}
				else
				{
					trial = countPoints(false);
				}
				possible[x]--;
				if (possible[x] == -2)
				{
					possible[x] = 6*x + 5;
				}
				if ((max != 0) && (n2 != 2) && nummoves <= 10 & n == max & (x <= 1 || x >= 5))
				{
					trial -= 1;
				}
				/*if (n == max & (possible[x] % 6 == 3 || possible[x] % 6 == 4) & (x <= 4 & x >= 2))
				{
					trial += 200;
				}*/
				undod1(u);
				b[possible[x]] = 0;
				if (trial == best)
				{
					rand++;
					if (rand*Math.random() < 1)
					{
						bestp = possible[x];
					}
				}
				if (trial > best)
				{
					rand = 1;
					best = trial;
					bestp = possible[x];
				}
				if (n == 5 + 2*(3 - (numcolumns+1)/2))//
				{
					//System.out.println("X " + trial);
				}//
				game = storegame2;
			}
		}
		p = bestp;
		trial = best;
		game = storegame;
		if (trial <= -9990)
		{
			trial = -5000;
			return 0;
		}
		/*if (!recorded && learns1 && learns2 && n == 5 + 2*(3 - (numcolumns+1)/2))
		{
			if (isLeft(game))
			{
				temprecords.put(game, new Integer(trial));
				if (trial <= -2000 || trial >= 2000)
				{
					recorded = true;
					endgame = game;
				}
				System.out.println("Adding     " + game + " " + trial);
			}
			else
			{
				String g = mirrorGame(game);
				temprecords.put(g, new Integer(trial));
				if (trial <= -2000 || trial >= 2000)
				{
					recorded = true;
					endgame = g;
				}
				System.out.println("Adding     " + g + " " + trial);
			}
		}*/
		return p/6;
	}
	public int findMoveO()
	{
		if (learns1 && learns2 && n < max)
		{
			if (isLeft(game))
			{
				if (temprecords.containsKey(game))
				{
					trial = Integer.parseInt(temprecords.get(game).toString());
					return 0;
				}
				if (records.containsKey(game))
				{
					trial = Integer.parseInt(records.get(game).toString());
					//System.out.println(n);
					//System.out.println(game + " " + trial);
					return 0;
				}
			}
			else
			{
				String g = mirrorGame(game);
				if (temprecords.containsKey(g))
				{
					trial = Integer.parseInt(temprecords.get(g).toString());
					return 0;
				}
				if (records.containsKey(g))
				{
					trial = Integer.parseInt(records.get(g).toString());
					//System.out.println(n);
					//System.out.println(game + " " + trial);
					return 0;
				}
			}				
		}
		int best = 9999;
		int bestp = 0;
		int rand = 1;
		String storegame = game;
		int[] u = new int[8];
		for (int x = 0; x < 7; x++)
		{
			if (possible[x] != -1 && danger2[possible[x]])
			{
				p = possible[x];
				trial = -1*winvalue - n + nummoves;
				game = storegame;
				return x;
			}
		}
		for (int x = 0; x < 7; x++)
		{
			if (possible[x] != -1 && danger1[possible[x]])
			{
				game += x;
				p = possible[x];
				b[p] = -1;
				modifyDanger2(p, u);
				possible[x]++;
				danger1[p] = false;
				if (possible[x] % 6 == 0)
				{
					possible[x] = -1;
				}
				if (block)//
				{
					block = false;
					n+=2;
				}
				else
				{
					block = true;
				}//
				if (n != 0)
				{
					n--;
					findMoveX();
					n++;
				}
				else
				{
					trial = countPoints(true);
				}
				if (!block)
				{
					n-=2;
					block = true;
				}
				else
				{
					block = false;
				}
				possible[x]--;
				if (possible[x] == -2)
				{
					possible[x] = 6*x + 5;
				}
				b[possible[x]] = 0;
				undod2(u);
				p = possible[x];
				danger1[p] = true;
				game = storegame;
				/*if (!recorded && learns1 && learns2 && n == 5 + 2*(3 - (numcolumns+1)/2))
				{
					if (isLeft(game))
					{
						temprecords.put(game, new Integer(trial));
						if (trial <= -2000 || trial >= 2000)
						{
							recorded = true;
							endgame = game;
						}
						System.out.println("Adding     " + game + " " + trial);
					}
					else
					{
						String g = mirrorGame(game);
						temprecords.put(g, new Integer(trial));
						if (trial <= -2000 || trial >= 2000)
						{
							recorded = true;
							endgame = g;
						}
						System.out.println("Adding     " + g + " " + trial);
					}
				}*/
				return x;
			}
		}
		for (int x = 0; x < 7; x++)
		{
			if (possible[x] != -1)
			{
				String storegame2 = game;
				game += x;
				p = possible[x];
				b[p] = -1;
				modifyDanger2(p, u);
				possible[x]++;
				if (possible[x] % 6 == 0)
				{
					possible[x] = -1;
				}
				if (n != 0)
				{
					n--;
					findMoveX();
					n++;
				}
				else
				{
					trial = countPoints(true);
				}
				possible[x]--;
				if (possible[x] == -2)
				{
					possible[x] = 6*x + 5;
				}
				if ((max != 0) && (n2 != 2) && nummoves <= 10 & n == max & (x <= 1 || x >= 5))
				{
					trial += 1;
				}
				/*if (n == max & (possible[x] % 6 == 3 || possible[x] % 6 == 4) & (x <= 4 & x >= 2))
				{
					trial -= 200;
				}*/
				undod2(u);
				b[possible[x]] = 0;
				if (trial == best)
				{
					rand++;
					if (rand*Math.random() < 1)
					{
						bestp = possible[x];
					}
				}
				if (trial < best)
				{
					rand = 1;
					best = trial;
					bestp = possible[x];
				}
				if (n == 5 + 2*(3 - (numcolumns+1)/2))//
				{
					//System.out.println("X " + trial);
				}//
				game = storegame2;
			}
		}
		game = storegame;
		if (best >= 9990)
		{
			trial = -5000;
			return 0;
		}
		p = bestp;
		trial = best;
		/*if (!recorded && learns1 && learns2 && n == 5 + 2*(3 - (numcolumns+1)/2))
		{
			if (isLeft(game))
			{
				temprecords.put(game, new Integer(trial));
				if (trial <= -2000 || trial >= 2000)
				{
					recorded = true;
					endgame = game;
				}
				System.out.println("Adding     " + game + " " + trial);
			}
			else
			{
				String g = mirrorGame(game);
				temprecords.put(g, new Integer(trial));
				if (trial <= -2000 || trial >= 2000)
				{
					recorded = true;
					endgame = g;
				}
				System.out.println("Adding     " + g + " " + trial);
			}
		}*/
		return p/6;
	}
	public int countPoints(boolean turn)
	{
		if (learns1 && learns2 && n < max)
		{
			if (isLeft(game))
			{
				if (temprecords.containsKey(game))
				{
					trial = Integer.parseInt(temprecords.get(game).toString());
					return trial;
				}
				if (records.containsKey(game))
				{
					trial = Integer.parseInt(records.get(game).toString());
					//System.out.println(n);
					//System.out.println(game + " " + trial);
					return trial;
				}
			}
			else
			{
				String g = mirrorGame(game);
				if (temprecords.containsKey(g))
				{
					trial = Integer.parseInt(temprecords.get(g).toString());
					return trial;
				}
				if (records.containsKey(g))
				{
					trial = Integer.parseInt(records.get(g).toString());
					//System.out.println(n);
					//System.out.println(game + " " + trial);
					return trial;
				}
			}				
		}
		if (n2 == 1)
		{
			int total = 0;
			for (int x = 0; x < 7; x++)
			{
				for (int y = 0; y < 6; y++)
				{
					int p = 6*x + y;
					if (danger1[p] & !danger2[p])
					{
						total += 100;
					}
					if (danger2[p] & !danger1[p])
					{
						total -= 100;
					}
					if (danger1[p] & danger2[p])
					{
						y = 7;
					}
				}
			}
			return total;
		}
		if (n2 == 2)
		{
			int poss1 = 0;
			int poss2 = 0;
			int odd1 = 0;
			int odd2 = 0;
			int both = 0;
			int even1 = 0;
			int even2 = 0;
			int botheven = 0;
			int total = 0;
			boolean below1 = false;
			boolean below2 = false;
			int tester[] = new int[8];
			for (int x = 0; x < 7; x++)
			{
				int p = possible[x] - 6*x;
				if (p < 6 && p >= 0)
				{
					p += 6*x;
					if (danger1[p] && turn)
					{
						return winvalue - 1 - nummoves;
					}
					if (danger2[p] && !turn)
					{
						return 1 - winvalue + nummoves;
					}
				}
			}
			for (int x = 0; x < 7; x++)
			{
				int p = possible[x];
				if (p >= 0)
				{
					if (danger1[p])
					{
						b[p] = -1;
						possible[x]++;
						if (possible[x] % 6 == 0)
						{
							possible[x] = -1;
						}
						int answer = countPoints(!turn);
						possible[x]--;
						if (possible[x] == -2)
						{
							possible[x] = 6*x + 5;
						}
						b[p] = 0;
						return answer;
					}
					if (danger2[p])
					{
						b[p] = 1;
						possible[x]++;
						if (possible[x] % 6 == 0)
						{
							possible[x] = -1;
						}
						int answer = countPoints(!turn);
						possible[x]--;
						if (possible[x] == -2)
						{
							possible[x] = 6*x + 5;
						}
						b[p] = 0;
						return answer;
					}
				}
			}
			for (int x = 0; x < 7; x++)
			{

				below1 = false;
				below2 = false;
				boolean other = false;
				int control = 0;
				int low = -1;
				boolean rush = false;
				for (int y = possible[x] - 6*x + 1; y < 6 && y >= 1; y++)
				{
					int p = 6*x + y;
					if (!killedcolumns[x])
					{
						if (danger1[p] && danger2[p])
						{
							if (control == 0)
							{
								if (y%2 == 0)
								{
									both++;
								}
								else
								{
									botheven++;
									//
									if (!rush)
									{
									int[] undo = new int[8];
									b[p-1] = 1;
									modifyDanger1(p-1, undo);
									killedcolumns[x] = true;
									total = countPoints(turn);
									////
									//display();
									//System.out.println(total);
									////
									b[p-1] = 0;
									undod1(undo);
									killedcolumns[x] = false;
									if (total <= 300)
									{
										total -= 200;
										if (nummoves >= 14)
										{
											total -= 300;
										}
									}
									return total;
									}
									//
								}
							}
							if (control == 1)
							{
								if ((y - low) % 2 == 0)
								{
									if (low % 2 == 0)
									{
										odd1--;
										both++;
									}
									else
									{
										even1--;
										botheven++;
									}
								}
								else
								{
									if (low % 2 == 0)
									{
										even1++;
									}
									else
									{
										odd1++;
									}
								}
							}
							if (control == -1)
							{
								if ((y - low) % 2 == 0)
								{
									if (low % 2 == 0)
									{
										odd2--;
										both++;
									}
									else
									{
										even2--;
										botheven++;
									}
								}
								else
								{
									if (low % 2 == 0)
									{
										even2++;
									}
									else
									{
										odd2++;
									}
								}
							}
							y = 7;
						}
						if (danger1[p] && !danger2[p])
						{
							if (!below2)
							{
								if (control == 0)
								{
									control = 1;
									total += 50;
									low = y;
									if (y < 5)
									{
										if (danger1[p+1])
										{
											total += 500*(6-y);
											rush = true;
										}
									}
									if ((y % 2) == 0)
									{
										odd1++;
									}
									else
									{
										even1++;
										//
										if (!rush)
										{
											danger1[p] = false;
											int[] undo1 = new int[8];
											int[] undo2 = new int[8];
											int[] undo3 = new int[8];
											boolean storeabove = false;
											b[p-1] = 1;
											modifyDanger1(p-1, undo1);
											b[p] = -1;
											modifyDanger2(p, undo2);
											if (p%6 != 5)
											{
												b[p+1] = 1;
												modifyDanger1(p+1, undo3);
												storeabove = danger2[p+1];
												danger2[p+1] = false;
											}
											if (p % 6 >= 3)
											{
												killedcolumns[x] = true;
											}
											else if (danger2[p+2])
											{
												killedcolumns[x] = true;
											}
											else if (!danger1[p+2] && danger2[p+3])
											{
												killedcolumns[x] = true;
											}
											total = countPoints(turn);
											////
											//display();
											//System.out.println(total);
											////
											killedcolumns[x] = false;
											if (p%6 != 5)
											{
												b[p+1] = 0;
												undod1(undo3);
												danger2[p+1] = storeabove;
											}
											b[p] = 0;
											undod2(undo2);
											b[p-1] = 0;
											undod1(undo1);
											danger1[p] = true;
											return total;
										}
										//
									}
								}
								else if (control == 1)
								{
									if (y < 5)
									{
										if (danger1[p+1])
										{
											total += 500*(6-y);
										}
									}
									if ((y - low) % 2 == 1)
									{
										if (low % 2 == 0)
										{
											even1++;
										}
										else
										{
											odd1++;
										}
										y = 7;
									}
								}
								else
								{
									if ((y - low) % 2 == 0)
									{
										if (low % 2 == 0)
										{
											odd2--;
											both++;
										}
										else
										{
											even2--;
											botheven++;
										}
										y = 7;
									}
								}
							}
							below1 = true;
							below2 = false;
						}
						if (!danger1[p] && danger2[p])
						{
							if (!below1)
							{
								if (control == 0)
								{
									control = -1;
									if (y < 5)
									{
										if (danger2[p+1])
										{
											rush = true;
											total -= 500*(6-y);
										}
									}
									total -= 50;
									low = y;
									if ((y % 2) == 0)
									{
										odd2++;
									}
									else
									{
										even2++;
										//
										if (!rush)
										{
											int[] undo = new int[8];
											b[p-1] = 1;
											modifyDanger1(p-1, undo);
											killedcolumns[x] = true;
											poss1 = countPoints(turn);
											////
											//display();
											//System.out.println(poss1);
											////
											b[p-1] = 0;
											undod1(undo);
											killedcolumns[x] = false;
											if (poss1 <= 300)
											{
												poss1 -= 500;
												return poss1;
											}
											danger2[p] = false;
											int[] undo1 = new int[8];
											int[] undo2 = new int[8];
											int[] undo3 = new int[8];
											boolean storeabove = false;
											b[p-1] = -1;
											modifyDanger2(p-1, undo1);
											b[p] = 1;
											modifyDanger1(p, undo2);
											if (p%6 != 5)
											{
												b[p+1] = -1;
												modifyDanger2(p+1, undo3);
												storeabove = danger1[p+1];
												danger1[p+1] = false;
											}
											if (p % 6 >= 3)
											{
												killedcolumns[x] = true;
											}
											else if (danger1[p+2])
											{
												killedcolumns[x] = true;
											}
											else if (!danger2[p+2] && danger1[p+3])
											{
												killedcolumns[x] = true;
											}
											poss2 = countPoints(turn);
											////
											//display();
											//System.out.println(poss2);
											////
											killedcolumns[x] = false;
											if (p%6 != 5)
											{
												b[p+1] = 0;
												undod2(undo3);
												danger1[p+1] = storeabove;
											}
											b[p] = 0;
											undod1(undo2);
											b[p-1] = 0;
											undod2(undo1);
											danger2[p] = true;
											if (poss1 < poss2)
											{
												return poss1;
											}
											return poss2;
										}
										//	
									}
								}
								else if (control == -1)
								{
									if (y < 5)
									{
										if (danger2[p+1])
										{
											total -= 500*(6-y);
										}
									}
									if ((y - low) % 2 == 1)
									{
										if (low % 2 == 0)
										{
											even2++;
										}
										else
										{
											odd2++;
										}
										y = 7;
									}
								}
								else
								{
									if ((y - low) % 2 == 0)
									{
										if (low % 2 == 0)
										{
											odd1--;
											both++;
										}
										else
										{
											even1--;
											botheven++;
										}
										y = 7;
									}
								}
							}
							below1 = false;
							below2 = true;
						}
						if (!danger1[p] && !danger2[p])
						{
							below1 = false;
							below2 = false;
						}
					}
				}
			}
			total += b[13]*50;
			total += b[19]*50;
			total += b[25]*50;
			total += b[20]*200;
			total += b[21]*50;
			total += b[22]*100;
			total += b[14]*50;
			total += b[15]*50;
			total += b[16]*50;
			total += b[26]*50;
			total += b[27]*50;
			total += b[28]*50;
			total -= b[0]*50;
			total -= b[6]*50;
			total -= b[30]*50;
			total -= b[36]*50;
			if ((both % 2) + odd1 > odd2)
			{
				if (both % 2 == 1)
				{
					total += 500;
				}
				total += 500*odd1 + 50*even1;
				total -= (50*even2 + 50*odd2);
			}
			else
			{
				if (nummoves >= 14)
				{
					total -= 100;
				}
				if (nummoves >= 22)
				{
					total -= 400;
				}
				if (odd2 + (both%2) >= 2)
				{
					total -= 400;
				}
				total += 100*odd1 + 50*even1;
				total -= (100*even2 + 50*botheven + 50*odd2);
			}
			return total;
		}
		return 0;
	}
	public void modifyDanger1(int p, int[] undo)
	{
		int count = 0;
		int numspaces = 0;
		int s = 0;
		int s2 = 0;
		int count2 = 1;
		for (int x = -3; x <= 3; x++)
		{
			if ((p + 7*x) >= 0)
			{
				if (b[p+7*x] == 1)
				{
					count++;
				}
				else
				{
					numspaces++;
					s2 = s;
					s = x;
				}
				if (numspaces == 2)
				{
					count = x-s2-1;
					numspaces = 1;
				}
				if (count >= 3 && numspaces == 1)
				{
					if (b[p+7*s] == 0)
					{
						if (!danger1[p+7*s])
						{
							danger1[p+7*s] = true;
							undo[count2] = p + 7*s;
							count2++;
						}
					}
				}
				if (((p + 7*x) % 6) == 5)
				{
					count = 0;
					numspaces = 0;
				}
				if ((p + 7*x) > 34)
				{
					x = 4;
				}
			}
		}
		numspaces = 0;
		count = 0;
		for (int x = -3; x <= 3; x++)
		{
			if ((p + x) >= 0 && (p+x) < 42)
			{
				if (b[p+x] == 1)
				{
					count++;
				}
				else
				{
					numspaces++;
					s2 = s;
					s = x;
				}
				if (numspaces == 2)
				{
					count = x-s2-1;
					numspaces = 1;
				}
				if (count >= 3 && numspaces == 1)
				{
					if (b[p+s] == 0)
					{
						if (!danger1[p+s])
						{
							danger1[p+s] = true;
							undo[count2] = p + s;
							count2++;
						}
					}
				}
				if (((p + x) % 6) == 5)
				{
					count = 0;
					numspaces = 0;
				}
			}
		}
		numspaces = 0;
		count = 0;
		for (int x = -3; x <= 3; x++)
		{
			if ((p + 6*x) >= 0 && (p + 6*x) < 42)
			{
				if (b[p+6*x] == 1)
				{
					count++;
				}
				else
				{
					numspaces++;
					s2 = s;
					s = x;
				}
				if (numspaces == 2)
				{
					count = x-s2-1;
					numspaces = 1;
				}
				if (count >= 3 && numspaces == 1)
				{
					if (b[p+6*s] == 0)
					{
						if (!danger1[p+6*s])
						{
							danger1[p+6*s] = true;
							undo[count2] = p + 6*s;
							count2++;
						}
					}
				}
			}
		}
		numspaces = 0;
		count = 0;
		for (int x = -3; x <= 3; x++)
		{
			if ((p + 5*x) >= 0)
			{
				if (b[p+5*x] == 1)
				{
					count++;
				}
				else
				{
					numspaces++;
					s2 = s;
					s = x;
				}
				if (numspaces == 2)
				{
					count = x-s2-1;
					numspaces = 1;
				}
				if (count >= 3 && numspaces == 1)
				{
					if (b[p+5*s] == 0)
					{
						if (!danger1[p+5*s])
						{
							danger1[p+5*s] = true;
							undo[count2] = p + 5*s;
							count2++;
						}
					}
				}
				if (((p + 5*x) % 6) == 0)
				{
					count = 0;
					numspaces = 0;
				}
				if ((p + 5*x) > 35)
				{
					x = 4;
				}
			}
		}
		undo[0] = count2 - 1;
	}
	public void modifyDanger2(int p, int[] undo)
	{
		int count = 0;
		int numspaces = 0;
		int s = 0;
		int s2 = 0;
		int count2 = 1;
		for (int x = -3; x <= 3; x++)
		{
			if ((p + 7*x) >= 0)
			{
				if (b[p+7*x] == -1)
				{
					count++;
				}
				else
				{
					numspaces++;
					s2 = s;
					s = x;
				}
				if (numspaces == 2)
				{
					count = x-s2-1;
					numspaces = 1;
				}
				if (count >= 3 && numspaces == 1)
				{
					if (b[p+7*s] == 0)
					{
						if (!danger2[p+7*s])
						{
							danger2[p+7*s] = true;
							undo[count2] = p + 7*s;
							count2++;
						}
					}
				}
				if (((p + 7*x) % 6) == 5)
				{
					count = 0;
					numspaces = 0;
				}
				if ((p + 7*x) > 34)
				{
					x = 4;
				}
			}
		}
		numspaces = 0;
		count = 0;
		for (int x = -3; x <= 3; x++)
		{
			if ((p + x) >= 0 && (p+x) < 42)
			{
				if (b[p+x] == -1)
				{
					count++;
				}
				else
				{
					numspaces++;
					s2 = s;
					s = x;
				}
				if (numspaces == 2)
				{
					count = x-s2-1;
					numspaces = 1;
				}
				if (count >= 3 && numspaces == 1)
				{
					if (b[p+s] == 0)
					{
						if (!danger2[p+s])
						{
							danger2[p+s] = true;
							undo[count2] = p + s;
							count2++;
						}
					}
				}
				if (((p + x) % 6) == 5)
				{
					count = 0;
					numspaces = 0;
				}
			}
		}
		numspaces = 0;
		count = 0;
		for (int x = -3; x <= 3; x++)
		{
			if ((p + 6*x) >= 0 && (p + 6*x) < 42)
			{
				if (b[p+6*x] == -1)
				{
					count++;
				}
				else
				{
					numspaces++;
					s2 = s;
					s = x;
				}
				if (numspaces == 2)
				{
					count = x-s2-1;
					numspaces = 1;
				}
				if (count >= 3 && numspaces == 1)
				{
					if (b[p+6*s] == 0)
					{
						if (!danger2[p+6*s])
						{
							danger2[p+6*s] = true;
							undo[count2] = p + 6*s;
							count2++;
						}
					}
				}
			}
		}
		numspaces = 0;
		count = 0;
		for (int x = -3; x <= 3; x++)
		{
			if ((p + 5*x) >= 0)
			{
				if (b[p+5*x] == -1)
				{
					count++;
				}
				else
				{
					numspaces++;
					s2 = s;
					s = x;
				}
				if (numspaces == 2)
				{
					count = x-s2-1;
					numspaces = 1;
				}
				if (count >= 3 && numspaces == 1)
				{
					if (b[p+5*s] == 0)
					{
						if (!danger2[p+5*s])
						{
							danger2[p+5*s] = true;
							undo[count2] = p + 5*s;
							count2++;
						}
					}
				}
				if (((p + 5*x) % 6) == 0)
				{
					count = 0;
					numspaces = 0;
				}
				if ((p + 5*x) > 35)
				{
					x = 4;
				}
			}
		}
		undo[0] = count2 - 1;
	}
	public void undod1(int[] u)
	{
		int n = u[0];
		for (int x = 1; x <= n; x++)
		{
			danger1[u[x]] = false;
		}
	}
	public void undod2(int[] u)
	{
		int n = u[0];
		for (int x = 1; x <= n; x++)
		{
			danger2[u[x]] = false;
		}
	}
	/*public void display()
	{
		System.out.println("---------------");
		for (int x = 5; x >= 0; x--)
		{
			for (int y = 0; y < 7; y++)
			{
				int z = b[6*y + x];
				if (z == 1)
				{
					System.out.print("|X");
				}
				else if (z == -1)
				{
					System.out.print("|O");
				}
				else
				{
					System.out.print("| ");
				}
			}
			System.out.println("|");
			System.out.println("---------------");
		}
	}*/
}

