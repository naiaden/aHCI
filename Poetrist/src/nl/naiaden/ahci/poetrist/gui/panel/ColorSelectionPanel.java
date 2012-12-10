package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class ColorSelectionPanel extends JPanel implements MouseInputListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7362539375097800749L;
	
	static ColorSelectionPanel csp = new ColorSelectionPanel();
	
	public ColorSelectionPanel(){}
	
	public static void createAndShowGUI(){
		JFrame frame = new JFrame("ColorSelectionPanelDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content =  frame.getContentPane();
		
		GridLayout layout  = new GridLayout(1,3);
		csp.setLayout(layout);
		
		
		GridLayout leftLayout  = new GridLayout(9,1);
		JPanel leftPanel = new JPanel(leftLayout);
		GridLayout middleLayout  = new GridLayout(1,1);
		JPanel middlePanel = new JPanel(middleLayout);
		GridLayout rightLayout  = new GridLayout(1,1);
		JPanel rightPanel = new JPanel(rightLayout);
		
		csp.add(leftPanel);
		csp.add(middlePanel);
		csp.add(rightPanel);
		
		
		JButton black= new JButton();
		black.setBackground(Color.BLACK);
		leftPanel.add(black);
		
		JButton grey= new JButton();
		black.setBackground(Color.GRAY);
		leftPanel.add(grey);
		
		JButton yellow= new JButton();
		yellow.setBackground(Color.YELLOW);
		leftPanel.add(yellow);
		
		JButton brown= new JButton();
		Color myBrown = new Color(165,42,42);
		brown.setBackground(myBrown);
		leftPanel.add(brown);
		
		JButton pink = new JButton();
		pink.setBackground(Color.PINK);
		leftPanel.add(pink);
		
		JButton red = new JButton();
		red.setBackground(Color.RED);
		leftPanel.add(red);
		
		JButton white = new JButton();
		white.setBackground(Color.WHITE);
		leftPanel.add(white);
		
		JButton orange = new JButton();
		orange.setBackground(Color.ORANGE);
		leftPanel.add(orange);
		
		JButton blue = new JButton();
		blue.setBackground(Color.BLUE);
		leftPanel.add(blue);
		
		
		content.add(csp);
		frame.setSize(400,300);
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createAndShowGUI();
			}
		});
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	} 
}
