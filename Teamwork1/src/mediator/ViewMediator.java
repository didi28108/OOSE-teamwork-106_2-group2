package mediator;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import controller.Controller;
import document.DocumentOperation;
import document.SDEDocument;
import guiStrategy.FlatUI;
import guiStrategy.GuiStrategy;
import state.ChosenSelect;
import state.ChosenState;
import state.ChosenTransition;
import state.MouseState;
import statediagram.Component;
import statediagram.StateDiagram;
import view.ButtonDelete;
import view.ButtonEdit;
import view.ButtonSelect;
import view.ButtonState;
import view.ButtonTransition;
import view.DrawCanvas;
import view.EditDialog;
import view.SettingPanel;
import view.StateDiagramEditor;
import view.StatusPanel;

// combining facade and mediator
public class ViewMediator {

	//Singleton with Eager initialization 
	private static ViewMediator vMdtr = new ViewMediator();
	private Controller controller;
	private GuiStrategy guiStrategy;
	private SDEDocument dc;
	
	private ViewMediator() {
		guiStrategy = new FlatUI();
		dc = new DocumentOperation();
	}
	
	public static ViewMediator getInstance() {
		return vMdtr;
	}
	
	public void setController(Controller ctrl) {
		this.controller = ctrl;
	}
	
	//Declare
	private ButtonState buttonState;
	private ButtonSelect buttonSelect;
	private ButtonTransition buttonTransition;
	private ButtonDelete buttonDelete;
	private ButtonEdit buttonEdit;

	private StateDiagramEditor mainFrame;
	private DrawCanvas drawCanvas;
	private MouseState currentState = ChosenSelect.getInstance(); //singleton
	private StatusPanel statusPanel;
	
	private EditDialog eDialog;
	private JComboBox eDialogCbColor;
	private JComboBox eDialogCbGroup;
	private JTextField eDialogTextFieldName;

	private JMenuItem menuOpen;
	private JMenuItem menuSave;
	private JMenuItem menuExit;
	private JMenuItem menuDelete;
	private JMenuItem menuModify;
	private JMenuItem menuUndo;
	private JMenuItem menuRedo;

	private int selectedItemID = -1;
	
	private SettingPanel settingPanel;
	private JComboBox settingCbStateColor;
	private JComboBox settingCbTransColor;
	private JComboBox settingCbGroupColor;
	private JComboBox settingCbGroup;
	private boolean pressedOK;
	
	
	//**************Register****************//
	public void registerButtonState(ButtonState bState) {
		// TODO Auto-generated method stub
		this.buttonState = bState;
	}

	public void registerButtonSelect(ButtonSelect bSelect) {
		// TODO Auto-generated method stub
		this.buttonSelect = bSelect;
	}

	public void registerButtonTransition(ButtonTransition bTransition) {
		// TODO Auto-generated method stub
		this.buttonTransition = bTransition;
	}

	public void registerButtonDelete(ButtonDelete bDelete) {
		// TODO Auto-generated method stub
		this.buttonDelete = bDelete;
	}
	
	public void registerButtonEdit(ButtonEdit bEdit) {
		this.buttonEdit = bEdit;
	}
	
	public void registerDrawCanvas(DrawCanvas drawCanvas) {
		// TODO Auto-generated method stub
		this.drawCanvas = drawCanvas;
	}
	
	public void registerStatusPanel(StatusPanel sp) {
		// TODO Auto-generated method stub
		this.statusPanel = sp;
	}

	public void registerEditStateDialog(EditDialog editStateDialog) {
		// TODO Auto-generated method stub
		this.eDialog = editStateDialog;
	}

	public void registerMenuOpen(JMenuItem menuItemOpen) {
		// TODO Auto-generated method stub
		this.menuOpen = menuItemOpen;
	}

	public void registerMenuSave(JMenuItem menuItemSave) {
		// TODO Auto-generated method stub
		this.menuSave = menuItemSave;
	}

	public void registerMenuExit(JMenuItem menuItemExit) {
		// TODO Auto-generated method stub
		this.menuExit = menuItemExit;
	}

	public void registerMenuDelete(JMenuItem menuItemDelete) {
		// TODO Auto-generated method stub
		this.menuDelete = menuItemDelete;
	}

	public void registerMenuModify(JMenuItem menuItemModify) {
		// TODO Auto-generated method stub
		this.menuModify = menuItemModify;
	}

	public void registerMainFrame(StateDiagramEditor sde) {
		// TODO Auto-generated method stub
		this.mainFrame = sde;
	}
	
	public void registerMenuUndo(JMenuItem menuItemUndo) {
		// TODO Auto-generated method stub
		this.menuUndo = menuItemUndo;
	}

	public void registerMenuRedo(JMenuItem menuItemRedo) {
		// TODO Auto-generated method stub
		this.menuRedo = menuItemRedo;
	}
	

