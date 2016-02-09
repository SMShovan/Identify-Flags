package project;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlagsPanel extends JPanel
{
	private JLabel label= new JLabel();
	
	public FlagsPanel()
	{
		setLayout(new FlowLayout());
		add(label);
	}
	 public void setLabel( ImageIcon icon)
	 {
		 label.setIcon(icon);
	 }
}
