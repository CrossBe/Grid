package Game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.imageio.ImageIO;

public class Character implements Drawable, ImageObserver{

	BufferedImage image;
	public Character(){
		String file = "";
		try{
			image = ImageIO.read(
					getClass().getResourceAsStream(file));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, 0, 0, this);
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

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return true;
	}

}
