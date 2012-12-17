/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import nl.naiaden.ahci.poetrist.lexicon.Word;

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
	private Word word;

	/**
	 * Returns the word, the essence of the seed.
	 * 
	 * @return the word.
	 */
	public Word getWord()
	{
		return word;
	}

	/**
	 * Creates a new seed bases on a word.
	 * 
	 * @param word
	 *            The word on which the new seed is based.
	 */
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
