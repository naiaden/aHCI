/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import java.awt.Color;
import java.util.ArrayList;

import nl.naiaden.ahci.poetrist.PoetristColors;

/**
 * @author louis
 * @author Nellethor
 */
public class Word
{
	public String word;
	public Color color;
	private ArrayList<PoetristColors> colors;
	private ArrayList<Double> weight;
	private ArrayList<String> emotion;
	private ArrayList<ArrayList<String>> sense;

	public Word(String word, Color color)
	{
		new Word(word, color, 0.00, "", null);
	}
	
	public Word(String word, Color color, double weight, String emotion, ArrayList<String> sense)
	{
		clearAll();
		this.word = word;
		this.colors.add((PoetristColors) color);
		this.weight.add(weight);
		this.emotion.add(emotion);
		this.sense.add(sense);
		this.color = color;
	}

	private void clearAll() {
		this.colors.clear();
		this.weight.clear();
		this.emotion.clear();
		this.sense.clear();
	}
	
	public void fill (Color color, double weight, String emotion, ArrayList<String> sense)
	{
		int index = colors.indexOf(color);
		if (index == -1) 
		{
			System.out.println("This should probably not happen!");
			this.colors.add((PoetristColors)color);
			this.weight.add(weight);
			this.emotion.add(emotion);
			this.sense.add(sense);
		}
		else 
		{
			this.weight.set(index, weight);
			this.emotion.set(index, emotion);
			this.sense.set(index, sense);
		}
	}
	@Override
	public String toString()
	{
		return word;
	}
	
	public boolean equals(Word w) 
	{	
		boolean color_found = false, emotion_found = false;
		for (int i = 0; i < this.colors.size(); i++) 
			if (w.colors.contains(this.colors.get(i)))
			{
				color_found = true;
				break;
			}
		for (int i = 0; i < this.emotion.size(); i++)
			if (w.emotion.contains(this.emotion.get(i)))
			{
				emotion_found = true;
				break;
			}
		return ((this.word == w.word) && (emotion_found || color_found) );
	}
	
	// Getters 
	public String getWord() { return word; }
	
	public ArrayList<String> getWordEmotions()
	{
		ArrayList<String> wordemotion = new ArrayList<String>();
		for (int i = 0; i < this.emotion.size(); i++)
			wordemotion.add(this.word + " " + this.emotion.get(i));
		return wordemotion;
	}
	
	public ArrayList<String> getWordColors()
	{
		ArrayList<String> wordcolor = new ArrayList<String>();
		for (int i = 0; i < this.colors.size(); i++)
			wordcolor.add(this.word + " " + this.colors.get(i) + " " + this.weight.get(i));
		return wordcolor;
	}
	
	/**
	 * 
	 * @return a list of strings, each with the pattern
	 * emotion followed by whitespace followed by color
	 */
	public ArrayList<String> getEmotionsColors()
	{
		ArrayList<String> emotioncolors = new ArrayList<String>();
		for (int i = 0; i < this.emotion.size(); i++)
			emotioncolors.add(this.emotion.get(i) + " " + this.colors.get(i));
		return emotioncolors;
	}
	
	public int getEmotionCount() { return this.colors.size(); }
	
	public String printAll() 
	{
		String tmp = this.word;
		for (int i = 0; i < this.colors.size(); i++) 
			tmp += " " + emotion.get(i) + " "+ colors.get(i).toString() + " " + weight.get(i);
		return tmp;
	}
}
