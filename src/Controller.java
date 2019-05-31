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

    public Controller(GUI_PlaySetting PS) {
        this.model = new Model(PS.get_settingValue());
        // model에게 플레이수, 말 수 전달
        this.GUI = new GUI_Frame(PS.get_settingValue(), model, PS.get_turnoff());
        // 게임판 생성
    }

    public void init() {

        // GUI.PYP.whoTurn();
        // 첫 시작시 플레이어 1 정보 표시

        this.GUI.PYP.btn_play[0].addActionListener(this);
        //랜덤 윷 버튼
        
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

        do {
            horse = this.GUI.YP.selectHorse();
        } while(this.model.hrsEnd(this.model.whoTurn, horse));
        
        if((this.model.hrsInfo(this.model.whoTurn, horse)[0] == 0 && this.model.hrsInfo(this.model.whoTurn, horse)[1] == 10) ||
        (this.model.hrsInfo(this.model.whoTurn, horse)[0] == 0 && this.model.hrsInfo(this.model.whoTurn, horse)[1] == 0) ||
        (this.model.hrsInfo(this.model.whoTurn, horse)[0] == 5 && this.model.hrsInfo(this.model.whoTurn, horse)[0] == 5)) {
            String setDistbtn[] = {"네", "아니오"};
            dirC = JOptionPane.showOptionDialog(null, "방향을 바꾸시겠습습니까?", "방향 바꾸기",
           JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, setDistbtn, "두 번째값");
           if(dirC == 0) {
               dirChange = true;
           } else {
               dirChange = false;
           }
        } else {
            dirChange = false;
        }
        this.model.moveHrs(0, distance, dirChange);

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


            //view에서 model의 윷 던지기 실행->distance 구함

            /*choose what horse at view*/
            
            //model.moveHrs(horsenum, distance, directionchange);
            //view에서 받은 정보를 모델에거 전달 후 말 옮기기 실행

            /*모델 정보를 뷰에 보낸 후 뷰에서 반영*/

            //if(model.endGame()){
                /*뷰에서 게임 끝났을 때 처리*/
            //}
            //게임이 끝났는지 체크

            //GUI.PYP.whoTurn();
            //다음 플레이어 표시
    }

}