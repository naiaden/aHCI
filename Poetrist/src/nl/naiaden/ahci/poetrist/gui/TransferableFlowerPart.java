/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import nl.naiaden.ahci.poetrist.gui.model.Tepal;
import nl.naiaden.ahci.poetrist.gui.view.FlowerPartViewObject;
import nl.naiaden.ahci.poetrist.gui.view.TepalViewObject;

/**
 * @author louis
 * 
 */
public class TransferableFlowerPart implements Transferable
{
	protected static DataFlavor flowerPartFlavor = new DataFlavor(FlowerPartViewObject.class, "A Flower Part Object");
	protected static DataFlavor[] supportedFlavors =
	{ flowerPartFlavor };

	private final FlowerPartViewObject flowerPart;

	public TransferableFlowerPart(FlowerPartViewObject flowerPart)
	{
		System.out.println("[TransferableFlowerPart#TransferableFlowerPart]");
		this.flowerPart = flowerPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.datatransfer.Transferable#getTransferData(java.awt.datatransfer
	 * .DataFlavor)
	 */
	@Override
	public Object getTransferData(DataFlavor arg0) throws UnsupportedFlavorException, IOException
	{
		System.out.println("[TransferableFlowerPart#getTransferData]");

		if (arg0.equals(flowerPartFlavor))
		{
			return flowerPart;
		} else
			throw new UnsupportedFlavorException(arg0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.datatransfer.Transferable#getTransferDataFlavors()
	 */
	@Override
	public DataFlavor[] getTransferDataFlavors()
	{
		System.out.println("[TransferableFlowerPart#getTransferDataFlavors]");
		return supportedFlavors;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.datatransfer.Transferable#isDataFlavorSupported(java.awt.
	 * datatransfer.DataFlavor)
	 */
	@Override
	public boolean isDataFlavorSupported(DataFlavor arg0)
	{
		System.out.println("[TransferableFlowerPart#isDataFlavorSupported]");
		if (arg0.equals(flowerPartFlavor)) { return true; }
		return false;
	}

}
