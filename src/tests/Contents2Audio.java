package tests;

import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import commands.ReplayManager;
import model.Document;

class Contents2Audio {
	Document doc = new Document(new ReplayManager());
	JTextArea jtx = new JTextArea();
	OpenDocument opendoc = new OpenDocument(doc, jtx);
	@Test
	void tranformingToAudio() {
		String wordpath = "C:/Users/VaggSt/Documents/test.docx" ; 
		doc.open(wordpath,  "docx" ,"None");
		doc.playContents();
	}

}
