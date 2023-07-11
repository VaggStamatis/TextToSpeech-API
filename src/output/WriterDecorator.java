/*WriterDecorator Class
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package output;

import java.util.ArrayList;

import input.DocumentReader;

public abstract class WriterDecorator implements DocumentWriter {
	private DocumentReader docwrite;


	public DocumentReader getDocread() {
		return docwrite;
	}


	public void setDocwrite(DocumentReader docwrite) {
		this.docwrite = docwrite;
	}


	public abstract ArrayList<String> write();
	
	public abstract ArrayList<String> translate(ArrayList<String> contents);
}
