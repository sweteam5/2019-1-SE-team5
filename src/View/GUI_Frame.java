import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.IOException;
import Model.*;


public class GUI_Frame extends Frame{		

	String[] PSValue = new String[2];
	Model model;
	GUI_YUTPAN YP;
	GUI_PlayPan PYP;

	public GUI_Frame(String[] PSValue,Model model ,boolean exit){
		this.model=model;
		this.PSValue = PSValue;
		if(exit==true){
			System.exit(0);
		}

		JFrame frame = new JFrame("SEPJ1");
		frame.setBounds(250,220,870,700);
		frame.setResizable(false);

		frame.setLayout(new BorderLayout(5,3));		

		this.YP = new GUI_YUTPAN(PSValue);
		this.PYP = new GUI_PlayPan(PSValue);
									
		frame.add(YP.get_yutPan(), BorderLayout.CENTER);
		frame.add(PYP.get_playpan(),BorderLayout.EAST);


		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);


	}		
}

