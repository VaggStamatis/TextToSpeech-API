package tests;

import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import commands.ReplayManager;
import model.Document;

class SaveDocTest {
	
	public JTextArea jtx = new JTextArea();
	public Document doc = new Document(new ReplayManager());
	@Test
	void savingDoc() {
		jtx.append("This is a Test File");
		doc.setContents(jtx);
		String wordpath = "C:/Users/VaggSt/Documents/test"; 
		doc.save(wordpath + "1.docx",  "docx" ,"None");
		doc.save(wordpath + "2.docx", "docx" , "Rot13");
		doc.save(wordpath + "3.docx", "docx" , "AtBash");
		String excelpath = "C:/Users/VaggSt/Documents/testx";
		doc.save(excelpath + "1.xlsx",  "xlsx" ,"None");
		doc.save(excelpath + "2.xlsx", "xlsx" , "Rot13");
		doc.save(excelpath + "3.xlsx", "xlsx" , "AtBash");
	}

}
