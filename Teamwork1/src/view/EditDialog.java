package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ViewMediator;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditDialog extends JDialog implements ActionListener{

	private JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JLabel lblDescription;
	private JLabel lblName;
	private JLabel lblGroup;
	private JComboBox cbGroup;
	private JLabel lblColor;
	private JComboBox cbColor;
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	
	private ViewMediator vMdtr = ViewMediator.getGuiMediator();

	/**
	 * Create the dialog.
	 */
	public EditDialog() {
		vMdtr.registerEditStateDialog(this);
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Edit Dialog");
		setBounds(100, 100, 365, 283);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblDescription = new JLabel("Please define the status.");
		lblDescription.setBounds(10, 10, 234, 15);
		contentPanel.add(lblDescription);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(10, 47, 101, 15);
		contentPanel.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(116, 44, 219, 21);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		lblGroup = new JLabel("Group:");
		lblGroup.setBounds(10, 111, 46, 15);
		contentPanel.add(lblGroup);
		
		cbGroup = new JComboBox();
		cbGroup.setEditable(true);
		cbGroup.setBounds(116, 108, 219, 21);
		contentPanel.add(cbGroup);
		
		lblColor = new JLabel("Color:");
		lblColor.setBounds(10, 80, 147, 15);
		contentPanel.add(lblColor);
		
		cbColor = new JComboBox();
		cbColor.setEditable(true);
		cbColor.setBounds(116, 77, 219, 21);
		contentPanel.add(cbColor);
		
		buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	
		okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		okButton.addActionListener(this);
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	
	
		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(this);
		buttonPane.add(cancelButton);
	
		
	}
	
	public void showDialog() {
		String compName = vMdtr.getSelectedItemText();
		textFieldName.setText(compName);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if(cmd == "Cancel") {
			closeDialog();
		}else if(cmd == "OK") {
			vMdtr.setComponentText(textFieldName.getText());
			closeDialog();
		}
	}

	public void closeDialog() {
		cleanUp();
		this.dispose();
	}
	
	public void cleanUp() {
		textFieldName.setText("");
	}
}
