package ni.naiaden.ahci.poetrist.object;

import java.util.ArrayList;


public class Word {
	String name;
	ArrayList<Sense> senses;
	
	public void setWord(String name){
		this.name = name;
	}
	
	public String getWord(){
		return name;
	}
	
	public void addSense(Sense newSense){
		for (Sense sense : senses){
			if (!newSense.equals(sense)){
				senses.add(newSense);
			}
		}
	}
	
	public void addAllSences(ArrayList<Sense> senseList){
		for (Sense sense : senses){
			for (Sense newSense : senseList){
				if (!newSense.equals(sense)){
					senses.add(newSense);
				}
			}
		}
	}
	
	public ArrayList<Sense> getSenseList(){
		return senses;
	}
}
