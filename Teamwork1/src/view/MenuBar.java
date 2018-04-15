package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ViewMediator;
import listeners.MenuDeleteListener;
import listeners.MenuExitListener;
import listeners.MenuModifyListener;
import listeners.MenuOpenListener;
import listeners.MenuRedoListener;
import listeners.MenuSaveListener;
import listeners.MenuUndoListener;

public class MenuBar extends JMenuBar{
	ViewMediator vMdtr = ViewMediator.getGuiMediator();
	
	public MenuBar() {
		setToolTipText("");
		
		JMenu file = new JMenu("File");
		add(file);
		
		JMenuItem menuItemOpen = new JMenuItem("Open");
		file.add(menuItemOpen);
		
		JMenuItem menuItemSave = new JMenuItem("Save");
		file.add(menuItemSave);
		
		file.addSeparator();
		
		JMenuItem menuItemExit = new JMenuItem("Exit");
		file.add(menuItemExit);
		
		JMenu menuEdit = new JMenu("Edit");
		add(menuEdit);
		
		JMenuItem menuItemDelete = new JMenuItem("Delete");
		menuEdit.add(menuItemDelete);

		JMenuItem menuItemModify = new JMenuItem("Modify");
		menuEdit.add(menuItemModify);
		
		menuEdit.addSeparator();
		
		JMenuItem menuItemUndo = new JMenuItem("Undo");
		menuEdit.add(menuItemUndo);
		
		JMenuItem menuItemRedo = new JMenuItem("Redo");
		menuEdit.add(menuItemRedo);
		
		vMdtr.registerMenuOpen(menuItemOpen);
		vMdtr.registerMenuSave(menuItemSave);
		vMdtr.registerMenuExit(menuItemExit);
		vMdtr.registerMenuDelete(menuItemDelete);
		vMdtr.registerMenuModify(menuItemModify);
		vMdtr.registerMenuUndo(menuItemUndo);
		vMdtr.registerMenuRedo(menuItemRedo);
		
		menuItemOpen.addActionListener(new MenuOpenListener());
		menuItemSave.addActionListener(new MenuSaveListener());
		menuItemExit.addActionListener(new MenuExitListener());
		menuItemDelete.addActionListener(new MenuDeleteListener());
		menuItemModify.addActionListener(new MenuModifyListener());
		menuItemUndo.addActionListener(new MenuUndoListener());
		menuItemRedo.addActionListener(new MenuRedoListener());
	}
}
