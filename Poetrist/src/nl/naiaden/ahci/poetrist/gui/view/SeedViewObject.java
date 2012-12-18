/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import nl.naiaden.ahci.poetrist.lexicon.OldWord;

/**
 * A seed can spawn a new flower, as words can spawn new emotions.
 * 
 * @author louis
 * 
 */
public class SeedViewObject extends JLabel implements Observer
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -84023964320703459L;
	private OldWord oldWord;

	/**
	 * Returns the oldWord, the essence of the seed.
	 * 
	 * @return the oldWord.
	 */
	public OldWord getWord()
	{
		return oldWord;
	}

	/**
	 * Creates a new seed bases on a oldWord.
	 * 
	 * @param oldWord
	 *            The oldWord on which the new seed is based.
	 */
	public SeedViewObject(OldWord oldWord)
	{
		this.oldWord = oldWord;
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		// TODO Auto-generated method stub

	}

}
