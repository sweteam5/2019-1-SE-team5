package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI_PlayPan extends JPanel implements ActionListener {

    private String[] PSValue = new String[2];

    private JPanel panelP = new JPanel();
    private JLabel label_inform;

    private JTextArea txtLog = new JTextArea(15, 10);
    private JScrollPane scrollPane = new JScrollPane(txtLog);

    private JButton[] btn_yut = new JButton[4];
    public JButton[] btn_play = new JButton[2];

    
    private ImageIcon doo = new ImageIcon("./img/doo.png");
    private ImageIcon gae = new ImageIcon("./img/gae.png");
    private ImageIcon girl = new ImageIcon("./img/girl.png");
    private ImageIcon yut = new ImageIcon("./img/yut2.png");
    private ImageIcon mo = new ImageIcon("./img/mo.png");
    private ImageIcon bk = new ImageIcon("./img/bk.png");

    private String[] setYutbtn = {"빽도", "도", "개", "걸", "윷","모"};
    public int distance;
   
    public GUI_PlayPan(String[] PSValue) {
        this.PSValue = PSValue;
         
        label_inform = new JLabel(" 설정된 참여자   :   " + PSValue[0] + "  설정된 말 개수   :   " + PSValue[1]);
        txtLog.setEditable(false);  //edit == false
        txtLog.setFocusable(false); // focusing == false

        ButtonPan Vpanel = new ButtonPan();  // creat button jpanel 1
        ButtonPan Bpanel = new ButtonPan();  // creat button jpanel 2
        ButtonPan Cpanel = new ButtonPan();  // creat button jpanel 3

        ButtonPan lspanel = new ButtonPan();  // creat button jpanel 4

        lspanel.setLayout(new BorderLayout());  // set layout == border
        lspanel.add(label_inform, BorderLayout.NORTH); // label add to panel [north]
        lspanel.add(scrollPane, BorderLayout.CENTER);   // text area add to panel [center]

        Vpanel.setLayout(new GridLayout(1, 1)); //set gridlayout with no margin

        Vpanel.add(btn_yut[0] = new JButton(""));   // create image yut button to markup result 
        btn_yut[0].setPreferredSize(new Dimension(300,244)); 
        btn_yut[0].setIcon(doo); // set image icon
        btn_yut[0].setPreferredSize(new Dimension(300,270)); 
        btn_yut[0].setText(null); // text set == false
        btn_yut[0].setBorderPainted(false); // border sett == false
        btn_yut[0].setContentAreaFilled(false); // transparent content

        Bpanel.setLayout(new GridLayout(1, 2)); //set grid lyout to assign

        Bpanel.add(btn_play[0] = new JButton("랜덤 던지기")); // create random yut button
        btn_play[0].setPreferredSize(new Dimension(100,100)); // set size

        Bpanel.add(btn_play[1] = new JButton("지정 던지기")); // create set yut button

        Cpanel.setLayout(new BorderLayout()); // create Cpanel to add V&B panel
        Cpanel.add(Vpanel, BorderLayout.CENTER); // set Vpanel to Center
        Cpanel.add(Bpanel, BorderLayout.SOUTH);  // set Bpanel to South

        panelP.setLayout(new GridLayout(2, 1));  // Set gridlayout to assign V&B panel
        panelP.add(lspanel); // add panel
        panelP.add(Cpanel);  // add panel
    }

    private class ButtonPan extends JPanel {
        // Button Panel Class
    }

    public JPanel get_playpan() {
        return panelP; //get main panel
    }

    public void randomYut(int distance){
        // Random yut value to Set Icon 
        if(distance==1){    
          btn_yut[0].setIcon(doo);   // Result of YUT == 1 , then set icon doo
          txtLog.append("Random : 도\n");
        }
        else if(distance==2){
          btn_yut[0].setIcon(gae);  // Result of YUT == 2 , then set icon gae
          txtLog.append("Random : 개\n");
        }
        else if(distance==3){
          btn_yut[0].setIcon(girl);   // Result of YUT == 3 , then set icon girl
          txtLog.append("Random : 걸\n");
        }
        else if(distance==4){
          btn_yut[0].setIcon(yut);    // Result of YUT == 4 , then set icon yut
          txtLog.append("Random : 윷\n");
        }
        else if(distance==5){
          btn_yut[0].setIcon(mo);     // Result of YUT == 2 , then set icon mo
          txtLog.append("Random : 모\n");
        }
        else{
          btn_yut[0].setIcon(bk);      // Result of YUT == else , then set icon gae
          txtLog.append("Random : 빽도\n");
        }

    }

    public void chosenYut(int distance){
         // setted yut value to Set Icon 
      if(distance==1){
        btn_yut[0].setIcon(doo);
        txtLog.append("Set : 도\n");
      }
      else if(distance==2){
        btn_yut[0].setIcon(gae);
        txtLog.append("Set : 개\n");
      }
      else if(distance==3){
        btn_yut[0].setIcon(girl);
        txtLog.append("Set : 걸\n");
      }
      else if(distance==4){
        btn_yut[0].setIcon(yut);
        txtLog.append("Set : 윷\n");
      }
      else if(distance==5){
        btn_yut[0].setIcon(mo);
        txtLog.append("Set : 모\n");
      }
      else{
        btn_yut[0].setIcon(bk);
        txtLog.append("Set : 빽도\n");
      }

  }

    // public void whoturn(){
    //     txtlog.append("Player turn : "+model.whoTurn()+"/n");
    // }
    public int chooseYut(){
      int Count = JOptionPane.showOptionDialog(null, "던질 윷을 설정하세요 ! .", "지정 윷 던지기.",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, setYutbtn, "두 번째값");
      return Count;
    }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
