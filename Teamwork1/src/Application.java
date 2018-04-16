import java.awt.Dimension;

import javax.swing.SwingUtilities;

import controller.Controller;
import view.StateDiagramEditor;

public class Application {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                	runApp();
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
	}
	
	public static void runApp(){
        StateDiagramEditor view = new StateDiagramEditor();
        view.pack();
        view.setLocationRelativeTo(null);
        Controller ctrl = new Controller();
        ctrl.vMdtrRefresh();
        //view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ctrl.settingColor();
        view.setVisible(true);
    }
}
