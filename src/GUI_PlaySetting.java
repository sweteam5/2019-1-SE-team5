import java.io.IOException;
import javax.swing.*;


public class GUI_PlaySetting {

    //처음 시작시 Joption Popup 호출

    String NOP[] = {"2","3","4"};  // 플레이할 사람의 수
    String NOH[] = {"2","3","4","5"}; // 플레이할 말의 수
    String[] PSValue = new String[2]; // 값 반환 배열

    JComboBox<String> YNP; //콤보박스 벡터
    JComboBox<String> YNH;  

    public GUI_PlaySetting() throws IOException{


        YNP = new JComboBox<String>(NOP); //콤보박스 생성
        YNH = new JComboBox<String>(NOH);
        
        JPanel myPanel = new JPanel(); // 컴포넌트들이 들어갈 패널 생성

        myPanel.add(new JLabel(" Person :")); // 라벨생성
        myPanel.add(YNP);

        myPanel.add(new JLabel(" Horse :"));
        myPanel.add(YNH);
  
         // result 값으로 반환. 
        int result = JOptionPane.showConfirmDialog(null, myPanel,  
                 "PlaySetting", JOptionPane.OK_CANCEL_OPTION);

       if (result == JOptionPane.OK_OPTION) {
           
        // PSValue 배열의 0,1 번째 index에 각각의 값 반환 
           PSValue[0] = YNP.getSelectedItem().toString(); //사람수
           PSValue[1] = YNH.getSelectedItem().toString(); //말 수
                
        }
    }

    public String[] get_settingValue(){

        return PSValue;
    }
}