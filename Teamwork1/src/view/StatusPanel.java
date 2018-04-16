package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import mediator.ViewMediator;

public class StatusPanel extends JPanel{
	private JLabel posText = new JLabel("Position: ");
	private JLabel coordX = new JLabel("0", JLabel.RIGHT);
	private JLabel coordY = new JLabel("0", JLabel.RIGHT);
	private JLabel wall = new JLabel("   ||   "); //區隔用
	private JLabel itemText = new JLabel("Selected Item: ");
	private JLabel selectedItem = new JLabel("None", JLabel.LEFT);
	private JLabel wall2 = new JLabel("   ||   "); //區隔用
	private JLabel stateText = new JLabel("Mouse State: ");
	private JLabel selectedState = new JLabel("Select", JLabel.LEFT);
	
	private ViewMediator mdtr = ViewMediator.getInstance();

	public StatusPanel() {
		this.setLayout(new FlowLayout());
		this.add(posText);
		this.add(coordX);
		this.add(coordY);
		this.add(wall);
		this.add(itemText);
		selectedItem.setForeground(Color.red);
		this.add(selectedItem);
		this.add(wall2);
		this.add(stateText);
		selectedState.setForeground(Color.red);
		this.add(selectedState);
		this.setBackground(Color.LIGHT_GRAY);
		mdtr.registerStatusPanel(this);
	}
	
	public void setCoordinates(int x, int y) {
		coordX.setText(Integer.toString(x));
		coordY.setText(Integer.toString(y));
	}
	
	public void setSelectedItem(String s) {
		selectedItem.setText(s);
	}
	
	public void setSelectedState(String s) {
		selectedState.setText(s);
	}
}
