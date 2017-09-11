package Game;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class Plane implements Drawable{

	private boolean visible;
	
	ArrayList<ArrayList<Tile>> plane;
	
	private int type;
	
	public Plane(){
		type = Drawable.MULTI;
		
		visible = true;
		
		plane = new ArrayList<ArrayList<Tile>>();
		
		for(int i = 0; i < plane.size(); ++i){
			plane.add(new ArrayList<Tile>());
			for(int k = 0; k < plane.size(); ++k){
				plane.get(i).add(new Tile(i, k, Drawable.SPACE));
			}
		}
	}
	
	//===========================Overrides================================

	@Override
	public void draw(Graphics g) {
		for(int i = 0; i < plane.size(); ++i){
			for(int k = 0; k < plane.size(); ++k){
				plane.get(i).get(k).draw(g);
			}
		}
	}

	@Override
	public void move(int x, int y) {}

	@Override
	public Point getXY() {return null;}

	@Override
	public int getType() {return type;}

	@Override
	public void setVisisble(boolean visible) {
		this.visible = visible;
	}

	@Override
	public boolean isVisible() {return visible;}

	@Override
	public void setType(int type) {}
	
}
