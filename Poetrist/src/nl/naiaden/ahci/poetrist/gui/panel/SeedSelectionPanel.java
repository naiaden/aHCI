/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The {@link SeedSelectionPanel} is a sort of closet where words are ordered
 * by their colour.
 * 
 * @author Ding
 * @author louis
 * 
 */
public class SeedSelectionPanel extends JPanel
{

	private ColorSelectionPanel colorSelectionPanel = null;
	private SeedListPanel seedListPanel = null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6313111916626939259L;

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
		JFrame frame = new JFrame("ColorSelectionPanelDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		SeedSelectionPanel csp = new SeedSelectionPanel();

		frame.getContentPane().add(csp);

		frame.setSize(400, 300);
		frame.setVisible(true);
	}



	public SeedSelectionPanel()
	{
		GridLayout layout = new GridLayout(1, 3);
		setLayout(layout);

		colorSelectionPanel = new ColorSelectionPanel();
		seedListPanel = new SeedListPanel();

		add(colorSelectionPanel);
		add(seedListPanel);

		colorSelectionPanel.addEventListener(seedListPanel);
	}
}