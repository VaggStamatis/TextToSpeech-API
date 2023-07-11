package tests;

import javax.swing.JTextArea;

import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import commands.ReplayManager;
import model.Document;
import model.TTSFacade;

class TuneAudioParamsTest {

	Document doc = new Document(new ReplayManager());
	JTextArea jtx = new JTextArea();
	OpenDocument opendoc = new OpenDocument(doc, jtx);
	TTSFacade audiomanager = new TTSFacade();
	@Test
	void tuningParametres() {
		String wordpath = "C:/Users/VaggSt/Documents/test.docx" ; 
		doc.open(wordpath,  "docx" ,"None");
		opendoc.update();
		audiomanager.setPitch(200);
		audiomanager.setRate(200);
		audiomanager.setVolume((float) 0.8);
		doc.playContents();
		doc.setAudioManager(audiomanager);
		doc.playContents();
	}

}
