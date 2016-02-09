package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.*;

public class ErrorPreview extends JPanel
{
	private ImageIcon[] flags = {new ImageIcon("Flags/output/small/Argentina.png"),
			new ImageIcon("Flags/output/small/Australia.png"),
			new ImageIcon("Flags/output/small/Bangladesh.png"),
			new ImageIcon("Flags/output/small/Brazil.png"),
			new ImageIcon("Flags/output/small/Canada.png"),
			new ImageIcon("Flags/output/small/India.png"),
			new ImageIcon("Flags/output/small/Pakistan.png"),
			new ImageIcon("Flags/output/small/Sri Lanka.png"),
			new ImageIcon("Flags/output/small/South Africa.png"),
			new ImageIcon("Flags/output/small/United Kingdom.png"),
			new ImageIcon("Flags/output/small/New Zealand.png"),
			new ImageIcon("Flags/output/small/United States.png"),
			new ImageIcon("Flags/output/small/Zimbabwe.png"),
			new ImageIcon("Flags/output/small/Saudi Arabia.png"),
			new ImageIcon("Flags/output/small/Japan.png"),
			
			new ImageIcon("Flags/output/small/Iraq.png"),
			new ImageIcon("Flags/output/small/Afghanistan.png"),
			new ImageIcon("Flags/output/small/China.png"),
			new ImageIcon("Flags/output/small/Indonesia.png"),
			new ImageIcon("Flags/output/small/Israel.png"),
			new ImageIcon("Flags/output/small/Kenya.png"),
			new ImageIcon("Flags/output/small/Malaysia.png"),
			new ImageIcon("Flags/output/small/France.png"),
			new ImageIcon("Flags/output/small/Norway.png"),
			new ImageIcon("Flags/output/small/Portugal.png"),
			new ImageIcon("Flags/output/small/Spain.png"),
			new ImageIcon("Flags/output/small/Thailand.png"),
			new ImageIcon("Flags/output/small/United Arab Emirates.png"),
			new ImageIcon("Flags/output/small/Nepal.png"),
			new ImageIcon("Flags/output/small/Myanmar.png"),
			
			new ImageIcon("Flags/output/small/Singapore.png"),
			new ImageIcon("Flags/output/small/Denmark.png"),
			new ImageIcon("Flags/output/small/Chile.png"),
			new ImageIcon("Flags/output/small/Colombia.png"),
			new ImageIcon("Flags/output/small/Egypt.png"),
			new ImageIcon("Flags/output/small/Finland.png"),
			new ImageIcon("Flags/output/small/Georgia.png"),
			new ImageIcon("Flags/output/small/Greece.png"),
			new ImageIcon("Flags/output/small/Hungary.png"),
			new ImageIcon("Flags/output/small/Iceland.png"),
			new ImageIcon("Flags/output/small/Switzerland.png"),
			new ImageIcon("Flags/output/small/Mozambique.png"),
			new ImageIcon("Flags/output/small/Kuwait.png"),
			new ImageIcon("Flags/output/small/Panama.png"),
			new ImageIcon("Flags/output/small/Swaziland.png"),
			new ImageIcon("Flags/output/small/Poland.png"),
			new ImageIcon("Flags/output/small/Philippines.png"),
			new ImageIcon("Flags/output/small/Netherlands.png"),
			new ImageIcon("Flags/output/small/Mexico.png"),
			new ImageIcon("Flags/output/small/Libya.png"),
			};
	private ImageIcon ss = new ImageIcon("Buttons/button.PNG");
	
	private String[] strings = {"Argentina","Australia","Bangladesh","Brazil","Canada","India","Pakistan","Sri Lanka","South Africa",
			"United Kingdom","New Zealand","United States","Zimbabwe","Saudi Arabia","Japan",
			
			"Iraq","Afghanistan","China","Indonesia","Israel","Kenya","Malaysia","France","Norway",
			"Portugal","Spain","Thailand","United Arab Emirates","Nepal","Myanmar",
			
			"Singapore","Denmark","Chile","Colombia","Egypt","Finland","Georgia","Greece","Hungary","Iceland","Switzerland",
			"Mozambique","Kuwait","Panama","Swaziland","Poland","Philippines","Netherlands","Mexico","Libya"};
	
	
	JLabel jlbl;
	JPanel p1=new JPanel();
	JPanel p= new JPanel();
	JPanel p2= new JPanel();
	JButton scrn=new JButton("Save Image");
	public int r;
	public ErrorPreview(int errors[],int length,final JFrame frame)
	{

		p1.setLayout(new GridLayout( (int) Math.sqrt(length),6,10,10 ));
		for ( int i =0; i < length; i++)
		{
			
			JLabel jlbl= new JLabel(strings[errors[i]],flags[errors[i]],SwingConstants.CENTER);
			jlbl.setHorizontalTextPosition(SwingConstants.CENTER);
			jlbl.setVerticalTextPosition(SwingConstants.BOTTOM);
			p1.add(jlbl);
			
			
		}
		add(p1);
		p2.add(scrn);
		scrn.setIcon(ss);
		scrn.setHorizontalTextPosition(SwingConstants.CENTER);
		scrn.setBackground(Color.gray);
		scrn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				robo(frame);
				scrn.setText("Saved in e:\\ again?");
			}
		});
		p.setLayout(new BorderLayout());
		p.add(p1,BorderLayout.CENTER);
		p.add(p2,BorderLayout.SOUTH);
		add(p);
		
		
	}
	void robo(final JFrame frame) 
    {

        Rectangle rec = frame.getBounds();
        BufferedImage bufferedImage = new BufferedImage(rec.width, rec.height,
                BufferedImage.TYPE_INT_ARGB);
        frame.paint(bufferedImage.getGraphics());
        try {
			ImageIO.write(bufferedImage, "PNG", new File("e:\\Errors"+Math.random()*10000+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	public int row(int length)
	{
		if (length <= 2)
			r=1;
		else if ( length <=6)
			r=2;
		return r;
		
	}
	
	public static void main (String[] args)
	{
		JFrame frame= new JFrame();
		frame.add(new ErrorPreview( new int [] {1,2,3,4,5,6,7,8,9,20} , 10, frame));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	

}