package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.print.attribute.standard.JobHoldUntil;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.View;

import org.omg.CORBA.PUBLIC_MEMBER;


public class identifyFlagstest extends JFrame
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
	
	private int[] errors = new int[50];
	private int err=0;
	
	private ImageIcon buttonRegularIcon = new ImageIcon("Buttons/buttonRegular.PNG");
	private ImageIcon buttonPressedIcon = new ImageIcon("Buttons/buttonPressed.PNG");
	private ImageIcon buttonRollOverIcon = new ImageIcon("Buttons/buttonMoving.PNG");
	private ImageIcon restartIcon = new ImageIcon("Buttons/restart.PNG");
	private ImageIcon crossIcon = new ImageIcon("Buttons/cross.PNG");
	private ImageIcon rightIcon = new ImageIcon("Buttons/right.PNG");
	private ImageIcon levelsIcon = new ImageIcon("Buttons/levels.PNG");
	
	JButton button = new JButton("ok",buttonRegularIcon);
    JButton restart = new JButton("",restartIcon);
    JButton playModeButton = new JButton("Learn");
	
	JRadioButton rButton1 = new JRadioButton();
	JRadioButton rButton2 = new JRadioButton();
	JRadioButton rButton3 = new JRadioButton();
	JRadioButton rButton4 = new JRadioButton();
	
	JPanel rPanel = new JPanel();
	JPanel sPanel = new JPanel();
	JPanel bPanel = new JPanel();
	JPanel wPanel = new JPanel();
	JPanel ePanel = new JPanel();
	JPanel sliderPanel = new JPanel();
	
	private JSlider slider = new JSlider(JSlider.VERTICAL,1,3,1);

	ButtonGroup group = new ButtonGroup();
	
	int start =1;
	int right=0;
	int wrong=0; 
	int times=0;
	public static int levels= 10;
	int l=levels;
	public static int dif= 0;
	
	JFrame frame = new JFrame("Graphically Representation");
	
	
	JLabel rightLabel = new JLabel(""+right , rightIcon , SwingConstants.CENTER);
	JLabel wrongLabel = new JLabel(""+wrong , crossIcon, SwingConstants.CENTER);
	JLabel levelsLabel = new JLabel(""+levels , levelsIcon , SwingConstants.CENTER);
	JLabel setlevels = new JLabel("Settings");
	

	
	int i, one, two, three, four, actual;
	
	public identifyFlagstest()
	{
		setLayout(new BorderLayout());
		
		final FlagsPanel fPanel = new FlagsPanel();
		
		button.setPressedIcon(buttonPressedIcon);
		button.setRolloverIcon(buttonRollOverIcon);
		button.setBorder(new LineBorder(Color.GRAY,0));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setBackground(Color.white);
		
		 
		bPanel.setLayout(new GridLayout(1,3));
		bPanel.add(rightLabel);
		bPanel.add(button);
		bPanel.add(wrongLabel);
		bPanel.setBackground(Color.white);
		
		rPanel.setBackground(Color.white);
		rButton1.setBackground(Color.white);
		rButton2.setBackground(Color.white);
		rButton3.setBackground(Color.white);
		rButton4.setBackground(Color.white);

		//east panel
		
		ePanel.setLayout(new GridLayout(4,1));
		ePanel.setBackground(Color.white);
		
		JLabel setLevels = new JLabel(new ImageIcon("Buttons/settings.png"));
		ePanel.add(setLevels);
		JButton levelsButton = new JButton(new ImageIcon("Buttons/steps.png"));
		levelsButton.setBackground(Color.white);
		levelsButton.setBorderPainted(false);
		levelsButton.setText("");
		ePanel.add(levelsButton);
		
		// slider property
		
		sliderPanel.setLayout(new BorderLayout());
		sliderPanel.setBackground(Color.white);
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new GridLayout(3,1));
		subPanel.add(new JLabel("   Difficult"));
		subPanel.add(new JLabel("   Medium"));
		subPanel.add(new JLabel("   Easy"));
		subPanel.setBackground(Color.white);
		slider.setBackground(Color.white);
		sliderPanel.add(subPanel, BorderLayout.WEST);
		sliderPanel.add(slider,BorderLayout.CENTER);
		
		
		ePanel.add(sliderPanel);
		
		//ePanel.add(slider);
		slider.setMaximum(3);
		slider.setPaintLabels(false);
		slider.setPaintTicks(false);
		slider.setPaintTrack(true);
		
		slider.setMajorTickSpacing(3);
		slider.setMinorTickSpacing(1);
		
		slider.addChangeListener(new ChangeListener() 
		{
			
			public void stateChanged(ChangeEvent e) 
			{
				setDif(slider.getValue());
				
			}
		});
		 
		
		levelsButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				try {
					String s= JOptionPane.showInputDialog("Set levels (enter en integer");
					levels = Integer.parseInt(s);
					if(levels >0 )
					{
						// copy from restart 
						//button.setVisible(false);
						fPanel.setVisible(false);
						rButton1.setVisible(false);
						rButton2.setVisible(false);
						rButton3.setVisible(false);
						rButton4.setVisible(false);
						//rightLabel.setVisible(false);
						//wrongLabel.setVisible(false);
						//levelsLabel.setVisible(false);
						right= 0;
						wrong= 0;
						times=0;
						start=1;
						l=levels;
						button.setVisible(true);
						button.setText("Start");
						
						rightLabel.setText(""+right);
						wrongLabel.setText(""+wrong);
						levelsLabel.setText(""+levels);
					}
					
				} catch (Exception e2) {
					
				}
				
				
				
			}
		});
		
		add(ePanel, BorderLayout.EAST);
		
		
		add(bPanel, BorderLayout.SOUTH);  
		
		wPanel.setLayout(new GridLayout(3,1));
		wPanel.add(levelsLabel);
		levelsLabel.setBackground(Color.white);
		wPanel.setBackground(Color.white);
		
		wPanel.add(restart);
		restart.setBackground(Color.white);
		restart.setBorder(new LineBorder(Color.white, 0));
		
		levelsLabel.setBackground(Color.white);
		levelsLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		wPanel.add(playModeButton);
		
		add(wPanel, BorderLayout.WEST);
		levelsLabel.setVisible(true);
		
		playModeButton.setIcon(levelsIcon);
		playModeButton.setHorizontalTextPosition(SwingConstants.CENTER);
		playModeButton.setBackground(Color.white);
		playModeButton.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				new BaseClass2();
				setVisible(false);
				
			}
		});
		
		button.setText("Start");
		
		group.add(rButton1);
		group.add(rButton2);
		group.add(rButton3);
		group.add(rButton4);
		
		//add(rightLabel,BorderLayout.WEST);
		
		restart.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
			
				
				button.setVisible(true);
				fPanel.setVisible(false);
				rButton1.setVisible(false);
				rButton2.setVisible(false);
				rButton3.setVisible(false);
				rButton4.setVisible(false);
				//rightLabel.setVisible(false);
				//wrongLabel.setVisible(false);
				levelsLabel.setVisible(true);
				right= 0;
				wrong= 0;
				times=0;
				start=1;
				l=levels;
				button.setVisible(true);
				button.setText("Start");
				
				rightLabel.setText(""+right);
				wrongLabel.setText(""+wrong);
				levelsLabel.setText(""+levels);
				
				System.out.println("right is "+right +"  /n wrong is " + wrong);
				
			}
		});
		
		button.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
				
				
				System.out.println("levels are "+levels);

				fPanel.setVisible(true);
				
				rButton1.setVisible(true);
				rButton2.setVisible(true);
				rButton3.setVisible(true);
				rButton4.setVisible(true);
				rightLabel.setVisible(true);
				wrongLabel.setVisible(true);
				levelsLabel.setVisible(true);
				
				
				
				button.setText("Confirm & Next");
				
				
				
				if (start== 1)
				{
					add(fPanel);
					
					rPanel.setLayout(new GridLayout(2,2));
					
					rPanel.add(rButton1);
					rPanel.add(rButton2);
					rPanel.add(rButton3);
					rPanel.add(rButton4);
					
					sPanel.setLayout(new GridLayout(2,1));
					
					sPanel.add(rPanel);
					sPanel.add(bPanel);
					add(sPanel, BorderLayout.SOUTH);
					
				}
				
				// is correct ?? 
				
				if( start == 0)
				{
					
					l--;
					
					if( rButton1.isSelected())
					{
						if( rButton1.getText() == strings[i] )
						{
							playSound_y();
							++right;
						}
							
						else
						{
							playSound_n();
							++wrong;
							errors[err++]=i;
						}
							
						rButton1.setSelected(false);

					}
					else if ( rButton2.isSelected() )
					{
						if (rButton2.getText() == strings[i])
						{
							playSound_y();
							++right;
						}
							
						else
						{
							playSound_n();
							++wrong;
							errors[err++]=i;
						}
						rButton2.setSelected(false);

					}
					else if ( rButton3.isSelected())
					{
						if (rButton3.getText() == strings[i])
						{
							playSound_y();
							++right;
						}
							
						else
						{
							playSound_n();
							++wrong;
							errors[err++]=i;
						}
						rButton3.setSelected(false);

					}
					else if ( rButton4.isSelected() )
					{
						if (rButton4.getText() == strings[i])
						{
							playSound_y();
							++right;
						}
							
						else
						{
							playSound_n();
							++wrong;
							errors[err++]=i;
							
						}
						rButton4.setSelected(false);

					}
					
					
					
				}
				

				start=0;
				
				System.out.println("right is "+right +"  /n wrong is " + wrong);
				
				rightLabel.setText(""+right);
				wrongLabel.setText(""+wrong);
				levelsLabel.setText(""+l);
				
				//set Random
				
				i =(int)( dif + Math.random()*20);
				//System.out.println(i);
				fPanel.setLabel(flags[i]);
				
				one = (int) ( dif + Math.random()*20);
				rButton1.setText(strings[one]);
				
				two = (int) ( dif + Math.random()*20);
				rButton2.setText(strings[two]);
				
				three = (int) ( dif + Math.random()*20);
				rButton3.setText(strings[three]);
				
				four = (int) ( dif + Math.random()*20);
				rButton4.setText(strings[four]);
				
				actual = (int) (Math.random()*3);
				
				System.out.println();
				System.out.println("actual "+ actual);
				
				switch (actual) 
				{
				case 0:
					rButton1.setText(strings[i]);
					break;
				case 1:
					rButton2.setText(strings[i]);
                    break;
				case 2:
					rButton3.setText(strings[i]);
					break;
				default:
					rButton4.setText(strings[i]);
					break;
				}
				
				if( times==levels)
				{
					button.setVisible(false);
					fPanel.setVisible(false);
					rButton1.setVisible(false);
					rButton2.setVisible(false);
					rButton3.setVisible(false);
					rButton4.setVisible(false);
					//rightLabel.setVisible(false);
					//wrongLabel.setVisible(false);
					//levelsLabel.setVisible(false);
					
					System.out.println(""+ right +""+wrong );
					
					JFrame eFrame = new JFrame();
					ErrorPreview ePanel=  new ErrorPreview(errors, err,eFrame);
					
					eFrame.setLayout(new BorderLayout());
					eFrame.add(ePanel, BorderLayout.CENTER);
					eFrame.pack();
					eFrame.setLocationRelativeTo(null);
					eFrame.setVisible(true);
					
					frame.setSize(300,300);
					frame.setLocationRelativeTo(null);
					frame.setVisible(false);
					
				}
				
				System.out.println(times);
				
				times++;
				group.clearSelection();
					
			}
			
		});
		
		
	}
	 
	 
	 public static void  main(String[] args) 
	 {
		 JFrame frame= new identifyFlagstest();
		 frame.setTitle("Identify Flags");
		 frame.pack();
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		 
		
	}
	 public static void setLevels( int i)
	 {
		 levels=i;
	 }
	 public static void setDif( int i )
	 {
		 dif= 15*i - 15;
		 System.out.println(dif);
	 }
	 public Dimension getPreferredSize()
		{
			return new Dimension(600,500);
		}
	 public static  void playSound_y() {
		    try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("music/yes.wav").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		        Thread.sleep(clip.getMicrosecondLength() / 1000);
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
		    
		}
		public static  void playSound_n() {
		    try {
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("music/no.wav").getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		        Thread.sleep(clip.getMicrosecondLength() / 1000);
		    } catch(Exception ex) {
		        System.out.println("Error with playing sound.");
		        ex.printStackTrace();
		    }
		    
		}

}
