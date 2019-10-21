//Luke Russenberger
//CSCI 3381
package project2PKG;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

//import project2PKG.MainPanel.AddPanelListener;

//Panel used to edit and view existing patients
public class EditPanel extends JPanel {
	private final int WIDTH = 800, HEIGHT = 500;   
	private JPanel home;

	//Buttons
	private JButton showControlPanel;
	private JButton Submit;
	private JButton Load;

	//Project 1 stuff
	private AceDataManagerADT myData;
	private ArrayList<String> ids;
	private ArrayList<String> tempRF;
	private String RFs;
	private PatientADT temp;

	private boolean test = false;

	//Labels
	private JLabel ID;
	private JLabel NAME;
	private JLabel ACEs;
	private JLabel RISKS;

	//Stuff
	private JComboBox<String> IDstring;
	private JTextField Namestring;
	private JTextPane RiskFactors;
	private JScrollPane jsp;

	//Check boxes for aces
	private JCheckBox ACE1;
	private JCheckBox ACE2;
	private JCheckBox ACE3;
	private JCheckBox ACE4;
	private JCheckBox ACE5;
	private JCheckBox ACE6;
	private JCheckBox ACE7;
	private JCheckBox ACE8;
	private JCheckBox ACE9;
	private JCheckBox ACE10;



	//Does the stuff
	public EditPanel(JPanel x, AceDataManagerADT y)
	{	
		home = x;
		myData= y;
		ids=null;
		ids = myData.getIDs();
		//puts the IDs in order
		Collections.sort(ids);
		tempRF= new ArrayList<String>();

		//setVisible(true);

		showControlPanel = new JButton("Back");
		showControlPanel.setBounds(10, 10, 83, 23);
		showControlPanel.addActionListener(new EditPanelListener());
		setLayout(null);
		add(showControlPanel);

		Load = new JButton("Load");
		Load.setBounds(307, 76, 83, 23);
		Load.addActionListener(new LoadListener());
		add(Load);

		ID = new JLabel("ID:");
		ID.setBounds(89, 80, 30, 14);
		NAME = new JLabel("Name:");
		NAME.setBounds(71, 109, 38, 14);
		ACEs = new JLabel("ACEs:");
		ACEs.setBounds(71, 137, 38, 14);
		RISKS = new JLabel("Risk Factors");
		RISKS.setBounds(555, 52, 106, 14);

		IDstring = new JComboBox<String>();
		//Sets the combo box to contain a list of all existing IDs
		IDstring.setModel(new DefaultComboBoxModel(ids.toArray()));
		IDstring.setBounds(113, 77, 184, 20);
		Namestring = new JTextField();
		Namestring.setBounds(113, 106, 184, 20);

		RiskFactors = new JTextPane();
		RiskFactors.setBounds(420, 76, 334, 339);
		jsp = new JScrollPane(RiskFactors);
		jsp.setBounds(420, 76, 334, 339);


		ACE1 = new JCheckBox("Physical abuse");
		ACE1.setBounds(113, 158, 215, 23);
		ACE2 = new JCheckBox("Sexual abuse");
		ACE2.setBounds(113, 184, 215, 23);
		ACE3 = new JCheckBox("Emotional abuse");
		ACE3.setBounds(113, 210, 215, 23);
		ACE4 = new JCheckBox("Physical neglect");
		ACE4.setBounds(113, 236, 215, 23);
		ACE5 = new JCheckBox("Emotional neglect");
		ACE5.setBounds(113, 262, 215, 23);
		ACE6 = new JCheckBox("Exposure to domestic violence");
		ACE6.setBounds(113, 288, 215, 23);
		ACE7 = new JCheckBox("Household substance abuse");
		ACE7.setBounds(113, 314, 215, 23);
		ACE8 = new JCheckBox("Household mental illness");
		ACE8.setBounds(113, 340, 215, 23);
		ACE9 = new JCheckBox("Parental separation or divorce");
		ACE9.setBounds(113, 366, 215, 23);
		ACE10 = new JCheckBox("Incarcerated household member");
		ACE10.setBounds(113, 392, 215, 23);


		add(RISKS);
		add(jsp);
		add(ID);
		add(IDstring);
		add(NAME);
		add(Namestring);
		add(ACEs);
		add(ACE1);
		add(ACE2);
		add(ACE3);
		add(ACE4);
		add(ACE5);
		add(ACE6);
		add(ACE7);
		add(ACE8);
		add(ACE9);
		add(ACE10);

		Submit = new JButton("Submit");
		Submit.setBounds(701, 467, 89, 23);
		Submit.addActionListener(new SubmitListener());
		add(Submit);


		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		setBackground (Color.LIGHT_GRAY);

	}

