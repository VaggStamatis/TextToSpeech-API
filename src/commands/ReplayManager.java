/*ReplayManager Class
 * Responsible : for recording commands
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package commands;

import java.util.ArrayList;

import input.DocumentReaderFactory;
import output.DocumentWriterFactory;

public class ReplayManager {
	public boolean recordingStatus;
	public ArrayList<ArrayList<String>> replayList = new ArrayList<ArrayList<String>>(); 
	public DocumentReaderFactory readf = new DocumentReaderFactory(this);
	public DocumentWriterFactory writef = new DocumentWriterFactory(this);
	public ReplayManager() {}
	
	public void replay() {
		if(!this.recordingStatus) {
			for(int i =0; i<replayList.size(); i++) {
				if(replayList.get(i).get(0).equals("ReaderFactory")) {
					readf.createReader(replayList.get(i).get(1), replayList.get(i).get(2), replayList.get(i).get(3));
				}else if(replayList.get(i).get(0).equals("ReaderFactory")) {
					writef.createWriter(replayList.get(i).get(1), replayList.get(i).get(2), replayList.get(i).get(3));
				}
			}
		}
	}
	
	public void startRecording() {
		this.recordingStatus = true;
	}
	
	public void endRecording() {
		this.recordingStatus = false;
	}
	
	public boolean isActiveRecording() {
		return recordingStatus;
	}
	
	public void addCommand(ArrayList<String> command) {
		replayList.add(command);
	}
}
