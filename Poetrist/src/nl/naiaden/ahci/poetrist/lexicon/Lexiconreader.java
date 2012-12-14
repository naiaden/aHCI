package nl.naiaden.ahci.poetrist.lexicon;
import java.awt.Color;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import nl.naiaden.ahci.poetrist.PoetristColors;

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
		private ArrayList<Word> words;

		public Wordlist() { 
			words = new ArrayList<Word>();
		}

		public void add(String name, String emotion, boolean association) {
			if (contains(name)) {
				int index = indexOf(new Word(name, emotion, association));
				Word tmp = new Word(words.get(index).word, words.get(index).color);
				tmp.extend(emotion, association);
				words.set(index, tmp);
			}
			else
				words.add(new Word(name, emotion, association));
		}

		public boolean contains(String word) {
			for (int i = 0; i<words.size(); i++) { 
				//System.out.println("Checking " + word + " against " + words.get(i).getName() + " " + (words.get(i).getName().equals(word)));
				if (words.get(i).word.equals(word))
					return true;	
			}
			return false;
		}

		public int indexOf (Word target) {
			int index = 0;
			for (Word w : words) { 
				if (w.equals(target))
					return index;
				index++;
			}
			return -1;
		}

		public int indexOf(String word) {
			int index = 0;
			for (Word w : words) {
				if (w.word.equals(word))
					return index;
				index++;
			}
			return -1;
		}
		public Word get(int index) {
			return words.get(index);
		}
		public void set(int index, Word w) {
			words.set(index, w);
		}

		public int size() {
			return words.size();
		}
	}

	Wordlist my_lexicon = new Wordlist();

	/**
	 * lexiconreader()
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
		}
		catch (Exception e) {
			System.out.println("Job failed!");
			e.printStackTrace();
		} 
		
		/**
		 * welcome to my much to complicated way to parse the
		 * horrible strings presented by the second file. It
		 * DOES work, though, so just change it if you're sure
		 * what you're doing. Every element of the string is 
		 * nicely separated. Any good ideas how to integrate those?
		 */
		try {
			in = new FileInputStream(file2);
			Scanner linescanner = new Scanner(in);
			for (int i = 1; i < 17; i++)
				linescanner.nextLine();
			int line = 0;
			int filler = 0;
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
				//if (my_lexicon.contains(_name)) {
				//	int index = my_lexicon.indexOf(_name);
				//	Word dummy = new Word (my_lexicon.get(index));
				//	Color rgb = stringToColor(_color);
				//	dummy.fill((PoetristColors)rgb, weight, sense);
				//	filler++;
				//}
				//my_lexicon.add(_name, _emotion, association);
				line++;
			}
			//System.out.println("Job done, filled "+filler+" of the "+my_lexicon.size() + " entries");
			linescanner.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * needed for get strings from the text files
	 * but require Color for one of my current
	 * functions in the word class
	 * @param c
	 * @return
	 */
	public Color stringToColor(String c) 
	{
		if (c.equals("black"))
			return PoetristColors.black; 
		else if (c.equals("blue"))
			return PoetristColors.blue;
		else if (c.equals("brown"))
			return PoetristColors.brown;
		else if (c.equals("green"))
			return PoetristColors.green;
		else if (c.equals("grey"))
			return PoetristColors.gray;
		else if (c.equals("orange"))
			return PoetristColors.orange;
		else if (c.equals("pink"))
			return PoetristColors.pink;
		else if (c.equals("purple"))
			return PoetristColors.purple;
		else if (c.equals("red"))
			return PoetristColors.red;
		else if (c.equals("white"))
			return PoetristColors.white;
		else if (c.equals("yellow"))
			return PoetristColors.yellow;
		else 
			return PoetristColors.darkGray;	//my solution for the problem that the Color string can be "None"
											//Louis suggested to just drop words with this string, but I wasn't
											//sure yet how many of the words we would have lost that way.
	}

}

