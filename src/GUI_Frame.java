import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.IOException;


public class GUI_Frame extends Frame{		

	String[] PSValue = new String[2]; // 라벨에 표시할 정보 배열

	public GUI_Frame(String[] PSValue) throws IOException{

		this.PSValue = PSValue; //저장

		JFrame frame = new JFrame("SEPJ1"); //프로그램 창 제목
		frame.setBounds(50,50,870,700); // 창을 시작할 좌표와 창의 크기 설정
		frame.setResizable(false); // 프레임 크기변경 - false 

		frame.setLayout(new BorderLayout()); // border layout 설정

		GUI_YUTPAN YP = new GUI_YUTPAN(PSValue); // 윷놀이판 밑 버튼 패널
		GUI_PlayPan PYP = new GUI_PlayPan(PSValue); // 윷놀이 정보 패널
									
		frame.add(YP.get_yutPan(), BorderLayout.CENTER); //윷놀이 판은 중앙에 배치
		frame.add(PYP.get_playpan(),BorderLayout.EAST);  //정보 패널은 오른쪽에 배치

		frame.getContentPane().setBackground(Color.WHITE); //프레임 배경 흰색으로 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X누르면 종료
		frame.setResizable(false); // 크기조정 불가
		frame.setVisible(true); // 가시성 True

	}		
}

