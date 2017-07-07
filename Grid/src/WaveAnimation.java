import java.awt.Color;
/**
 * A little program to show a wave of scaling and coloring
 * 
 * @author Benjamin Cross
 * @author Thomas Pianko
 * @version Sep 27, 2016
 */
public class WaveAnimation {
	public static void main(String[] args){
		DrawableObjectList objList = new DrawableObjectList();
		int windowX = 400;
		int windowY = 400;
        DrawingTablet tablet = new DrawingTablet("wave", windowX, windowY, objList);
        
        //For all of the circles to act orderly, we put them in a
        //two dimensional array
        Circle[][] circles = new Circle[5][5];
        for(int r = 0; r < circles.length; r++){
        	for(int c = 0; c < circles[r].length; c++){
        		circles[r][c] = new Circle(r*(80) + 40, c*(80) + 40, 20, Color.BLUE);
        		objList.addDrawable(circles[r][c]);//adding them to the objList to be drawn
        	}
		}
        
        tablet.repaint();
        int l = 1;
        while(l == 1){ //because who doesn't want an infinite loop of my animation?
        //increase scale wave
        for(int i = 0; i < 3; i++){
        	for(int r = 0; r < circles.length; r++){
        		for(int c = 0; c < circles[r].length; c++){
        			circles[c][r].scale(1.5);
        		}
        		//I was bored and wanted to play with random numbers and colors...
        		//What can I say, I was watching the debate at the time...
        		if(i == 0)
        			circles[(int) Math.round(Math.random()*4)][(int) Math.round(Math.random()*4)].setColor(Color.BLUE);
        		if(i == 1)
        			circles[(int) Math.round(Math.random()*4)][(int) Math.round(Math.random()*4)].setColor(Color.RED);
        		if(i == 2)
        			circles[(int) Math.round(Math.random()*4)][(int) Math.round(Math.random()*4)].setColor(Color.WHITE);
        		
        		tablet.repaint();
        		AnimationTimer.sleep(100);//making it a bit zippy looks better.
        	}
        }
        //decrease scale wave
        for(int i = 0; i < 3; i++){
        	for(int r = 0; r < circles.length; r++){
        		for(int c = 0; c < circles[r].length; c++){
        			circles[c][r].scale(0.66);
        		}
        		if(i == 0)
        			circles[(int) Math.round(Math.random()*4)][(int) Math.round(Math.random()*4)].setColor(Color.BLUE);
        		if(i == 1)
        			circles[(int) Math.round(Math.random()*4)][(int) Math.round(Math.random()*4)].setColor(Color.RED);
        		if(i == 2)
        			circles[(int) Math.round(Math.random()*4)][(int) Math.round(Math.random()*4)].setColor(Color.WHITE);

        		tablet.repaint();
        		AnimationTimer.sleep(100);
        	}
        }
        }
	}
}
