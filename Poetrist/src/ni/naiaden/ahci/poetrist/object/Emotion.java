package ni.naiaden.ahci.poetrist.object;

public class Emotion {
	String name;
	boolean association;
	
	public void setEmotion(String name){
		this.name = name;
	}
	
	public String getEmotion(){
		return name;
	}
	
	public void setAssociation(boolean association){
		this.association = association;
	}
	
	public boolean getAssociation(){
		return association;
	}
}
