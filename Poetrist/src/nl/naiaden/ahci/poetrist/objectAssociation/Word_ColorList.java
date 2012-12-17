package nl.naiaden.ahci.poetrist.objectAssociation;

import java.util.ArrayList;

import nl.naiaden.ahci.poetrist.object.Color;
import nl.naiaden.ahci.poetrist.object.Word;

public class Word_ColorList
{	
	Word word;
	ArrayList<Color> colorList;
	
	public void setWord(Word word){
		
		this.word  = word;
	}
	
	public Word getWord(){
		
		return word;
	}
	
	public void addColor(Color newColor){
		
		for (Color color : colorList){
			if (!newColor.getName().equals(color.getName())){
				colorList.add(newColor);
			}
		}
	}
	
	public ArrayList<Color> getColorList(){
		
		return colorList;
	}
}
