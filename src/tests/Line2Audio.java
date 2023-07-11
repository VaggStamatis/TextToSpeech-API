package tests;

import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import commands.ReplayManager;
import model.Document;

class Line2Audio {

	Document doc = new Document(new ReplayManager());
	JTextArea jtx = new JTextArea();
	OpenDocument opendoc = new OpenDocument(doc, jtx);
	@Test
	void tranformingLineToAudio() {
		String wordpath = "C:/Users/VaggSt/Documents/test.docx" ; 
		doc.open(wordpath,  "docx" ,"None");
		opendoc.update();
		jtx.select(0,5);
		doc.playLine(jtx);
	}

}
