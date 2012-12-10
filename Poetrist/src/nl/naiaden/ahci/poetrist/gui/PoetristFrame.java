package nl.naiaden.ahci.poetrist.gui;

import javax.swing.JFrame;

public class PoetristFrame extends JFrame
{

	/**
	 * @param args
	 */
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
	
	/**
	 * Create the GUI and show it.
	 */
	private static void createAndShowGUI()
	{
		PoetristFrame frame = new PoetristFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3465836273841215128L;
	
	public PoetristFrame()
	{		
		initialiseFrame();
		
		setSize(400, 300);
		setVisible(true);
	}
	
	
	private void initialiseFrame()
	{		
		setTitle("Poetrist -- Your source of click and point art generation");
	}
	
}
