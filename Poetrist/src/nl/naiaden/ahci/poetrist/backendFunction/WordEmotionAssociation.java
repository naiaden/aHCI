package nl.naiaden.ahci.poetrist.backendFunction;

import java.util.ArrayList;

import nl.naiaden.ahci.poetrist.object.Emotion;
import nl.naiaden.ahci.poetrist.object.Word;
import nl.naiaden.ahci.poetrist.objectAssociation.Emotion_WordList;
import nl.naiaden.ahci.poetrist.objectAssociation.Word_EmotionList;

/**
 * describe the relation between word and emotions
 * @author Ding
 */
public class WordEmotionAssociation
{
	ArrayList<Emotion_WordList> ewList;
	ArrayList<Word_EmotionList> weList;
	ArrayList<Word> wordList;
	ArrayList<Emotion> emotionList;
	boolean exist;
	
	
	/**
	 * add new emotion to the list of Emotion_WordList
	 * @param newEmotion
	 */
	public void addEmotion(Emotion newEmotion){
		
		for (Emotion_WordList ewl : ewList){
			if (!newEmotion.equals(ewl.getEmotion())){
				Emotion_WordList newEwl = new Emotion_WordList();
				newEwl.setEmotion(newEmotion);
				ewList.add(newEwl);
			}
		}
	}
	
	
	/**
	 * add new word to the word list related to the emotion
	 * @param emotion
	 * @param newWord
	 */
	public void addWordByEmotion(Emotion emotion, Word newWord){
		
		exist = false;
		for (Emotion_WordList ewl : ewList){
			if (emotion.equals(ewl.getEmotion())){
				ewl.addWord(newWord);
				exist = true;
			}
		}
		if (!exist){
			Emotion_WordList newEwl = new Emotion_WordList();
			newEwl.setEmotion(emotion);
			newEwl.addWord(newWord);
			ewList.add(newEwl);
		}
	}
	
	
	/**
	 * get a list of words by choosing emotion
	 * @param emotion
	 * @return
	 */
	public ArrayList<Word> getWordByEmotion(Emotion emotion){
		
		for (Emotion_WordList ewl : ewList){
			if (emotion.equals(ewl.getEmotion())){
				wordList = ewl.getWordList();
			}
		}
		return wordList;
	}
	
	
	/**
	 * add new word into Word_EmotionList
	 * @param newWord
	 */
	public void addWord(Word newWord){
		for (Word_EmotionList wel : weList){
			if (!newWord.equals(wel.getWord())){
				Word_EmotionList newWel = new Word_EmotionList();
				newWel.setWord(newWord);
			}
		}
	}
	
	
	/**
	 * add new emotion to the emotion list related to the word
	 * @param word
	 * @param newEmotion
	 */
	public void addEmotionByWord(Word word, Emotion newEmotion){
		exist = false;
		for (Word_EmotionList wel : weList){
			if (word.equals(wel.getWord())){
				wel.addEmotion(newEmotion);
				exist = true;
			}
		}
		if (!exist){
			Word_EmotionList newWel = new Word_EmotionList();
			newWel.setWord(word);
			newWel.addEmotion(newEmotion);
			weList.add(newWel);
		}
	}
	
	
	/**
	 * get a list of emotions by choosing word
	 * @param word
	 * @return
	 */
	public ArrayList<Emotion> getEmotionByWord(Word word){
		
		for (Word_EmotionList wel : weList){
			if (word.equals(wel.getWord())){
				emotionList = wel.getEmotionList();
			}
		}
		return emotionList;
	}
	
	/**
	 * return a list of words
	 * @return
	 */
	public ArrayList<Word> getWordList(){
		for (Word_EmotionList wel : weList){
			wordList.add(wel.getWord());
		}
		return wordList;
	}
	
	/**
	 * Check if the list contains target word
	 * @param word
	 * @return
	 */
	public boolean contains(Word word){
		for (Word_EmotionList wel : weList){
			if (word.equals(wel.getWord())){
				return true;
			}
		}
		return false;
	}
}
