package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditStateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_State_Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditStateDialog dialog = new EditStateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditStateDialog() {
		setTitle("Edit State Dialog");
		setBounds(100, 100, 450, 371);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel Label_Please_define_the_state = new JLabel("Please define the state.");
		Label_Please_define_the_state.setBounds(10, 10, 234, 15);
		contentPanel.add(Label_Please_define_the_state);
		
		JLabel Label_State_Name = new JLabel("State Name:");
		Label_State_Name.setBounds(10, 111, 101, 15);
		contentPanel.add(Label_State_Name);
		
		textField_State_Name = new JTextField();
		textField_State_Name.setBounds(116, 108, 219, 21);
		contentPanel.add(textField_State_Name);
		textField_State_Name.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 147, 434, 153);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("State Condition:\r\n");
		lblNewLabel_2.setBounds(10, 10, 128, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter a piece of program to define the state.");
		lblNewLabel_3.setBounds(20, 35, 284, 15);
		panel.add(lblNewLabel_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 60, 414, 83);
		panel.add(textArea);
		
		JLabel Label_Group = new JLabel("Group:");
		Label_Group.setBounds(10, 47, 46, 15);
		contentPanel.add(Label_Group);
		
		JComboBox comboBox_Subject = new JComboBox();
		comboBox_Subject.setEditable(true);
		comboBox_Subject.setBounds(116, 44, 219, 21);
		contentPanel.add(comboBox_Subject);
		
		JLabel Label_Color = new JLabel("Color:");
		Label_Color.setBounds(10, 80, 147, 15);
		contentPanel.add(Label_Color);
		
		JComboBox comboBox_Color = new JComboBox();
		comboBox_Color.setEditable(true);
		comboBox_Color.setBounds(116, 77, 219, 21);
		contentPanel.add(comboBox_Color);
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