	public void registerSettingPanel(SettingPanel settingPanel) {
		// TODO Auto-generated method stub
		this.settingPanel = settingPanel;
	}
	

	public void registerEditStateDialogComboColor(JComboBox cbColor) {
		// TODO Auto-generated method stub
		this.eDialogCbColor = cbColor;
	}

	public void registerEditStateDialogComboGroup(JComboBox cbGroup) {
		// TODO Auto-generated method stub
		this.eDialogCbGroup = cbGroup;
	}

	public void registerEditStateDialogTextFieldName(JTextField textFieldName) {
		// TODO Auto-generated method stub
		this.eDialogTextFieldName = textFieldName;
	}
	
	public void registerComboStateColor(JComboBox comboStateColor) {
		// TODO Auto-generated method stub
		this.settingCbStateColor = comboStateColor;
	}

	public void registerComboTransColor(JComboBox comboTransitionColor) {
		// TODO Auto-generated method stub
		this.settingCbTransColor = comboTransitionColor;
	}

	public void registerComboGroupColor(JComboBox comboGroupColor) {
		// TODO Auto-generated method stub
		this.settingCbGroupColor = comboGroupColor;
	}

	public void registerComboComponentGroup(JComboBox comboComponentGroup) {
		// TODO Auto-generated method stub
		this.settingCbGroup = comboComponentGroup;
	}
	
	/*****************/
	/*  Action Event */
	/*****************/
	public void transClick(ActionEvent e) {
		changeState(ChosenTransition.getInstance());
		this.setSelectedItemID(-1);
		System.out.println("trans btn clicked");
	}
	
	public void stateClick(ActionEvent e) {
		changeState(ChosenState.getInstance());
		this.setSelectedItemID(-1);
		System.out.println("state btn clicked");
	}
	
	public void selectClick(ActionEvent e) {
		changeState(ChosenSelect.getInstance());
		System.out.println("select btn clicked");
	}
	
	public void editClick(ActionEvent e) {
		System.out.println("Edit btn clicked");
		if(getSelectedItemID() != -1) {
			showDialog();
		}
	}
	
	public void deleteClick(ActionEvent e) {
		System.out.println("Delete btn clicked");
		this.removeComponent();
	}
	
	public void openFileBtnClicked() {
		//delegate SDEDocument to open document
		dc.openDocument(getStateDiagram(), this.drawCanvas);
		repaint();

	}

	public void saveFileBtnClicked() {
		//delegate SDEDocument to save document
		dc.saveDocument(getStateDiagram());

	}
	
	/*********/
	
	//Change mouse state and update status
	public void changeState(MouseState newState) {
		currentState = newState;
		setSelectedStateText(currentState.getMouseStateText());
	}

	// return current chosen mouse state
	public MouseState getCurrentState() {
		return currentState;
	}
	
	//****************Status************//
	//update mouse position
	public void setCoordinates(MouseEvent e) {
		// TODO Auto-generated method stub
		statusPanel.setCoordinates(e.getX(), e.getY());
	}
	
	//update selected item status
	public void setSelectedItemText() {
		String Text = "None";
		if(selectedItemID != -1) {
			Text = this.getSelectedItemText();
		}
		statusPanel.setSelectedItem(Text);
	}
	
	//update chosen state status (ex. State, Transition and Select)
	public void setSelectedStateText(String text) {
		statusPanel.setSelectedState(text);
	}
	
	//*********************Diagram*********************//
	
	//draw State
	public void addState(MouseEvent e) {
		controller.addState(e);
	}
	
	// draw transition
	public void addTranstion(MouseEvent e, Component s1, Component s2) {
		controller.addTranstion(e, s1, s2);
	}
	
	//Set Selected Component Text
	public void setComponentText(String text) {
		controller.setComponentText(text);
	}

	//Get Selected Component Text
	public String getSelectedItemText() {
		return controller.getSelectedItemText();
	}

	//record selected(clicked) component ID
	public void setSelectedItemID(int id) {
		this.selectedItemID = id;
		setSelectedItemText();

		buttonRefresh();
	}
	
	//get selected(clicked) component ID
	public int getSelectedItemID() {
		return this.selectedItemID;
	}

	//remove component from state diagram by ID
	public void removeComponent() {
		controller.removeComponent();
	}
	
	public StateDiagram getStateDiagram() {
		return controller.getStateDiagram();
	}
	
	
	
	
	//**************Mouse Event***********//
	public void mouseClicked(MouseEvent e) {
		currentState.mouseClicked(this, e);
	}
	
	public void mouseDragged(MouseEvent e) {
		currentState.mouseDragged(this, e);
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		currentState.mousePressed(this, e);
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		currentState.mouseReleased(this, e);
	}

