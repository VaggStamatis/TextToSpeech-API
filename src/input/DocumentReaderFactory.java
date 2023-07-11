/*DocumentReader Factory Class
 * Responsible : for handling types of acceptable documents to be read 
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package input;

import java.util.ArrayList;

import commands.ReplayManager;

public class DocumentReaderFactory {
	public AtBashDecorator atbashDecorator;
	public Rot13Decorator rot13Decorator;
	public ReplayManager repman;
	
	public DocumentReaderFactory( ReplayManager repman){
		this.atbashDecorator =  new AtBashDecorator();
		this.rot13Decorator =  new Rot13Decorator();
		this.repman = repman;
	}

	public DocumentReader createReader(String path, String filetype, String encoding) {
		// TODO Auto-generated method stub
		ArrayList<String> command = new ArrayList<String>();
		command.add("ReaderFactory");
		command.add(path);
		command.add(filetype);
		command.add(encoding);
		if(repman.isActiveRecording()) {
			repman.addCommand(command);
		}
		if(filetype.equals("xlsx") && encoding.equals("None")) {
			return new ExcelReader(path);
		}
		else if (filetype.equals("docx") && encoding.equals("None")) {
			return new WordReader(path);
		}
		else {
			DocumentReader temp;
			ReaderDecorator decor;
			if(filetype.equals("docx")) {
				temp = new WordReader(path);
			}
			else {
				temp = new ExcelReader(path);
			}
			if(encoding.equals("Rot13")) {
				decor = new Rot13Decorator();
			}
			else {
				decor = new AtBashDecorator();
			}
			decor.setDocread(temp);
			return decor;
		}
			
	}
	
	
}
