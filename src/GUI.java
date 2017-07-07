import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GUI extends JFrame{
	Plane model;
	public GUI(Plane model){
		super("GUI");
		this.model = model;
		
	}
}