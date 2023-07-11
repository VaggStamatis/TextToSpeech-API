/*AtBashEncoder Class
 * Responsible : for AtBash coding of a file
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package output;

import java.util.ArrayList;

public class AtBashEncoder extends WriterDecorator {

	// Not needed to be implemented
	@Override
	public void write(ArrayList<String> contents) {
		// TODO Auto-generated method stub
		
	}
	
	// Not needed to be implemented
	@Override
	public ArrayList<String> write(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> translate(ArrayList<String> contents) {
		ArrayList<String> tempcode = new ArrayList<String>();
		boolean bol;
		for(int i =0; i <contents.size(); i++) {
			String temp = "";
			for(int j =0; j <contents.get(i).length(); j++) {
					char c = contents.get(i).charAt(j);
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
