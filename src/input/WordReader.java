/*WordReader Class
 * Responsible : for reading an Word document
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;



public class WordReader implements DocumentReader {
	private String path;
	public WordReader(String path) {
		// TODO Auto-generated constructor stub
		this.path = path;
	}

	@Override
	public ArrayList<String> read() {
		// TODO Auto-generated method stub
		ArrayList<String> file_in = new ArrayList<String>();
		File file = new File(this.path);
        FileInputStream fis = null;
		try {
			fis = new FileInputStream(file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         XWPFDocument document = null;
		try {
			document = new XWPFDocument(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

         List<XWPFParagraph> paragraphs = document.getParagraphs();

         for (XWPFParagraph para : paragraphs) {
             file_in.add(para.getText() + "\n");
         }
         return file_in;
	}
}
