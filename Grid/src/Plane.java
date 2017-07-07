import java.awt.Color;
import java.awt.Point;

public class Plane {
	Tile[][] plane;
	public Plane(){
		plane = new Tile[10][10];
		for(int i = 0; i < plane.length; ++i){
			for(int k = 0; k < plane[i].length; ++k){
				plane[i][k] = new Tile(0, new Point(i,k), Color.BLUE);
			}
		}
	}
}
