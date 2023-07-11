package tests;

import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import commands.ReplayManager;
import model.Document;

class OpenDocTest {
	
	public JTextArea jtx = new JTextArea();
	public Document doc = new Document(new ReplayManager());
	@Test
	void openingDoc() {
		String wordpath = "C:/Users/VaggSt/Documents/test.docx" ; 
		doc.open(wordpath,  "docx" ,"None");
		doc.open(wordpath, "docx" , "Rot13");
		doc.open(wordpath, "docx" , "AtBash");
		String excelpath = "C:/Users/VaggSt/Documents/testx.xlsx";
		doc.open(excelpath,  "xlsx" ,"None");
		doc.open(excelpath, "xlsx" , "Rot13");
		doc.open(excelpath, "xlsx" , "AtBash");
	}

}
