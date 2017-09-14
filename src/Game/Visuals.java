package Game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Visuals extends JPanel implements KeyListener{

	private static final long serialVersionUID = -4054101857266828615L;
	private int HEIGHT;
	private int WIDTH;
	
	GameStateManager gsm;

	public Visuals(int h, int w) {
		HEIGHT = h;
		WIDTH = w;
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		gsm =  new GameStateManager();
	}

	public void paint(Graphics g) {
		gsm.draw(g);
		g.dispose();
	}
	// ===========================Overrides================================
	public void actionPerformed(ActionEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			gsm.rightKey();
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			gsm.leftKey();
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			gsm.upKey();
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			gsm.downKey();
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			gsm.spaceKey();
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

}
