package project2PKG;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("ACE Data Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);

		ImageIcon icon = new ImageIcon("DR.png");
		frame.setIconImage(icon.getImage());
		
		frame.getContentPane().add(new MainPanel());

		frame.pack();
		frame.setVisible(true);
	}

}

