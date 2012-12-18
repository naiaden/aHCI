/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @author louis
 *
 */
public class NRCColourLexiconReader implements LexiconReader
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void read() throws IOException
	{
		FileInputStream fis = new FileInputStream("doc/NRC-color-lexicon-senselevel-v0.92.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));

		String line;

		while ((line = br.readLine()) != null)
		{
			if (line.startsWith("............"))
			{
				break;
			}
		}

		while ((line = br.readLine()) != null)
		{
			String[] elements = line.split("\t");

			if (elements.length >= 3)
			{
				String[] wordSense = elements[0].split("--");

				Word word = new Word(wordSense[0]);
				AssociationFactory.addWord(word);

				String[] senses = wordSense[1].split(", ");
				for (String sense : senses)
				{
					AssociationFactory.addWordSense(new WordSense(word, new Sense(sense)));
				}

				AssociationFactory.addWordColor(new WordColor(word, new ColorName(elements[1].substring(7)), Integer.parseInt(elements[2].substring(19)), Integer
						.parseInt(elements[3].substring(15))));

			}

			System.out.println();
		}
	}

}
