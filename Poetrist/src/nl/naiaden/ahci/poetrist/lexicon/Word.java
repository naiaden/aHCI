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

/**
 * Some commentary: this class is my attempt to extend my 
 * initial Entry class with the field required by the 
 * second lexicon. 
 * I am not entirely sure we actually NEED all the fields 
 * that the lexica provide for us.
 */
public class Word
{
	public String word;
	public Color color;	// in here since Ding's code assumed one singular color per word
	private ArrayList<PoetristColors> colors;
	private ArrayList<Double> weight = new ArrayList<Double>();	// computed from the votes inside the lexicon
	private ArrayList<String> emotion = new ArrayList<String>();
	private ArrayList<ArrayList<String>> sense = new ArrayList<ArrayList<String>>(); 
	public ArrayList<Boolean> associated = new ArrayList<Boolean>(); // the 0's and 1's from the emotion lexicon
	int nColors = 0;
	public Word(String word, Color color)
	{
	    this.word = word;
	    this.color = color;
	    this.colors.add((PoetristColors) color);
	    nColors++;
	}
	
	public Word(String word, String emotion, Boolean associated)
	{
	    this.word = word;
	    this.color = Color.LIGHT_GRAY;	// needed some initial setting,
	    								// went with light_gray since
	    								// it's not in the lexicon
	    this.colors.add((PoetristColors) Color.LIGHT_GRAY);
	    this.weight.add(-1.0);
	    this.emotion.add(emotion);
	    ArrayList<String> dummy = new ArrayList<String>();
	    dummy.add("default");
	    this.sense.add(dummy);
	    this.associated.add(associated);	
	}
	public Word(String word, Color color, double weight, String emotion, ArrayList<String> sense, Boolean associated)
	{
		//clearAll();
		this.word = word;
		this.colors.add((PoetristColors) color);
		this.weight.add(weight);
		this.emotion.add(emotion);
		this.sense.add(sense);
		this.color = color;
		if (!(this.color.equals(null)))
		    nColors++;
		this.associated.add(associated);
	}
	
	public Word (Word source)
	{
	    this.word = source.word;
	    this.color = source.color;
	    this.colors.addAll(source.getColors());
	    this.weight.addAll(source.weight);
	    this.emotion.addAll(source.getEmotions());
	    this.sense.addAll(source.getSense());
	    this.associated = source.associated;
	}
	private void clearAll() {
		this.colors.clear();
		this.weight.clear();
		this.emotion.clear();
		this.sense.clear();
		this.associated.clear();
	}
	
	public void fill (PoetristColors color, double weight, ArrayList<String> sense)
	{
		int index = colors.indexOf(color);
		if (index == -1) 
		{
			System.out.println("This should probably not happen!");
			this.colors.add((PoetristColors)color);
			this.weight.add(weight);
			//this.emotion.add(emotion);
			this.sense.add(sense);
		}	// the emotion part remained after I trimmed this function back
		else  // assumed that I might need it in the future 
		{
			this.weight.set(index, weight);
			//this.emotion.set(index, emotion);
			this.sense.set(index, sense);
		}
	}
	@Override
	public String toString()
	{
		return word;
	}
	
	/**
	 * 
	 * @param w word
	 * @return true if the name of the words are equal and, 
	 * additionally, the color or emotion listed for it
	 */
	public boolean equals(Word w) 
	{	
		boolean color_found = false, emotion_found = false;
		for (int i = 0; i < nColors; i++) 
			if (w.colors.contains(this.colors.get(i)))
			{
				color_found = true;
				break;
			}
		for (int i = 0; i < nColors; i++)
			if (w.emotion.contains(this.emotion.get(i)))
			{
				emotion_found = true;
				break;
			}
		return ((this.word == w.word) && (emotion_found || color_found) );
	}
	
	// Getters 
	public String getWord() { return word; }
	
	public ArrayList<PoetristColors> getColors() { return this.colors; }
	
	public ArrayList<String> getWordEmotions()
	{
		ArrayList<String> wordemotion = new ArrayList<String>();
		for (int i = 0; i < nColors; i++)
			wordemotion.add(this.word + " " + this.emotion.get(i));
		return wordemotion;
	}
	
	public ArrayList<String> getWordColors()
	{
		ArrayList<String> wordcolor = new ArrayList<String>();
		for (int i = 0; i < nColors; i++)
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
		for (int i = 0; i < nColors; i++)
			emotioncolors.add(this.emotion.get(i) + " " + this.colors.get(i));
		return emotioncolors;
	}
	
	public int getEmotionCount() { return this.colors.size(); }
	
	public ArrayList<String> getEmotions() { return this.emotion;}
	
	public ArrayList<ArrayList<String>> getSense() { return this.sense; }
	
	public String printAll() 
	{
		String tmp = this.word;
		for (int i = 0; i < this.nColors; i++) 
			tmp += " " + emotion.get(i) + " "+ colors.get(i).toString() + " " + weight.get(i);
		return tmp;
	}

	public boolean extend (String emotion, boolean associated) {
		if (this.emotion.contains(emotion))
			return false;
		else {
			this.emotion.add(emotion);
			this.associated.add(associated);
			return true;
		}
	
	}
}
