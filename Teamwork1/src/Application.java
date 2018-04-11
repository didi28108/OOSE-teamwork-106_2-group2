import javax.swing.SwingUtilities;

import controller.MainMediator;
import view.StateDiagramEditor;

public class Application {
	public static void main(String[] args) {
		runApp();
		/*
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
        */
	}
	
	public static void runApp(){
        StateDiagramEditor view = new StateDiagramEditor();
        view.setVisible(true);
    }
}
