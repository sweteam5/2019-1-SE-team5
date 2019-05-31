import java.io.IOException;
import javax.swing.UIManager;
import View.*;
import Model.*;


public class GUI_main
{
	public static void main(String[] args)
	{
		//uimanager로 테마 적용
		try {

			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
			} catch (Exception e) { }
			
		Controller Yutgame = new Controller();
		Yutgame.init();
	}
}

