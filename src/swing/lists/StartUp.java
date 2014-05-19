package swing.lists;

import javax.swing.JFrame;

public final class StartUp {

	private StartUp() {}

	public static void main(String[] args) {
		ActionFrame frame = new ActionFrame("List DEMO");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
