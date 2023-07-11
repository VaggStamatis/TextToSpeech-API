/*ReaderDecorator Class
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package input;

import java.util.ArrayList;

public abstract class ReaderDecorator implements DocumentReader{
	private DocumentReader docread;


	public DocumentReader getDocread() {
		return docread;
	}


	public void setDocread(DocumentReader docread) {
		this.docread = docread;
	}


	public abstract ArrayList<String> read();
}
