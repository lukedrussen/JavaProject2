package project2PKG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import project2PKG.MainPanel.AddPanelListener;

public class AddPanel extends JPanel {
	private final int WIDTH = 800, HEIGHT = 500;   
	private int height;
	   private int width;
	   private JPanel home;
	   
	   private JButton showControlPanel;
	   private JButton Submit;
	   
	   private JLabel ID;
	   private JLabel NAME;
	   private JLabel ACEs;
	   
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


	   

	   public AddPanel(JPanel x)
	   {	
		  width = WIDTH;
		  height = HEIGHT;
		  home = x;
		  
		  setVisible(true);
		  
		  showControlPanel = new JButton("Back");
		  showControlPanel.setBounds(21, 5, 83, 23);
		  showControlPanel.addActionListener(new AddPanelListener());
		  setLayout(null);
		  add(showControlPanel);
		  
		  ID = new JLabel("ID:");
		  ID.setBounds(96, 80, 30, 14);
		  NAME = new JLabel("Name:");
		  NAME.setBounds(78, 109, 38, 14);
		  ACEs = new JLabel("ACEs:");
		  ACEs.setBounds(78, 134, 38, 14);
		  

		  IDstring = new JTextField();
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
		  
		  Submit = new JButton("Submit");
		  Submit.setBounds(328, 466, 89, 23);
		  Submit.addActionListener(new SubmitListener());
		  add(Submit);
		  add(ACE10);
		  
	      setPreferredSize (new Dimension(WIDTH, HEIGHT));
	      setBackground (Color.LIGHT_GRAY);
	      
	   }
	  
	   private class AddPanelListener implements ActionListener {
		   public void actionPerformed (ActionEvent event) {
				  setVisible(false);
				  home.setVisible(true);
		   }
	   }
	   
	   private class SubmitListener implements ActionListener {
		   public void actionPerformed (ActionEvent event) {
				  //addPatient
				  IDstring.setText("");
				  Namestring.setText("");
				  
				  //ACE1.isSelected();
				  
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
	   

}

