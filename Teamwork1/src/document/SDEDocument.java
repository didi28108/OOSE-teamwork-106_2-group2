package document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import statediagram.Component;
import statediagram.StateDiagram;
import view.DrawCanvas;

public abstract class SDEDocument {
	
	//template method
	public void openDocument(Component de, DrawCanvas c) {

		File fileName = getFileName(c);
		loadFile(fileName);
		loadElementsFromFile(de);
		closeFile();

	}

	public void saveDocument(StateDiagram de) {

		try {
			JFileChooser chooseDirec = new JFileChooser();
			chooseDirec.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooseDirec.showSaveDialog(null);
			File file = chooseDirec.getSelectedFile();
			file = new File(file + ".jenny");

			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

			bufferedWriter.close();

			openFile(file);
			writeSketchToFile(de);
			closeFile();
		} catch (IOException exception) {
			System.err.println("Error saving to new file.");
		}

	}

	public abstract void openFile(File fileName);

	public abstract File getFileName(DrawCanvas c);

	public abstract void loadFile(File fileName);

	public abstract void loadElementsFromFile(Component de);

	public abstract void closeFile();

	public abstract void writeSketchToFile(StateDiagram de);

}
