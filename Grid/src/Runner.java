
public class Runner {
	public static void main(String[] args){
		Plane model = new Plane();
		int windowX = 400;
		int windowY = 400;
		GUI gui = new GUI(model, "Grid", windowX, windowY);
		gui.repaint();
	}
}
