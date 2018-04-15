package view;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;

import java.awt.BorderLayout;
import java.awt.Canvas;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.ViewMediator;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;

public class StateDiagramEditor extends JFrame{
	
	private ViewMediator vMdtr = ViewMediator.getGuiMediator();
	
	//private GridBagLayout gbl = new GridBagLayout();
    
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 500));
		
		JPanel left = new JPanel(new BorderLayout(5, 5));
		PanelButton panelButton = new PanelButton();
		BorderPanel borderPanel = new BorderPanel("State Diagram");
		DrawCanvas canvas = new DrawCanvas();
		SettingPanel settingPanel = new SettingPanel();
		StatusPanel statusPnael = new StatusPanel();
		borderPanel.add(canvas, BorderLayout.CENTER);
		
		canvas.setPreferredSize(new Dimension(800, 600));
		borderPanel.add(statusPnael, BorderLayout.SOUTH);
		getContentPane().add(borderPanel, BorderLayout.CENTER);
		left.add(panelButton, BorderLayout.NORTH);
		left.add(settingPanel, BorderLayout.CENTER);
		getContentPane().add(left, BorderLayout.WEST);
		
		//Menu Bar
		MenuBar menuBar = new MenuBar();
		this.setJMenuBar(menuBar);
		
		vMdtr.registerMainFrame(this);

		/* GridBagLayout
		getContentPane().setLayout(gbl);
		easyConstraints(gbl, panelButton, 1, 1, 0, 0, 0.1, 0.1);
		easyConstraints(gbl, canvas, 1, 2, 1, 0, 1.0, 1.0);
		easyConstraints(gbl, settingPanel, 1, 1, 0, 1, 0.1, 0.1);
		*/
		
	}
	
	
	/*
	private void easyConstraints(GridBagLayout GLB, JComponent Comp, int w, int h, int x, int y, double wx, double wy) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.weightx = wx;
		constraints.weighty = wy;
		gbl.setConstraints(Comp, constraints);
	}
	*/
}
