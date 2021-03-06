package Game;
import javax.swing.JFrame;

public class Main {

	public static final int HEIGHT = 500, WIDTH = 500;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Visuals visuals = new Visuals(HEIGHT, WIDTH);
		
		frame.setBounds(10, 10, HEIGHT, WIDTH);
		frame.setTitle("GRID");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(visuals);
		
		frame.pack();
	}
}
