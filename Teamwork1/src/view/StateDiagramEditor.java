package view;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JMenuBar;
import java.awt.Canvas;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.MainMediator;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;

public class StateDiagramEditor extends JFrame{
	//define private Components
	private MainMediator guiMdtr = MainMediator.getGuiMediator();
	private ButtonState btnState;
	private ButtonSelect btnSelect;
	private ButtonTransition btnTransition;
	private ButtonDelete btnDelete;
	private ButtonEdit btnEdit;
	
	//private JTextField guiStateSize;
	
	private int preX; //上一次滑鼠的座標  
	private int preY; 
	
	private int startX;  //按下滑鼠時的座標
    private int startY; 
    
    BufferedImage image = new BufferedImage(541, 322, BufferedImage.TYPE_INT_RGB);//畫圖用的image
    
    Graphics g = image.getGraphics(); //重寫Graphics中的矩形方法  
    
	/**
	 * Create the application.
	 */
	public StateDiagramEditor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("State Diagram Editor");
		getContentPane().setBackground(SystemColor.controlShadow);
		setBounds(100, 100, 726, 573);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		btnState = new ButtonState("State", guiMdtr);
		btnState.setBounds(0, 41, 139, 23);
		getContentPane().add(btnState);
		
		btnTransition = new ButtonTransition("Transition", guiMdtr);
		btnTransition.setBounds(0, 74, 139, 23);
		getContentPane().add(btnTransition);
		
		btnSelect = new ButtonSelect("Select", guiMdtr);
		btnSelect.setBackground(Color.WHITE);
		btnSelect.setBounds(0, 107, 139, 23);
		getContentPane().add(btnSelect);
		
		btnDelete = new ButtonDelete("Delete", guiMdtr);
		btnDelete.setBounds(0, 173, 139, 23);
		getContentPane().add(btnDelete);
		
		btnEdit = new ButtonEdit("Edit", guiMdtr);
		btnEdit.setBounds(0, 140, 139, 23);
		getContentPane().add(btnEdit);
		
		DrawCanvas canvas = new DrawCanvas(guiMdtr);
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(145, 41, 555, 453);
		getContentPane().add(canvas);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBounds(0, 0, 710, 21);
		getContentPane().add(menuBar);
		
		JMenu file = new JMenu("File");
		menuBar.add(file);
		
		JMenuItem menuItemOpen = new JMenuItem("Open");
		file.add(menuItemOpen);
		
		JMenuItem menuItemSave = new JMenuItem("Save");
		file.add(menuItemSave);
		
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		JMenuItem menuItemDelete = new JMenuItem("Delete");
		menuEdit.add(menuItemDelete);
		
		JMenuItem menuItemModify = new JMenuItem("Modify");
		menuEdit.add(menuItemModify);
		
		JMenuItem menuItemAdd = new JMenuItem("Add");
		menuEdit.add(menuItemAdd);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(2, 237, 139, 218);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGroup = new JLabel("Group:");
		lblGroup.setBounds(9, 10, 51, 15);
		panel.add(lblGroup);
		
		JPanel panelState = new JPanel();
		panelState.setBounds(9, 35, 121, 84);
		panelState.setBorder(new TitledBorder(null, "State", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panelState);
		panelState.setLayout(null);
		
		JLabel lblStateColor = new JLabel("Color");
		lblStateColor.setBounds(13, 27, 40, 15);
		panelState.add(lblStateColor);
		
		JComboBox comboStateColor = new JComboBox();
		comboStateColor.setBounds(53, 24, 58, 21);
		panelState.add(comboStateColor);
		comboStateColor.setEditable(true);
		
		JLabel lblStateSize = new JLabel("Size");
		lblStateSize.setBounds(13, 52, 40, 15);
		panelState.add(lblStateSize);
		
		JTextField guiStateSize = new JTextField();
		guiStateSize.setBounds(53, 52, 58, 21);
		panelState.add(guiStateSize);
		guiStateSize.setColumns(10);
		
		JComboBox comboComponentGroup = new JComboBox();
		comboComponentGroup.setBounds(58, 7, 58, 21);
		panel.add(comboComponentGroup);
		comboComponentGroup.setEditable(true);
		
		JPanel panelTransition = new JPanel();
		panelTransition.setBounds(9, 129, 121, 57);
		panelTransition.setBorder(new TitledBorder(null, "Transition", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panelTransition);
		panelTransition.setLayout(null);
		
		JLabel lblTransitionColor = new JLabel("Color");
		lblTransitionColor.setBounds(13, 27, 45, 15);
		panelTransition.add(lblTransitionColor);
		
		JComboBox comboTransitionColor = new JComboBox();
		comboTransitionColor.setBounds(53, 24, 58, 21);
		panelTransition.add(comboTransitionColor);
		comboTransitionColor.setEditable(true);
		
	}
}
