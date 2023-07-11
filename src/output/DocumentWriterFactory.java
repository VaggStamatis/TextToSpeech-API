/*DocumentWriter Factory Class
 * Responsible : for handling saving and creation of various types of files
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package output;

import java.util.ArrayList;

import commands.ReplayManager;

public class DocumentWriterFactory {
	public ReplayManager repman;
	public DocumentWriterFactory(ReplayManager repman) {
		this.repman = repman;
	}
	public DocumentWriter createWriter(String path, String filetype, String encoding) {
		ArrayList<String> command = new ArrayList<String>();
		command.add("WriterFactory");
		command.add(path);
		command.add(filetype);
		command.add(encoding);
		if(repman.isActiveRecording()) {
			repman.addCommand(command);
		}
		if(filetype.equals("docx")) {
				return new WordWriter(path , encoding);
		}
		else {
			return new ExcelWriter(path , encoding);
		}
	}



}
