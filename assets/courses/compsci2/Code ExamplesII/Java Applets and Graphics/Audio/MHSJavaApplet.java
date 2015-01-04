/*
	JApplet using SOUND and IMAGES
*/

import java.awt.*;
import javax.swing.*;
import java.applet.AudioClip;


public class MHSJavaApplet extends JApplet
{
	private AudioClip playMe;
	private Image picture;
	
	public void init() 
	{
		picture = getImage(getDocumentBase(), "ian.jpg");
		repaint();
	}
	
	public void paint(Graphics g) 
	{
		if (picture != null)
			g.drawImage(picture, 5, 10, this);
		g.drawString("Playing Audio FIle...", 30, 30);
		play();
		
	}
	
	
	public void play()
	{
		playMe =
		// getAudioClip(getDocumentBase(), "motown Gladys Night & The Pips - Midnight train to Georgia.mp3");
		 getAudioClip(getDocumentBase(), ("shenanigans.wav"));
		
		playMe.play();
	
	
	}
}
