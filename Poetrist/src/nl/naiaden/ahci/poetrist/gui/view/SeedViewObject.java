/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import nl.naiaden.ahci.poetrist.lexicon.Word;

/**
 * @author louis
 *
 */
public class SeedViewObject extends JLabel implements Observer
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -84023964320703459L;
	private Word word;

	public Word getWord()
	{
		return word;
	}

	public SeedViewObject(Word word)
	{
		this.word = word;
	}
	
	@Override
	public void update(Observable arg0, Object arg1)
	{
		// TODO Auto-generated method stub

	}

}
