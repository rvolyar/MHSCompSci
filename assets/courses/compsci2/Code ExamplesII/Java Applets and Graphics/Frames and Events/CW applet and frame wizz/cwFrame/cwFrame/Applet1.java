/* 
 APPLET using JFrame and Built through Code Warriors
 Applet Wizzard.  Note Generated code and Overhead
 */

package cwFrame;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class Applet1 extends javax.swing.JApplet {

// IMPORTANT: Source code between BEGIN/END comment pair will be regenerated
// every time the form is saved. All manual changes will be overwritten.
// BEGIN GENERATED CODE
	// member declarations
	javax.swing.JButton jButton1 = new javax.swing.JButton();
	javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
	javax.swing.JTextField jTextField1 = new javax.swing.JTextField();
// END GENERATED CODE

	boolean isStandalone = false;

	public Applet1() {
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
		jButton1.setVisible(true);
		jButton1.setSize(new java.awt.Dimension(130, 50));
		jButton1.setText("jButton1");
		jButton1.setLocation(new java.awt.Point(120, 190));
		jLabel1.setSize(new java.awt.Dimension(140, 20));
		jLabel1.setLocation(new java.awt.Point(40, 50));
		jLabel1.setVisible(true);
		jLabel1.setText("a label");
		jTextField1.setVisible(true);
		jTextField1.setSize(new java.awt.Dimension(190, 40));
		jTextField1.setText("jTextField1");
		jTextField1.setLocation(new java.awt.Point(110, 90));
		setLocation(new java.awt.Point(0, 0));
		getContentPane().setLayout(null);

		getContentPane().add(jButton1);
		getContentPane().add(jLabel1);
		getContentPane().add(jTextField1);

		setSize(new java.awt.Dimension(400, 300));

		// event handling
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				jButton1ActionPerformed(e);
			}
		});

// END GENERATED CODE
	}
	
	public void jButton1ActionPerformed(java.awt.event.ActionEvent e) 
	{
		jLabel1.setText("BUTTON WAS PRESSED");
	}
		

}
