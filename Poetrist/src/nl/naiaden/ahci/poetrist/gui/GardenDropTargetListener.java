/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JPanel;

import nl.naiaden.ahci.poetrist.gui.model.Flower;
import nl.naiaden.ahci.poetrist.gui.model.Stigma;
import nl.naiaden.ahci.poetrist.gui.panel.GardenPanel;
import nl.naiaden.ahci.poetrist.gui.view.FlowerViewObject;
import nl.naiaden.ahci.poetrist.gui.view.SeedViewObject;
import nl.naiaden.ahci.poetrist.lexicon.Word;

/**
 * @author louis
 *
 */
public class GardenDropTargetListener extends DropTargetAdapter
{

	private final DropTarget dropTarget;
	private final GardenPanel dropPanel;

	public GardenDropTargetListener(GardenPanel panel)
	{
		System.out.println("[GardenDropTargetListener#GardenDropTargetListener]");
		dropPanel = panel;
		dropTarget = new DropTarget(dropPanel, DnDConstants.ACTION_COPY, this, true, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.dnd.DropTargetListener#drop(java.awt.dnd.DropTargetDropEvent)
	 */
	@Override
	public void drop(DropTargetDropEvent arg0)
	{
		System.out.println("[GardenDropTargetListener#drop] ");
		try
		{
			Transferable tr = arg0.getTransferable();
			System.out.println("[GardenDropTargetListener#drop] 1 - " + tr.getTransferDataFlavors().toString());

			if (arg0.isDataFlavorSupported(TransferableSeed.seedFlavor))
			{
				System.out.println("[GardenDropTargetListener#drop]2");
				SeedViewObject seed = (SeedViewObject) tr.getTransferData(TransferableSeed.seedFlavor);
				arg0.acceptDrop(DnDConstants.ACTION_COPY);

				// if (dropPanel instanceof GardenPanel)
				// {

				Point dropLocation = arg0.getLocation();
				
					System.out.println("[GardenDropTargetListener#drop] Seed (" + seed.getWord().word + ") dropped in Garden!");
					FlowerViewObject flower = new FlowerViewObject(new Flower(new Stigma(seed.getWord().color)), dropLocation.getX(), dropLocation.getY(), 150, 7);
					dropPanel.addFlower(flower);

					// if (flowerPart instanceof StigmaViewObject)
					// {
					// StigmaViewObject stigma = (StigmaViewObject) flowerPart;
					//
					// System.out.println("Dropped stigma into bucket! [" +
					// stigma.getStigma().getColour() + "]");
					//
					// FlowerPartPotPanel fpp = (FlowerPartPotPanel) dropPanel;
					// Stigma originalStigma = stigma.getStigma();
					// StigmaViewObject stigmaCopy = new
					// StigmaViewObject(originalStigma,
					// arg0.getLocation().getX(), arg0.getLocation().getY(),
					// stigma.getRadius());
					// fpp.addFlowerPart(stigmaCopy);
					// }
					//
					// if (flowerPart instanceof TepalViewObject)
					// {
					// TepalViewObject tepal = (TepalViewObject) flowerPart;
					//
					// System.out.println("Dropped tepal into bucket! [" +
					// tepal.getTepal().getColour() + "]");
					//
					// FlowerPartPotPanel fpp = (FlowerPartPotPanel) dropPanel;
					// Tepal originalTepal = tepal.getTepal();
					// TepalViewObject tepalCopy = new
					// TepalViewObject(originalTepal, arg0.getLocation().getX(),
					// arg0.getLocation().getY(), tepal.getHeight(),
					// tepal.getWidth(),
					// tepal.getRotation());
					// fpp.addFlowerPart(tepalCopy);
					// }

				// }

				arg0.dropComplete(true);
				return;
			}
			// }
			arg0.rejectDrop();
		} catch (Exception e)
		{
			e.printStackTrace();
			arg0.rejectDrop();
		}

	}

}
