package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SettingPanel extends JPanel{

	JLabel lblGroup = new JLabel("Group:");
	JPanel panelState = new JPanel();
	JLabel lblStateColor = new JLabel("Color");
	JComboBox comboStateColor = new JComboBox();
	JLabel lblStateSize = new JLabel("Size");
	JTextField guiStateSize = new JTextField();
	JComboBox comboComponentGroup = new JComboBox();
	JPanel panelTransition = new JPanel();
	JLabel lblTransitionColor = new JLabel("Color");
	JComboBox comboTransitionColor = new JComboBox();
	
	JLabel mouseXY = new JLabel("");
	JPanel panel_1 = new JPanel();

	private GridBagLayout gbl = new GridBagLayout();
	
	public SettingPanel() {
		this.setLayout(gbl);
		Border bdr = BorderFactory.createEtchedBorder(Color.black,Color.black);
		Border titlebdr = BorderFactory.createTitledBorder(bdr, "Setting");
		this.setBorder(titlebdr);
		
		this.add(lblGroup);
		this.add(comboComponentGroup);
		comboComponentGroup.setEditable(true);
		
		panelState.setBorder(new TitledBorder(null, "State", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.add(panelState);
		panelState.add(lblStateColor);
		
		panelState.add(comboStateColor);
		comboStateColor.setEditable(true);
		
		panelState.add(lblStateSize);
		
		panelState.add(guiStateSize);
		guiStateSize.setColumns(10);
		
		panelTransition.setBorder(new TitledBorder(null, "Transition", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.add(panelTransition);
		
		panelTransition.add(lblTransitionColor);
		
		panelTransition.add(comboTransitionColor);
		comboTransitionColor.setEditable(true);

		panelState.setLayout(new GridLayout(2,1));
		panelTransition.setLayout(new GridLayout(1,1));
		
		GridBagConstraints c = new GridBagConstraints();

		c.insets.left = 5;
		easyConstraints(c, gbl, lblGroup, 1, 1, 0, 0, 0.5, 1.0);

		c.insets.left = 0;
		easyConstraints(c, gbl, comboComponentGroup, 1, 1, 1, 0, 0.5, 1.0);
		c.ipadx = 0;
		
		easyConstraints(c, gbl, panelState, 2, 1, 0, 1, 0.5, 1.0);
		easyConstraints(c, gbl, panelTransition, 2, 1, 0, 2, 0.5, 1.0);
		c.weighty = 0.5;
		this.add(Box.createVerticalGlue(), c);
	}
	
	private void easyConstraints(GridBagConstraints c, GridBagLayout gbl, JComponent comp, int w, int h, int x, int y, double wx, double wy) {
		/*
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.weightx = wx;
		constraints.weighty = wy;
		gbl.setConstraints(Comp, constraints);
		*/
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.insets.top = 3;
		c.insets.bottom = 0;
		c.gridwidth = w;
		c.gridheight = h;
		c.gridx = x;
		c.gridy = y;
		c.weightx = wx;
		c.weighty = 0;
		this.add(comp, c);
	}
}
