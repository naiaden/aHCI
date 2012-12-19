/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import nl.naiaden.ahci.poetrist.lexicon.WordColor;

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
	private WordColor wordColor;

	/**
	 * Returns the word color, the essence of the seed.
	 * 
	 * @return the word color.
	 */
	public WordColor getWord()
	{
		return wordColor;
	}

	/**
	 * Creates a new seed bases on a word color.
	 * 
	 * @param oldWord
	 *            The word color on which the new seed is based.
	 */
	public SeedViewObject(WordColor wordColor)
	{
		this.wordColor = wordColor;
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		// TODO Auto-generated method stub

	}

}
