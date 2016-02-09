package project;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameChoice extends JFrame
{
	private ImageIcon frameBackGround = new ImageIcon("BackGround/Background.jpg");
	private JLabel backGround = new JLabel("" , frameBackGround,SwingConstants.CENTER);
	
	
	private ImageIcon learn  = new ImageIcon("Buttons/butto.png");
	private ImageIcon play = new ImageIcon("Buttons/butto.png");
	
	private JButton lButton = new JButton("Learning Mood",learn);
	private JButton pButton = new JButton("Practice Mood",play);
	
	public GameChoice() 
	{
		//button 
		
		lButton.setHorizontalTextPosition(SwingConstants.CENTER);
		lButton.setBorderPainted(false);
		pButton.setHorizontalTextPosition(SwingConstants.CENTER);
		
		//
		
		setLayout(new FlowLayout());
		add(backGround, BorderLayout.CENTER);
		backGround.setLayout(new FlowLayout());
		backGround.add(lButton);
		lButton.setBackground(Color.white);
		pButton.setBackground(Color.white);
		
		lButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				
			    new BaseClass2();
				setVisible(false);
				
			}
		});
		pButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				new BaseClass();
				setVisible(false);
			}
		});
		backGround.add(pButton);
		
		
	}
	
	public static  void flashScreen() {
		JWindow window = new JWindow();
		window.getContentPane().add(
		    new JLabel("", new ImageIcon("BackGround/Splash Screen1.jpg"), SwingConstants.CENTER));
		window.setBounds(400, 180, 550, 400);
		window.setVisible(true);
		try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		window.dispose();
	    
	}
	
	public static void  main(String[] args)
	{
		flashScreen();
		JFrame frame= new GameChoice();
		 frame.setTitle("Identify Flags");
		 frame.setSize(900,450);
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
	}

}
