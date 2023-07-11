/*ExcelWriter Class
 * Responsible : for creating and writing a Excel document
 * Created by : Evangelos Stamatis 
 * 				Antreas Katsantonis
 * 				Xristos Paraskevopoulos
 * For AdvancedText2SpeechEditor project on Software Engineering 
 * */
package output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter implements DocumentWriter {

	private String encoding;
	private String path;
	private Rot13Encoder rot_13 = new Rot13Encoder();
	private AtBashEncoder at_bash = new AtBashEncoder();
	public ExcelWriter(String path, String encoding) {
		// TODO Auto-generated constructor stub
		this.path = path;
		this.encoding = encoding;
	}

	@SuppressWarnings("resource")
	@Override
	public void write(ArrayList<String> contents) {
		// TODO Auto-generated method stub
		 if(encoding.equals("Rot13")) {
			contents = rot_13.translate(contents);
		 }else if(encoding.equals("AtBash")) {
			contents = at_bash.translate(contents);
		 }
		 XSSFWorkbook workbook = new XSSFWorkbook();
		 XSSFSheet sheet = workbook.createSheet("Sheet Zero");
		 int rowCount = -1;
		 int cellCount =-1;
		 Row row = sheet.createRow(++rowCount);
		 for(int i=0; i<contents.size(); i++) {
			 if(contents.get(i).equals("\n")) {
				row = sheet.createRow(++rowCount);
				cellCount = 0;
			 } 
			 else {
				 Cell cell = row.createCell(++cellCount);   
				 cell.setCellValue(contents.get(i));
			 }
		 }
		 try (FileOutputStream outputStream = new FileOutputStream(path)) {
			 try {
				workbook.write(outputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 } catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

