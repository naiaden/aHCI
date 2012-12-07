package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import nl.naiaden.ahci.poetrist.gui.model.Flower;
import nl.naiaden.ahci.poetrist.gui.model.Tepal;
import nl.naiaden.ahci.poetrist.gui.view.FlowerViewObject;
import nl.naiaden.ahci.poetrist.gui.view.TepalViewObject;

public class GardenPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7043512667139679491L;
	
	/**
	 * 
	 */
	private JPanel gardenPanel = null;
	
	/**
	 * 
	 */
	private List<FlowerViewObject> flowers = null;
	
	/**
	 * Default constructor.
	 */
	public GardenPanel()
	{
		gardenPanel = new JPanel();
		
		flowers = new ArrayList<FlowerViewObject>();
		
	}
	
	/**
	 * 
	 * @param flower
	 */
	public void addFlower(FlowerViewObject flower)
	{
		flowers.add(flower);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for(FlowerViewObject flower : flowers)
		{		
			flower.paint(g);
		}
		
	}
	
	
	/**
	 * Create the GUI and show it.
	 */
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("GardenPanelDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GardenPanel gp = new GardenPanel();
        
        FlowerViewObject flower1 = new FlowerViewObject(new Flower(), 62.5, 20, 150, 25);
        flower1.addTepal(new TepalViewObject(new Tepal(Color.BLUE), 40, 40));
        flower1.addTepal(new TepalViewObject(new Tepal(Color.BLACK), 35, 55));
        flower1.addTepal(new TepalViewObject(new Tepal(Color.RED), 50, 50));
        
        gp.addFlower(flower1);
        gp.addFlower(new FlowerViewObject(new Flower(), 162.5, 20, 150, 25));
        
        frame.getContentPane().add(gp);
        
        frame.setSize(400, 300);
        frame.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}
