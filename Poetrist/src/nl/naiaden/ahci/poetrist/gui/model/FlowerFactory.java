/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui.model;

import java.util.List;
import java.util.Random;

import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.Word;
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
		
//		List<WordColor> wordColors = AssociationFactory.getWordColors();
		Random r = new Random();
		
		List<Word> similarWords = AssociationFactory.getNSimilarWords(seed.getWord(), 8);
		for(Word word : similarWords)
		{
			List<WordColor> wordColors = AssociationFactory.getWordColors(word);
			WordColor wordColor = wordColors.get(r.nextInt(wordColors.size()));
			
			flower.addTepal(new Tepal(wordColor));
		}
		
		return flower;
	}

}
