package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ViewMediator;

public class StatusPanel extends JPanel{
	private JLabel posText = new JLabel("Position: ");
	private JLabel coordX = new JLabel("0", JLabel.RIGHT);
	private JLabel coordY = new JLabel("0", JLabel.RIGHT);
	private ViewMediator mdtr = ViewMediator.getGuiMediator();

	public StatusPanel() {
		this.setLayout(new FlowLayout());
		this.add(posText);
		this.add(coordX);
		this.add(coordY);
		this.setBackground(Color.LIGHT_GRAY);
		mdtr.registerStatusPanel(this);
	}
	
	public void setCoordinates(int x, int y) {
		coordX.setText(Integer.toString(x));
		coordY.setText(Integer.toString(y));
	}
	
}
