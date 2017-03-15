package UI;  
  
import java.awt.Frame;  
import java.awt.Menu;  
import java.awt.MenuBar;  
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import code.colorModels;  

public class menuBar {  
    Frame myFrame;  
    MenuBar menubar;  
    Menu file, fractal, editSon1, editSon2, color;  
    MenuItem open, save, input, line, exit,  
    		 fra1, fra2,  
    		 secFra1, secFra2,  
             colorSch1, colorSch2;  
    MenuItem[] fra;
    MenuItem[] colorSch;
    private int nf = 4; // # of Fractals
    private int nc = 4; // # of Color schemes
    private userInterface _ui;
    public menuBar(userInterface ui)  
    {  
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
        input = new MenuItem("input");
        line = new MenuItem("-");  
        exit = new MenuItem("exit");
        
        input.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int value = 0;
				Matcher mer;
				String msg = JOptionPane.showInputDialog("Please Enter a value of escape distance:");
		
				if(msg == null){
					return;
				}
				
				mer = Pattern.compile("^[+-]?[0-9]+$").matcher(msg);
				//return true is msg is an integer
				//the above two lines used to determine if the input string is an integer
				//using regular expression
				
				if (mer.find()) value = Integer.valueOf(msg);

				while ( (!mer.find()) || ((value < 0) && (value > 32767)) )  {
					JOptionPane.showMessageDialog(null, "Input should be an integer and no more than 32767. Press OK to re-enter.");
					msg = JOptionPane.showInputDialog("Please Enter a valid value of escape distance:");
					if(msg == null){
						return;
					}
					mer = Pattern.compile("^[+-]?[0-9]+$").matcher(msg);
					if (mer.find()) value = Integer.valueOf(msg);;
				}
				
				_ui._model.set_escapeDistance(value);
				_ui.update();
				
				
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
        file.add(input);
        file.add(line);  
        file.add(exit);  
        menubar.add(file);
        
        
        for (int i = 0; i < nf; i++) {
        	String s =  "Fractal " + String.valueOf(i+1);
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
    
    public MenuBar getMenuBar() {
    	return menubar;
    }
    
    // parameter myMenuItem: menu item need to add ActionListener
    // parameter index: add the index-th condition
    // parameter x: x<0 means fractal, x>=0 means color scheme
    public void shiftFraOrColor(MenuItem myMenuItem, int index, int x) {
    	myMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				if (x < 0) {
					_ui._model.set__fractalType(index + 1);
					_ui.update();
				}
				else {
					//colorModels cM = new colorModels();
					_ui._colorModel.setColorModel(index);
					//cM.setColorModel(index);
					_ui.update();
					
				}
			}
        });
    }
  
}