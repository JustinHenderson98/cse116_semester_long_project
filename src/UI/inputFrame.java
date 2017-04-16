package UI; 

import javax.swing.*;  
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;  
  
public class inputFrame extends JFrame{
	
    JList jlist;    
    JComboBox jcb;  
    JPanel jp1, jp2;    
    JLabel jlb1, jlb2;  
    JButton jb;
    JScrollPane jsp;    
    int n = 255; //1~255
    boolean f, ifNewInput;
    int escapetime;
      
    
    public inputFrame(userInterface ui){  
        jp1 = new JPanel(new GridLayout(2,1));  
        jp2 = new JPanel(new GridLayout(2,1));  
          
        jlb1 = new JLabel("Please Enter a value of escape time:");  
        String str[] = new String[n];
        for (int i = 0; i < n; i++)
        	str[i] = String.valueOf(i+1);
        jcb = new JComboBox(str);  
        jcb.setEditable(true);          
        jp1.add(jlb1);  
        jp1.add(jcb);  
          
        jb = new JButton("OK");
        jlb2 = new JLabel("Press OK after entering/selecting");
        
        jp2.add(jlb2);
        jp2.add(jb);
        this.add(jp1);  
        this.add(jp2);  
        
        jb.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent arg0) 
            {
                new Thread(new Runnable(){
 
                    @Override
                    public void run() {
                    	String msg = (String) jcb.getSelectedItem();
        				Matcher mer;
        				mer = Pattern.compile("^[+-]?[0-9]+$").matcher(msg); 
        				if (f = mer.find()) escapetime = Integer.valueOf(msg);
        				if ( (!f) || ((escapetime < 0) || (escapetime > 255)) ) {
        					JOptionPane.showMessageDialog(null, "Input must be a positive integer and no more than 255. Press OK to re-enter.");
        				}
        				else {
        					ui.getModel().SetMaxEscapeTime(escapetime);
        					String jlbs = "Passing Escape time";
        					jlb2.setText(jlbs);
        					for (int i = 0; i < 6; i++) {
        						try {   
        							Thread.currentThread().sleep(1000);//ms  
        						} catch(Exception e){}
        						ui.update();
        						jlbs = jlbs + ".";
        						jlb2.setText(jlbs);
        					}
        					try {   
        						Thread.currentThread().sleep(2000);//ms  
        					} catch(Exception e){}
        					jlb2.setText("Passing successful!");
        					try {   
        						Thread.currentThread().sleep(2000);//ms  
        					} catch(Exception e){}
        					jlb2.setText("This window will close soon.");
        					try {   
        						Thread.currentThread().sleep(2000);//ms  
        					} catch(Exception e){}
        					setVisible(false);
                    }
                }
                     
                }).start();
            }
        });
        
        this.setLayout(new GridLayout(2, 1));  

          
        this.setSize(300,200);  
        this.setTitle("Input Escape time");  
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);  
    }  
      
  
} 