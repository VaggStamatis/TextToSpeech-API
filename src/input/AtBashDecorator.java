/*AtBashDecorator Class
 * Responsible : for decoding AtBash files
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package input;

import java.util.ArrayList;

public class AtBashDecorator extends ReaderDecorator {

	public DocumentReader docread;
	AtBashDecorator (){
		super();
	}
	public DocumentReader getDocread() {
		return docread;
	}

	public void setDocread(DocumentReader docread) {
		this.docread = docread;
	}

	
	@Override
	public ArrayList<String> read() {
		// TODO Auto-generated method stub
		ArrayList<String> code = this.docread.read();
		ArrayList<String> tempcode = new ArrayList<String>();
		boolean bol;
		for(int i =0; i <code.size(); i++) {
			String temp = "";
			for(int j =0; j <code.get(i).length(); j++) {
					char c = code.get(i).charAt(j);
					if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
						bol = Character.isUpperCase(c);
						c = Character.toLowerCase(c);
						if (c>= 'a' && c<= 'z') {
							c = (char) (c - 97);
							c = (char) (25 - c);
							c = (char) (c + 97);
						}if(bol) {
							c = Character.toUpperCase(c);
						}
						temp += c;
					}else{
						temp += c;
					}
			}
			tempcode.add(temp);
		}
		return tempcode;
	}

}
