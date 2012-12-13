/**
 * 
 */
package nl.naiaden.ahci.poetrist.gui;

import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JPanel;
import nl.naiaden.ahci.poetrist.gui.model.Stigma;
import nl.naiaden.ahci.poetrist.gui.model.Tepal;
import nl.naiaden.ahci.poetrist.gui.panel.FlowerPartPotPanel;
import nl.naiaden.ahci.poetrist.gui.view.FlowerPartViewObject;
import nl.naiaden.ahci.poetrist.gui.view.StigmaViewObject;
import nl.naiaden.ahci.poetrist.gui.view.TepalViewObject;

/**
 * @author louis
 * 
 */
public class FlowerPartPotDropTargetListener extends DropTargetAdapter
{
	private final DropTarget dropTarget;
	private final JPanel dropPanel;

	public FlowerPartPotDropTargetListener(JPanel panel)
	{
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
		System.out.println("[FlowerPartPotDropTargetListener#drop]");
		try
		{
			Transferable tr = arg0.getTransferable();

			if (arg0.isDataFlavorSupported(TransferableFlowerPart.flowerPartFlavor))
			{
				FlowerPartViewObject flowerPart = (FlowerPartViewObject) tr.getTransferData(TransferableFlowerPart.flowerPartFlavor);
				arg0.acceptDrop(DnDConstants.ACTION_COPY);

				// if (dropPanel instanceof FlowerPartPotPanel)
				// {

					if (flowerPart instanceof StigmaViewObject)
					{
						StigmaViewObject stigma = (StigmaViewObject) flowerPart;

						System.out.println("Dropped stigma into bucket! [" + stigma.getStigma().getColour() + "]");

						FlowerPartPotPanel fpp = (FlowerPartPotPanel) dropPanel;
						Stigma originalStigma = stigma.getStigma();
						StigmaViewObject stigmaCopy = new StigmaViewObject(originalStigma, arg0.getLocation().getX(), arg0.getLocation().getY(), stigma.getRadius());
						fpp.addFlowerPart(stigmaCopy);
					}

					if (flowerPart instanceof TepalViewObject)
					{
						TepalViewObject tepal = (TepalViewObject) flowerPart;

						System.out.println("Dropped tepal into bucket! [" + tepal.getTepal().getColour() + "]");

						FlowerPartPotPanel fpp = (FlowerPartPotPanel) dropPanel;
						Tepal originalTepal = tepal.getTepal();
						TepalViewObject tepalCopy = new TepalViewObject(originalTepal, arg0.getLocation().getX(), arg0.getLocation().getY(), tepal.getHeight(), tepal.getWidth(),
								tepal.getRotation());
						fpp.addFlowerPart(tepalCopy);
					}

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
