import java.awt.Point;

public class Tile {
	public int type;
	public Point location;
	public Tile(int type, Point location){
		this.type = type;
		this.location = location;
	}
	public void setType(int type){
		this.type = type;
	}
}