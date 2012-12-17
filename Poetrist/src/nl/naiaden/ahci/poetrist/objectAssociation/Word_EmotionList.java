package nl.naiaden.ahci.poetrist.objectAssociation;

import java.util.ArrayList;

import nl.naiaden.ahci.poetrist.object.Emotion;
import nl.naiaden.ahci.poetrist.object.Word;

public class Word_EmotionList
{
	Word word;
	ArrayList<Emotion> emotionList;
	
	public void setWord(Word word){
		
		this.word = word;
	}
	
	public Word getWord(){
		
		return word;
	}
	
	
	public void addEmotion(Emotion newEmotion){
		
		for (Emotion emotion : emotionList){
			
			if (!newEmotion.getName().equals(emotion.getName())){
				
				emotionList.add(newEmotion);
			}
		}
	}
	
	public ArrayList<Emotion> getEmotionList(){
		
		return emotionList;
	}
}
