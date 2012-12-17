package nl.naiaden.ahci.poetrist.objectAssociation;

import java.util.ArrayList;

import nl.naiaden.ahci.poetrist.object.Emotion;
import nl.naiaden.ahci.poetrist.object.Word;

public class Emotion_WordList
{
	Emotion emotion;
	ArrayList<Word> wordList;
	
	public void setEmotion(Emotion emotion){
		
		this.emotion = emotion;
	}
	
	public Emotion getEmotion(){
		
		return emotion;
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
