package nl.naiaden.ahci.poetrist.gui.event;

import java.awt.Color;
import java.util.EventObject;

/**
 * 
 * @author louis
 * 
 */
public class ColorChangedEvent extends EventObject
{

	private final Color newColor;

	public Color getColor()
	{
		return newColor;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7649195186297653251L;

	public ColorChangedEvent(Object source, Color color)
	{
		super(source);
		newColor = color;
	}
}