	//Change Position and repaint when drag the component
	public void changePoint(MouseEvent e, Component comp) {
		// TODO Auto-generated method stub
		comp.changePoint(e.getPoint());
		repaint();
	}
	
	
	//***************Edit Dialog***************//
	//show up the edit dialog
	public void showDialog() {
		if(eDialog == null) {
			eDialog = new EditDialog();
			this.refreshColorComboBoxItem(eDialogCbColor, getColorStringList());
		}
		this.eDialogTextFieldName.setText(getSelectedItemText());
		this.refreshGroupComboBoxItem(eDialogCbGroup, getGroupList());
		this.eDialogCbGroup.setSelectedItem((Integer)getGroupByID());
		eDialog.showDialog();
	}
	
	public void closeMainFrame() {
		mainFrame.dispose();
	}

	//*********Draw Canvas****************//
	public void repaint() {
		drawCanvas.repaint();
		controller.saveAction();
	}
	public void repaintWithoutSave() {
		drawCanvas.repaint();
	}

	public void undoClick(ActionEvent e) {
		// TODO Auto-generated method stub
		controller.undoAction();
	}
	public void redoClick(ActionEvent e) {
		controller.redoAction();
	}

	public void setComponentColor(Object selectedItem) {
		// TODO Auto-generated method stub
		controller.changeColor(selectedItem.toString());
	}
	
	public void setStateSubject(String color) {
		controller.setStateSubject(color);
	}
	public void setTransitionSubject(String color) {
		controller.setTransitionSubject(color);
	}

	public ArrayList<String> getColorStringList() {
		return controller.getColorStringList();
	}

	public void initSettingComboBox() {
		// TODO Auto-generated method stub
		refreshColorComboBoxItem(settingCbGroupColor, getColorStringList());
		refreshColorComboBoxItem(settingCbStateColor, getColorStringList());
		refreshColorComboBoxItem(settingCbTransColor, getColorStringList());
		refreshGroupComboBoxItem(settingCbGroup, getGroupList());
	}

	public void changeStateSize(int size) {
		// TODO Auto-generated method stub
		controller.changeStateSize(size);
		repaint();
	}

	public void buttonRefresh() {
		// TODO Auto-generated method stub
		if(this.selectedItemID != -1) {
			this.buttonDelete.setEnabled(true);
			this.buttonEdit.setEnabled(true);
			this.menuDelete.setEnabled(true);
			this.menuModify.setEnabled(true);
		}
		else {
			this.buttonDelete.setEnabled(false);
			this.buttonEdit.setEnabled(false);
			this.menuDelete.setEnabled(false);
			this.menuModify.setEnabled(false);
		}
	}

	public ArrayList<Integer> getGroupList() {
		// TODO Auto-generated method stub
		return controller.getGroupList();
	}

	public void addNewGroup() {
		// TODO Auto-generated method stub
		controller.addNewGroup(getGroupList().size()+1);
		refreshGroupComboBoxItem(settingCbGroup, getGroupList());
	}
	
	public void refreshGroupComboBoxItem(JComboBox cb, ArrayList<Integer> list) {
		cb.removeAllItems();
		for(int i =0; i < list.size();i++) {
			cb.addItem(list.get(i));
		}
	}
	
	public void refreshColorComboBoxItem(JComboBox cb, ArrayList<String> list) {
		cb.removeAllItems();
		for(int i =0; i < list.size();i++) {
			cb.addItem(list.get(i));
		}
	}
	
	public int getGroupByID() {
		System.out.println("Group ID: " +controller.getGroupByID());
		return controller.getGroupByID();
	}

	public void setComponentGroup(Object selectedGroup) {
		// TODO Auto-generated method stub
		controller.changeGroup(getSelectedItemID(), Integer.parseInt(selectedGroup.toString()));
	}
	
	public void changeGroupColor() {
		// TODO Auto-generated method stub
		int group = settingPanel.getSelectedGroupText();
		String color = settingPanel.getGroupSelectedColorText();
		System.out.println("vMdtr.changeGroupColor  " + group + color);
		controller.changeGroupColor(group, color);
		repaint();
	}

	public void changeGuiStrategy(GuiStrategy s) {
		this.guiStrategy = s;
		handleGuiStrategy();
	}
	
	public void handleGuiStrategy() {
		this.buttonDelete.setBackground(guiStrategy.changeButton());
		this.buttonEdit.setBackground(guiStrategy.changeButton());
		this.buttonSelect.setBackground(guiStrategy.changeButton());
		this.buttonState.setBackground(guiStrategy.changeButton());
		this.buttonTransition.setBackground(guiStrategy.changeButton());
		
		this.buttonDelete.setForeground(guiStrategy.changeButtonFont());
		this.buttonEdit.setForeground(guiStrategy.changeButtonFont());
		this.buttonSelect.setForeground(guiStrategy.changeButtonFont());
		this.buttonState.setForeground(guiStrategy.changeButtonFont());
		this.buttonTransition.setForeground(guiStrategy.changeButtonFont());
		
		this.settingPanel.setBackground(guiStrategy.changePanel());
		
	}

}
