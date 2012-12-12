/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import nl.naiaden.ahci.poetrist.lexicon.Word;

/**
 * @author louis
 * 
 */
public class WordCellListRenderer extends DefaultListCellRenderer
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3322459458679910468L;

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{

		Word word = (Word) value;
		setText(word.word);
		setBackground(word.color);

		return this;
	}

}
