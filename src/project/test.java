package project;
import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class test {
	public static  void flashScreen() {
		JWindow window = new JWindow();
		window.getContentPane().add(
		    new JLabel("", new ImageIcon("BackGround/Splash Screen.jpg"), SwingConstants.CENTER));
		window.setBounds(400, 180, 550, 400);
		window.setVisible(true);
		try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		JFrame frame = new JFrame();
		frame.add(new JLabel("Welcome"));
		frame.setVisible(true);
		frame.setSize(600,600);
		window.dispose();
	    
	}
	
	public static void main(String[] args)
	{
		flashScreen();
	}
	

}
