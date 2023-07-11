/*SaveDocument Class
 * Responsible : for saving a file 
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.Document;

public class SaveDocument implements ActionListener {
	public Document doc;
	public ReplayManager repman;
	private JTextArea jtx;
	
	public SaveDocument(Document doc , JTextArea jtx) {
		this.doc = doc;
		this.jtx = jtx;
	}
	
	public void setDocument(Document doc) {
		this.doc = doc;
	}
	
	public void setReplayManager(ReplayManager repman) {
		this.repman= repman;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser chooser=new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.showSaveDialog(null);
		
		String path =chooser.getSelectedFile().getPath();
		String name = chooser.getSelectedFile().getName();
		System.out.println(path);
		System.out.println(name);
		int lastIndexOf = path.lastIndexOf(".");
		String encoding = JOptionPane.showInputDialog("Please input the encoding strategy (AtBash | Rot13 | None)");
		doc.setContents(jtx);
		doc.save(path,  path.substring(lastIndexOf +1), encoding );
	}

}
