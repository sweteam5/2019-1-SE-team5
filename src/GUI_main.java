import java.io.IOException;

public class GUI_main 
{
	public static void main(String[] args) throws IOException
	{
		// try {

		// 	UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			
		// } catch (Exception e) { }

		GUI_PlaySetting PS = new GUI_PlaySetting();
		Controller Yutgame = new Controller(PS);
		Yutgame.init();
	}
}

