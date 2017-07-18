import java.awt.Color;
import java.awt.Point;

public class TileView {
	public static void main(String[] args){
		DrawableObjectList objList = new DrawableObjectList();
		int windowX = 400;
		int windowY = 400;
        DrawingTablet tablet = new DrawingTablet("Tiles", windowX, windowY, objList);
        Tile[][] tiles = new Tile[5][5];
        for(int r = 0; r < tiles.length; r++){
        	for(int c = 0; c < tiles[r].length; c++){
        		tiles[r][c] = new Tile(1, new Point(r,c), Color.BLUE);
        		objList.addDrawable(tiles[r][c]);//adding them to the objList to be drawn
        	}
		}
        tablet.repaint();
        
	}
}
