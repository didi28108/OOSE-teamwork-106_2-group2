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

import listeners.DeleteListener;
import listeners.EditListener;
import listeners.BtnSelectListener;
import listeners.BtnStateListener;
import listeners.BtnTransListener;

public class PanelButton extends JPanel{
	private ButtonState btnState;
	private ButtonTransition btnTransition;
	private ButtonSelect btnSelect;
	private ButtonDelete btnDelete;
	private ButtonEdit btnEdit;
	
	private GridBagLayout gbl = new GridBagLayout();
	
	public PanelButton(){
		this.setLayout(new GridLayout(0, 1, 5, 5));
		
		btnState = new ButtonState("State");
		btnTransition = new ButtonTransition("Transition");
		btnSelect = new ButtonSelect("Select");
		btnDelete = new ButtonDelete("Delete");
		btnEdit = new ButtonEdit("Edit");
		
		this.add(btnState);
		this.add(btnTransition);
		this.add(btnSelect);
		this.add(btnDelete);
		this.add(btnEdit);
		
		btnState.addActionListener(new BtnStateListener());
		btnTransition.addActionListener(new BtnTransListener());
		btnSelect.addActionListener(new BtnSelectListener());
		btnDelete.addActionListener(new DeleteListener());
		btnEdit.addActionListener(new EditListener());
	}
}
