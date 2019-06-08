package View;

import javax.swing.*;


public class GUI_PlaySetting {

    String NOP[] = {"2","3","4"};   // num of player
    String NOH[] = {"2","3","4","5"}; // num of mal 
    String[] PSValue = new String[2];
    boolean turnoff=true;

 
    JComboBox<String> YNP;
    JComboBox<String> YNH;

    public GUI_PlaySetting() {


        YNP = new JComboBox<String>(NOP); //creat choose combobox
        YNH = new JComboBox<String>(NOH); //creat choosecombobox
        
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel(" Person :")); // add current player information label
        myPanel.add(YNP);

        //myPanel.add(Box.createHorizontalStrut(10)); // a spacer

        myPanel.add(new JLabel(" Horse :")); // add current horse information label
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
