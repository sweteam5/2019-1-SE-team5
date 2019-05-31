import Model.*;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Controller implements ActionListener {

    GUI_Frame GUI;
    int distance;
    Model model;

    public Controller() {
        
    }

    public void init() {
        GUI_PlaySetting PS = new GUI_PlaySetting();
        this.model = new Model(PS.get_settingValue());
        // model에게 플레이수, 말 수 전달
        this.GUI = new GUI_Frame(PS.get_settingValue(), model, PS.get_turnoff());
        // 게임판 생성
        this.GUI.PYP.btn_play[0].addActionListener(this);
        this.GUI.PYP.btn_play[1].addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        int horse;
        int dirC;
        boolean dirChange;
        if(e.getActionCommand()=="랜덤 던지기"){
            distance = this.model.throwYut();
            this.GUI.PYP.randomYut(distance);
        } else if(e.getActionCommand()=="지정 던지기"){
            distance=GUI.PYP.chooseYut();
            this.model.throwYut(distance);
            this.GUI.PYP.chosenYut(distance);         
        }

        horse = this.GUI.YP.selectHorse()-1;

        if(this.model.hrsEnd(this.model.whoTurn() - 1, horse) == true) {
            do {
                JOptionPane.showMessageDialog(null, "움직일 수 없는 말입니다.", "오류", 2);
                horse = this.GUI.YP.selectHorse()-1;
            } while(this.model.hrsEnd(this.model.whoTurn() - 1, horse));    
        }
        
        if((this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(0) == 0 && this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(1) == 10) ||
        (this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(0) == 0 && this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(1) == 0) ||
        (this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(0) == 5 && this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(1) == 5)) {
            String setDistbtn[] = {"네", "아니오"};
            dirC = JOptionPane.showOptionDialog(null, "방향을 바꾸시겠습니까?", "방향 바꾸기",
           JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, setDistbtn, "두 번째값");
           if(dirC == 0) {
               dirChange = true;
           } else {
               dirChange = false;
           }
        } else {
            dirChange = false;
        }
        System.out.println(horse + " " + distance + " " + dirChange);
        this.model.moveHrs(horse, distance, dirChange);

        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                String mapinfo = this.model.mapAt(i, j);
                System.out.println(mapinfo);
                if(mapinfo!=""){
                    this.GUI.YP.btn_Board[i][j].set_Mal(Integer.parseInt(mapinfo));
                }
                else{
                    this.GUI.YP.btn_Board[i][j].set_Mal(0);
                }
                
            }
        }
        
        /*
        this.GUI.YP.btn_data[0]= new JButton("Player : "+this.model.whoTurn());
        this.GUI.YP.btn_data[0].setText("Player : "+whoTurn());
        */
        
    
        this.GUI.YP.Check_Pan();
        
        this.GUI.YP.YUTPAN.repaint();
        this.GUI.repaint();


        if(this.model.endGame()) {
            String setDistbtn[] = {"네", "아니오"};
            int choice = JOptionPane.showOptionDialog(null, "게임이 끝났습니다. 승자 : Player " + this.model.whoTurn() + "\n재시작 하시겠습니까?",
            "게임 종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, setDistbtn, "");
            if(choice == 0) {
                this.GUI.close();
                this.init();
            }
            else System.exit(0);
        }
    }

}