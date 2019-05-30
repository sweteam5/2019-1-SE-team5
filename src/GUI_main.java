import java.io.IOException;

public class GUI_main 
{
	public static void main(String[] args) throws IOException
	{
		GUI_PlaySetting PS = new GUI_PlaySetting();
		Controller Yutgame = new Controller(PS);
		Yutgame.init();
	}
}

