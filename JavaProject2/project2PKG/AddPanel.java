package project2PKG;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

//import project2PKG.MainPanel.AddPanelListener;

public class AddPanel extends JPanel {
	private final int WIDTH = 800, HEIGHT = 500;   
	private JPanel home;

	private JButton showControlPanel;
	private JButton Submit;

	private JLabel ID;
	private JLabel NAME;
	private JLabel ACEs;

	private AceDataManagerADT myData;
	private ArrayList<String> ids;
	private PatientADT temp;

	private String tempID;
	private String tempName;

	private JTextField IDstring;
	private JTextField Namestring;

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




	public AddPanel(JPanel x, AceDataManagerADT y, ArrayList<String> z)
	{	
		home = x;
		myData = y;
		ids = z;
		temp = new Patient<String>();
//		setVisible(true);

		showControlPanel = new JButton("Back");
		showControlPanel.setBounds(10, 10, 83, 23);
		showControlPanel.addActionListener(new AddPanelListener());
		setLayout(null);
		add(showControlPanel);

		ID = new JLabel("ID:");
		ID.setBounds(264, 80, 30, 14);
		NAME = new JLabel("Name:");
		NAME.setBounds(242, 108, 38, 14);
		ACEs = new JLabel("ACEs:");
		ACEs.setBounds(244, 133, 38, 14);


		IDstring = new JTextField();
		IDstring.setBounds(288, 80, 215, 20);
		Namestring = new JTextField();
		Namestring.setBounds(288, 108, 215, 20);


		ACE1 = new JCheckBox("Physical abuse");
		ACE1.setBounds(288, 161, 215, 23);
		ACE2 = new JCheckBox("Sexual abuse");
		ACE2.setBounds(288, 187, 215, 23);
		ACE3 = new JCheckBox("Emotional abuse");
		ACE3.setBounds(288, 213, 215, 23);
		ACE4 = new JCheckBox("Physical neglect");
		ACE4.setBounds(288, 239, 215, 23);
		ACE5 = new JCheckBox("Emotional neglect");
		ACE5.setBounds(288, 265, 215, 23);
		ACE6 = new JCheckBox("Exposure to domestic violence");
		ACE6.setBounds(288, 291, 215, 23);
		ACE7 = new JCheckBox("Household substance abuse");
		ACE7.setBounds(288, 317, 215, 23);
		ACE8 = new JCheckBox("Household mental illness");
		ACE8.setBounds(288, 343, 215, 23);
		ACE9 = new JCheckBox("Parental separation or divorce");
		ACE9.setBounds(288, 369, 215, 23);
		ACE10 = new JCheckBox("Incarcerated household member");
		ACE10.setBounds(288, 395, 215, 23);



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

		Submit = new JButton("Submit");
		Submit.setBounds(701, 467, 89, 23);
		Submit.addActionListener(new SubmitListener());
		add(Submit);
		add(ACE10);

		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		setBackground (Color.LIGHT_GRAY);
	}


	private class AddPanelListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
//			ACE1.setSelected(false);
//			ACE2.setSelected(false);
//			ACE3.setSelected(false);
//			ACE4.setSelected(false);
//			ACE5.setSelected(false);
//			ACE6.setSelected(false);
//			ACE7.setSelected(false);
//			ACE8.setSelected(false);
//			ACE9.setSelected(false);
//			ACE10.setSelected(false);
//
//			IDstring.setText("");
//			Namestring.setText("");


			setVisible(false);
			home.setVisible(true);
		}
	}

	private class SubmitListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			//addPatient


			if(Namestring.getText() == "")
			{
				do {

					tempName = JOptionPane.showInputDialog("You did not enter a patient name. Please enter a Name.");
					if(Namestring.getText() != "")
						temp.setId(tempID);

				} while (Namestring.getText() == ""); 
			}else 
				temp.setName(Namestring.getText());


			if(ids.contains(IDstring.getText()))
			{
				do {

					tempID = JOptionPane.showInputDialog("The ID you entered already exists. Please enter a new ID.");
					if(!ids.contains(tempID))
						temp.setId(tempID);

				} while (ids.contains(tempID)); 
			}
			else 
				temp.setId(IDstring.getText());


			if(ACE1.isSelected())
				temp.addACE("Physical abuse");

			if(ACE2.isSelected())
				temp.addACE("Sexual abuse");

			if(ACE3.isSelected())
				temp.addACE("Emotional abuse");

			if(ACE4.isSelected())
				temp.addACE("Physical neglect");

			if(ACE5.isSelected())
				temp.addACE("Emotional neglect");

			if(ACE6.isSelected())
				temp.addACE("Exposure to domestic violence");

			if(ACE7.isSelected())
				temp.addACE("Household substance abuse");


			if(ACE8.isSelected())
				temp.addACE("Household mental illness");

			if(ACE9.isSelected())
				temp.addACE("Parental separation or divorce");

			if(ACE10.isSelected())
				temp.addACE("Incarcerated household member");

			myData.addPatient(temp);

			try {
				myData.writeToFile("output.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


//			IDstring.setText("");
//			Namestring.setText("");
//
//			ACE1.setSelected(false);
//			ACE2.setSelected(false);
//			ACE3.setSelected(false);
//			ACE4.setSelected(false);
//			ACE5.setSelected(false);
//			ACE6.setSelected(false);
//			ACE7.setSelected(false);
//			ACE8.setSelected(false);
//			ACE9.setSelected(false);
//			ACE10.setSelected(false);


			setVisible(false);
			home.setVisible(true);
		}
	}


}

