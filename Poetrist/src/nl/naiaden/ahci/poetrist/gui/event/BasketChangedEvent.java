/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.event;

import java.util.EventObject;

import nl.naiaden.ahci.poetrist.gui.panel.BasketPanel;
import nl.naiaden.ahci.poetrist.gui.view.FlowerPartViewObject;

/**
 * @author louis
 *
 */
public class BasketChangedEvent extends EventObject
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -466412347376357198L;
	private final FlowerPartViewObject flowerPart;
	private final EventType eventType;


	public EventType getEventType()
	{
		return eventType;
	}

	public FlowerPartViewObject getFlowerPart()
	{
		return flowerPart;
	}

	public enum EventType
	{
		CHANGED, MOVED, ADDED, DELETED
	};

	public BasketChangedEvent(BasketPanel source, FlowerPartViewObject flowerPart, EventType eventType)
	{
		super(source);
		this.flowerPart = flowerPart;
		this.eventType = eventType;
	}

}
