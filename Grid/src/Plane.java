import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Plane {
	Tile[][] plane;
	public Plane(){
		plane = new Tile[10][10];
		for(int i = 0; i < plane.length; ++i){
			for(int k = 0; k < plane[i].length; ++k){
				if(i%2==0){
					plane[i][k] = new Tile(0, new Point(i,k), Color.BLACK);
				}
				else{
					plane[i][k] = new Tile(0, new Point(i,k), Color.BLUE);
				}
			}
		}
	}
	public void drawAll(Graphics g) {
		for(int i = 0; i < plane.length; ++i){
			for(int k = 0; k < plane[i].length; ++k){
				plane[i][k].draw(g);
			}
		}
    }
}
