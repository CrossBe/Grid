package Game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Plane implements Drawable{

	private boolean visible;
	
	public Tile[][] plane;
	
	private int type;
	
	private int playerX = 1;
	private int playerY = 1;
	
	int holdingX = -1;
	int holdingY = -1;
	boolean showHold = false;
	
	public Plane(){
		type = Drawable.MULTI;
		
		visible = true;
		
		plane = new Tile[10][10];
		for(int i = 0; i < 10; ++i){
			for(int k = 0; k < 10; ++k){
				plane[i][k] = new Tile(i, k, Drawable.SPACE);
			}
		}
		
		plane[1][2].setType(Drawable.WALL);
		plane[1][3].setType(Drawable.WALL);
		plane[1][4].setType(Drawable.WALL);
		plane[2][1].setType(Drawable.WALL);
		plane[2][5].setType(Drawable.WALL);
		plane[3][1].setType(Drawable.WALL);
		plane[3][3].setType(Drawable.WALL);
		plane[3][5].setType(Drawable.WALL);
		plane[4][1].setType(Drawable.WALL);
		plane[4][3].setType(Drawable.WALL);
		plane[4][4].setType(Drawable.WALL);
		plane[5][1].setType(Drawable.WALL);
		plane[6][2].setType(Drawable.WALL);
		plane[6][3].setType(Drawable.WALL);
		plane[6][4].setType(Drawable.WALL);
		plane[6][5].setType(Drawable.WALL);
		plane[6][6].setType(Drawable.WALL);
		
		plane[playerX][playerY].select();
		plane[playerX][playerY].setChar(new Character(plane[playerX][playerY]));
		showDistance(false);
	}
	
	public int getPlayerX() {
		return playerX;
	}

	public int getPlayerY() {
		return playerY;
	}
	
	public void showDistance(boolean reveal){
		for (int i = 0; i < plane.length; ++i) {
			for (int k = 0; k < plane[i].length; ++k) {
				plane[i][k].revealStats(reveal);
			}
		}
	}
	
	// ===========================Player Control===========================

	public void makeSelection(){
		if(holdingX == -1 || holdingY == -1){
			if(plane[playerX][playerY].getChar() != null){
				showHold = true;
				holdingX = playerX;
				holdingY = playerY;
				clearDistance();
				setDistance(playerX, playerY);
				showDistance(true);
			}
		}else{
			if(plane[holdingX][holdingY].getChar().speed >= plane[playerX][playerY].getDistance()){
				moveChar(holdingX, holdingY, playerX, playerY);
				showHold = false;
				holdingX = -1;
				holdingY = -1;
				showDistance(false);
			}
		}
	}
	
	public void moveRight(){
		if(playerX < 9){
			plane[playerX][playerY].select();
			playerX++;
			plane[playerX][playerY].select();
		}
	}
	public void moveLeft(){
		if(playerX > 0){
			plane[playerX][playerY].select();
			playerX--;
			plane[playerX][playerY].select();
		}
	}
	public void moveUp(){
		if(playerY > 0){
			plane[playerX][playerY].select();
			playerY--;
			plane[playerX][playerY].select();
		}
	}
	public void moveDown(){
		if(playerY < 9){
			plane[playerX][playerY].select();
			playerY++;
			plane[playerX][playerY].select();
		}
	}
	
	private void moveChar(int fromX, int fromY, int toX, int toY){
		Character character = plane[fromX][fromY].getChar();
		if(character!=null){
			character.setTile(plane[toX][toY]);
			plane[fromX][fromY].setChar(null);
			plane[toX][toY].setChar(character);
		}
	}
	
	// ===========================Math Type Stuff==========================
	
	public void clearDistance(){
		for (int i = 0; i < plane.length; ++i) {
			for (int k = 0; k < plane[i].length; ++k) {
				plane[i][k].distance = 0;
			}
		}
	}
	
	public void setDistance(int x, int y){
		LinkedList<Tile> queue = new LinkedList<Tile>();
		plane[x][y].distance = -1;
		plane[x][y].path = plane[x][y];
        queue.add(plane[x][y]);
        Tile selected;
        while (queue.size() != 0)
        {
            selected = queue.poll();
            selected.visited = true;
            selected.distance = selected.path.distance+1;
            //south
            if(isOpenTile(selected.x,selected.y+1)){
            	plane[selected.x][selected.y+1].path = selected;
            	queue.add(plane[selected.x][selected.y+1]);
            }
            //east
            if(isOpenTile(selected.x+1,selected.y)){
            	plane[selected.x+1][selected.y].path = selected;
            	queue.add(plane[selected.x+1][selected.y]);
            }
            //north
            if(isOpenTile(selected.x,selected.y-1)){
            	plane[selected.x][selected.y-1].path = selected;
            	queue.add(plane[selected.x][selected.y-1]);
            }
            //west
            if(isOpenTile(selected.x-1,selected.y)){
            	plane[selected.x-1][selected.y].path = selected;
            	queue.add(plane[selected.x-1][selected.y]);
            }
        }
        for (int i = 0; i < plane.length; ++i) {
			for (int k = 0; k < plane[i].length; ++k) {
				plane[i][k].visited = false;
			}
		}
	}
	
	private boolean isOpenTile(int x, int y){
		if(x>=0 && x<10 && y>=0 && y< 10){
			if(!plane[x][y].visited && plane[x][y].type == Drawable.SPACE){
				return true;
			}
		}
		return false;
	}
	
	
	//===========================Overrides================================

	@Override
	public void draw(Graphics g) {
		for(int i = 0; i < plane.length; ++i){
			for(int k = 0; k < plane.length; ++k){
				plane[i][k].draw(g);
			}
		}
		if(showHold){
			g.drawString("Holding Char", 20, 20);
		}
	}

	@Override
	public void move(int x, int y) {}

	@Override
	public int getX() {return -1;}
	
	@Override
	public int getY() {return -1;}

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
