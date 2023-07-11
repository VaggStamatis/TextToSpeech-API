package tests;

import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import commands.ReplayManager;
import model.Document;

class EditDocTest {
	Document doc = new Document(new ReplayManager());
	JTextArea jtx = new JTextArea();
	OpenDocument opendoc = new OpenDocument(doc, jtx);
	@Test
	void editingDoc() { 
		String wordpath = "C:/Users/VaggSt/Documents/test.docx" ; 
		doc.open(wordpath,  "docx" ,"None");
		opendoc.update();
		jtx.select(0, 1);
		String clipBoard = new String(jtx.getSelectedText());
		jtx.replaceRange(clipBoard, 0,0);
		
	}

}
