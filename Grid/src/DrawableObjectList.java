import java.util.*;
import java.awt.*;

/**
 * A DrawableObjectList is a collection of Objects that implement the Drawable
 * interface. This class is used by the DrawingTablet to maintain the list of
 * objects to be drawn on the screen. This class also provides methods for
 * drawing or scaling all of the objects.
 */
public class DrawableObjectList {
	ArrayList<Drawable> objs;
    /**
     * Construct a new empty DrawableObjectList.
     */
    public DrawableObjectList() {
    	objs = new ArrayList<Drawable>();
    }
    /**
     * Get the number of Drawable objects that are currently in the list.
     * 
     * @return the size of the list.
     */
    public int getSize() {
        return objs.size();
    }

    /**
     * Add the specified Drawable object to the end of this DrawableObjectList.
     * 
     * @param obj the Drawable object to be added.
     */
    public void addDrawable(Drawable obj) {
    	objs.add(obj);
    }

    /**
     * Remove the specified Drawable object from the DrawableObjectList.  If the
     * object referred to by obj is also stored in the list it is removed.
     * 
     * @param obj the Drawable object to remove.
     */
    public void removeDrawable(Drawable obj) {
    	objs.remove(obj);
    }
    
    /**
     * Finds the index of the given Drawable Object. Returns -1 if it is not in the arrayList
     * Returns the first index of the object in the array if there are duplicates. Probably could
     * have used the getIndexOf method...
     * 
     * @param Drawable the Drawable object to find the index of.
     * @return int the index value of d in the array or -1 if it is not found.
     */
    public int getIndex(Drawable d){
    	for(int i = 0; i < objs.size(); i++){
    		if(objs.get(i) == d){
    			return i;
    		}
    	}
    	return -1;
    }
    /**
     * Swaps the object at indexFrom with the object indexTo
     * 
     * @param int indexFrom index value of the object to move
     * @param int indexTo index value of the object to move
     */
    public void swapIndex(int indexFrom, int indexTo){
      	Drawable holder = objs.get(indexFrom);
    	objs.set(indexFrom, objs.get(indexTo));
    	objs.set(indexTo, holder);
    }
    /**
     * Moves the drawable object by the amount given in either direction. Meaning
     * if you gave it -1, it would move 1 value towards the first value in the list
     * 
     * @param int amount to move the object
     * @param Drawable obj that needs to be moved.
     */
    public void shift(int amount, Drawable obj){
    	int indexFrom = getIndex(obj);
    	if(indexFrom > -1 || (indexFrom == 0 && amount < 0) || (indexFrom == objs.size() && amount > 0)){
    		for(int i = Math.abs(amount); i > 0; i--){
    			swapIndex(indexFrom, (indexFrom + (amount/Math.abs(amount))));
    			indexFrom = getIndex(obj);
        	}
    	}
    }
    /**
     * Moves the drawable object to the end in the direction given
     * 
     * @param int direction -value to move to the front, +value to move the the end
     * @param Drawable obj that needs to be moved 
     */
    public void toAnEnd(int direction, Drawable obj){
    	if(getIndex(obj) > -1){
    		if(direction > 0){
    			shift(0-(getIndex(obj)), obj);
    		}
    		if(direction < 0){
    			shift((objs.size()-getIndex(obj)), obj);
    		}
    	}
    }

    /**
     * Draw each of the visible Drawable objects that are contained in this
     * DrawableObjectList onto the specified graphics object. Objects that are
     * not visible are not drawn. The objects are drawn in the order
     * that they were added so that more recently added objects appear in front
     * of added earlier.
     * 
     * @param g the Graphics object on which to draw the objects.
     */
    public void drawAll(Graphics g) {
    	for(int i = 0; i < objs.size(); i++){
    		objs.get(i).draw(g);
    	}
    }
}
