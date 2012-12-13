package nl.naiaden.ahci.poetrist.lexicon;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * The lexiconreader, used to read in the NRC lexica.
 * The National Research Council Canada (NRC) owns all
 * rights to the lexica. NRC has the following terms
 * regarding the use of the lexica:
 * The NRC Emotion Lexicon and the NRC Colour lexicon
 * are to be used for research purposes only. If you 
 * are interested in a commercial license, then please
 * contact NRC.
 * If you are interested in obtaining your personal
 * copy please contact saif.mohammad@nrc-cnrc.gc.ca
 * 
 * Note: requires the NRC emotion lexicon and the 
 * NRC color lexicon, both v0.92, locally available.
 * 
 * @author Nellethor
 * @version 0.2
 *	-- updated to read both lexica
 */
public class Lexiconreader {
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
	
	Wordlist my_lexicon = new Wordlist();
	
	/**
	 * Lexiconreader()
	 * Constructor class, assumes the NRC emotion 
	 * lexicon v0.92 and the NRC color lexicon
	 * v0.92 to be present in the 
	 * Provides some error feedback in case anything
	 * goes wrong.
	 */
	public Lexiconreader() {

		String file1 = "NRC-emotion-lexicon-wordlevel-alphabetized-v0.92.txt";
		String file2 = "NRC-color-lexicon-senselevel-v0.92.txt";
		FileInputStream in; 
		try {
			in = new FileInputStream(file1);
			Scanner linescanner = new Scanner(in);
			for (int i = 1; i < 32; i++)
				linescanner.nextLine();
			int line = 0;
			while (linescanner.hasNext()) {
				String source = linescanner.nextLine();
				Scanner wordscanner = new Scanner(source).useDelimiter("\\t");
				String _name = wordscanner.next();
				String _emotion = wordscanner.next();
				String _association = wordscanner.next();
				boolean association = true;
				if (_association == "0")
					association = false;
				my_lexicon.add(_name, _emotion, association);
				line++;
			}
			System.out.println("Job done!");
			linescanner.close();
			System.out.println(my_lexicon.get(0).toString());
		}
		catch (Exception e) {
			System.out.println("Job failed!");
			e.printStackTrace();
		} 
		try {
			in = new FileInputStream(file2);
			Scanner linescanner = new Scanner(in);
			for (int i = 1; i < 17; i++)
				linescanner.nextLine();
			int line = 0;
			while (linescanner.hasNext()) {
				String source = linescanner.nextLine();
				Scanner wordscanner = new Scanner(source).useDelimiter("--");
				String _name = wordscanner.next();
				ArrayList<String> sense = new ArrayList<String>();
				String _color = new String();
				String tmp = new String();
				if (source.contains(",")) {
				    int counter = 0; int round = 1;
				    for (int i = 0; i < source.length(); i++) {
					if(source.charAt(i) == ',')
					    counter++;
				    }
				    wordscanner.useDelimiter(",");
				    do {
					
					tmp = wordscanner.next();
					if (tmp.contains("--"))  
					    tmp = tmp.substring(2);    
					while (tmp.charAt(0) == ' ')
						tmp = tmp.trim();
					sense.add(tmp);
					
					if (round == counter) {
					    wordscanner.useDelimiter("\\t");
					    tmp = wordscanner.next();
					    tmp = tmp.substring(2);					    
					    sense.add(tmp);
					}
					round++;
				    }while (!(tmp.contains("Colour")));
				}
				else {
				    wordscanner.useDelimiter("\\t");
				    sense.add(wordscanner.next().substring(2));
				    tmp = wordscanner.next();
				}
				Scanner wordchopper = new Scanner(tmp).useDelimiter("=");
				wordchopper.next();
				wordchopper.useDelimiter("\\t");
				_color = wordchopper.next();
				_color = _color.substring(1);
				wordscanner.useDelimiter("\\t");
				tmp = wordscanner.next();
				wordchopper = new Scanner(tmp).useDelimiter("=");
				String _votesPro = wordchopper.next();
				wordchopper.useDelimiter("\\t");
				_votesPro = wordchopper.next();
				_votesPro = _votesPro.substring(1);
				if (_votesPro.equals("None"))
				    _votesPro = "0";
				wordchopper = new Scanner(wordscanner.next()).useDelimiter("=");
				String _votesTotal = wordchopper.next();
				wordchopper.useDelimiter("\\t");
				_votesTotal = wordchopper.next();
				_votesTotal = _votesTotal.substring(1);
				if (_votesTotal.equals("None"))
				    _votesTotal = "0";
				double weight = Integer.parseInt(_votesPro) / Integer.parseInt(_votesTotal);
				//my_lexicon.add(_name, _emotion, association);
				line++;
			}
			System.out.println("Job done!");
			linescanner.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}

