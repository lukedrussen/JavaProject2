//Luke Russenberger


package project2PKG;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class MainPanel extends JPanel {
	private final int WIDTH = 800, HEIGHT = 500;

	private AceDataManagerADT myData;

	private ArrayList<String> IDS;

	private JPanel controlPanel;
	private AddPanel addpanel;
	private EditPanel editpanel;

	private String ID;

	private JButton showAddPanel;
	private JButton showEditPanel;
	private JButton removePatient;


	public MainPanel(AceDataManagerADT x)
	{
		super(new BorderLayout());
		myData=x;
		myData.readFile("output.txt");



		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		setBackground (Color.RED);

		controlPanel = new JPanel();
		controlPanel.setPreferredSize (new Dimension(WIDTH, HEIGHT));
		controlPanel.setBackground (Color.GRAY);		   



		showAddPanel = new JButton("Add Patient");
		showAddPanel.setBounds(326, 129, 148, 23);
		showAddPanel.addActionListener(new AddPanelListener());

		showEditPanel = new JButton("View/Edit Patient");
		showEditPanel.setBounds(326, 162, 148, 23);
		showEditPanel.addActionListener(new EditPanelListener());

		removePatient = new JButton("Remove Patient");
		removePatient.setBounds(326, 195, 148, 23);
		removePatient.addActionListener(new RemoveListener());


		IDS = myData.getIDs();

		addpanel = new AddPanel(controlPanel, myData);
		editpanel = new EditPanel(controlPanel, myData);











		add(addpanel, BorderLayout.EAST);
		addpanel.setVisible(false);
		add(editpanel, BorderLayout.NORTH);
		editpanel.setVisible(false);

		add(controlPanel, BorderLayout.WEST);
		controlPanel.setVisible(true);

		controlPanel.setLayout(null);

		controlPanel.add(showEditPanel);
		controlPanel.add(showAddPanel);
		controlPanel.add(removePatient);
	}


	private class AddPanelListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {

			addpanel = new AddPanel(controlPanel, myData);
			add(addpanel, BorderLayout.EAST);
			controlPanel.setVisible(false);
			addpanel.setVisible(true);
		}
	}

	private class EditPanelListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			editpanel = new EditPanel(controlPanel, myData);
			add(editpanel, BorderLayout.NORTH);
			controlPanel.setVisible(false);
			editpanel.setVisible(true);
		}
	}

	private class RemoveListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			IDS = myData.getIDs();

			ID = JOptionPane.showInputDialog("Enter a Patient ID:");

			if(!IDS.contains(ID) && ID != null) {
				do {
					ID = JOptionPane.showInputDialog("No Patient With Matching ID.\nEnter Different ID or Cancel.");
				} while ( !IDS.contains(ID) && ID != null); 
			}
			myData.removePatient(myData.getPatient(ID));
		}
	}

	public void doClose() {
		// TODO Auto-generated method stub
		try {
			myData.writeToFile("output.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

