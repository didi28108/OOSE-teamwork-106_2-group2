package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.ViewMediator;

public class BorderPanel extends JPanel{
	
	public BorderPanel() {
		Border bdr = init();
		this.setBorder(bdr);
	}
	
	public BorderPanel(String text) {
		Border bdr = init();
		Border titlebdr = BorderFactory.createTitledBorder(bdr, text);
		this.setBorder(titlebdr);
	}
	
	public Border init() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.LIGHT_GRAY);
		Border bdr = BorderFactory.createEtchedBorder(Color.WHITE,Color.WHITE);
		return bdr;
	}
}
