package nl.naiaden.ahci.poetrist.backendFunction;

import java.util.ArrayList;

import nl.naiaden.ahci.poetrist.object.Color;
import nl.naiaden.ahci.poetrist.object.Word;
import nl.naiaden.ahci.poetrist.objectAssociation.Color_WordList;
import nl.naiaden.ahci.poetrist.objectAssociation.Word_ColorList;

public class WordColorAssociation
{
	ArrayList<Color_WordList> cwList;
	ArrayList<Word_ColorList> wcList;
	
	
	public void addColor(Color newColor){
		
		for (Color_WordList cwl : cwList){
			if (!newColor.getName().equals(cwl.getColor().getName())){
				Color_WordList newCwl  = new Color_WordList();
				newCwl.setColor(newColor);
				cwList.add(newCwl);
			}
		}
	}
	
	public void addWordByColor(Color color, Word newWord){
		for (Color_WordList cwl : cwList){
			if(color.getName().equals(cwl.getColor().getName())){
				cwl.addWord(newWord);
			}
			else{
				Color_WordList newCwl  = new Color_WordList();
				newCwl.setColor(color);
				cwList.add(newCwl);
				
			}
		}
	}
	
	
	public void addWord(Word word){
		
		
	}
	
}
