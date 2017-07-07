import java.awt.Point;

public class Plane {
	tile[][] plane;
	public Plane(){
		plane = new tile[10][10];
		for(int i = 0; i < plane.length; ++i){
			for(int k = 0; k < plane[i].length; ++k){
				plane[i][k] = new tile(0, new Point(i,k));
			}
		}
	}
	private class tile{
		public int type;
		public Point location;
		public tile(int type, Point location){
			this.type = type;
			this.location = location;
		}
		public void setType(int type){
			this.type = type;
		}
	}
}
