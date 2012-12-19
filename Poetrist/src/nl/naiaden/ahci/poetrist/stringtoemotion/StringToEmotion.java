package nl.naiaden.ahci.poetrist.stringtoemotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import nl.naiaden.ahci.poetrist.lexicon.AssociationFactory;
import nl.naiaden.ahci.poetrist.lexicon.LexiconReader;
import nl.naiaden.ahci.poetrist.lexicon.NRCEmotionLexiconReader;
import nl.naiaden.ahci.poetrist.lexicon.Word;
import nl.naiaden.ahci.poetrist.lexicon.WordEmotion;

/**
 * accepts the raw poem, filters out the punctuationm and takes all the relevant words and makes an Emotions class which contains
 * all the necessary information about the emotional value of the raw string.
 * @author Stef Janssen
 *
 */
public class StringToEmotion
{
	//the list of words that are in the poem
	private String [] wordList;
	private Emotions emotions;
	LexiconReader lr;
	private  List <Word> words = new ArrayList<Word>();
	/**
	 * constructor which is going to be actually used, input is the raw poem
	 * @param text
	 */
	public StringToEmotion(String text) {
		emotions = new Emotions();
		lr = new NRCEmotionLexiconReader();
		words = AssociationFactory.getWords();
		wordList = textToWords(text);
		determineEmotions();
	}
	
	/**
	 * a testing constructor with a preset proem, simply for testing
	 */
	public StringToEmotion() 	{
		String text = "firstborn iniquity loyalty stab";
		
		emotions = new Emotions();
		lr = new NRCEmotionLexiconReader();
		words = AssociationFactory.getWords();
		wordList = textToWords(text);
		determineEmotions();
		//emotions.showMagnitudes();
	}
	
	/**
	 * changes the raw text to a list of words. This function does not determine whether these words are relevant or not. 
	 * it just simply splits it into separate words and returns it as a String array
	 */
	private String[] textToWords(String text) {
		text = text.replaceAll("\\p{Punct}", "");	//takes out all punctuation
		text = text.trim();							//removes the outside whitespace
		text = text.replaceAll("\\s+", " ");		//removes duplicate whitespace
		return text.split(" ");						//splits string into an array of words
	}
	
	
	/**
	 * loops through the list of words and checks whether the lexicon contains the word. If so, it adds the emotional value to the
	 * emotions class.
	 */
	private void determineEmotions() {
		System.out.println("determining emotions");
		for(String word:wordList)
			for(Word w: words)
				if(word.equals(w.getWord()))
				{
					//System.out.println("A relevant word: " + word);	//for visualizing which words get chosen
					emotions.addMagnitudes(AssociationFactory.getWordEmotions(w));
					//for(WordEmotion ww: AssociationFactory.getWordEmotions(w))
					//	System.out.println(ww.toString());
					
				}
			
	}
	
	/**
	 * returns what words have been found in the poem
	 * @return
	 */
	public String [] getText()	{
		return wordList;
	}
	
	/**
	 * returns the emotions class which holds all the information about the magnitudes.
	 * @return
	 */
	public Emotions getEmotions() {
		return emotions;
	}
}
