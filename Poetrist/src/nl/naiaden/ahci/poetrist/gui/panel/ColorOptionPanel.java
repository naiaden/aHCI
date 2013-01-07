package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import nl.naiaden.ahci.poetrist.gui.event.ColorChangedEvent;
import nl.naiaden.ahci.poetrist.gui.event.ColorChangedListener;
import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.ColorName;
import nl.naiaden.ahci.poetrist.lexicon.Word;

public class ColorOptionPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8514589512508637236L;
	
	
	private Word searchWord = null;
	private List<ColorSelectionButton> buttons = null;
	private GridLayout layout = null;
	private boolean wordFound = false;

	private List<ColorChangedListener> colorChangedListeners = null;
	
	public void setSearchWord(Word word){
		
		this.searchWord = word; 
	}
	
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
	
	public ColorOptionPanel(){
		buttons = new ArrayList<ColorSelectionButton>();
		layout = new GridLayout(0, 1);
		setLayout(layout);

		colorChangedListeners = new ArrayList<ColorChangedListener>();
	}
	
	public void initialise(){
		System.out.println("---------------->"+searchWord);
		
		wordFound = false;
		
		if (searchWord != null){
			
			for (Word word : AssociationFactory.getWords()){
				if (word.equals(searchWord)){
					wordFound = true;
				}
			}
			
			if (wordFound){
				for(ColorName cn : AssociationFactory.getColors(searchWord))
				{
					
					addButton(new ColorSelectionButton(cn.getColor()));
					System.out.println("--------->"+cn.getColor());
				}

				for (ColorSelectionButton button : buttons)
				{
					add(button); // add button to panel
				}
			
				//this.getGraphics().clearRect(0,0,getWidth(),getHeight());
				revalidate();
				repaint();
			}
			else{
				System.out.println("no match word in database");
			}
		}
		else{
			System.out.println("no search word");
		}
	}
	
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
