/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.model;

import java.util.List;
import java.util.Random;

import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.WordColor;

/**
 * @author louis
 *
 */
public class FlowerFactory
{

	public static Flower createFlower(WordColor seed)
	{
		Flower flower = new Flower(new Stigma(seed), 8);
		
		List<WordColor> wordColors = AssociationFactory.getWordColors();
		Random r = new Random();
		for(int i = 0; i < 8; ++i)
		{
			flower.addTepal(new Tepal(wordColors.get(r.nextInt(wordColors.size()))));
		}
		
		
		return flower;
	}

}
