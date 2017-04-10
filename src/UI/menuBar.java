package UI;  
  
import java.awt.Frame;  
import java.awt.Menu;  
import java.awt.MenuBar;  
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
 

/**
 * This class is used to hold the menubar and it's action listeners
 * 
 * @author Justin Henderson
 * @author Kunku Wu
 * @author Ethan Gagne
 * @author Ben Conomos
 *
 */
public class menuBar { 
	//private int n = 4;
    Frame myFrame;  
    MenuBar menubar;  
    Menu file, fractal, editSon1, editSon2, color;  
    MenuItem open, save, inputEscapeTime, inputEscapeDis, line, exit,  
    		 fra1, fra2,  
    		 secFra1, secFra2,  
             colorSch1, colorSch2;  
    MenuItem[] fra;
    MenuItem[] colorSch;
    private int nf = 4; // # of Fractals
    private int nc = 4; // # of Color schemes
    String[] fractalName = new String[nf];
    private userInterface _ui;
    
    /**
     * generates the menubar which contains fractal selection, fractal color,
     * escape distance changes, and the option to exit
     * @param ui
     * 			the linked UI object
     */
    public menuBar(userInterface ui)  
    {  
    	fractalName[0] = "Mandelbrot Set";
    	fractalName[1] = "Julia Set";
    	fractalName[2] = "Burning Ship Set";
    	fractalName[3] = "Multibrot Set";
    	_ui = ui;
    	fra = new MenuItem[nf];
    	colorSch = new MenuItem[nc];
    	
        menubar = new MenuBar();  
        
        file = new Menu("File");  
        fractal = new Menu("Fractal");
        
//        editSon1=new Menu("Fractal Items"); //second menu if needed
        
        color = new Menu("Color");  

        open = new MenuItem("open");  
        save = new MenuItem("save");
        inputEscapeDis = new MenuItem("input escape distance");
        inputEscapeTime = new MenuItem("max escape time");
        line = new MenuItem("-");  
        exit = new MenuItem("exit");
        
        inputEscapeDis.addActionListener(new ActionListener() {
        	@Override
			public void actionPerformed(ActionEvent arg0) {				
				
				int value = 0;
				Matcher mer;
				String msg = JOptionPane.showInputDialog("Please Enter a value of escape distance:");
				boolean f = false;
				
				if(msg == null){
					return;
				}
				
				mer = Pattern.compile("^[+-]?[0-9]+$").matcher(msg);
				//return true is msg is an integer
				//the above two lines used to determine if the input string is an integer
				//using regular expression
				
				
				if (f = mer.find()) value = Integer.valueOf(msg);
						
				while ( (!f) || ((value < 0) || (value > 32767)) )  {
					JOptionPane.showMessageDialog(null, "Input should be a positive integer and no more than 32767. Press OK to re-enter.");
					msg = JOptionPane.showInputDialog("Please Enter a valid value of escape distance:");
					if(msg == null){
						return;
					}
					mer = Pattern.compile("^[+-]?[0-9]+$").matcher(msg);
					if (f = mer.find()) value = Integer.valueOf(msg);;
				}
				
				_ui.getModel().set_escapeDistance(value);
				//_ui.update();
				
				
			}
        });
        inputEscapeTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inputFrame _inputFrame = new inputFrame(_ui);				
			}
        });
        
        exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
        });
        
        file.add(open);  
        file.add(save);
        file.add(inputEscapeTime);
        file.add(inputEscapeDis);
        file.add(line);  
        file.add(exit);  
        menubar.add(file);
        
        
        for (int i = 0; i < nf; i++) {
        	String s =  fractalName[i];
        	fra[i] = new MenuItem(s);
        	shiftFraOrColor(fra[i], i, -1);
        	fractal.add(fra[i]);
        }
        menubar.add(fractal);
        
        for (int i = 0; i < nc; i++) {
        	String s =  "color scheme " + String.valueOf(i+1);
        	colorSch[i] = new MenuItem(s);
        	shiftFraOrColor(colorSch[i], i + 1, 1);
        	color.add(colorSch[i]);
        }
        menubar.add(color);
         
    } 
    
    /**
     * 
     * @return the menubar object created by the class
     */
    public MenuBar getMenuBar() {
    	return menubar;
    }
    
    /**
     * 
     * @param myMenuItem: menu item need to add ActionListener
     * @param index: add the index-th condition
     * @param x: x<0 means fractal, x>=0 means color scheme
     */
    public void shiftFraOrColor(MenuItem myMenuItem,final int index, final int x) {
    	myMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				if (x < 0) {
					_ui.getModel().set__fractalType(index + 1);
					//_ui.update();
				}
				else {
					//colorModels cM = new colorModels();
					_ui.getColorModel().setColorModel(index);
					//cM.setColorModel(index);
					//_ui.update();
					
				}
			}
        });
    }
  
}