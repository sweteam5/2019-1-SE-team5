package View;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.IOException;
import Model.*;


public class GUI_Frame extends Frame{		

	String[] PSValue = new String[2];
	Model model;
	public GUI_YUTPAN YP;
	public GUI_PlayPan PYP;
	private JFrame frame;

	public GUI_Frame(String[] PSValue,Model model ,boolean exit){
		this.model=model;
		this.PSValue = PSValue;
		if(exit==true){
			System.exit(0);
		}

		frame = new JFrame("SEPJ1 - YUTGAME");   // Create View Main_frame
		frame.setBounds(250,220,870,700);	// set size & margins
		frame.setResizable(false);		// resize == false

		frame.setLayout(new BorderLayout(0,0));	  // use border layout to assign

		this.YP = new GUI_YUTPAN(PSValue);	 // get start setting value 
		this.PYP = new GUI_PlayPan(PSValue);	 // get start setting value 
									
		frame.add(YP.get_yutPan(), BorderLayout.CENTER);	// add yutpanel to frame
		frame.add(PYP.get_playpan(),BorderLayout.EAST);		// add playpanel to frame


		frame.getContentPane().setBackground(Color.WHITE);	// set background white
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// exit on close
		frame.setResizable(false);	// resize == false
		frame.setVisible(true);		// Visible == flase
	}	
	
	public void close() {
		frame.setVisible(false); // if restart game, set visible to 'false' for previous frame
	}
}

