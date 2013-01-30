/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
		// GridLayout layout = new GridLayout(1, 3);
		// GridBagLayout gbl = new GridBagLayout();
		// setLayout(layout);

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.anchor = GridBagConstraints.NORTH;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		colorSelectionPanel = new ColorSelectionPanel();
		add(colorSelectionPanel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		seedListPanel = new SeedListPanel();
		add(seedListPanel, gbc);

		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Seed Cabinet"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

		colorSelectionPanel.addEventListener(seedListPanel);
	}
}