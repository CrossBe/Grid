package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Tile implements Drawable{

	public int x;
	public int y;
	public int type;
	private boolean visible;
	private boolean selected;
	
	public Tile path;
	public int distance;
	public boolean visited;
	
	private boolean revealStats = true;
	
	private Character character;
	
	public Tile(int x, int y, int type){
		this.x = x;
		this.y = y;
		this.type = type;
		visible = true;
		
		distance = 0;
		visited = false;
		path = null;
		
		character = null;
	}
	
	public void select(){
		if(selected){
			selected = false;
		}else{
			selected = true;
		}
	}
	
	//===========================Overrides================================
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		if(type == SPACE){
			g.setColor(Color.GRAY);
		}else if(type == WALL){
			g.setColor(Color.BLACK);
		}
		g.fillRect(x*50, y*50, 50, 50);
		g.setColor(Color.WHITE);
		g.drawRect(x*50, y*50, 50, 50);
		if(selected){
			g.setColor(Color.BLUE);
			g.fillRect(x*50, y*50, 5, 50);//Left
			g.fillRect(x*50, y*50, 50, 5);//UP
			g.fillRect(x*50, ((y+1)*50)-5, 50, 5);//Down
			g.fillRect(((x+1)*50)-5, y*50, 5, 50);//Right
		}
		if(revealStats){
			g.setColor(Color.white);
	    	g.drawString("" + distance, x*50, (y*50)+10);
		}
		if(character != null){
			character.draw(g);
		}
	}

	@Override
	public void move(int x, int y) {}

	@Override
	public Point getXY() {
		return new Point(x, y);
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public void setVisisble(boolean visible) {
		this.visible = visible;
	}

	@Override
	public boolean isVisible() {return visible;}

	@Override
	public void setType(int type) {
		this.type = type;
		
	}

}
