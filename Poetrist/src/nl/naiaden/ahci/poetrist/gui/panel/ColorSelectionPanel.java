package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.prefs.BackingStoreException;

import javax.swing.JPanel;

import nl.naiaden.ahci.poetrist.gui.event.ColorChangedEvent;
import nl.naiaden.ahci.poetrist.gui.event.ColorChangedListener;
import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.ColorName;

/**
 * 
 * @author louis
 * @author Ding
 * 
 */
class ColorSelectionPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6034898644914662901L;
	private List<ColorSelectionButton> buttons = null;
	private GridLayout layout = null;

	private List<ColorChangedListener> colorChangedListeners = null;

	public synchronized void addEventListener(ColorChangedListener listener)
	{
		colorChangedListeners.add(listener);
	}

	public synchronized void removeEventListener(ColorChangedListener listener)
	{
		colorChangedListeners.remove(listener);
	}

	private synchronized void fireEvent(Color color)
	{
		ColorChangedEvent event = new ColorChangedEvent(this, color);
		Iterator<ColorChangedListener> i = colorChangedListeners.iterator();
		while (i.hasNext())
		{
			((ColorChangedListener) i.next()).handleColorChangedEvent(event);
		}
	}

	/**
	 * Creates and initialises the color selection panel.
	 */
	public ColorSelectionPanel()
	{
		buttons = new ArrayList<ColorSelectionButton>();
		layout = new GridLayout(0, 1);
		setLayout(layout);

		colorChangedListeners = new ArrayList<ColorChangedListener>();

		initialise();
	}

	/**
	 * Initialise the color selection panel.
	 */
	private void initialise()
	{

		for(ColorName cn : AssociationFactory.getColors())
		{
			addButton(new ColorSelectionButton(cn.getColor()));
		}

		for (ColorSelectionButton button : buttons)
		{
			add(button); // add button to panel
		}

		revalidate();
		repaint();
	}

	/**
	 * Adds a button to the color selection panel.
	 * 
	 * @param button
	 *            Element to be added to the list
	 * @return true (as specified by {@link Collection#add(Object)}
	 */
	public boolean addButton(final ColorSelectionButton button)
	{
		boolean result = buttons.add(button);
		if (result)
		{
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					fireEvent(button.getColor());
				}
			});
		}
		return result;
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if
	 * it is present.
	 * 
	 * @param button
	 *            Element to be removed from this list, if present.
	 * @return true if this list contained the specified element.
	 */
	public boolean removeButton(ColorSelectionButton button)
	{
		return buttons.remove(button);
	}

}