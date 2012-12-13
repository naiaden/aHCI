package nl.naiaden.ahci.poetrist.lexicon;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import nl.naiaden.ahci.poetrist.lexicon.Entry;

/**
 * The lexiconreader, used to read in the NRC lexica.
 * The National Research Council Canada (NRC) owns all
 *  rights to the lexica. NRC has the following terms
 *  regarding the use of the lexica:
 *  The NRC Emotion Lexicon and the NRC Colour lexicon
 *  are to be used for research purposes only. If you 
 *  are interested in a commercial license, then please
 *  contact NRC.
 *  If you are interested in obtaining your personal
 *  copy please contact saif.mohammad@nrc-cnrc.gc.ca
 *  
 * @author Nellethor
 * @version 0.1
 */
public class LexiconReader {
	/**
	 * Little subclass. Might be forked into
	 * an own java file in the near future.
	 */
	private class Wordlist {
		private ArrayList<Entry> words;
		
		
		public Wordlist() { 
			words = new ArrayList<Entry>();
		}
		
		public void add(String name, String emotion, boolean association) {
			if (contains(name)) {
				int index = indexOf(new Entry(name, emotion, association));
				Entry tmp = new Entry(words.get(index));
				tmp.extend(emotion, association);
				words.set(index, tmp);
			}
			else
				words.add(new Entry(name, emotion, association));
		}
		
		public boolean contains(String word) {
			for (int i = 0; i<words.size(); i++) { 
				//System.out.println("Checking " + word + " against " + words.get(i).getName() + " " + (words.get(i).getName().equals(word)));
				if (words.get(i).getName().equals(word))
					return true;	
			}
			return false;
		}
		
		public int indexOf (Entry target) {
			int index = 0;
			for (Entry w : words) { 
				if (w.equals(target))
					return index;
				index++;
			}
			return -1;
		}
		public Entry get(int index) {
			return words.get(index);
		}
	}
	
	Wordlist lex_emotion = new Wordlist();
	Wordlist lex_colour = new Wordlist();
	
	/**
	 * lexiconreader()
	 * Constructor class, assumes a file emolex.txt.
	 * This file is assumed to be the NRC emotion 
	 * lexicon v0.92.
	 * Provides some error feedback in case anything
	 * goes wrong.
	 */
	public LexiconReader() {
		//System.out.println("Hello, I live!");
		String filename = "emolex.txt";
		FileInputStream in;
		try {
			in = new FileInputStream(filename);
			Scanner sc = new Scanner(in);
			for (int i = 1; i < 31; i++)
				sc.nextLine();
			int line = 0;
			StringTokenizer st; 
			while (sc.hasNext()) {
				String source = sc.nextLine();
				Scanner sc2 = new Scanner(source).useDelimiter("\\t");
				st = new StringTokenizer(source);
				String _name = sc.next();
				//System.out.println(_name);
				String _emotion = sc.next();
				//System.out.println(_emotion);
				String _association = sc.next();
				//System.out.println(_association);
				boolean association = true;
				if (_association == "0")
					association = false;
				lex_emotion.add(_name, _emotion, association);
				line++;
			}
			System.out.println("Job done!");
			//System.out.println(lex_emotion.get(1).toString());
		}
		catch (Exception e) {
			System.out.println("Job failed!");
			e.printStackTrace();
		}
	}


}
