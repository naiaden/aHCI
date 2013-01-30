/**
 * 
 */
package nl.naiaden.ahci.poetrist;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author louis
 *
 */
public class LogWriter
{
	BufferedWriter bw;
	final String fileName;

	public LogWriter()
	{
		fileName = "Poetrist-" + System.currentTimeMillis() + ".log";
		try
		{
			bw = new BufferedWriter(new FileWriter(fileName));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// public void writeImage(BufferedImage g2d)
	// {
	// ImageIO.write(bi, "PNG", new File("c:\\yourImageName.PNG"));
	// }

	public void system(String s)
	{
		try
		{
			bw.write("+++ " + s);
			bw.newLine();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void print(String s)
	{
		try
		{
			bw.write(s);
			bw.newLine();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close()
	{

		try
		{
			bw.flush();
			bw.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void finalize()
	{
		try
		{
			bw.flush();
			bw.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
