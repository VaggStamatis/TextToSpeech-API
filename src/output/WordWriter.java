/*WordWriter Class
 * Responsible : for creating and writing a Word document
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordWriter implements DocumentWriter {

	private String encoding;
	private String path;
	private Rot13Encoder rot_13 = new Rot13Encoder();
	private AtBashEncoder at_bash = new AtBashEncoder();
	public WordWriter(String path, String encoding) {
		// TODO Auto-generated constructor stub
		this.path = path;
		this.encoding = encoding;
	}

	public void write(ArrayList<String> contents) {
		// TODO Auto-generated method stub
		XWPFDocument document = new XWPFDocument();
		if(encoding.equals("Rot13")) {
			contents = rot_13.translate(contents);
		}else if(encoding.equals("AtBash")) {
			contents = at_bash.translate(contents);
		}
		for(int i =0; i<contents.size(); i++) {
			XWPFParagraph tmpParagraph = document.createParagraph();
			XWPFRun tmpRun = tmpParagraph.createRun();
			tmpRun.setText(contents.get(i));
			tmpRun.setFontSize(14);
		}
		try {
			document.write(new FileOutputStream(new File(path)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
