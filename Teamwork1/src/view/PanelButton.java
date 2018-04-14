package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class PanelButton extends JPanel{
	private ButtonState btnState = new ButtonState("State");
	private ButtonTransition btnTransition = new ButtonTransition("Transition");
	private ButtonSelect btnSelect = new ButtonSelect("Select");
	private ButtonDelete btnDelete = new ButtonDelete("Delete");
	private ButtonEdit btnEdit = new ButtonEdit("Edit");
	
	private GridBagLayout gbl = new GridBagLayout();
	
	public PanelButton(){
		this.setLayout(new GridLayout(0, 1, 5, 5));
		this.add(btnState);
		this.add(btnTransition);
		this.add(btnSelect);
		this.add(btnDelete);
		this.add(btnEdit);
	}
}
