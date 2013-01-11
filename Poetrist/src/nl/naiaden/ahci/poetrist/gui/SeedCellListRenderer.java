/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.color.ColorSpace;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import nl.naiaden.ahci.poetrist.gui.view.SeedViewObject;

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
		setText(seed.getWord().getWord().toString());
//		setBackground(seed.getWord().getColor().getColor());
		Color color = seed.getWord().getColor().getColor();
		setBackground(new Color(color.getRed(), color.getGreen(), color.getBlue(), 96));

		
		return this;
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge)
	{
		System.out.println("[SeedCellListRenderer#dragGestureRecognized]");
	}

}
