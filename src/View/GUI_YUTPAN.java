package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI_YUTPAN implements ActionListener {

    public JLayeredPane YUTPAN = new JLayeredPane();

    private String Mals[] = {"1","2","3","4","5"};
    private JComboBox<String> MCB;
    
    private Image img;
    public JButton[] btn_data = new JButton[3];
    public PanButton[][] btn_Board= new PanButton[11][11];

    private BYP ypanel;
    private YP ipanel;

    private ImageIcon P1 = new ImageIcon("C:/Users/Purung/Desktop/VIEW_I~1/img/Opac.png");
    private ImageIcon M1 = new ImageIcon("C:/Users/Purung/Desktop/VIEW_I~1/img/m1.png");
    private ImageIcon M2 = new ImageIcon("C:/Users/Purung/Desktop/VIEW_I~1/img/m2.png");
    private ImageIcon M3 = new ImageIcon("C:/Users/Purung/Desktop/VIEW_I~1/img/m3.png");
    private ImageIcon M4 = new ImageIcon("C:/Users/Purung/Desktop/VIEW_I~1/img/m4.png");
    private ImageIcon M5 = new ImageIcon("C:/Users/Purung/Desktop/VIEW_I~1/img/m5.png");

    private String[] setYutbtn = {"도", "개", "걸", "윷","모","빽도"};
    private String[] setDistbtn = {"네","아니오"};

    private String[] PSValue = new String[2];
    private int[] NumOfPlayer;
    private String[] NumOfMal;

    private int Dist;
    private int chooseHorse;

    public GUI_YUTPAN(String[] PSValue) {
        try {
            img = ImageIO.read(new File(("C:/Users/Purung/Desktop/VIEW_I~1/img/yutpan.png")));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
            e.printStackTrace();
            System.exit(0);
        }
        
        this.PSValue = PSValue;
        NumOfPlayer = new int[Integer.parseInt(PSValue[0])];
        NumOfMal = new String[Integer.parseInt(PSValue[1])];

        for(int i =0; i<NumOfPlayer.length;i++){
            NumOfPlayer[i] = i+1;
        }

        for(int i =0; i<NumOfMal.length;i++){
            NumOfMal[i] = Integer.toString(i+1);
        } // 인원 =4, 말개수 = 5로 설정할 경우 배열에 들어있는 값 (크기는 psvalue의 각 요소로 맞춤)[1, 2, 3, 4]/[1, 2, 3, 4, 5]

        MCB = new JComboBox<String>(NumOfMal);

        YUTPAN.setSize(500, 500);
        YUTPAN.setLayout(new BorderLayout(5, 3));

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
        btn_Board[10][10].setBounds(476, 480, 50, 50);
        btn_Board[8][10].setBounds(476, 380, 50, 50);
        btn_Board[6][10].setBounds(476, 300, 50, 50);
        btn_Board[4][10].setBounds(476, 220, 50, 50);
        btn_Board[2][10].setBounds(476, 140, 50, 50);
        btn_Board[0][10].setBounds(476, 39, 50, 50);

        // 맨 왼쪽 보드
        btn_Board[0][0].setBounds(42, 480, 50, 50);
        btn_Board[2][0].setBounds(42, 380, 50, 50);
        btn_Board[4][0].setBounds(42, 300, 50, 50);
        btn_Board[6][0].setBounds(42, 220, 50, 50);
        btn_Board[8][0].setBounds(42, 140, 50, 50);
        btn_Board[10][0].setBounds(42, 39, 50, 50);

        // 맨 위쪽 보드
        btn_Board[0][2].setBounds(139, 39, 50, 50);
        btn_Board[0][4].setBounds(218, 39, 50, 50);
        btn_Board[0][6].setBounds(297, 39, 50, 50);
        btn_Board[0][8].setBounds(376, 39, 50, 50);

        // 맨 아래쪽 보드
        btn_Board[10][2].setBounds(139, 480, 50, 50);
        btn_Board[10][4].setBounds(218, 480, 50, 50);
        btn_Board[10][6].setBounds(297, 480, 50, 50);
        btn_Board[10][8].setBounds(376, 480, 50, 50);

        // 대각선1
        btn_Board[2][2].setBounds(120, 120, 50, 50);
        btn_Board[4][4].setBounds(179, 180, 50, 50);
        btn_Board[6][6].setBounds(337, 340, 50, 50);
        btn_Board[8][8].setBounds(396, 400, 50, 50);

        // 중앙점
        btn_Board[5][5].setBounds(249, 251, 60, 60);

        // 대각선2
        btn_Board[2][8].setBounds(396, 120, 50, 50);
        btn_Board[6][4].setBounds(337, 180, 50, 50);
        btn_Board[4][6].setBounds(179, 350, 50, 50);
        btn_Board[8][2].setBounds(120, 400, 50, 50); 

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
                        System.out.println("1-");
                        btn_Board[i][j].setIcon(M1);
                        btn_Board[i][j].setBackground(Color.RED);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 11:
                        System.out.println("2-");
                        btn_Board[i][j].setIcon(M2);
                        btn_Board[i][j].setBackground(Color.RED);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 111 :
                        System.out.println("3-");
                        btn_Board[i][j].setIcon(M3);
                        btn_Board[i][j].setBackground(Color.RED);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 1111 :
                        System.out.println("4-");
                        btn_Board[i][j].setIcon(M4);
                        btn_Board[i][j].setBackground(Color.RED);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 11111 :
                        System.out.println("5-");
                        btn_Board[i][j].setIcon(M5);
                        btn_Board[i][j].setBackground(Color.RED);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 2:
                        System.out.println("1-");
                        btn_Board[i][j].setIcon(M1);
                        btn_Board[i][j].setBackground(Color.BLUE);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 22:
                        System.out.println("2-");
                        btn_Board[i][j].setIcon(M2);
                        btn_Board[i][j].setBackground(Color.BLUE);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 222 :
                        System.out.println("3-");
                        btn_Board[i][j].setIcon(M3);
                        btn_Board[i][j].setBackground(Color.BLUE);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 2222 :
                        System.out.println("4-");
                        btn_Board[i][j].setIcon(M4);
                        btn_Board[i][j].setBackground(Color.BLUE);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 22222 :
                        System.out.println("5-");
                        btn_Board[i][j].setIcon(M5);
                        btn_Board[i][j].setBackground(Color.BLUE);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 3:
                        System.out.println("1-");
                        btn_Board[i][j].setIcon(M1);
                        btn_Board[i][j].setBackground(Color.GREEN);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 33:
                        System.out.println("2-");
                        btn_Board[i][j].setIcon(M2);
                        btn_Board[i][j].setBackground(Color.GREEN);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 333 :
                        System.out.println("3-");
                        btn_Board[i][j].setIcon(M3);
                        btn_Board[i][j].setBackground(Color.GREEN);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 3333 :
                        System.out.println("4-");
                        btn_Board[i][j].setIcon(M4);
                        btn_Board[i][j].setBackground(Color.GREEN);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 33333 :
                        System.out.println("5-");
                        btn_Board[i][j].setIcon(M5);
                        btn_Board[i][j].setBackground(Color.GREEN);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 4:
                        System.out.println("1-");
                        btn_Board[i][j].setIcon(M1);
                        btn_Board[i][j].setBackground(Color.YELLOW);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 44:
                        System.out.println("2-");
                        btn_Board[i][j].setIcon(M2);
                        btn_Board[i][j].setBackground(Color.YELLOW);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 444 :
                        System.out.println("3-");
                        btn_Board[i][j].setIcon(M3);
                        btn_Board[i][j].setBackground(Color.YELLOW);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 4444 :
                        System.out.println("4-");
                        btn_Board[i][j].setIcon(M4);
                        btn_Board[i][j].setBackground(Color.YELLOW);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;
                    case 44444 :
                        System.out.println("5-");
                        btn_Board[i][j].setIcon(M5);
                        btn_Board[i][j].setBackground(Color.YELLOW);
                        btn_Board[i][j].setBorderPainted(true);
                        btn_Board[i][j].setContentAreaFilled(true);
                        break;                    
                    default :
                        btn_Board[i][j].setIcon(null);
                        btn_Board[i][j].setText(null);
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
            int result = JOptionPane.showConfirmDialog(null, MCB,
            "Choose Mal", JOptionPane.OK_CANCEL_OPTION);
            if( result == 0){
                chooseHorse = Integer.parseInt(getSelectedItem().toString());
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

    public int selectHorse() {
        int result = JOptionPane.showConfirmDialog(null, MCB,
            "Choose Mal", JOptionPane.OK_CANCEL_OPTION);
            if(result == 0){
                chooseHorse = Integer.parseInt(MCB.getSelectedItem().toString());
            } else {
                chooseHorse = 0;
            }
        return chooseHorse;
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