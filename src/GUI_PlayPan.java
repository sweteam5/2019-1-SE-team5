import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI_PlayPan extends JPanel implements ActionListener {

    private String[] PSValue = new String[2]; //초기 설정값 저장 할 배열

    private JPanel panelP = new JPanel();
    private JLabel label_inform;

    private JTextArea txtLog = new JTextArea(15, 10);  // 텍스트 영역
    private JScrollPane scrollPane = new JScrollPane(txtLog); // 스크롤 부착

    private JButton[] btn_yut = new JButton[4];
    private JButton[] btn_play = new JButton[2];

    // 각각의 결과에 대한 아이콘 (도 개 걸 윷 모 빽도)
    private ImageIcon doo = new ImageIcon("./img/doo.png");
    private ImageIcon gae = new ImageIcon("./img/gae.png");
    private ImageIcon girl = new ImageIcon("./img/girl.png");
    private ImageIcon yut = new ImageIcon("./img/yut.png");
    private ImageIcon mo = new ImageIcon("./img/mo.png");
    private ImageIcon bk = new ImageIcon("./img/BK.png");

    private String[] setYutbtn = {"도", "개", "걸", "윷","모","빽도"}; // 버튼

    private int Count = 0;

    public GUI_PlayPan(String[] PSValue) {

        this.PSValue = PSValue;

        // 라벨에 세팅 값 표시
        label_inform = new JLabel(" 설정된 참여자   :   " + PSValue[0] + "  설정된 말 개수   :   " + PSValue[1]);
        txtLog.setEditable(false); //수정 불가
        txtLog.setFocusable(false); // 포커싱 불가

        // Sub로 Main 에 들어갈 판 3개
        ButtonPan Vpanel = new ButtonPan();
        ButtonPan Bpanel = new ButtonPan();
        ButtonPan Cpanel = new ButtonPan();

        // Main 판
        ButtonPan lspanel = new ButtonPan(); 

        lspanel.setLayout(new BorderLayout()); // Border Layout 설정
        lspanel.add(label_inform, BorderLayout.NORTH); // 라벨은 최상단
        lspanel.add(scrollPane, BorderLayout.CENTER); //텍스트 아리아는 중단으로 설정
        

        Vpanel.setLayout(new GridLayout(1, 1)); // 그리드 레이아웃 1,1 설정
        Vpanel.add(btn_yut[0] = new JButton("")); // 텍스트 없음
        btn_yut[0].setIcon(doo);   // 초기 시작 아이콘 은 '도'
        btn_yut[0].setBackground(Color.WHITE); // 배경 흰색 
        btn_yut[0].setPreferredSize(new Dimension(300,270)); //사이즈 설정
        btn_yut[0].setText(null); // 텍스트 설정 불가
        btn_yut[0].setBorderPainted(false); // 경계선 설정 불가
        btn_yut[0].setContentAreaFilled(false); // 콘텐츠 내부 채우기 불가 (투명화)
        

        Bpanel.setLayout(new GridLayout(1, 2)); //랜덤 및 지정 던지기 버튼 들어갈 패널 (layout = Grid 1,2)

        Bpanel.add(btn_play[0] = new JButton("랜덤 던지기")); // 랜덤 던지기 버튼 
        btn_play[0].setPreferredSize(new Dimension(100,100)); //크기 100#100 pixel
        btn_play[0].addActionListener(this); // 액션리스너 장착

        Bpanel.add(btn_play[1] = new JButton("지정 던지기")); // 지정던지기 버튼
        btn_play[1].addActionListener(this); // 액션리스너 장착

        Cpanel.setLayout(new BorderLayout()); //border layout 설정
        Cpanel.add(Vpanel, BorderLayout.CENTER); // VPanel 센터
        Cpanel.add(Bpanel, BorderLayout.SOUTH);  // BPanel 맨밑

        panelP.setLayout(new GridLayout(2, 1)); // 그리드 레이아웃 2,1 
        panelP.add(lspanel); // ls 패널 장착
        panelP.add(Cpanel); // Cpanel 장착
    } 

    // 버튼 패널 클래스 Jpanel 상속
    private class ButtonPan extends JPanel {

    }

    public JPanel get_playpan() {
        return panelP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        //System.out.println(e.getActionCommand());

        if(e.getActionCommand()=="랜덤 던지기"){
             Count = (int)(Math.random()*6+1);

        if(Count == 1){
              btn_yut[0].setIcon(doo);
                txtLog.append("Random : 도\n");
            } else if(Count == 2){
              btn_yut[0].setIcon(gae);
                txtLog.append("Random : 개\n");
            } else if(Count == 3){
              btn_yut[0].setIcon(girl);
                txtLog.append("Random : 걸\n");
            } else if(Count == 4){
              btn_yut[0].setIcon(yut);
                txtLog.append("Random : 윷\n");
            } else if(Count == 5){
              btn_yut[0].setIcon(mo);
                txtLog.append("Random : 모\n");
            } else{
              btn_yut[0].setIcon(bk);
                txtLog.append("Random : Back 도\n");
            }
        } else {
            Count = JOptionPane.showOptionDialog(null, "던질 윷을 설정하세요 ! .", "지정 윷 던지기.",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, setYutbtn, "두 번째값");

                if(Count+1 == 1){
                    btn_yut[0].setIcon(doo);
                      txtLog.append("Set : 도\n");
                } else if(Count+1 == 2){
                    btn_yut[0].setIcon(gae);
                      txtLog.append("Set : 개\n");
                } else if(Count+1 == 3){
                    btn_yut[0].setIcon(girl);
                      txtLog.append("Set : 걸\n");
                } else if(Count+1 == 4){
                    btn_yut[0].setIcon(yut);
                      txtLog.append("Set : 윷\n");
                } else if(Count+1 == 5){
                    btn_yut[0].setIcon(mo);
                      txtLog.append("Set : 모\n");
                } else{
                  btn_yut[0].setIcon(bk);
                     txtLog.append("Set : Back 도\n");
                }
        }       
    }
}