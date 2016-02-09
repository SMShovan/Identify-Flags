package project;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Settings extends JFrame
{
	private JSlider slider = new JSlider(JSlider.HORIZONTAL,1,3,1);
	
	public Settings()
	{
		setLayout(new GridLayout(2,2));
		add(slider);
		slider.setMaximum(3);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		
		slider.addChangeListener(new ChangeListener() 
		{
			
			public void stateChanged(ChangeEvent e) 
			{
				System.out.println(slider.getValue());
				
			}
		});
		
		
	}
	public static void main(String[] args)
	{
		
		JFrame frame= new Settings();
		 //JPanel panel= new Settings();
		 //frame.add(panel);
		 frame.setTitle("Identify Flags");
		 frame.pack();
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		 
	}

}
