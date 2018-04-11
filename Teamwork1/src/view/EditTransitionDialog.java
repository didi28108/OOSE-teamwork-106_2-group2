package view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class EditTransitionDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditTransitionDialog dialog = new EditTransitionDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditTransitionDialog() {
		setTitle("Edit Transition Dialog");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPleaseDefineThe = new JLabel("Please define the transition.");
			lblPleaseDefineThe.setBounds(10, 10, 259, 15);
			contentPanel.add(lblPleaseDefineThe);
		}
		
		JLabel label = new JLabel("Group:");
		label.setBounds(10, 38, 46, 15);
		contentPanel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(143, 32, 219, 21);
		contentPanel.add(comboBox);
		
		JLabel label_1 = new JLabel("Color:");
		label_1.setBounds(10, 71, 147, 15);
		contentPanel.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(143, 65, 219, 21);
		contentPanel.add(comboBox_1);
		
		JLabel lblTransitionName = new JLabel("Transition Name:");
		lblTransitionName.setBounds(10, 102, 123, 15);
		contentPanel.add(lblTransitionName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(143, 96, 219, 21);
		contentPanel.add(textField);
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
