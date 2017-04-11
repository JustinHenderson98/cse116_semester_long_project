package UI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private FractalPanel _display;
	private colorModels _colorModel;
	private Point topLeft = new Point(0,0);
	private Point bottomRight = new Point(0,0);
	private JLabel zoomCoordinates;
	private JLabel zoomCoordinates1;

	private JLabel mouseCoordinate;
	
	public userInterface() {
		_colorModel = new colorModels(this);
		_model = new generateFractal(this);
		_menu = new menuBar(this);
		_display = new FractalPanel();
		_globalPanel = new JPanel();
		_textBoxes = new JPanel();
		_textBoxes.setLayout(new BoxLayout(_textBoxes, BoxLayout.PAGE_AXIS) );
		zoomCoordinates = new JLabel();
		zoomCoordinates1 = new JLabel();
		mouseCoordinate = new JLabel();
		zoomCoordinates.setText("Zoom Top Left : (" + topLeft.getX() + "," + topLeft.getY()+ ")     Top Right: (" + bottomRight.getX() + "," + topLeft.getY());
		zoomCoordinates1.setText(" Bottom Left : (" + topLeft.getX() + "," + bottomRight.getY()+ ")  Bottom Right: (" + bottomRight.getX() + "," + bottomRight.getY());

		_textBoxes.add(zoomCoordinates);
		_textBoxes.add(zoomCoordinates1);
		_textBoxes.add(mouseCoordinate);

		_globalPanel.setLayout(new GridLayout(2,1));
		_frame = new JFrame("CSE116IsBomb_B1");
		_frame.setMenuBar(_menu.getMenuBar());
		_globalPanel.add(_display);
		_globalPanel.add(_textBoxes);
		_globalPanel.addMouseListener(this);
		_globalPanel.addMouseMotionListener(this);
		
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
	
	public static void main(String[] args) {  
		userInterface ui = new userInterface();  
  
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
		topLeft = e.getPoint();

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		bottomRight = e.getPoint();
		_model.setZoomBR(bottomRight);
		_model.setZoomTL(topLeft);
		_model.coordinateToZoom();
		System.out.println("updating");
		update();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		bottomRight= e.getPoint();
		mouseCoordinate.setText("X: " + e.getX() +"  Y: " + e.getY());

		zoomCoordinates.setText("Zoom Top Left : (" + topLeft.getX() + "," + topLeft.getY()+ ")  Top Right: (" + bottomRight.getX() + "," + topLeft.getY());
		zoomCoordinates1.setText(" Bottom Left : (" + topLeft.getX() + "," + bottomRight.getY()+ ")  Bottom Right: (" + bottomRight.getX() + "," + bottomRight.getY());

	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		

		mouseCoordinate.setText("X: " + e.getX() +"  Y: " + e.getY());
	}
}