import Model.*;
import View.*;

import java.awt.Color;
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
        //지정 윷던지기와 랜덤 윷던지기에 이벤트 할당
    }

    public void actionPerformed(ActionEvent e) {
        int horse;
        int dirC;
        boolean dirChange;
        if(e.getActionCommand()=="랜덤 던지기"){
            distance = this.model.throwYut();
            this.GUI.PYP.randomYut(distance);
            //모델에서 throwYut으로 윷 정보 구한 후 뷰에 전달
        } else if(e.getActionCommand()=="지정 던지기"){
            distance=GUI.PYP.chooseYut();
            this.model.throwYut(distance);
            this.GUI.PYP.chosenYut(distance);
            //뷰에서 선택한 윷을 모델에 전달
            //다시 해당 값을 뷰에 전달     
        }

        horse = this.GUI.YP.selectHorse()-1;
        //뷰로 부터 선택한 말 정보 받음

        if(this.model.hrsEnd(this.model.whoTurn() - 1, horse) == true) {
            do {
                JOptionPane.showMessageDialog(null, "움직일 수 없는 말입니다.", "오류", 2);
                horse = this.GUI.YP.selectHorse()-1;
            } while(this.model.hrsEnd(this.model.whoTurn() - 1, horse));
            //만약 해당 말이 이미 완주한 말이면 다른말을 고르게 함
        }
        
        if(((this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(0) == 0 && this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(1) == 10) ||
        (this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(0) == 0 && this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(1) == 0) ||
        (this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(0) == 5 && this.model.hrsInfo(this.model.whoTurn() - 1, horse).get(1) == 5)) && distance != 0) {
            //선택한 말이 방향을 결정해야하는 위치에 있는지 체크
            //해당 위치에 있을시 방향 변경 여부 결정
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

        this.model.moveHrs(horse, distance, dirChange);
        //말 번호, 이동 거리, 방향 변경 여부를 모델에 보내 말을 옮김

        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                String mapinfo = this.model.mapAt(i, j);
                if(mapinfo!=""){
                    this.GUI.YP.btn_Board[i][j].set_Mal(Integer.parseInt(mapinfo));
                }
                else{
                    this.GUI.YP.btn_Board[i][j].set_Mal(0);
                }
                
            }
        }
        //모델의 모든 맵정보를 뷰에 전달해줌
        
        this.GUI.YP.btn_data[0].setText("Player : " + Integer.toString(this.model.whoTurn()));
        this.GUI.YP.btn_data[1].setText("남은 말 : " + this.model.getRemainHorseofPlayer(this.model.whoTurn() - 1));
        switch(this.model.whoTurn()) {
            case 1:
                this.GUI.YP.btn_data[2].setText("Color : " + "RED");
                this.GUI.YP.btn_data[2].setBackground(Color.RED);
                break;
            case 2:
                this.GUI.YP.btn_data[2].setText("Color : " + "GREEN");
                this.GUI.YP.btn_data[2].setBackground(Color.GREEN);
                break;
            case 3:
                this.GUI.YP.btn_data[2].setText("Color : " + "BLUE");
                this.GUI.YP.btn_data[2].setBackground(Color.BLUE);
                break;
            case 4:
                this.GUI.YP.btn_data[2].setText("Color : " + "PURPLE");
                this.GUI.YP.btn_data[2].setBackground(Color.magenta);
                break;
            default: break;
        }
        //플레이터 턴에 따라 플레이어 번호와 남은 말의 수, 색깔을 변경
    
        this.GUI.YP.Check_Pan();
        this.GUI.YP.YUTPAN.repaint();
        this.GUI.repaint();
        //뷰에서 변경여부 확인 후 재출력


        if(this.model.endGame()) {
            String setDistbtn[] = {"네", "아니오"};
            int choice = JOptionPane.showOptionDialog(null, "게임이 끝났습니다. 승자 : Player " + (this.model.whoTurn()) + "\n재시작 하시겠습니까?",
            "게임 종료", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, setDistbtn, "");
            if(choice == 0) {
                this.GUI.close();
                this.init();
            }
            else System.exit(0);
        }
        //게임 종료 여부 확인 후 재시작 여부 결정
    }

}