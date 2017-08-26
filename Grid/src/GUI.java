import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI{
	private DrawingCanvas canvas;
    private JFrame myFrame;
    

    public GUI(Plane model, String title, int windowX, int windowY) {
    	myFrame = new JFrame(title);
        canvas = new DrawingCanvas(windowX, windowY, model);

        Container thePane = myFrame.getContentPane();
        thePane.add(canvas, BorderLayout.CENTER);

        // Handle closing the window.
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.setResizable(false);
        myFrame.pack();
        myFrame.setLocation(100, 100);

        myFrame.setVisible(true);	}
	/**
     * Cause all of the model in the Plane to be repainted. This
     * will allow changes to the model or to the Plane to be
     * reflected in the window.
     */
    public void repaint() {
        canvas.repaint();
    }
    /*
     * This is the component on which the model are actually painted.
     */
    class DrawingCanvas extends JPanel {

        private int width;
        private int height;
        private Plane model;

        /**
         * Construct a new DrawingCanvas with the specified width and height.
         * 
         * @param width the width of the new DrawingCanvas.
         * @param height the height of the new DrawingCanvas.
         */
        public DrawingCanvas(int width, int height, Plane model) {
            this.width = width;
            this.height = height;
            this.model = model;
        }

        /**
         * Return the width and height of this DrawingCanvas as its preferred,
         * minimum and maximum sizes.
         * 
         * @return a new Dimension object specifying the width and height of
         *         this DrawingCanvas.
         */
        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }

        /**
         * Return the width and height of this DrawingCanvas as its preferred,
         * minimum and maximum sizes.
         * 
         * @return a new Dimension object specifying the width and height of
         *         this DrawingCanvas.
         */
        public Dimension getMinimumSize() {
            return new Dimension(width, height);
        }

        /**
         * Return the width and height of this DrawingCanvas as its preferred,
         * minimum and maximum sizes.
         * 
         * @return a new Dimension object specifying the width and height of
         *         this DrawingCanvas.
         */
        public Dimension getMaximumSize() {
            return new Dimension(width, height);
        }

        /**
         * Paint all of the model onto the specified graphics context.
         * 
         * @param g the graphics context onto which the model are to be drawn.
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            model.drawAll(g);
        }
    }
}