package Game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Visuals extends JPanel implements KeyListener, ActionListener {

	private boolean play;
	
	ArrayList<Drawable> layers;

	private Timer timer;
	private int delay = 8;

	private int HEIGHT;
	private int WIDTH;
	
	Plane plane;

	public Visuals(int h, int w) {
		HEIGHT = h;
		WIDTH = w;
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		play = false;
		timer = new Timer(delay, this);
		timer.start();
		
		
		
		
		layers = new ArrayList<Drawable>();
		plane = new Plane();
		layers.add(plane);
	}

	public void paint(Graphics g) {
		for(int i = 0; i < layers.size(); ++i){
			layers.get(i).draw(g);
		}
		g.dispose();
	}

	// ===========================Overrides================================
	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			plane.moveRight();
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			plane.moveLeft();
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			plane.moveUp();
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			plane.moveDown();
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

}
