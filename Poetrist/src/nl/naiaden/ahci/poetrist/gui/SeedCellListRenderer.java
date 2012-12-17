/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.Component;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import nl.naiaden.ahci.poetrist.gui.view.SeedViewObject;
import nl.naiaden.ahci.poetrist.lexicon.Word;

/**
 * @author louis
 * 
 */
public class SeedCellListRenderer extends DefaultListCellRenderer implements DragGestureListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3322459458679910468L;

	private SeedViewObject seed;

	public SeedViewObject getWord()
	{
		return seed;
	}

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{

		this.seed = (SeedViewObject) value;
		setText(seed.getWord().word);
		setBackground(seed.getWord().color);

		
		return this;
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge)
	{
		System.out.println("[SeedCellListRenderer#dragGestureRecognized]");
	}

}
