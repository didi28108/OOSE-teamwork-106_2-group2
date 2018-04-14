import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.ViewMediator;
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
        //view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.setVisible(true);
    }
}
