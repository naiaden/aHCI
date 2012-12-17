package nl.naiaden.ahci.poetrist.objectAssociation;

import java.util.ArrayList;

import nl.naiaden.ahci.poetrist.object.Color;
import nl.naiaden.ahci.poetrist.object.Word;

public class Color_WordList
{
	Color color;
	ArrayList<Word> wordList;
	
	public void setColor(Color color){
		
		this.color = color;
	}
	
	public Color getColor(){
		
		return color;
	}
	
	public void addWord(Word newWord){
		for (Word word : wordList){
			if (!newWord.getName().equals(word.getName())){
				wordList.add(newWord);
			}
		}
	}
	
	public ArrayList<Word> getWordList(){
		
		return wordList;
		
	}
}
