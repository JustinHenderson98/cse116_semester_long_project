package UI;  
  
import java.awt.Frame;  
import java.awt.Menu;  
import java.awt.MenuBar;  
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  

public class menuBar {  
    Frame myFrame;  
    MenuBar menubar;  
    Menu file,fractal,editSon1,editSon2,color;  
    MenuItem open,save,line,exit,  
    		 fra1,fra2,  
    		 secFra1,secFra2,  
                colorSch1,colorSch2;  
    public menuBar()  
    {  
        myFrame=new Frame("CSEisBOMB Menu");  
        myFrame.setBounds(400,400,300,300);  
          
        //添加关闭事件  
        myFrame.addWindowListener(new WindowAdapter()  
        {  
            public void windowClosing(WindowEvent e)  
            {  
                System.exit(0);  
            }  
        });  
        //初始菜单项  
        menubar=new MenuBar();  
        
        file=new Menu("File");  
        fractal=new Menu("Fractal");
        
        editSon1=new Menu("Fractal Items"); //second menu if needed
        
        color=new Menu("Color");  
        //editSon2=new Menu("Color Schemes"); second menu if needed   

        open=new MenuItem("open");  
        save=new MenuItem("save");  
        line=new MenuItem("-");  
        exit=new MenuItem("exit");
        
        exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
        });
        
        file.add(open);  
        file.add(save);  
        file.add(line);  
        file.add(exit);  
        menubar.add(file);  
        fra1=new MenuItem("Fractal 1");  
        fra2=new MenuItem("Fractal 2");  
        fractal.add(fra1);  
        fractal.add(fra2);
        
        secFra1=new MenuItem("Fractal 1");  
        secFra2=new MenuItem("Fractal 2");  
        editSon1.add(secFra1);  
        editSon1.add(secFra2);  
        fractal.add(editSon1);
        
        menubar.add(fractal);  
        colorSch1=new MenuItem("color scheme 1");  
        colorSch2=new MenuItem("color scheme 2");  
        color.add(colorSch1);  
        color.add(colorSch2);  
        menubar.add(color);  
        //set menuBar  
        myFrame.setMenuBar(menubar);            
        myFrame.setVisible(true);  
    }  
    public static void main(String[] args)
    {  
        new menuBar();  
    }  
  
}