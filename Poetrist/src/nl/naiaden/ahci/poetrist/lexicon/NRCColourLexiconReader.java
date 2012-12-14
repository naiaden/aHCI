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
public class NRCColourLexiconReader
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
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
				System.out.println("Word:   " + wordSense[0]);
				String[] senses = wordSense[1].split(", ");
				for (String sense : senses)
				{
					System.out.println("Sense:  " + sense);
				}

				System.out.println("Colour: " + elements[1].substring(7));
				System.out.println("Votes:  " + elements[2].substring(19));
				System.out.println("Tvotes: " + elements[3].substring(15));
			}

			System.out.println();
		}
	}

}
