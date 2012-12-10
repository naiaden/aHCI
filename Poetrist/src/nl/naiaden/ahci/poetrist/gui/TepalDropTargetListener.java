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

import nl.naiaden.ahci.poetrist.gui.view.TepalViewObject;

/**
 * @author louis
 *
 */
public class TepalDropTargetListener extends DropTargetAdapter
{
	private final DropTarget dropTarget;
	private final JPanel dropPanel;

	public TepalDropTargetListener(JPanel panel)
	{
		dropPanel = panel;
		dropTarget = new DropTarget(dropPanel, DnDConstants.ACTION_COPY, this, true, null);
	}

	/* (non-Javadoc)
	 * @see java.awt.dnd.DropTargetListener#drop(java.awt.dnd.DropTargetDropEvent)
	 */
	@Override
	public void drop(DropTargetDropEvent arg0)
	{
		try
		{
			Transferable tr = arg0.getTransferable();
			TepalViewObject tepal = (TepalViewObject) tr.getTransferData(TransferableTepal.tepalFlavor);
			if (arg0.isDataFlavorSupported(TransferableTepal.tepalFlavor))
			{
				arg0.acceptDrop(DnDConstants.ACTION_COPY);
				System.out.println("Dropped tepal into bucket! [" + tepal.getTepal().getColour() + "]");
				arg0.dropComplete(true);
				return;
			}
			arg0.rejectDrop();
		} catch (Exception e)
		{
			e.printStackTrace();
			arg0.rejectDrop();
		}

	}

}
