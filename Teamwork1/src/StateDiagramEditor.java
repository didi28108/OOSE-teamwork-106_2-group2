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
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;

public class StateDiagramEditor {

	private JFrame frmStateDiagramEditor;
	private JTextField Gui_State_Size;
	
	private int preX; //上一次滑鼠的座標  
	private int preY; 
	
	private int startX;  //按下滑鼠時的座標
    private int startY; 
    
    BufferedImage image = new BufferedImage(541, 322, BufferedImage.TYPE_INT_RGB);//畫圖用的image
    
    Graphics g = image.getGraphics(); //重寫Graphics中的矩形方法  
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StateDiagramEditor window = new StateDiagramEditor();
					window.frmStateDiagramEditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frmStateDiagramEditor = new JFrame();
		frmStateDiagramEditor.setTitle("State Diagram Editor");
		frmStateDiagramEditor.getContentPane().setBackground(SystemColor.controlShadow);
		frmStateDiagramEditor.setBounds(100, 100, 726, 573);
		frmStateDiagramEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStateDiagramEditor.getContentPane().setLayout(null);
		
		JButton Button_State = new JButton("State");
		Button_State.setBounds(0, 41, 139, 23);
		frmStateDiagramEditor.getContentPane().add(Button_State);
		
		JButton Button_Transition = new JButton("Transition");
		Button_Transition.setBounds(0, 74, 139, 23);
		frmStateDiagramEditor.getContentPane().add(Button_Transition);
		
		JButton Button_Select = new JButton("Select");
		Button_Select.setBackground(Color.WHITE);
		Button_Select.setBounds(0, 107, 139, 23);
		frmStateDiagramEditor.getContentPane().add(Button_Select);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(145, 41, 555, 453);
		frmStateDiagramEditor.getContentPane().add(canvas);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBounds(0, 0, 710, 21);
		frmStateDiagramEditor.getContentPane().add(menuBar);
		
		JMenu Menu_Open = new JMenu("Open");
		menuBar.add(Menu_Open);
		
		JMenu Menu_Save = new JMenu("Save");
		menuBar.add(Menu_Save);
		
		JMenu Menu_Edit = new JMenu("Edit");
		menuBar.add(Menu_Edit);
		
		JMenuItem MenuItem_Delete = new JMenuItem("Delete");
		Menu_Edit.add(MenuItem_Delete);
		
		JMenuItem MenuItem_Modify = new JMenuItem("Modify");
		Menu_Edit.add(MenuItem_Modify);
		
		JMenuItem MenuItem_Add = new JMenuItem("Add");
		Menu_Edit.add(MenuItem_Add);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 164, 139, 218);
		frmStateDiagramEditor.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGroup = new JLabel("Group:");
		lblGroup.setBounds(9, 10, 51, 15);
		panel.add(lblGroup);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(9, 35, 121, 84);
		panel_1.setBorder(new TitledBorder(null, "State", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Color");
		lblNewLabel.setBounds(13, 27, 40, 15);
		panel_1.add(lblNewLabel);
		
		JComboBox Gui_comboBox_State_Color = new JComboBox();
		Gui_comboBox_State_Color.setBounds(53, 24, 58, 21);
		panel_1.add(Gui_comboBox_State_Color);
		Gui_comboBox_State_Color.setEditable(true);
		
		JLabel lblNewLabel_1 = new JLabel("Size");
		lblNewLabel_1.setBounds(13, 52, 40, 15);
		panel_1.add(lblNewLabel_1);
		
		Gui_State_Size = new JTextField();
		Gui_State_Size.setBounds(53, 52, 58, 21);
		panel_1.add(Gui_State_Size);
		Gui_State_Size.setColumns(10);
		
		JComboBox Gui_comboBox_Group = new JComboBox();
		Gui_comboBox_Group.setBounds(58, 7, 58, 21);
		panel.add(Gui_comboBox_Group);
		Gui_comboBox_Group.setEditable(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(9, 129, 121, 57);
		panel_2.setBorder(new TitledBorder(null, "Transition", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(13, 27, 45, 15);
		panel_2.add(lblColor);
		
		JComboBox Gui_comboBox_Transition = new JComboBox();
		Gui_comboBox_Transition.setBounds(53, 24, 58, 21);
		panel_2.add(Gui_comboBox_Transition);
		Gui_comboBox_Transition.setEditable(true);
	}
	
	//Strategy Pattern
	interface Strategy{
		public void handle(Context context);
	}
	 
	class SelectStrategy implements Strategy{
		public void handle(Context context){
			System.out.println("Select");
			
		}
	}
	class StateStrategy implements Strategy{
		public void handle(Context context){
			System.out.println("State");
			
		}
	}
	class TransitionStrategy implements Strategy{
		public void handle(Context context){
			System.out.println("Transition");
			
		}
	}
	class Context{
		private Strategy strategy;
		public void setState(Strategy strategy){
			this.strategy=strategy;
		}
		public void request(){
			strategy.handle(this);
		}
	
	}	
}
