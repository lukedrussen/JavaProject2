package project2PKG;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class MainPanel extends JPanel {
	private final int WIDTH = 800, HEIGHT = 500;

	private AceDataManagerADT myData;
	private AceDataManagerADT dummy;

	private PatientADT temp;

	private ArrayList<String> IDS;

	private JPanel controlPanel;
	private AddPanel addpanel;
	private ViewPanel viewpanel;
	private EditPanel editpanel;

	private String ID;

	private JButton showAddPanel;
	private JButton showViewPanel;
	private JButton showEditPanel;
	private JButton removePatient;


	public MainPanel()
	{
		super(new BorderLayout());
		dummy = new AceDataManager<PatientADT>();
		myData=new AceDataManager<PatientADT>();
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

		addpanel = new AddPanel(controlPanel, myData, IDS);
		editpanel = new EditPanel(controlPanel, myData, IDS);











		//		add(addpanel, BorderLayout.EAST);
		//		addpanel.setVisible(false);
		//		add(editpanel, BorderLayout.NORTH);
		//		editpanel.setVisible(false);

		add(controlPanel, BorderLayout.WEST);
		controlPanel.setVisible(true);

		controlPanel.setLayout(null);

		controlPanel.add(showEditPanel);
		controlPanel.add(showAddPanel);
		controlPanel.add(removePatient);
	}


	private class AddPanelListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			dummy.readFile("output.txt");
			myData = dummy;
			IDS = myData.getIDs();
			dummy = new AceDataManager<PatientADT>();
			addpanel = new AddPanel(controlPanel, myData, IDS);
			add(addpanel, BorderLayout.EAST);
			controlPanel.setVisible(false);
			addpanel.setVisible(true);
		}
	}

	private class EditPanelListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			dummy.readFile("output.txt");
			myData = dummy;
			IDS = myData.getIDs();
			dummy = new AceDataManager<PatientADT>();
			editpanel = new EditPanel(controlPanel, myData, IDS);
			add(editpanel, BorderLayout.NORTH);
			controlPanel.setVisible(false);
			editpanel.setVisible(true);
		}
	}

	private class RemoveListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {

			ID = JOptionPane.showInputDialog("Enter a Patient ID:");
			
			if(!IDS.contains(ID) && ID != null) {
			do {
				ID = JOptionPane.showInputDialog("No Patient With Matching ID.\nEnter Different ID or Cancel.");
			} while ( !IDS.contains(ID) && ID != null); 
			}
			myData.removePatient(myData.getPatient(ID));
			
			try {
				myData.writeToFile("output.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}

