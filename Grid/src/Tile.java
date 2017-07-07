import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Tile implements Drawable{
	public int type;
	private Color theColor;
    private boolean isVisible;
	public Point location;
	public Tile(int type, Point location, Color initColor){
		this.type = type;
		this.location = location;
		theColor = initColor;
        isVisible = true;
	}
	public void setType(int type){
		this.type = type;
	}
	public int getX(){
		return location.x;
	}
	public int getY(){
		return location.y;
	}
	// === Implementation of the Drawable interface ===

    /**
     * Draw this DrawableCircle onto the specified Graphics object.
     * 
     * @param g the Graphics object on which to draw this DrawableCircle.
     */
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX() - 5, getY() - 5, 2 * 5, 2 * 5);
    }

    /**
     * Get the Color of this Circle.
     * 
     * @return the color.
     */
    public Color getColor() {
        return theColor;
    }

    /**
     * Change the color of this Circle to the newColor.
     * 
     * @param newColor the new color.
     */
    public void setColor(Color newColor) {
        theColor = newColor;
    }

    /**
     * Set whether or not this Circle will be visible. If it is visible its draw
     * method will be invoked when the DrawingTablet is repainted. If it is not
     * visible its draw method will not be invoked.
     * 
     * @param visible true to make this Circle visible, false to make it
     *            invisible.
     */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    /**
     * Find out if this Circle is visible or not.
     * 
     * @return true if the Circle is visible, false if it is not.
     */
    public boolean isVisible() {
        return isVisible;
    }
}