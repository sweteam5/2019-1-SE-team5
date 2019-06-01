package View;

import javax.swing.*;


public class GUI_PlaySetting {

    String NOP[] = {"2","3","4"};
    String NOH[] = {"2","3","4","5"};
    String[] PSValue = new String[2];
    boolean turnoff=true;

 
    JComboBox<String> YNP;
    JComboBox<String> YNH;

    public GUI_PlaySetting() {


        YNP = new JComboBox<String>(NOP);
        YNH = new JComboBox<String>(NOH);
        
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel(" Person :"));
        myPanel.add(YNP);

        //myPanel.add(Box.createHorizontalStrut(10)); // a spacer

        myPanel.add(new JLabel(" Horse :"));
        myPanel.add(YNH);
  
        int result = JOptionPane.showConfirmDialog(null, myPanel, 
                 "PlaySetting", JOptionPane.OK_CANCEL_OPTION);

       if (result == JOptionPane.OK_OPTION) {
           
           PSValue[0] = YNP.getSelectedItem().toString();
           PSValue[1] = YNH.getSelectedItem().toString(); 
           turnoff= false;    
        }
        else{
           turnoff=true;
           System.exit(0);
        }
    }

    public String[] get_settingValue(){
        return PSValue;
    }

    public boolean get_turnoff(){
        return turnoff;
    }
}