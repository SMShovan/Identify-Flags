package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.omg.CORBA.PUBLIC_MEMBER;


public class LearningMode extends JFrame
{
	private ImageIcon[] flags = {new ImageIcon("Flags/output/Argentina.png"),
			new ImageIcon("Flags/output/Australia.png"),
			new ImageIcon("Flags/output/Bangladesh.png"),
			new ImageIcon("Flags/output/Brazil.png"),
			new ImageIcon("Flags/output/Canada.png"),
			new ImageIcon("Flags/output/India.png"),
			new ImageIcon("Flags/output/Pakistan.png"),
			new ImageIcon("Flags/output/Sri Lanka.png"),
			new ImageIcon("Flags/output/South Africa.png"),
			new ImageIcon("Flags/output/United Kingdom.png"),
			new ImageIcon("Flags/output/New Zealand.png"),
			new ImageIcon("Flags/output/United States.png"),
			new ImageIcon("Flags/output/Zimbabwe.png"),
			new ImageIcon("Flags/output/Saudi Arabia.png"),
			new ImageIcon("Flags/output/Japan.png"),
			
			new ImageIcon("Flags/output/Iraq.png"),
			new ImageIcon("Flags/output/Afghanistan.png"),
			new ImageIcon("Flags/output/China.png"),
			new ImageIcon("Flags/output/Indonesia.png"),
			new ImageIcon("Flags/output/Israel.png"),
			new ImageIcon("Flags/output/Kenya.png"),
			new ImageIcon("Flags/output/Malaysia.png"),
			new ImageIcon("Flags/output/France.png"),
			new ImageIcon("Flags/output/Norway.png"),
			new ImageIcon("Flags/output/Portugal.png"),
			new ImageIcon("Flags/output/Spain.png"),
			new ImageIcon("Flags/output/Thailand.png"),
			new ImageIcon("Flags/output/United Arab Emirates.png"),
			new ImageIcon("Flags/output/Nepal.png"),
			new ImageIcon("Flags/output/Myanmar.png"),
			
			new ImageIcon("Flags/output/Singapore.png"),
			new ImageIcon("Flags/output/Denmark.png"),
			new ImageIcon("Flags/output/Chile.png"),
			new ImageIcon("Flags/output/Colombia.png"),
			new ImageIcon("Flags/output/Egypt.png"),
			new ImageIcon("Flags/output/Finland.png"),
			new ImageIcon("Flags/output/Georgia.png"),
			new ImageIcon("Flags/output/Greece.png"),
			new ImageIcon("Flags/output/Hungary.png"),
			new ImageIcon("Flags/output/Iceland.png"),
			new ImageIcon("Flags/output/Switzerland.png"),
			new ImageIcon("Flags/output/Mozambique.png"),
			new ImageIcon("Flags/output/Kuwait.png"),
			new ImageIcon("Flags/output/Panama.png"),
			new ImageIcon("Flags/output/Swaziland.png"),
			new ImageIcon("Flags/output/Poland.png"),
			new ImageIcon("Flags/output/Philippines.png"),
			new ImageIcon("Flags/output/Netherlands.png"),
			new ImageIcon("Flags/output/Mexico.png"),
			new ImageIcon("Flags/output/Libya.png"),
			};
	
	private String[] strings = {"Argentina","Australia","Bangladesh","Brazil","Canada","India","Pakistan","Sri Lanka","South Africa",
			"United Kingdom","New Zealand","United States","Zimbabwe","Saudi Arabia","Japan",
			
			"Iraq","Afghanistan","China","Indonesia","Israel","Kenya","Malaysia","France","Norway",
			"Portugal","Spain","Thailand","United Arab Emirates","Nepal","Myanmar",
			
			"Singapore","Denmark","Chile","Colombia","Egypt","Finland","Georgia","Greece","Hungary","Iceland","Switzerland",
			"Mozambique","Kuwait","Panama","Swaziland","Poland","Philippines","Netherlands","Mexico","Libya"};
	
	private ImageIcon buttonRegularIcon = new ImageIcon("Buttons/buttonRegular.PNG");
	private ImageIcon buttonPressedIcon = new ImageIcon("Buttons/buttonPressed.PNG");
	private ImageIcon buttonRollOverIcon = new ImageIcon("Buttons/buttonMoving.PNG");
	private ImageIcon levelsIcon = new ImageIcon("Buttons/levels.PNG");
	
	JButton button = new JButton("ok",buttonRegularIcon);
    

	JPanel sPanel = new JPanel();
	JPanel bPanel = new JPanel();
	JPanel ePanel = new JPanel();
	
	JButton playMode = new JButton("Play");

	JLabel countryLabel = new JLabel("");

	Font countryFont = new Font("SansSerif", Font.BOLD,24);
	
	int i, one, two, three, four, actual;
	
	public LearningMode()
	{
		setLayout(new BorderLayout());
		
		final FlagsPanel fPanel = new FlagsPanel();
		
		button.setPressedIcon(buttonPressedIcon);
		button.setRolloverIcon(buttonRollOverIcon);
		button.setBorder(new LineBorder(Color.GRAY,0));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setBackground(Color.white);
		 
		bPanel.setLayout(new GridLayout(2,1));
		
		bPanel.add(countryLabel);
		countryLabel.setFont(countryFont);
		bPanel.add(button);
		bPanel.setBackground(Color.white);
		//bPanel.add(playMode);
		
		playMode.setIcon(levelsIcon);
		playMode.setBackground(Color.white);
		playMode.setHorizontalTextPosition(SwingConstants.CENTER);
		playMode.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				new BaseClass();
				setVisible(false);
				
			}
		});
		
		//fPanel.setVisible(true);
		add(fPanel, BorderLayout.CENTER);
		
		
		add(playMode, BorderLayout.NORTH);
		add(bPanel, BorderLayout.SOUTH);  
		add(ePanel, BorderLayout.EAST);		
		button.setText("Start");
		
		
		
		
		
		button.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				fPanel.setVisible(true);
				button.setText("Next");
				
				
				i =(int)( Math.random()*50);;
				fPanel.setLabel(flags[i]);
				countryLabel.setText("The name of the country is :   "+strings[i]);
				
				
					
			}
			
		});
		
	}
	 
	 
	 public static void  main(String[] args) 
	 {
		 JFrame frame= new LearningMode();
		 frame.setTitle("Identify Flags");
		 frame.pack();
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		 
		
	}
	 public Dimension getPreferredSize()
		{
			return new Dimension(600,500);
		}

}
