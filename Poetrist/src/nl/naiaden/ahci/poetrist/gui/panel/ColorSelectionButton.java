/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;

import javax.swing.JButton;

import nl.naiaden.ahci.poetrist.gui.panel.ColorSelectionPanel.ButtonListener;

/**
 * @author louis
 *
 */
public class ColorSelectionButton extends JButton
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8194198147219801600L;

	private Color color = null;

	public ColorSelectionButton(Color color, ButtonListener buttonListener)
	{
		this.color = color;

		setOpaque(true);
		setBackground(color);

		addActionListener(buttonListener);
	}

	/**
	 * @return the color.
	 */
	public Color getColor()
	{
		return color;
	}
}
