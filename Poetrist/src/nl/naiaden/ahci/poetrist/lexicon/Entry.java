package nl.naiaden.ahci.poetrist.lexicon;

import java.util.ArrayList;
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
	private ArrayList<String> emotions = new ArrayList<String>();
	private ArrayList<Boolean> associations = new ArrayList<Boolean>();
	
	public Entry (String _name, String emotion, boolean associated) {
		name = _name;
		emotions.add(emotion);
		associations.add(associated);
	}
	
	public Entry (Entry _entry) {
		name = _entry.getName();
		emotions.addAll(_entry.getEmotions());
		associations.addAll(_entry.getAssociations()); 
	}
	
	public boolean extend (String emotion, boolean associated) {
		if (emotions.contains(emotion))
			return false;
		else {
			emotions.add(emotion);
			associations.add(associated);
			return true;
		}
	}
	
	public boolean contains(String emotion) {
		return emotions.contains(emotion);
	}
	
	public ArrayList<String> getEmotions() {
		return emotions;
	}
	
	public ArrayList<Boolean> getAssociations() {
		return associations;
	}
	
	public String getName() {
		return name;
	}
	public String toString() {
		String tmp = new String();
		tmp = "Name: "+name+", Emotions/Associations: ";
		for (int i = 0; i < emotions.size(); i++)
			tmp = tmp + emotions.get(i) + "/" + associations.get(i) + " ";
		return tmp;
	}
	
	public boolean equals (Entry w) {
		return w.getName().equals(name);
	}
}
