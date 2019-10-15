package project2PKG;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainPanel extends JPanel {
	   private final int WIDTH = 800, HEIGHT = 500;
	   
	   private JPanel controlPanel;
	   private AddPanel addpanel;
	   private ViewPanel viewpanel;
	   private EditPanel editpanel;
	   
	   
	   private JButton showAddPanel;
	   private JButton showViewPanel;
	   private JButton showEditPanel;
	   
	   
	   public MainPanel()
	   {
		   super(new BorderLayout());
		   
		   
		   setPreferredSize (new Dimension(WIDTH, HEIGHT));
		   setBackground (Color.RED);
		   
		   controlPanel = new JPanel();
		   controlPanel.setPreferredSize (new Dimension(WIDTH, HEIGHT));
		   controlPanel.setBackground (Color.GRAY);		   
		   
		   
		   
		   showAddPanel = new JButton("Add Patient");
		   showAddPanel.addActionListener(new AddPanelListener());
		   
		   
		
		  
		   
		   addpanel = new AddPanel(WIDTH,HEIGHT, controlPanel);
		   
	      
	      
	      
	      
	      
	      		   
	      		   
	      		   
	      		   
		   add(controlPanel, BorderLayout.WEST);
	      controlPanel.setVisible(true);
	      
	      add(addpanel);
	      
	      
	      controlPanel.add(showAddPanel);
	   }
	   
	   
	   private class AddPanelListener implements ActionListener {
		   public void actionPerformed (ActionEvent event) {
				   controlPanel.setVisible(false);
				   addpanel.setVisible(true);
				  
		   }
	   }	   
}

