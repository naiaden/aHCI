/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @author louis
 *
 */
public class NRCEmotionLexiconReader
{

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream("doc/NRC-emotion-lexicon-wordlevel-alphabetized-v0.92.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));

		/*
		 * Each line has the following format:
		 * TargetWord<tab>AffectCategory<tab>AssociationFlag
		 */

		String line;

		int countDividerLines = 0;
		while ((line = br.readLine()) != null)
		{
			if (line.startsWith("............"))
			{
				++countDividerLines;
			}

			if (countDividerLines == 2)
			{
				break;
			}
		}

		while ((line = br.readLine()) != null)
		{
			String[] elements = line.split("\t");
			for (String element : elements)
			{
				System.out.println(element);
			}
			System.out.println();
		}
	}

}
