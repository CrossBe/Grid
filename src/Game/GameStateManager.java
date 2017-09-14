package Game;

import java.awt.Graphics;
import java.util.ArrayList;

public class GameStateManager {

	ArrayList<Drawable> layers;

	Plane plane;
	
	public GameStateManager(){
		
		layers = new ArrayList<Drawable>();
		plane = new Plane();
		layers.add(plane);
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i < layers.size(); ++i){
			layers.get(i).draw(g);
		}
	}
	
	//===================Controls===================
	public void rightKey(){
		plane.moveRight();
	}
	public void leftKey(){
		plane.moveLeft();
	}
	public void upKey(){
		plane.moveUp();
	}
	public void downKey(){
		plane.moveDown();
	}
	public void spaceKey(){
		plane.makeSelection();
	}
}