	//Goes back to home screen
	private class EditPanelListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			setVisible(false);
			home.setVisible(true);
		}
	}
	
	//Saves changes to patients
	private class SubmitListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {

			if(test) {
				if(ACE1.isSelected())
					temp.addACE("Physical abuse");
				else temp.removeACE("Physical abuse");

				if(ACE2.isSelected())
					temp.addACE("Sexual abuse");
				else temp.removeACE("Sexual abuse");

				if(ACE3.isSelected())
					temp.addACE("Emotional abuse");
				else temp.removeACE("Emotional abuse");

				if(ACE4.isSelected())
					temp.addACE("Physical neglect");
				else temp.removeACE("Physical neglect");

				if(ACE5.isSelected())
					temp.addACE("Emotional neglect");
				else temp.removeACE("Emotional neglect");

				if(ACE6.isSelected())
					temp.addACE("Exposure to domestic violence");
				else temp.removeACE("Exposure to domestic violence");

				if(ACE7.isSelected())
					temp.addACE("Household substance abuse");
				else temp.removeACE("Household substance abuse");

				if(ACE8.isSelected())
					temp.addACE("Household mental illness");
				else temp.removeACE("Household mental illness");

				if(ACE9.isSelected())
					temp.addACE("Parental separation or divorce");
				else temp.removeACE("Parental separation or divorce");

				if(ACE10.isSelected())
					temp.addACE("Incarcerated household member");
				else temp.removeACE("Incarcerated household member");
			}

			test = false;
			IDstring.setSelectedIndex(0);
			Namestring.setText("");
			RiskFactors.setText("");
			ACE1.setSelected(false);
			ACE2.setSelected(false);
			ACE3.setSelected(false);
			ACE4.setSelected(false);
			ACE5.setSelected(false);
			ACE6.setSelected(false);
			ACE7.setSelected(false);
			ACE8.setSelected(false);
			ACE9.setSelected(false);
			ACE10.setSelected(false);

			//			setVisible(false);
			//			home.setVisible(true);
		}
	}

	//Loads all info for the patient with the selected ID
	private class LoadListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			test = true;

			temp = myData.getPatient(IDstring.getSelectedItem().toString());
			Namestring.setText(temp.getName());





			if(temp.getACEs().contains("Physical abuse"))
				ACE1.setSelected(true);
			else ACE1.setSelected(false);

			if(temp.getACEs().contains("Sexual abuse"))
				ACE2.setSelected(true);
			else ACE2.setSelected(false);

			if(temp.getACEs().contains("Emotional abuse"))
				ACE3.setSelected(true);
			else ACE3.setSelected(false);

			if(temp.getACEs().contains("Physical neglect"))
				ACE4.setSelected(true);
			else ACE4.setSelected(false);

			if(temp.getACEs().contains("Emotional neglect"))
				ACE5.setSelected(true);
			else ACE5.setSelected(false);

			if(temp.getACEs().contains("Exposure to domestic violence"))
				ACE6.setSelected(true);
			else ACE6.setSelected(false);

			if(temp.getACEs().contains("Household substance abuse"))
				ACE7.setSelected(true);
			else ACE7.setSelected(false);

			if(temp.getACEs().contains("Household mental illness"))
				ACE8.setSelected(true);
			else ACE8.setSelected(false);

			if(temp.getACEs().contains("Parental separation or divorce"))
				ACE9.setSelected(true);
			else ACE9.setSelected(false);

			if(temp.getACEs().contains("Incarcerated household member"))
				ACE10.setSelected(true);
			else ACE10.setSelected(false);

			tempRF= temp.getACEs();

			tempRF= myData.getRiskFactors(tempRF);

			RFs=null;

			RFs=tempRF.toString();





			RiskFactors.setText(RFs.replace("[", "").replace("]", "").replace("., ", "\n\n"));
		}
	}
}

