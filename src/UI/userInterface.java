package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import code.colorModels;
import code.generateFractal;
import code.mainModel;
import edu.buffalo.fractal.FractalPanel;

/**
 * displays the menubar and the fractal image
 * 
 * @author Justin Henderson
 * @author Kunku Wu
 * @author Ethan Gagne
 * @author Ben Conomos
 *
 */
public class userInterface implements MouseMotionListener, MouseListener {
	private JFrame _frame;
	private mainModel _model;
	private menuBar _menu;
	private JPanel _textBoxes;
	private JPanel _globalPanel;
	private JLayeredPane _holder;
	private JPanel _draw;
	private FractalPanel _display;
	private colorModels _colorModel;
	private int top, bottom, left, right =0;
	private Point originalP;
	private Point currentP;
	private JLabel zoomCoordinates;
	private JLabel zoomCoordinates1;

	private JLabel mouseCoordinate;
	
	/**
	 * instantiates the gui. 
	 */
	public userInterface() {
		_colorModel = new colorModels(this);
		_menu = new menuBar(this);
		_display = new FractalPanel();
		_model = new mainModel(this,4);
		_display.setLayout(new BoxLayout(_display, BoxLayout.X_AXIS));
		_globalPanel = new JPanel();
		_holder = new JLayeredPane();
		_draw = new paint();
		_draw.setLayout(new BoxLayout(_draw, BoxLayout.X_AXIS));
		_draw.setOpaque(false);
		_draw.setSize(1024, 1024);
		_display.setSize(new Dimension(1024,1024));
		_display.setDebugGraphicsOptions(2);
		_holder.add(_draw, new Integer(2));
		_holder.add(_display,  new Integer(1));
		_holder.setPreferredSize(new Dimension(1024, 1024));
		_textBoxes = new JPanel();
		_textBoxes.setLayout(new BoxLayout(_textBoxes, BoxLayout.PAGE_AXIS) );
		zoomCoordinates = new JLabel();
		zoomCoordinates1 = new JLabel();
		mouseCoordinate = new JLabel();
		zoomCoordinates.setText("Zoom Top Left : (" + left + "," + top+ ")  Top Right: (" + right + "," + top + ")");
		zoomCoordinates1.setText(" Bottom Left : (" + left + "," + bottom+ ")  Bottom Right: (" + right + "," + bottom + ")");
		_textBoxes.add(zoomCoordinates);
		_textBoxes.add(zoomCoordinates1);
		_textBoxes.add(mouseCoordinate);

		_globalPanel.setLayout(new BoxLayout(_globalPanel, BoxLayout.PAGE_AXIS));
		_frame = new JFrame("CSE116IsBomb_B1");
		_frame.setMenuBar(_menu.getMenuBar());
		_globalPanel.add(_holder);
		_globalPanel.add(_textBoxes);
		_display.addMouseListener(this);
		_display.addMouseMotionListener(this);
		
		_frame.add(_globalPanel);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		init();
		_frame.setVisible(true);
		
	}
	/**
	 * Keeps the current fractal, changes the color, and updates the image.
	 */
	public void updateColor() {
		_display.setIndexColorModel(_colorModel.getColorModel());
		//_display.updateImage(_model.getFractal());
		_model.get_pool().clearPool();
		_model.update();
	}
	
	/**
	 * Generates a new fractal and updates the image.
	 */
	public void update(){
		_display.setIndexColorModel(_colorModel.getColorModel());
		//_display.updateImage(_model.genFractal());
		if(_model.get_pool() != null){
		_model.get_pool().clearPool();
		}
		_model.update();
	}
	
	/**
	 * Generates a mandlebrot fractal then updates the image.
	 */
	public void init(){
		_model.getFractalClass().set__fractalType(1);
		update();
	}
	/**
	 * Returns the colorModels
	 * @return the current colorModels object
	 */
	public colorModels getColorModel() {
		return _colorModel;
	}
	/**
	 * Returns the model
	 * @return the current generateFractal object
	 */
	public mainModel getModel() {
		return _model;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * creates a starting point for the zoom.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		originalP = e.getPoint();
	}
	
	/**
	 * creates two points for the bottom-right and the top-left of the zoom area using variables top, left, bottom, right.
	 * assigns these points to the model.
	 * updates the start and end positions for x and y.
	 * resets top, left, right, bottom.
	 * resets the rectangle.
	 * and updates the fractal using the new coordinates.
	 * 
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//bottomRight = e.getPoint();
		Point br = new Point(bottom,right);
		Point tl = new Point(top, left);
		_model.getFractalClass().setZoomBR(br);
		_model.getFractalClass().setZoomTL(tl);
		_model.getFractalClass().coordinateToZoom();
		top = 0;
		bottom = 0;
		left = 0;
		right = 0;
		_draw.repaint();
		System.out.println("updating");
		update();
	}
	/**
	 * updates currentP using current mouse coordinates.
	 * dynamically reassigns the values for top, left, bottom, right.
	 * repaints the zoom rectangle 
	 * outputs the current coordinates to the JLabels 			
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		currentP = e.getPoint();
		top = (int) Math.min(currentP.getY(), originalP.getY());
		bottom = (int) Math.max(currentP.getY(), originalP.getY());
		left = (int) Math.min(currentP.getX(), originalP.getX());
		right = (int) Math.max(currentP.getX(), originalP.getX());
		_draw.setVisible(true);
		_draw.repaint();
		
		mouseCoordinate.setText("X: " + e.getX() +"  Y: " + e.getY());

		zoomCoordinates.setText("Zoom Top Left : (" + left + "," + top+ ")  Top Right: (" + right + "," + top + ")");
		zoomCoordinates1.setText(" Bottom Left : (" + left + "," + bottom+ ")  Bottom Right: (" + right + "," + bottom + ")");

	}
	
	/**
	 * updates the JLabels showing the current mouse position.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseCoordinate.setText("X: " + e.getX() +"  Y: " + e.getY());
	}
	
	/**
	 * JPanel that clears itself then draws a rectangle using left, top, bottom, right. 
	 * @author Justin Henderson
	 *
	 */
	private class paint extends JPanel{
		@Override public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawRect(left, top, right - left, bottom- top);
		}
	}
	
	/**
	 * 
	 * @return the _colorModel instance variable.
	 */
	public colorModels getColorModels() {
		return _colorModel;
	}
	
	/**
	 * Resests the current fractal to it's default starting values.
	 */
	public void reset() {
		System.out.println("reseting");
		_model.getFractalClass().resetZoom();
		update();
		System.out.println("reseting finish");
	}
	
	public FractalPanel getFractalPanel(){
		return _display;
	}
	
}