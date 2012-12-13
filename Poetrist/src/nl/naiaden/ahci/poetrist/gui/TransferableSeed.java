/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JLabel;

import nl.naiaden.ahci.poetrist.gui.view.SeedViewObject;
import nl.naiaden.ahci.poetrist.lexicon.Word;

/**
 * 
 * @author louis
 * 
 */
public class TransferableSeed implements Transferable
{

	public String toString()
	{
		return seed.getWord().word;
	}

	protected static DataFlavor seedFlavor = new DataFlavor(SeedViewObject.class, "A Seed Object");
	protected static DataFlavor[] supportedFlavors =
	{ seedFlavor };

	private final SeedViewObject seed;

	public TransferableSeed(SeedViewObject seed)
	{
		System.out.println("[TransferableSeed#TransferableSeed]");

		this.seed = seed;
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException
	{
		System.out.println("[TransferableSeed#getTransferData]");
		if (flavor.equals(seedFlavor))
		{
			return seed;
		} else
			throw new UnsupportedFlavorException(flavor);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors()
	{
		System.out.println("[TransferableSeed#getTransferDataFlavors]");
		return supportedFlavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor)
	{
		System.out.println("[TransferableSeed#isDataFlavorSupported]");
		if (flavor.equals(seedFlavor)) { return true; }
		return false;

		// return true;
	}

}
