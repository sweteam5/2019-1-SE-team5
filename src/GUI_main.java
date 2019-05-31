import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class GUI_main 
{
	
	public static void main(String[] args) throws IOException
	{
		//uimanager로 테마 적용
		try {

			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
			} catch (Exception e) { }
	
		// 플레이 세팅 객체와 GUI 객체 생성 
		GUI_PlaySetting PS = new GUI_PlaySetting();	 // 팝업으로 설정
		GUI_Frame GUI = new GUI_Frame(PS.get_settingValue()); //GUI frame 호출
	}
}

