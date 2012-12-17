package nl.naiaden.ahci.poetrist.backendFunction;

import java.util.ArrayList;

import nl.naiaden.ahci.poetrist.object.Color;
import nl.naiaden.ahci.poetrist.object.Word;
import nl.naiaden.ahci.poetrist.objectAssociation.Color_WordList;
import nl.naiaden.ahci.poetrist.objectAssociation.Word_ColorList;

/**
 * describe the relation between word and color
 * @author Ding
 */
public class WordColorAssociation
{
	ArrayList<Color_WordList> cwList;
	ArrayList<Word_ColorList> wcList;
	ArrayList<Word> wordList = null;
	ArrayList<Color> colorList = null;
	boolean exist;
	
	/**
	 * add new color into the list of Color_WordList
	*/
	public void addColor(Color newColor){
		
		for (Color_WordList cwl : cwList){
			if (!newColor.equals(cwl.getColor())){
				Color_WordList newCwl  = new Color_WordList();
				newCwl.setColor(newColor);
				cwList.add(newCwl);
			}
		}
	}
	
	/**
	 * add word to the word list related to the color, 
	 * if the color does not exist, new entry for the color
	 * is created, and then word is added into word list
	*/
	public void addWordByColor(Color color, Word newWord){
		exist = false;
		for (Color_WordList cwl : cwList){
			if(color.equals(cwl.getColor())){
				cwl.addWord(newWord);
				exist = true;
			}
				
		}
		if (!exist){
			Color_WordList newCwl  = new Color_WordList();
			newCwl.setColor(color);
			newCwl.addWord(newWord);
			cwList.add(newCwl);
		}
	}
	
	
	/**
	 * return a list of words by choosing color
	 * @param color
	 * @return
	 */
	public ArrayList<Word> getWordByColor(Color color){
		
		for (Color_WordList cwl : cwList){
			if (color.equals(cwl.getColor())){
				wordList =  cwl.getWordList();
			}
		}
		return wordList;
	}
	
	
	/**
	 * add new word into the list of Word_EmotionList
	 * @param newWord
	 */
	public void addWord(Word newWord){
		for (Word_ColorList wcl : wcList){
			if (!newWord.equals(wcl.getWord())){
				Word_ColorList newWcl  = new Word_ColorList();
				newWcl.setWord(newWord);
			}
		}
	}
	
	
	/**
	 * add new color to the color list related to the word,
	 * if the word does not exist, create a new entry for
	 * the word, and then color is added
	 * @param word
	 * @param newColor
	 */
	public void addColorByWord(Word word, Color newColor){
		exist = false;
		for (Word_ColorList wcl : wcList){
			if (word.equals(wcl.getWord())){
				
				wcl.addColor(newColor);
				exist = true;
			}
		}
		if (!exist){
			
			Word_ColorList newWcl = new Word_ColorList();
			newWcl.setWord(word);
			newWcl.addColor(newColor);
			wcList.add(newWcl);
		}
	}
	
	
	/**
	 * return a list of color by choosing word
	 * @param word
	 * @return
	 */
	public ArrayList<Color> getColorByWord(Word word){
		
		for (Word_ColorList wcl : wcList){
			if (word.equals(wcl.getWord())){
				colorList = wcl.getColorList();
			}
		}
		return colorList;
	}
	
}
