package nl.naiaden.ahci.poetrist.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PeotryMakePanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -916168874765976242L;

	public PeotryMakePanel(){
		JTextArea input =  new JTextArea(5,25);
		JButton submit = new JButton("submit");
		add(input);
		add(submit);
	}
	public class TextFieldListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
