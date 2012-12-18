/**
 * 
 */
package nl.naiaden.ahci.poetrist.lexicon;

import java.io.File;
import java.io.IOException;

/**
 * @author louis
 *
 */
public interface LexiconReader
{
	public void read(File lexiconFile) throws IOException;
}
