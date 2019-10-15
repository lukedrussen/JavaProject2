package project2PKG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import project2PKG.MainPanel.AddPanelListener;

public class AddPanel extends JPanel {
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
	   private JTextField ACEstring;
	   
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


	   

	   public AddPanel(int w, int h, JPanel x)
	   {	
		  width = w;
		  height = h;
		  home = x;
		  setVisible(false);
		  
		  showControlPanel = new JButton("Back");
		  showControlPanel.addActionListener(new AddPanelListener());
		  add(showControlPanel);
		  
		  Submit = new JButton("Submit");
		  Submit.addActionListener(new SubmitListener());
		  add(Submit);
		  
		  ID = new JLabel("ID:");
		  NAME = new JLabel("Name:");
		  ACEs = new JLabel("ACEs:");
		  

		  IDstring = new JTextField();
		  Namestring = new JTextField();
		  ACEstring = new JTextField();
		  
		  ACE1 = new JCheckBox("ACE1");
		  ACE2 = new JCheckBox("ACE2");
		  ACE3 = new JCheckBox("ACE3");
		  ACE4 = new JCheckBox("ACE4");
		  ACE5 = new JCheckBox("ACE5");
		  ACE6 = new JCheckBox("ACE6");
		  ACE7 = new JCheckBox("ACE7");
		  ACE8 = new JCheckBox("ACE8");
		  ACE9 = new JCheckBox("ACE9");
		  ACE10 = new JCheckBox("ACE10");
		  
		  
		  
		  add(ID);
		  add(IDstring);
		  add(NAME);
		  add(Namestring);
		  add(ACEs);
		  add(ACEstring);
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
		  
	      setPreferredSize (new Dimension(w, h));
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
		   }
	   }
	   

}

