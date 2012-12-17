package nl.naiaden.ahci.poetrist.stringtoemotion;

import java.util.Scanner;

import nl.naiaden.ahci.poetrist.lexicon.LexiconReader;

/**
 * accepts the raw poem, filters out the punctuationm and takes all the relevant words and makes an Emotions class which contains
 * all the necessary information about the emotional value of the raw string.
 * @author Stef Janssen
 *
 */
public class StringToEmotion
{
	//the list of words that are in the poem
	String [] wordList;
	Emotions emotions;
	LexiconReader lr;
	/**
	 * constructor which is going to be actually used, input is the raw poem
	 * @param text
	 */
	public StringToEmotion(String text) {
		emotions = new Emotions();
		lr = new LexiconReader();
		wordList = textToWords(text);
		determineEmotions();
	}
	
	/**
	 * a testing constructor with a preset proem, simply for testing
	 */
	public StringToEmotion() 	{
		String text = "There once was an abbreviated donut, it was lonesome. Future work into a random poem, madness and uncertainty";
		
		emotions = new Emotions();
		lr = new LexiconReader();
		wordList = textToWords(text);
		determineEmotions();
		
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
		for(String word:wordList)
			if(lr.lex_emotion.contains(word))
			{
				System.out.println("A relevant word: " + word);
				emotions.addMagnitudes(lr.lex_emotion.get(word));
			}
			
	}
	
	/**
	 * returns what words have been found in the poem
	 * @return
	 */
	public String [] getText()	{
		return wordList;
	}
}
