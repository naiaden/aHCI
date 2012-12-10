package nl.naiaden.ahci.poetrist;

import java.awt.Color;
/**
 * Extended version of java.awt.Color
 * Needed since the original had no
 * build-in support for the colors 
 * brown and purple.
 * @author Nellethor
 * @version 0.1
 *
 */
public class PoetristColors extends Color
{

	public PoetristColors(int r, int g, int b)
	{
		super(r, g, b);
	}

	public static final Color brown = new PoetristColors(150,75,0);
	public static final Color BROWN = brown; 
	public static final Color purple = new PoetristColors(128,0,128);
	public static final Color PURPLE = purple;
	
	
}
