/*Document Class
 * Responsible : for document initialization and handling
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package model;

import java.util.ArrayList;

import javax.swing.JTextArea;

import commands.ReplayManager;
import input.DocumentReader;
import input.DocumentReaderFactory;
import output.DocumentWriter;
import output.DocumentWriterFactory;

public class Document {

	public  ArrayList<String> contents ;  
	public DocumentWriter documentWriter; 
	public DocumentWriterFactory docWriteFactory;
	public TTSFacade audioManager;
	public DocumentReader documentReader;
	public DocumentReaderFactory docReaderFactory;
	public ReplayManager repman;
	
	
	public Document(ReplayManager repman) {
		contents = new ArrayList<String>();
		docWriteFactory = new DocumentWriterFactory(repman);
		docReaderFactory = new DocumentReaderFactory(repman);
		audioManager = new TTSFacade();
		this.repman = repman;
		
	}
	
	public void setDocReaderFactory(DocumentReaderFactory docReaderFactory) {
		this.docReaderFactory=docReaderFactory;
	}
	public void setDocWriteFactory(DocumentWriterFactory docWriteFactory) {
		this.docWriteFactory=docWriteFactory;
	}
	public void setAudioManager(TTSFacade audioManager) {
		this.audioManager = audioManager;
	}
	public TTSFacade getAudioManager() {
		return this.audioManager;
	}
	public void open(String path , String filetype , String encoding) {
		documentReader = this.docReaderFactory.createReader(path , filetype , encoding);
		contents = documentReader.read();
	}
	
	public void save(String path , String filetype , String encoding) {
		documentWriter = this.docWriteFactory.createWriter(path , filetype , encoding);
		documentWriter.write(this.contents);
	}
	
	public ArrayList<String> getContents(){
		return contents;
	}
	
	public void setContents(JTextArea jtx) {
		ArrayList<String> temp = new ArrayList<String>();
		for (String line : jtx.getText().split("\n")) {
			temp.add(line);
		}	
		contents = temp;	
	}

	public void playContents() {
		// TODO Auto-generated method stub
		for(int i=0; i<contents.size(); i++) {
			audioManager.play(contents.get(i));
		}
		
	}
	
	public void playLine(JTextArea jtx) {
		audioManager.play(new String(jtx.getSelectedText()));
	}
}
