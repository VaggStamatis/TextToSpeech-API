/*OpenDocument Class
 * Responsible : for opening a file
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.Document;

public class OpenDocument implements ActionListener {
	public Document doc;
	public ReplayManager repman;
	public JTextArea jtx;
	public OpenDocument(Document doc , JTextArea jtx) {
		this.doc = doc;
		this.jtx = jtx;
	}
	
	public void setDocument(Document doc) {
		this.doc =doc;
	}
	public Document getDocument() {
		return this.doc;
	}
	public void setReplayManager(ReplayManager repman) {
		this.repman =repman;
	}
	
	public void update() {
		ArrayList<String> cont = doc.getContents();
		for(int i=0 ; i <cont.size(); i++) {
			this.jtx.append(cont.get(i));
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser chooser=new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.showOpenDialog(null);

		String path =chooser.getSelectedFile().getAbsolutePath();
		int lastIndexOf = path.lastIndexOf(".");
		String inputValue = JOptionPane.showInputDialog("Please input the encoding strategy (AtBash | Rot13 | None)");
		doc.open(path,  path.substring(lastIndexOf +1) , inputValue);
		update();
	}
}
