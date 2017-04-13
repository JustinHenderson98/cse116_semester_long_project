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
	private generateFractal _model;
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
	
	public userInterface() {
		_colorModel = new colorModels(this);
		_model = new generateFractal(this);
		_menu = new menuBar(this);
		_display = new FractalPanel();
		_display.setLayout(new BoxLayout(_display, BoxLayout.X_AXIS));
		_globalPanel = new JPanel();
		_holder = new JLayeredPane();
		_draw = new paint();
		_draw.setLayout(new BoxLayout(_draw, BoxLayout.X_AXIS));
		_draw.setOpaque(false);
		_holder.add(_draw, new Integer(2));
		_holder.add(_display,  new Integer(1));
		_holder.setPreferredSize(new Dimension(512, 512));
		_draw.setSize(new Dimension(512, 512));
		_display.setSize(new Dimension(512, 512));
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

		//_globalPanel.setLayout(new GridLayout(2,1));
		_globalPanel.setLayout(new BoxLayout(_globalPanel, BoxLayout.PAGE_AXIS));
		_frame = new JFrame("CSE116IsBomb_B1");
		_frame.setMenuBar(_menu.getMenuBar());
		_globalPanel.add(_holder);
		_globalPanel.add(_textBoxes);
		_globalPanel.addMouseListener(this);
		_globalPanel.addMouseMotionListener(this);
		//_display.addMouseListener(this);
		//_display.addMouseMotionListener(this);
		
		_frame.add(_globalPanel);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.pack();
		_frame.setVisible(true);
		init();
	}
	/**
	 * generates a new fractal and updates the image
	 */
	public void updateColor() {
		_display.setIndexColorModel(_colorModel.getColorModel());
		_display.updateImage(_model.getFractalHolder());
	}
	public void update(){
		_display.setIndexColorModel(_colorModel.getColorModel());
		_display.updateImage(_model.genFractal());
	}
	public void init(){
		
		_model.set__fractalType(1);
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
	public generateFractal getModel() {
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
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		originalP = e.getPoint();
		top = e.getY();
		left = e.getX();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//bottomRight = e.getPoint();
		Point br = new Point(bottom,right);
		Point tl = new Point(top, left);
		_model.setZoomBR(br);
		_model.setZoomTL(tl);
		_model.coordinateToZoom();
		top = 0;
		bottom = 0;
		left = 0;
		right = 0;
		_draw.repaint();
		System.out.println("updating");
		update();
	}
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
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		

		mouseCoordinate.setText("X: " + e.getX() +"  Y: " + e.getY());
	}
	private class paint extends JPanel{
		@Override public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawRect(left, top, right - left, bottom- top);
		}
	}
	public colorModels getColorModels() {
		return _colorModel;
	}
	
	public void reset() {
		System.out.println("reseting");
		_model.resetZoom();
		System.out.println("reseting finish");
	}
	
	
	
}