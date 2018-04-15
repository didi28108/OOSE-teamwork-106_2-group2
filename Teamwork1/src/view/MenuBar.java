package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listeners.DeleteListener;
import listeners.EditListener;
import listeners.MenuExitListener;
import listeners.MenuOpenListener;
import listeners.RedoListener;
import listeners.MenuSaveListener;
import listeners.UndoListener;
import mediator.ViewMediator;

public class MenuBar extends JMenuBar{
	ViewMediator vMdtr = ViewMediator.getInstance();
	
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
		menuItemDelete.addActionListener(new DeleteListener());
		menuItemModify.addActionListener(new EditListener());
		menuItemUndo.addActionListener(new UndoListener());
		menuItemRedo.addActionListener(new RedoListener());
	}
}
