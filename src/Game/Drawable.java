package Game;

import java.awt.Graphics;

public interface Drawable {

	public static final int OVERLAY = 0;
	public static final int SPACE = 1;
	public static final int WALL = 2;
	public static final int MULTI = -1;
	
	public void draw(Graphics g);
	public void move(int x, int y);
	public int getX();
	public int getY();
	
	public int getType();
	public void setType(int type);
	
	public void setVisisble(boolean visible);
	public boolean isVisible();
}
