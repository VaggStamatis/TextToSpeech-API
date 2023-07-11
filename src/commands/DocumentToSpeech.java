/*DocumentToSpeech Class
 * Responsible : for handling text to be turned into speech
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

import model.Document;

public class DocumentToSpeech implements ActionListener {
	public Document doc;
	public JTextArea jtx;
	public ReplayManager repman;
	public int num;
	
	public DocumentToSpeech(Document doc, JTextArea jtx, int num){
		this.doc = doc;
		this.jtx = jtx;
		this.num = num;
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
		doc.setContents(jtx);
		if(num == 0) {
			doc.playContents();
		}else {
			doc.playLine(jtx);
		}
		
	}

}
