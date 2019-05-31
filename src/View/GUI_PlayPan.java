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

    
    private ImageIcon doo = new ImageIcon("C:/Users/Purung/Desktop/SEP/img/doo.png");
    private ImageIcon gae = new ImageIcon("C:/Users/Purung/Desktop/SEP/img/gae.png");
    private ImageIcon girl = new ImageIcon("C:/Users/Purung/Desktop/SEP/img/girl.png");
    private ImageIcon yut = new ImageIcon("C:/Users/Purung/Desktop/SEP/img/yut2.png");
    private ImageIcon mo = new ImageIcon("C:/Users/Purung/Desktop/SEP/img/mo.png");
    private ImageIcon bk = new ImageIcon("C:/Users/Purung/Desktop/SEP/img/bk.png");

    private String[] setYutbtn = {"빽도", "도", "개", "걸", "윷","모"};

    private Image fimg, bimg;
    public int distance;
   

    

    public GUI_PlayPan(String[] PSValue) {
        this.PSValue = PSValue;
         
        label_inform = new JLabel(" 설정된 참여자   :   " + PSValue[0] + "  설정된 말 개수   :   " + PSValue[1]);
        txtLog.setEditable(false);
        // scrollPane.setPreferredSize(new Dimension(0,0));

        ButtonPan Vpanel = new ButtonPan();
        ButtonPan Bpanel = new ButtonPan();
        ButtonPan Cpanel = new ButtonPan();

        ButtonPan lspanel = new ButtonPan();

        lspanel.setLayout(new BorderLayout());
        lspanel.add(label_inform, BorderLayout.NORTH);
        lspanel.add(scrollPane, BorderLayout.CENTER);

        Vpanel.setLayout(new GridLayout(1, 1));

        Vpanel.add(btn_yut[0] = new JButton(""));
        btn_yut[0].setPreferredSize(new Dimension(300,244));
        btn_yut[0].setIcon(doo);

        Bpanel.setLayout(new GridLayout(1, 2));

        Bpanel.add(btn_play[0] = new JButton("랜덤 던지기"));
        btn_play[0].setPreferredSize(new Dimension(100,100));

        Bpanel.add(btn_play[1] = new JButton("지정 던지기"));

        Cpanel.setLayout(new BorderLayout());
        Cpanel.add(Vpanel, BorderLayout.CENTER);
        Cpanel.add(Bpanel, BorderLayout.SOUTH);

        /*
         * panelP.setLayout(new BorderLayout()); panelP.add(lspanel,BorderLayout.NORTH);
         * panelP.add(Cpanel,BorderLayout.SOUTH);
         */

        panelP.setLayout(new GridLayout(2, 1, 1, 1));
        panelP.add(lspanel);
        panelP.add(Cpanel);
    }

    private class ButtonPan extends JPanel {

    }

    public JPanel get_playpan() {
        return panelP;
    }

    public void randomYut(int distance){

        if(distance==1){
          btn_yut[0].setIcon(doo);
          txtLog.append("Random : 도\n");
        }
        else if(distance==2){
          btn_yut[0].setIcon(gae);
          txtLog.append("Random : 개\n");
        }
        else if(distance==3){
          btn_yut[0].setIcon(girl);
          txtLog.append("Random : 걸\n");
        }
        else if(distance==4){
          btn_yut[0].setIcon(yut);
          txtLog.append("Random : 윷\n");
        }
        else if(distance==0){
          btn_yut[0].setIcon(mo);
          txtLog.append("Random : 모\n");
        }
        else{
          btn_yut[0].setIcon(bk);
          txtLog.append("Random : 빽도\n");
        }

    }

    public void chosenYut(int distance){

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
}