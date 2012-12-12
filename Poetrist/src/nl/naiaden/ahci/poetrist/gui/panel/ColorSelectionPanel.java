package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class ColorSelectionPanel extends JPanel implements MouseInputListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7362539375097800749L;
	
	static ColorSelectionPanel csp = new ColorSelectionPanel();
	

	String listBlack[]={
		"motive",
		"bomer",
		"regrettable",
		"curse"
	};
	
	String listGrey[]={
			"saucepan","coincide","aerodynamics"
			
	};
	
	String listYellow[]={
			"motive","ditty"
	};
	
	String listBrown[]={
			"saddle","telephone"
	};
	
	String listPink[]={
			"coincide","buss"
	};
	
	String listRed[]={
			"assail","wrap","mangle","buss"
	};
	
	String listWhite[]={
			"tableware","transcendental","herewith","anterior"
	};
	
	String listOrange[]={
			"due"
	};
	
	String listBlue[]={
			"ditty"
	};
	
	String listGreen[]={
			"garden"
	};
	
	static JButton black= new JButton();
	static JButton grey= new JButton();
	static JButton yellow= new JButton();
	static JButton brown= new JButton();
	static JButton pink = new JButton();
	static JButton red = new JButton();
	static JButton white = new JButton();
	static JButton orange = new JButton();
	static JButton blue = new JButton();
	static JButton green = new JButton();
	
	static DefaultListModel model1 = new DefaultListModel();
	static JList wordList = new JList(model1);
	static DefaultListModel model2 = new DefaultListModel();
	static JList wordList2 = new JList(model2);
	
	
	public ColorSelectionPanel(){}
	
	public static void createAndShowGUI(){
		
		JFrame frame = new JFrame("ColorSelectionPanelDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content =  frame.getContentPane();
		ButtonListener bl = csp.new ButtonListener();
		
		GridLayout layout  = new GridLayout(1,3);
		csp.setLayout(layout);
		
		GridLayout leftLayout  = new GridLayout(10,1);
		JPanel leftPanel = new JPanel(leftLayout);
		GridLayout middleLayout  = new GridLayout(1,1);
		final JPanel middlePanel = new JPanel(middleLayout);
		GridLayout rightLayout  = new GridLayout(1,1);
		final JPanel rightPanel = new JPanel(rightLayout);
		
		black.setBackground(Color.BLACK);
		leftPanel.add(black);
		black.addActionListener(bl);
		
		grey.setBackground(Color.GRAY);
		leftPanel.add(grey);
		grey.addActionListener(bl);
		
		yellow.setBackground(Color.YELLOW);
		leftPanel.add(yellow);
		yellow.addActionListener(bl);
		
		Color myBrown = new Color(165,42,42);
		brown.setBackground(myBrown);
		leftPanel.add(brown);
		brown.addActionListener(bl);
		
		pink.setBackground(Color.PINK);
		leftPanel.add(pink);
		pink.addActionListener(bl);
		
		red.setBackground(Color.RED);
		leftPanel.add(red);
		red.addActionListener(bl);
		
		white.setBackground(Color.WHITE);
		leftPanel.add(white);
		white.addActionListener(bl);
		
		orange.setBackground(Color.ORANGE);
		leftPanel.add(orange);
		orange.addActionListener(bl);
		
		blue.setBackground(Color.BLUE);
		leftPanel.add(blue);
		blue.addActionListener(bl);
		
		green.setBackground(Color.GREEN);
		leftPanel.add(green);
		green.addActionListener(bl);
		
		wordList.setDragEnabled(true);
		wordList2.setDragEnabled(true);
		middlePanel.add(wordList);
		rightPanel.add(wordList2);
		
		csp.add(leftPanel);
		csp.add(middlePanel);
		csp.add(rightPanel);
		
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
	
	public class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{	int i;
			model1.clear();
			if(e.getSource() == black){
				for (i=0;i<listBlack.length;i++){
					model1.addElement(listBlack[i]);
					
				}
			}else if(e.getSource() == grey){
				for (i=0;i<listGrey.length;i++){
					model1.addElement(listGrey[i]);
				}
			}else if(e.getSource() == yellow){
				for (i=0;i<listYellow.length;i++){
					model1.addElement(listYellow[i]);
				}
			}else if(e.getSource() == brown){
				for (i=0;i<listBrown.length;i++){
					model1.addElement(listBrown[i]);
				}
			}else if(e.getSource() == grey){
				for (i=0;i<listGrey.length;i++){
					model1.addElement(listGrey[i]);
				}
			}else if(e.getSource() == pink){
				for (i=0;i<listPink.length;i++){
					model1.addElement(listPink[i]);
				}
			}else if(e.getSource() == red){
				for (i=0;i<listRed.length;i++){
					model1.addElement(listRed[i]);
				}
			}else if(e.getSource() == grey){
				for (i=0;i<listGrey.length;i++){
					model1.addElement(listGrey[i]);
				}
			}else if(e.getSource() == white){
				for (i=0;i<listWhite.length;i++){
					model1.addElement(listWhite[i]);
				}
			}else if(e.getSource() == orange){
				for (i=0;i<listOrange.length;i++){
					model1.addElement(listOrange[i]);
				}
			}else if(e.getSource() == blue){
				for (i=0;i<listBlue.length;i++){
					model1.addElement(listBlue[i]);
				}
			}else if(e.getSource() == green){
				for (i=0;i<listGreen.length;i++){
					model1.addElement(listGreen[i]);
				}
			}
		}
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
