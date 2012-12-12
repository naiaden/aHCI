package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;


public class ColorSelectionPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6313111916626939259L;

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
	
	JButton black= new JButton();
	JButton grey= new JButton();
	JButton yellow= new JButton();
	JButton brown= new JButton();
	JButton pink = new JButton();
	JButton red = new JButton();
	JButton white = new JButton();
	JButton orange = new JButton();
	JButton blue = new JButton();
	JButton green = new JButton();
	
	DefaultListModel model1 = new DefaultListModel();
	JList wordList = new JList(model1);
	DefaultListModel model2 = new DefaultListModel();
	JList wordList2 = new JList(model2);
	
	
	public ColorSelectionPanel(){
		
		ButtonListener bl = new ButtonListener();
		GridLayout layout = new GridLayout(1,3);
		setLayout(layout);
		
		GridLayout leftLayout  = new GridLayout(10,1);
		JPanel leftPanel = new JPanel(leftLayout);
		GridLayout middleLayout  = new GridLayout(1,1);
		JPanel middlePanel = new JPanel(middleLayout);
		GridLayout rightLayout  = new GridLayout(1,1);
		JPanel rightPanel = new JPanel(rightLayout);
		
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
		
		add(leftPanel);
		add(middlePanel);
		add(rightPanel);
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
}
