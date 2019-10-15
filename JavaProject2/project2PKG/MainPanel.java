package project2PKG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel {
	   private final int WIDTH = 400, HEIGHT = 500;
	   
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
		   
		   
		   setPreferredSize (new Dimension(WIDTH, HEIGHT));
		   setBackground (Color.RED);
		   
		   controlPanel = new JPanel();
		   controlPanel.setPreferredSize (new Dimension(WIDTH, HEIGHT));
		   controlPanel.setBackground (Color.GRAY);		   
		   
		   
		   
		   showAddPanel = new JButton("Add Patient");
		   showAddPanel.setBounds(133, 128, 126, 23);
		   showAddPanel.addActionListener(new AddPanelListener());
		   
		   showEditPanel = new JButton("Edit Patient");
		   showEditPanel.setBounds(133, 161, 126, 23);
		   showEditPanel.addActionListener(new EditPanelListener());
		   
		   removePatient = new JButton("Remove Patient");
		   removePatient.setBounds(133, 194, 126, 23);
		   removePatient.addActionListener(new RemoveListener());
		
		  
		   
		   addpanel = new AddPanel(controlPanel);
		   editpanel = new EditPanel(controlPanel);
	      
	      
	      
	      
	      
	      		   
	      		   
	      		   
	      		   
		   
	      
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
				   controlPanel.setVisible(false);
				   addpanel.setVisible(true);
		   }
	   }
	   
	   private class EditPanelListener implements ActionListener {
		   public void actionPerformed (ActionEvent event) {
				   controlPanel.setVisible(false);
				   editpanel.setVisible(true);  
		   }
	   }
	   
	   private class RemoveListener implements ActionListener {
		   public void actionPerformed (ActionEvent event) {
			  // do {
				   try {
					   ID = JOptionPane.showInputDialog("Enter a Patient ID:");
				   } catch (Exception e) {
					   ID = null;
				   } 
			   //} while (ID != An Existing ID && ID != Blank); 
		   }
	   }
}

