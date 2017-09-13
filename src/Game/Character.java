package Game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Character implements Drawable{

	BufferedImage image;
	Tile tile;
	public int speed = 10;
	
	public Character(Tile tile){
		String file = "src/Resources/char.png";
		this.tile = tile;
		try{
			image = ImageIO.read(
					new File(file));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setTile(Tile tile){
		this.tile = tile;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, tile.x*50, tile.y*50, null);
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getXY() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setType(int type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVisisble(boolean visible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
}
