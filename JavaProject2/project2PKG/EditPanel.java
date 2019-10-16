package project2PKG;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

//import project2PKG.MainPanel.AddPanelListener;

public class EditPanel extends JPanel {
	private final int WIDTH = 400, HEIGHT = 500;   
	private JPanel home;

	private JButton showControlPanel;
	private JButton Submit;
	private JButton Load;

	private AceDataManagerADT myData;
	private ArrayList ids;
	private PatientADT temp;
	

	private JLabel ID;
	private JLabel NAME;
	private JLabel ACEs;

	private JComboBox IDstring;
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




	public EditPanel(JPanel x, AceDataManagerADT y)
	{	
		home = x;
		myData= y;
		ids = myData.getIDs();
		Collections.sort(ids);


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
		ID.setBounds(96, 80, 30, 14);
		NAME = new JLabel("Name:");
		NAME.setBounds(78, 109, 38, 14);
		ACEs = new JLabel("ACEs:");
		ACEs.setBounds(78, 134, 38, 14);


		IDstring = new JComboBox();
		IDstring.setModel(new DefaultComboBoxModel(ids.toArray()));
		IDstring.setBounds(126, 77, 171, 20);
		Namestring = new JTextField();
		Namestring.setBounds(126, 106, 171, 20);


		ACE1 = new JCheckBox("ACE1");
		ACE1.setBounds(128, 154, 77, 23);
		ACE2 = new JCheckBox("ACE2");
		ACE2.setBounds(128, 180, 77, 23);
		ACE3 = new JCheckBox("ACE3");
		ACE3.setBounds(128, 206, 77, 23);
		ACE4 = new JCheckBox("ACE4");
		ACE4.setBounds(128, 232, 77, 23);
		ACE5 = new JCheckBox("ACE5");
		ACE5.setBounds(128, 258, 77, 23);
		ACE6 = new JCheckBox("ACE6");
		ACE6.setBounds(128, 284, 77, 23);
		ACE7 = new JCheckBox("ACE7");
		ACE7.setBounds(128, 310, 77, 23);
		ACE8 = new JCheckBox("ACE8");
		ACE8.setBounds(128, 336, 77, 23);
		ACE9 = new JCheckBox("ACE9");
		ACE9.setBounds(128, 362, 77, 23);
		ACE10 = new JCheckBox("ACE10");
		ACE10.setBounds(128, 388, 77, 23);



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
		Submit.setBounds(301, 467, 89, 23);
		Submit.addActionListener(new SubmitListener());
		add(Submit);


		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		setBackground (Color.LIGHT_GRAY);

	}

	private class EditPanelListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
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

			IDstring.setSelectedIndex(0);
			Namestring.setText("");

			setVisible(false);
			home.setVisible(true);
		}
	}

	private class SubmitListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {

			//ACE1.isSelected();
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

			
			try {
				myData.writeToFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			IDstring.setSelectedIndex(0);
			Namestring.setText("");
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

			setVisible(false);
			home.setVisible(true);
		}
	}

	private class LoadListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
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
		}
	}


}

