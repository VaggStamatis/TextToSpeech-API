/*Commands Factory Class
 * Responsible : for command handling and creation
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package commands;

import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import model.Document;

public class CommandsFactory {
	private Document doc;
	public ReplayManager repman;
	public CommandsFactory(ReplayManager repman) {
		this.repman = repman;
	}
	
	public ActionListener createCommand(String com , Document doc , JTextArea jtx) {
		this.doc=doc;
		if(com.equals("SaveDocument")) {
			return new SaveDocument(doc , jtx);
		}
		else if (com.equals("OpenDocument")){
			return new OpenDocument(doc , jtx);
		}
		else if(com.equals("DocumentToSpeech")) {
			return new DocumentToSpeech(doc, jtx , 0);
		}
		else if(com.equals("LineToSpeech")) {
			return new DocumentToSpeech(doc , jtx , 1);
		}
		return null;
		
	}
	public Document getDoc() {
		return this.doc;
	}
		
}
