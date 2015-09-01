package at.ac.tuwien.dbai.pdfwrap.gui.layer;

import at.ac.tuwien.dbai.pdfwrap.model.document.GenericSegment;
import at.ac.tuwien.dbai.pdfwrap.model.document.TextBlock;

import java.awt.*;

/**
 * A class for styling any kind of segment associated with it.
 * 
 * @author Timo Schleicher
 *
 */
public class Style {

	private boolean filled;
	
	private Color col;
	
	private int strokeWidth;
	
	private Shapes shape;
	
	private String source;
	
	private boolean isPrinted;
	
	/**
	 * The constructor for a Style object.
	 * 
	  Specifies whether the associated shape should be filled or not
	  Red value of the RGB color
	  Green value of the RGB color
	  Blue value of the RGB color
	  Alpha value of the RGB color
	  The width of the stroke that is used to draw the shape
	  Specifies which kind of shape is used.
	  The specific class (name) that is associated with this style information. Meant are outputs of the PDF analysis
	 * process, e.g. {@link TextBlock}.
	 */
	public Style(boolean filled, int r, int g, int b, int alpha, int strokeWidth, Shapes shape, String source) {
		
		this.filled = filled;
		this.col = new Color(r,g,b,alpha);
		this.strokeWidth = strokeWidth;
		this.shape = shape;
		this.source = source;
		
		//Default value for printing is set to true
		this.isPrinted = true;
	}
	
	/**
	 * Checks whether the shape is filled or not.
	 * 
	  if the shape is filled, false otherwise
	 */
	public boolean isfilled() {
		
		return filled;
	}
	
	/**
	 * Get the color information.
	 * 
	  color of the current style object
	 */
	public Color getColor() {
		
		return col;
	}
	
	/**
	 * Get the stroke width of the shape
	 * 
	  stroke width of the current shape
	 */
	public int getStrokeWidth() {
		
		return strokeWidth;
	}
	
	/**
	 * Get the name of the shape, e.g. rectangle.
	 * 
	  name of the shape.
	 */
	public Shapes getShape() {
		
		return shape;
	}
	
	/**
	 * Get the name of the associated class. That is one of the {@link GenericSegment} objects.
	 * 
	  name of a class
	 */
	public String getSource() {
		
		return source;
	}
	
	/**
	 * Checks whether the objects associated with this style information should be printed or not.
	 * 
	  if printing is desired, false otherwise
	 */
	public boolean isPrintable() {
		
		return isPrinted;
	}
	
	/**
	 * Sets the printing behavior.
	 * 
	  True if the objects associated with this class should be printed, false otherwise.
	 */
	public void setPrintable(boolean isPrinted) {
		
		this.isPrinted = isPrinted;
	}
	
	@Override
	public String toString() {		
		return "Source: " + source + " Shape: " + shape + " Color-Red: " + col.getRed() + " Color-Green: " + col.getGreen() + " Color-Blue: " + col.getBlue() +
				" Transparency: " + col.getAlpha() + " Filled: " + filled + " Stroke-Width: " + strokeWidth;	
	}	
}
