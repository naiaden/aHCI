package nl.naiaden.ahci.poetrist.lexicon;

import java.awt.Color;
import java.util.ArrayList;

import nl.naiaden.ahci.poetrist.PoetristColors;
/**
 * The Entry class, a simple tree structure.
 * At root level you have the name of your entry.
 * Currently only supports the format of the 
 * NRC emotion lexicon.
 * NRC colour format will be added ASAP.
 * @author Nellethor
 * @version 0.1
 */
public class Entry {

	private String name;
	private ArrayList<String> emotion_list = new ArrayList<String>();
	private ArrayList<String> senses = new ArrayList<String>();
	private ArrayList<Boolean> association_list = new ArrayList<Boolean>();
	private int nEmotions;
	public enum colors 		{black, blue, brown, green, grey, none, orange,
							pink, purple, red, white, yellow};
	public enum emotions 	{anger, anticipation, disgust, fear, joy, negative, 
							positive, sadness, surprise, trust};
	
	public Entry (String _name, String emotion, boolean associated) {
		name = _name;
		emotion_list.add(emotion);
		association_list.add(associated);
		nEmotions = 1;
	}
	
	public Entry (Entry _entry) {
		name = _entry.getName();
		emotion_list.addAll(_entry.getEmotions());
		association_list.addAll(_entry.getAssociations()); 
	}
	
	public boolean extend (String emotion, boolean associated) {
		if (emotion_list.contains(emotion))
			return false;
		else {
			emotion_list.add(emotion);
			association_list.add(associated);
			return true;
		}
	}
	
	public boolean contains(String emotion) {
		return emotion_list.contains(emotion);
	}
	
	public ArrayList<String> getEmotions() {
		return emotion_list;
	}
	
	public ArrayList<Boolean> getAssociations() {
		return association_list;
	}
	
	public String getName() {
		return name;
	}
	public String toString() {
		String tmp = new String();
		tmp = "Name: "+name+", Emotions/Associations: ";
		for (int i = 0; i < emotion_list.size(); i++)
			tmp = tmp + emotion_list.get(i) + "/" + association_list.get(i) + " ";
		return tmp;
	}
	
	public boolean equals (Entry w) {
		return w.getName().equals(name);
	}
}
