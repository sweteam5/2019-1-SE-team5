import java.io.File;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI_YUTPAN implements ActionListener {

    private JLayeredPane YUTPAN = new JLayeredPane();

    private String Mals[];

    private JComboBox<String> MCB;
    
    private Image img;
    private JButton[] btn_data = new JButton[3];
    private PanButton[][] btn_Board= new PanButton[11][11];

    private BYP ypanel;
    private YP ipanel;

    private ImageIcon P1 = new ImageIcon("./img/Opac.png");

    private ImageIcon P1_1 = new ImageIcon("./img/P1_1.png");
    private Image P1_R1 = P1_1.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P1_R15 = new ImageIcon(P1_R1);

    private ImageIcon P1_2 = new ImageIcon("./img/P1_2.png");
    private Image P1_R2 = P1_2.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P1_R25 = new ImageIcon(P1_R2);

    private ImageIcon P1_3 = new ImageIcon("./img/P1_3.png");
    private Image P1_R3 = P1_3.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P1_R35 = new ImageIcon(P1_R3);

    private ImageIcon P1_4 = new ImageIcon("./img/P1_4.png");
    private Image P1_R4 = P1_4.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P1_R45 = new ImageIcon(P1_R4);

    private ImageIcon P1_5 = new ImageIcon("./img/P1_5.png");
    private Image P1_R5 = P1_5.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P1_R55 = new ImageIcon(P1_R5);

    private ImageIcon P2_1 = new ImageIcon("./img/P2_1.png");
    private Image P2_R1 = P2_1.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P2_R15 = new ImageIcon(P2_R1);

    private ImageIcon P2_2 = new ImageIcon("./img/P2_2.png");
    private Image P2_R2 = P2_2.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P2_R25 = new ImageIcon(P2_R2);

    private ImageIcon P2_3 = new ImageIcon("./img/P2_3.png");
    private Image P2_R3 = P2_3.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P2_R35 = new ImageIcon(P2_R3);

    private ImageIcon P2_4 = new ImageIcon("./img/P2_4.png");
    private Image P2_R4 = P2_4.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P2_R45 = new ImageIcon(P2_R4);

    private ImageIcon P2_5 = new ImageIcon("./img/P2_5.png");
    private Image P2_R5 = P2_5.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P2_R55 = new ImageIcon(P2_R5);

    private ImageIcon P3_1 = new ImageIcon("./img/P3_1.png");
    private Image P3_R1 = P3_1.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P3_R15 = new ImageIcon(P3_R1);

    private ImageIcon P3_2 = new ImageIcon("./img/P3_2.png");
    private Image P3_R2 = P3_2.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P3_R25 = new ImageIcon(P3_R2);

    private ImageIcon P3_3 = new ImageIcon("./img/P3_3.png");
    private Image P3_R3 = P3_3.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P3_R35 = new ImageIcon(P3_R3);

    private ImageIcon P3_4 = new ImageIcon("./img/P3_4.png");
    private Image P3_R4 = P3_4.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P3_R45 = new ImageIcon(P3_R4);

    private ImageIcon P3_5 = new ImageIcon("./img/P3_5.png");
    private Image P3_R5 = P3_5.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P3_R55 = new ImageIcon(P3_R5);

    private ImageIcon P4_1 = new ImageIcon("./img/P4_1.png");
    private Image P4_R1 = P4_1.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P4_R15 = new ImageIcon(P4_R1);

    private ImageIcon P4_2 = new ImageIcon("./img/P4_2.png");
    private Image P4_R2 = P4_2.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P4_R25 = new ImageIcon(P4_R2);

    private ImageIcon P4_3 = new ImageIcon("./img/P4_3.png");
    private Image P4_R3 = P4_3.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P4_R35 = new ImageIcon(P4_R3);

    private ImageIcon P4_4 = new ImageIcon("./img/P4_4.png");
    private Image P4_R4 = P4_4.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P4_R45 = new ImageIcon(P4_R4);

    private ImageIcon P4_5 = new ImageIcon("./img/P4_5.png");
    private Image P4_R5 = P4_5.getImage().getScaledInstance(50, 60, Image.SCALE_SMOOTH);
    private ImageIcon P4_R55 = new ImageIcon(P4_R5);


    private String[] setYutbtn = {"도", "개", "걸", "윷","모","빽도"};
    private String[] setDistbtn = {"네","아니오"};

    private String[] PSValue = new String[2];
    private int[] NumOfPlayer;
    private String[] NumOfMal;
    
    private int Dist;
    
    public GUI_YUTPAN(String[] PSValue) {
        try {
            img = ImageIO.read(new File(("./img/yutpan.png")));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
            e.printStackTrace();
            System.exit(0);
        }

        this.PSValue = PSValue;
        NumOfPlayer = new int[Integer.parseInt(PSValue[0])];
        NumOfMal = new String[Integer.parseInt(PSValue[1])];

        for(int i =0; i<NumOfMal.length;i++){
            NumOfMal[i] = Integer.toString(i+1);
        } // 인원 =4, 말개수 = 5로 설정할 경우 배열에 들어있는 값 (크기는 psvalue의 각 요소로 맞춤)[1, 2, 3, 4]/[1, 2, 3, 4, 5]

        MCB = new JComboBox<String>(NumOfMal);

        for(int i =0; i<NumOfPlayer.length;i++){
            NumOfPlayer[i] = i+1;
        }

        MCB = new JComboBox<String>(NumOfMal);

        YUTPAN.setSize(500, 500);
        YUTPAN.setLayout(new BorderLayout());

        // 이미지 삽입
        ipanel = new YP();
        ypanel = new BYP();
            
        ypanel.setLayout(null);
        ypanel.setSize(500, 500);
        

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                btn_Board[i][j] = new PanButton();
                btn_Board[i][j].setIcon(P1);
                btn_Board[i][j].setText(null);
                btn_Board[i][j].setBorderPainted(false);
                btn_Board[i][j].setContentAreaFilled(false);
                
            }
        }

        ypanel.add(btn_Board[10][10]);
        ypanel.add(btn_Board[10][8]);
        ypanel.add(btn_Board[10][6]);
        ypanel.add(btn_Board[10][4]);
        ypanel.add(btn_Board[10][2]);
        ypanel.add(btn_Board[10][0]);

        ypanel.add(btn_Board[0][10]);
        ypanel.add(btn_Board[0][8]);
        ypanel.add(btn_Board[0][6]);
        ypanel.add(btn_Board[0][4]);
        ypanel.add(btn_Board[0][2]);
        ypanel.add(btn_Board[0][0]);

        ypanel.add(btn_Board[2][0]);
        ypanel.add(btn_Board[4][0]);
        ypanel.add(btn_Board[6][0]);
        ypanel.add(btn_Board[8][0]);

        ypanel.add(btn_Board[2][10]);
        ypanel.add(btn_Board[4][10]);
        ypanel.add(btn_Board[6][10]);
        ypanel.add(btn_Board[8][10]);

        ypanel.add(btn_Board[2][2]);
        ypanel.add(btn_Board[4][4]);
        ypanel.add(btn_Board[6][6]);
        ypanel.add(btn_Board[8][8]);

        ypanel.add(btn_Board[5][5]);
        ypanel.add(btn_Board[2][8]);
        ypanel.add(btn_Board[6][4]);
        ypanel.add(btn_Board[4][6]);
        ypanel.add(btn_Board[8][2]);



        // 맨 오른쪽 보드
        btn_Board[10][10].setBounds(472, 477, 50, 50);
        btn_Board[8][10].setBounds(471, 377, 50, 50);
        btn_Board[6][10].setBounds(471, 297, 50, 50);
        btn_Board[4][10].setBounds(471, 218, 50, 50);
        btn_Board[2][10].setBounds(471, 138, 50, 50);
        btn_Board[0][10].setBounds(472, 39, 50, 50);

        // 맨 왼쪽 보드
        btn_Board[10][0].setBounds(35, 476, 50, 50);
        btn_Board[2][0].setBounds(36, 377, 50, 50);
        btn_Board[4][0].setBounds(36, 297, 50, 50);
        btn_Board[6][0].setBounds(36, 218, 50, 50);
        btn_Board[8][0].setBounds(36, 138, 50, 50);
        btn_Board[0][0].setBounds(35, 39, 50, 50);

        // 맨 위쪽 보드
        btn_Board[0][2].setBounds(135, 39, 50, 50);
        btn_Board[0][4].setBounds(214, 39, 50, 50);
        btn_Board[0][6].setBounds(293, 39, 50, 50);
        btn_Board[0][8].setBounds(372, 39, 50, 50);

        // 맨 아래쪽 보드
        btn_Board[10][2].setBounds(135, 476, 50, 50);
        btn_Board[10][4].setBounds(214, 476, 50, 50);
        btn_Board[10][6].setBounds(293, 476, 50, 50);
        btn_Board[10][8].setBounds(372, 476, 50, 50);

        // 대각선1  왼쪽위 -> 오른쪽 아래
        btn_Board[2][2].setBounds(115, 118, 50, 50);
        btn_Board[4][4].setBounds(174, 178, 50, 50);
        btn_Board[6][6].setBounds(332, 337, 50, 50);
        btn_Board[8][8].setBounds(391, 397, 50, 50);

        // 중앙점 
        btn_Board[5][5].setBounds(249, 253, 60, 60);

        // 대각선2  오른쪽위 -> 왼쪽아래
        btn_Board[2][8].setBounds(392, 118, 50, 50);
        btn_Board[6][4].setBounds(333, 178, 50, 50);
        btn_Board[4][6].setBounds(175, 337, 50, 50);
        btn_Board[8][2].setBounds(115, 397, 50, 50); 

        DP dpanel = new DP();
        dpanel.setLayout(new GridLayout(1, 3));
        dpanel.add(btn_data[0] = new JButton("Player : " + "1"));

        btn_data[0].addActionListener(this);
        btn_data[0].setPreferredSize(new Dimension(100, 100));
        btn_data[0].setEnabled(false);

        dpanel.add(btn_data[1] = new JButton("말 선택"));
        btn_data[1].addActionListener(this);

        dpanel.add(btn_data[2] = new JButton("방향 바꾸기"));
        btn_data[2].addActionListener(this);

        ypanel.add(ipanel);
        ipanel.setBounds(0, 0, 555, 559);


        YUTPAN.add(ypanel, BorderLayout.CENTER);
        YUTPAN.add(dpanel, BorderLayout.SOUTH);

    }

    private class YP extends JPanel {

        public void paint(Graphics g) {
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
        
    }

    public class PanButton extends JButton{
        private int Mal = 0;

         public void set_Mal(int Mal){
            this.Mal = Mal;
        }

        public int get_Mal(){
            return Mal;
        }
    }

    private class BYP extends JPanel{
    }

    private class DP extends JPanel {
    }

    public JLayeredPane get_yutPan() {
        return YUTPAN;
    }

    public void Check_Pan(){
        for(int i =0;i<11;i++){
            for(int j =0;j<11;j++){
                switch(btn_Board[i][j].get_Mal()){
                    case 1:
                        btn_Board[i][j].setIcon(P1_R15);
                        break;
                    case 11:
                        btn_Board[i][j].setIcon(P1_R25);
                        break;
                    case 111 :
                        btn_Board[i][j].setIcon(P1_R35);
                        break;
                    case 1111 :
                        btn_Board[i][j].setIcon(P1_R45);
                        break;
                    case 11111 :
                        btn_Board[i][j].setIcon(P1_R55);
                        break;
                    case 2:
                        btn_Board[i][j].setIcon(P2_R15);
                        break;
                    case 22:
                        btn_Board[i][j].setIcon(P2_R25);
                        break;
                    case 222 :
                        btn_Board[i][j].setIcon(P2_R35);
                        break;
                    case 2222 :
                        btn_Board[i][j].setIcon(P2_R45);
                        break;
                    case 22222 :
                        btn_Board[i][j].setIcon(P2_R55);
                        break;
                    case 3:
                        btn_Board[i][j].setIcon(P3_R15);
                        break;
                    case 33:
                        btn_Board[i][j].setIcon(P3_R25);
                        break;
                    case 333 :
                        btn_Board[i][j].setIcon(P3_R35);
                        break;
                    case 3333 :
                        btn_Board[i][j].setIcon(P3_R45);
                        break;
                    case 33333 :
                        btn_Board[i][j].setIcon(P3_R55);
                        break;
                    case 4:
                        btn_Board[i][j].setIcon(P4_R15);
                        break;
                    case 44:
                        btn_Board[i][j].setIcon(P4_R25);
                        break;
                    case 444 :
                        btn_Board[i][j].setIcon(P4_R35);
                        break;
                    case 4444 :
                        btn_Board[i][j].setIcon(P4_R45);
                        break;
                    case 44444 :
                        btn_Board[i][j].setIcon(P4_R55);
                        break;                    
                    default :
                        btn_Board[i][j].setIcon(null);
                        btn_Board[i][j].setBorderPainted(false);
                        btn_Board[i][j].setContentAreaFilled(false);
                    }
            }
        }
        YUTPAN.repaint();
    }   

    public boolean Check_Direction() {

        if(btn_Board[10][0].get_Mal()!=0 || btn_Board[5][5].get_Mal()!=0 || btn_Board[0][0].get_Mal()!=0){
            return true;
        } else{
            return false;
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand()=="Player"){          
                // 버튼액션 X 버튼에 정보표시만 함
        } else if(e.getActionCommand()=="말 선택"){
            int Selected_MAl;
            int result = JOptionPane.showConfirmDialog(null, MCB,
            "던질 말을 선택하세요", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {     
                    Selected_MAl = Integer.parseInt(MCB.getSelectedItem().toString());
                   System.out.println("선택된 말 : "+Selected_MAl); //사람수         
                }

        } else if(e.getActionCommand()=="방향 바꾸기"){
               Check_Pan();
          if(Check_Direction() == true){
           Dist = JOptionPane.showOptionDialog(null, "방향을 바꾸시겠습습니까?", "방향 바꾸기",
           JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, setDistbtn, "두 번째값");
          } else{
            JOptionPane.showMessageDialog(null, "방향을 바꿀 수 없습니다.");
          }
        }
    }

    public boolean directChange(){
        if(Dist==0){
            return true;
        }
        else{
            return false;
        }
    }

}
