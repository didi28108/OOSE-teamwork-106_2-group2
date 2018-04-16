package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;

import listeners.ChangeColorListener;
import mediator.ViewMediator;

public class SettingPanel extends JPanel{

	JLabel lblGroup = new JLabel("Group:");
	JLabel lblGroupColor = new JLabel("Color");
	JLabel lblStateColor = new JLabel("Color");
	JLabel lblStateSize = new JLabel("Size");
	JLabel lblTransitionColor = new JLabel("Color");

	JTextField textFieldStateSize = new JTextField("0");
	
	JPanel panelGroup = new JPanel();
	JPanel panelTransition = new JPanel();
	JPanel panelState = new JPanel();
	
	JComboBox comboComponentGroup = new JComboBox();
	JComboBox comboGroupColor = new JComboBox();
	JComboBox comboStateColor = new JComboBox();
	JComboBox comboTransitionColor = new JComboBox();
	
	ViewMediator vMdtr = ViewMediator.getInstance();
	
	JLabel mouseXY = new JLabel("");
	JPanel panel_1 = new JPanel();

	private GridBagLayout gbl = new GridBagLayout();
	
	public SettingPanel() {
		this.setLayout(gbl);
		
		Border bdr = BorderFactory.createEtchedBorder(Color.black,Color.black);
		Border titlebdr = BorderFactory.createTitledBorder(bdr, "Setting");
		this.setBorder(titlebdr);

		panelGroup.setBorder(new TitledBorder(null, "Group", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGroup.add(lblGroup);
		panelGroup.add(comboComponentGroup);
		panelGroup.add(lblGroupColor);
		panelGroup.add(comboGroupColor);
		this.add(panelGroup);
		comboComponentGroup.setEditable(true);
		
		panelState.setBorder(new TitledBorder(null, "State", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelState.add(lblStateColor);
		panelState.add(comboStateColor);
		panelState.add(lblStateSize);
		panelState.add(textFieldStateSize);
		textFieldStateSize.setColumns(10);
		Document textDocOne = textFieldStateSize.getDocument();
	    DocumentFilter filterOne = new IntegerRangeDocumentFilter();
	    ((AbstractDocument) textDocOne).setDocumentFilter(filterOne);
		
		this.add(panelState);
		comboStateColor.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        vMdtr.setStateSubject(getStateSelectedColorText());
		    }
		});
		
		textFieldStateSize.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
				    warn();
				  }
				  public void removeUpdate(DocumentEvent e) {
				    warn();
				  }
				  public void insertUpdate(DocumentEvent e) {
				    warn();
				  }

				  public void warn() {
			    	System.out.println("changed size: " + textFieldStateSize.getText());
			    	String text = textFieldStateSize.getText();
			    	int size;
			    	if(!text.equals("")) {
				    	size = Integer.parseInt(text);
			    	}else {
			    		size = 0;
			    	}
			    	vMdtr.changeStateSize(size);
				  }
				});
		
		panelTransition.setBorder(new TitledBorder(null, "Transition", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTransition.add(lblTransitionColor);
		panelTransition.add(comboTransitionColor);
		this.add(panelTransition);
		comboTransitionColor.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        vMdtr.setTransitionSubject(getTransSelectedColorText());
		    }
		});

		panelGroup.setLayout(new GridLayout(2,1));
		panelState.setLayout(new GridLayout(2,1));
		panelTransition.setLayout(new GridLayout(1,1));
		
		GridBagConstraints c = new GridBagConstraints();
		
		easyConstraints(c, gbl, panelGroup, 1, 1, 0, 0, 0.5, 1.0);
		easyConstraints(c, gbl, panelState, 1, 1, 0, 1, 0.5, 1.0);
		easyConstraints(c, gbl, panelTransition, 1, 1, 0, 2, 0.5, 1.0);
		c.weighty = 1.0;
		this.add(Box.createVerticalGlue(), c);
		
		vMdtr.registerSettingPanel(this);
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
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets.top = 3;
		c.insets.bottom = 0;
		c.gridwidth = w;
		c.gridheight = h;
		c.gridx = x;
		c.gridy = y;
		c.weightx = 0;
		c.weighty = 0;
		this.add(comp, c);
	}
	
	public void settingInit() {
		ArrayList<String> ar = vMdtr.getColorStringList();
		for(int i =0; i < ar.size();i++) {
			comboStateColor.addItem(ar.get(i));
			comboTransitionColor.addItem(ar.get(i));
		}
	}
	
	public String getStateSelectedColorText() {
		return this.getStateSelectedColor().toString();
	}
	
	public Object getStateSelectedColor() {
		return this.comboStateColor.getSelectedItem();
	}
	
	public String getTransSelectedColorText() {
		return this.getTransSelectedColor().toString();
	}
	
	public Object getTransSelectedColor() {
		return this.comboTransitionColor.getSelectedItem();
	}
	
	public int getSelectedGroupText() {
		return Integer.parseInt(this.getSelectedGroup().toString());
	}
	
	public Object getSelectedGroup() {
		return this.comboComponentGroup.getSelectedItem();
	}
}
