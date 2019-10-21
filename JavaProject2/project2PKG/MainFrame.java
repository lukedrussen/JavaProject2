//Luke Russenberger
//CSCI 3381
package project2PKG;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame {

	public static void main(String[] args) {
		AceDataManagerADT myData = new AceDataManager<String>();
		MainPanel panel = new MainPanel(myData);
		JFrame frame = new JFrame("ACE Data Manager");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);


		ImageIcon icon = new ImageIcon("DR.png");
		frame.setIconImage(icon.getImage());

		frame.getContentPane().add(panel);

		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				panel.doClose();
				System.exit(0);
			}
		});

	}

}

